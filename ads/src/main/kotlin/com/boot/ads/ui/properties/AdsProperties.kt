package com.boot.ads.ui.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component


@Component
@ConfigurationProperties(prefix = "ads")
class AdsProperties {
    lateinit var env: String
}


@Configuration
class AdsPropertiesConfiguration(val prop: AdsProperties) {
    @Bean(name = ["adsProp"])
    fun AdsProp(): AdsProperties {
        return prop
    }
}
