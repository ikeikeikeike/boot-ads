package com.boot.ads.domain.usecase

import com.boot.ads.data.entity.Category
import com.boot.ads.data.repo.CategoryRepo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


@Service
class CategoryUsecase(private val repo: CategoryRepo) {
    fun findByName(name: String?, pageable: Pageable): Page<Category> {
        return repo.findByName(name, pageable)
    }

    fun findAll(pageable: Pageable): Page<Category> {
        return repo.findAll(pageable)  // translate to model
    }
}
