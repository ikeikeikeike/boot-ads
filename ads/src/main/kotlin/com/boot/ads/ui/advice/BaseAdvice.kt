package com.boot.ads.ui.advice

import com.boot.ads.domain.usecase.CategoryUsecase
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ModelAttribute


@ControllerAdvice
class BaseAdvice(private val usecase: CategoryUsecase) {

    @ModelAttribute
    fun addAttributes(model: Model) {
        model["title"] = "Ads"
        model["description"] = "Description here"
        model["categories"] = usecase.findAll(PageRequest.of(0, Integer.MAX_VALUE))
    }

    companion object {
        private val logger = LoggerFactory.getLogger(BaseAdvice::class.java)
    }
}
