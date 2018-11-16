package com.boot.ads.ui.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component


@Component
@ConfigurationProperties(prefix = "admin")
class AdminProperties {
    lateinit var html: String
    lateinit var fqdn: String
    lateinit var port: String
    lateinit var scheme: String
    lateinit var addr: String
}


@Configuration
class AdminPropertiesConfiguration(val prop: AdminProperties) {
    @Bean(name = ["adminProp"])
    fun adminProp(): AdminProperties {
        return prop
    }
}
