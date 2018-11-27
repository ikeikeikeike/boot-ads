package com.boot.ads.data.entity

import org.springframework.data.jpa.domain.AbstractPersistable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table


@Entity
@Table(name = "django_site")
class Site: AbstractPersistable<Long>() {

    // lateinit var

    @Column(name="domain", nullable=false)
    val domain: String = ""

    @Column(name="name", nullable=false)
    val name: String = ""
}

