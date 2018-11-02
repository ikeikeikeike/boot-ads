package com.boot.ads.data.repo

import com.boot.ads.data.entity.Post
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepo : JpaRepository<Post, Long> {
    fun findByCategorySlug(name: String?, pageable: Pageable): Page<Post>
    fun findByCategorySlugOrderByIdDesc(name: String?, pageable: Pageable): Page<Post>
    fun findAllByOrderByIdDesc(pageable: Pageable): Page<Post>
}
