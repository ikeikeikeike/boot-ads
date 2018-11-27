package com.boot.ads.data.repo

import com.boot.ads.data.entity.Site
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SiteRepo : JpaRepository<Site, Long> {
}
