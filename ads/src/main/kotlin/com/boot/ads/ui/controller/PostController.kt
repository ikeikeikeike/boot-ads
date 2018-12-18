package com.boot.ads.ui.controller

import com.boot.ads.domain.usecase.PostUsecase
import com.boot.ads.ui.exception.NotFound
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable


@Controller
class PostController(private val usecase: PostUsecase) {

    @GetMapping(value=["articles/{slug}"])
    fun show(@PathVariable("slug", required=true) slug: String, model: Model): String {
        val post = usecase.findProd(slug)
        if (post === null) {
            throw NotFound()
        }

        model["post"] = post
        return "post/show"
    }

    @GetMapping(value=["__articles__/{slug}"])
    fun any(@PathVariable("slug", required=true) slug: String, model: Model): String {
        val post = usecase.findAny(slug)
        if (post === null) {
            throw NotFound()
        }

        model["post"] = post
        return "post/show"
    }

}
