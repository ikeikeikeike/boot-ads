package com.boot.ads.ui.pebble.function


import com.mitchellbosecke.pebble.extension.Function
import com.mitchellbosecke.pebble.template.EvaluationContext
import com.mitchellbosecke.pebble.template.PebbleTemplate
import java.util.*


class NowFunction: Function {

    override fun execute(args: Map<String, Any>, self: PebbleTemplate, context: EvaluationContext, lineNumber: Int): Any? {
        return Date()
    }

    override fun getArgumentNames(): List<String>? {
        return null
    }

    companion object {
        val FUNCTION_NAME = "now"
    }
}
