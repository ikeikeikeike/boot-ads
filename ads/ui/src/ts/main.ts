import './post/show'
import './category/index'

declare const process: {
  env: {
    NODE_ENV: string,
    ENDPOINT: string,
  }
}

document.addEventListener('DOMContentLoaded', () => {
  console.debug('DOMContentLoaded');
});
