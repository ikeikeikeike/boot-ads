'use strict'

// const del = require('del');
const gulp = require('gulp');
const babel = require('gulp-babel');
const webserver  = require('gulp-webserver');
const runSequence = require('run-sequence');
const webpack = require('webpack');
const webpackStream = require('webpack-stream');
const webpackConfig = require('./webpack.config');

const sass = require('gulp-sass');
const postcss = require('gulp-postcss');
const concat = require('gulp-concat');
const cssnext = require('postcss-cssnext');
const cleanCSS = require('gulp-clean-css');
const uglify = require('gulp-uglify');
const rimraf = require('rimraf');

const env = process.env || 'development';
const dist = env.DIST_PATH || '../src/main/resources/static/';

// remove files
gulp.task('clean', () => {
  // var path = dist + '';

  // switch (env.NODE_ENV) {
  // case 'development':
  //   del([path + '/bundle-development.js']);
  //   del([path + '/bundle-development.map']);
  //   break
  // default:
  //   del([path + '/bundle.js']);
  //   del([path + '/bundle.map']);
  // }
});

// Compile TypeScript and run webpack
gulp.task('webpack', () => {
  return webpackStream(webpackConfig, webpack)
    .pipe(gulp.dest(dist + 'js'));
});

// launch dev server
gulp.task('serve', () => {
  gulp.src(dist + 'js')
    .pipe(webserver({
      host: '0.0.0.0',
      https: true,
      port: 8888,
      livereload: true,
      open: true
    }));
});

gulp.task('web-font', () => {
  gulp.src([
    './node_modules/font-awesome/fonts/*',
    './node_modules/simple-line-icons/fonts/*',
  ])
  .pipe(gulp.dest(dist + 'fonts'));
});


gulp.task('web-flags', () => {
  gulp.src([
    './node_modules/flag-icon-css/flags/*/*'
  ])
  .pipe(gulp.dest(dist + 'flags'));
});

gulp.task('prepared-scss', () => {
  var processors = [
      cssnext()
  ];
  return gulp.src([
    './vendor/prepared/**/*.scss',
    './prepared/**/*.scss'
  ])
  .pipe(sass({outputStyle: 'expanded'}).on('error', sass.logError))
  .pipe(postcss(processors))
  .pipe(concat('prepared.min.css'))
  .pipe(cleanCSS({level: {1: {specialComments: 0}}}))
  .pipe(gulp.dest(dist + 'css'));
});

gulp.task('vendor-scss', () => {
  var processors = [
      cssnext()
  ];

  gulp.src([
    './node_modules/animate.css/animate.css',
    './node_modules/font-awesome/css/font-awesome.css',
    './node_modules/simple-line-icons/css/simple-line-icons.css',
    './node_modules/weather-icons/css/weather-icons.css',
    './node_modules/flag-icon-css/css/flag-icon.min.css',
    './node_modules/bootstrap/dist/css/bootstrap.min.css',
    './node_modules/bootswitch/dist/litera/bootstrap.min.css',
    './vendor/css/**/*.css'])
  .pipe(sass({outputStyle: 'expanded'}).on('error', sass.logError))
  .pipe(postcss(processors))
  .pipe(concat('vendor.min.css'))
  .pipe(cleanCSS({level: {1: {specialComments: 0}}}))
  .pipe(gulp.dest(dist + 'css'));
});

gulp.task('scss', () => {
  var processors = [
      cssnext()
  ];
  return gulp.src([
    './src/css/**/*.css',
    './src/css/**/*.scss',
  ])
  .pipe(sass({outputStyle: 'expanded'}).on('error', sass.logError))
  .pipe(postcss(processors))
  .pipe(concat('app.min.css'))
  .pipe(cleanCSS({level: {1: {specialComments: 0}}}))
  .pipe(gulp.dest(dist + 'css'));
});

gulp.task('prepared-js', () => {
  gulp.src([
    './node_modules/jquery/dist/jquery.min.js',
    './vendor/prepared/**/*.js',
    './prepared/**/*.js'
  ])
  .pipe(concat('prepared.min.js'))
  .pipe(uglify())
  .pipe(gulp.dest(dist + 'js'));
});

gulp.task('vendor-js', () => {
  gulp.src([
    './node_modules/bootstrap/dist/js/bootstrap.bundle.min.js',
    './node_modules/i18next/dist/umd/*.js',
    './node_modules/sanitize-html/dist/sanitize-html.min.js',
    './node_modules/js-cookie/src/js.cookie.js',
    './vendor/js/**/*.js'])
  .pipe(concat('vendor.min.js'))
  .pipe(uglify())
  .pipe(gulp.dest(dist + 'js'));
});

gulp.task('js', () => {
  gulp.src(['./src/js/**/*.js'])
  .pipe(concat('app.min.js'))
  .pipe(babel())
  .pipe(uglify())
  .pipe(gulp.dest(dist + 'js'));
});

// watch ts
gulp.task('watch', () => {
  gulp.watch('./node_modules/jquery/dist/jquery.min.js', ['prepared-js'])
  gulp.watch('./vendor/prepared/*.js', ['prepared-js'])
  gulp.watch('./prepared/*.js', ['prepared-js'])
  gulp.watch('./vendor/prepared/*.scss', ['prepared-scss'])
  gulp.watch('./prepared/*.scss', ['prepared-scss'])
  gulp.watch('./vendor/css/maintheme/*.scss', ['vendor-scss'])
  gulp.watch('./src/css/**/*.css', ['scss']);
  gulp.watch('./src/css/**/*.scss', ['scss']);
  gulp.watch('./src/ts/**/*.ts', ['webpack'])
  gulp.watch('./src/js/**/*.js', ['js']);
});

gulp.task('build', (callback) => runSequence('clean', 'prepared-scss', 'vendor-scss', 'scss', 'prepared-js', 'vendor-js', 'js', 'web-flags', 'web-font', 'webpack', callback));
gulp.task('default', (callback) => {
  switch (env.NODE_ENV) {
  case 'production':
    runSequence('clean', 'prepared-scss', 'vendor-scss', 'scss', 'prepared-js', 'vendor-js', 'js', 'web-flags', 'web-font', 'webpack', callback);
    break
  default:
    // runSequence('clean', 'webpack', 'watch', 'serve', callback);
    runSequence('clean', 'prepared-scss', 'vendor-scss', 'scss', 'prepared-js', 'vendor-js', 'js', 'web-flags', 'web-font', 'webpack', 'watch', callback);
  }
});
