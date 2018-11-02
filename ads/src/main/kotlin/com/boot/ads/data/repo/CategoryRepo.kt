package com.boot.ads.data.repo

import com.boot.ads.data.entity.Category
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepo : JpaRepository<Category, Long> {
    fun findByName(name: String?, pageable: Pageable): Page<Category>
}
