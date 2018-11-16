package com.boot.ads.ui.pebble.function

import com.mitchellbosecke.pebble.extension.Function
import com.mitchellbosecke.pebble.template.EvaluationContext
import com.mitchellbosecke.pebble.template.PebbleTemplate
import java.io.File
import java.net.URL
import java.util.*

class UrlJoinFunction: Function {

    override fun execute(args: Map<String, Any>, self: PebbleTemplate, context: EvaluationContext, lineNumber: Int): Any? {
        val base = this.extractKey(args)
        val arguments = this.extractArguments(args)

        return URL(base).toURI().resolve(arguments.fold("/"){acc, p -> combine(acc, p)}).toString()
    }

    private fun extractKey(args: Map<String, Any>): String {
        return args["0"] as String
    }

    private fun extractArguments(args: Map<String, Any>): List<String> {
        var i = 1
        val arguments = ArrayList<String>()
        while (args.containsKey(i.toString())) {
            arguments.add(args[i.toString()] as String)
            i++
        }
        return arguments
    }

    private fun combine(path1: String, path2: String): String {
        val file1 = File(path1)
        val file2 = File(file1, path2)
        return file2.path
    }

    override fun getArgumentNames(): List<String>? {
        return null
    }

    companion object {
        val FUNCTION_NAME = "urljoin"
    }
}



