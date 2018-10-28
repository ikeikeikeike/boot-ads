package com.boot.ads.data.repo

import com.boot.ads.data.entity.CategoryEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepo : JpaRepository<CategoryEntity, Long> {
    fun findByName(name: String?, pageable: Pageable): Page<CategoryEntity>
}
