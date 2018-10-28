package com.boot.ads.domain.usecase

import com.boot.ads.data.entity.PostEntity
import com.boot.ads.data.repo.PostRepo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


@Service
class PostUsecase(private val repo: PostRepo) {
    /**
     * if name is null, search blank category's posts
     */
    fun findByCategorySlug(name: String?, pageable: Pageable): Page<PostEntity> {
        return repo.findByCategorySlugOrderByIdDesc(name, pageable)  // translate to model
    }

    fun findAll(pageable: Pageable): Page<PostEntity> {
        return repo.findAllByOrderByIdDesc(pageable)    // translate to model
    }

    fun posts(name: String?, pageable: Pageable): Page<PostEntity> {
        return when (name) {
            null -> findAll(pageable)                   // translate to model
            else -> findByCategorySlug(name, pageable)  // translate to model
        }
    }
}
