package com.boot.ads.domain.usecase

import com.boot.ads.data.entity.CategoryEntity
import com.boot.ads.data.repo.CategoryRepo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


@Service
class CategoryUsecase(private val repo: CategoryRepo) {
    fun findByName(name: String?, pageable: Pageable): Page<CategoryEntity> {
        return repo.findByName(name, pageable)
    }

    fun findAll(pageable: Pageable): Page<CategoryEntity> {
        return repo.findAll(pageable)  // translate to model
    }
}
