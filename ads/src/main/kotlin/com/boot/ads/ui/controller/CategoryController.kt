package com.boot.ads.ui.controller

import com.boot.ads.domain.usecase.PostUsecase
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class CategoryController(private val usecase: PostUsecase) {

    @GetMapping(value=["/categories", "/categories/{name}"])
    fun categorys(@PathVariable("name", required=false) name: String?, model: Model): String {

        model["posts"] = usecase.posts(name, PageRequest.of(0, Integer.MAX_VALUE))
        return "category/list"
    }


}
