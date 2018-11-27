package com.boot.ads.ui.advice

import com.boot.ads.domain.usecase.CategoryUsecase
import com.boot.ads.domain.usecase.SiteUsecase
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ModelAttribute


@ControllerAdvice
class BaseAdvice(private val categoryCase: CategoryUsecase, private val siteCase: SiteUsecase) {

    @ModelAttribute
    fun addAttributes(model: Model) {
        val site = siteCase.current()
        model["domain"] = site?.domain ?: "localhost"
        model["title"] = site?.name ?: "Site Name"
        model["description"] = site?.name ?: "Site Name"
        model["categories"] = categoryCase.findAll(PageRequest.of(0, Integer.MAX_VALUE))
    }

    companion object {
        private val logger = LoggerFactory.getLogger(BaseAdvice::class.java)
    }
}
