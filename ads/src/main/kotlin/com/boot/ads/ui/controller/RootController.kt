package com.boot.ads.ui.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class RootController {

    @GetMapping("/")
    fun root(model: Model): String {

        model["title"] = "My Title"
        model["hello"] = "hello world!"
        return "root"
    }

}
