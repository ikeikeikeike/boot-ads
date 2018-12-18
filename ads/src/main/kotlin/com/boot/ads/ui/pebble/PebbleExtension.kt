package com.boot.ads.ui.pebble

import com.boot.ads.ui.pebble.function.PathJoinFunction
import com.boot.ads.ui.pebble.function.UrlJoinFunction
import com.boot.ads.ui.pebble.function.NowFunction
import com.mitchellbosecke.pebble.extension.AbstractExtension
import com.mitchellbosecke.pebble.extension.Function
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*


@Configuration
class PebbleConfiguration {
    @Bean
    fun pebbleExtension(): PebbleExtension {
        return PebbleExtension()
    }
}

class PebbleExtension : AbstractExtension() {
    override fun getFunctions(): HashMap<String, Function> {
        val functions = HashMap<String, Function>()
        functions[NowFunction.FUNCTION_NAME] = NowFunction()
        functions[UrlJoinFunction.FUNCTION_NAME] = UrlJoinFunction()
        functions[PathJoinFunction.FUNCTION_NAME] = PathJoinFunction()
        return functions
    }
}


