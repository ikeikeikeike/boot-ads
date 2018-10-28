package com.boot.ads.data.repo

import com.boot.ads.data.entity.PostEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepo : JpaRepository<PostEntity, Long> {
    fun findByCategorySlug(name: String?, pageable: Pageable): Page<PostEntity>
    fun findByCategorySlugOrderByIdDesc(name: String?, pageable: Pageable): Page<PostEntity>
    fun findAllByOrderByIdDesc(pageable: Pageable): Page<PostEntity>
}
