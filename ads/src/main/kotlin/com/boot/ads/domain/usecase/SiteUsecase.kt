package com.boot.ads.domain.usecase

import com.boot.ads.data.entity.Site
import com.boot.ads.data.repo.SiteRepo
import org.springframework.data.domain.Sort
import org.springframework.data.domain.Sort.Direction.DESC
import org.springframework.stereotype.Service


@Service
class SiteUsecase(private val repo: SiteRepo) {
    fun current(): Site? {
        return repo.findAll(Sort(DESC, "id")).firstOrNull()
    }
}
