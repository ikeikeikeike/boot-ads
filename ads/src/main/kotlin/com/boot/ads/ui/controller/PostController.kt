package com.boot.ads.ui.controller

import com.boot.ads.domain.usecase.PostUsecase
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.client.HttpClientErrorException

@Controller
class PostController(private val usecase: PostUsecase) {

    @GetMapping(value=["articles/{slug}"])
    fun Show(@PathVariable("slug", required=true) slug: String, model: Model): String {
        println(slug)
        println(slug)
        println(slug)
        println(slug)
        println(slug)
        println(slug)
        println(slug)
        println(slug)
        val post = usecase.findBySlug(slug)
        if (post === null) {
            throw HttpClientErrorException(HttpStatus.NOT_FOUND)
        }

        model["post"] = post
        return "post/show"
    }

}
