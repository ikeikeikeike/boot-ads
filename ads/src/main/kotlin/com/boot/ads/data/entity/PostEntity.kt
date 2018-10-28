package com.boot.ads.data.entity

import org.springframework.data.jpa.domain.AbstractPersistable
import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "posts")
class PostEntity: AbstractPersistable<Long>() {

    @ManyToOne(optional=true, fetch=FetchType.LAZY)
    @JoinColumn(name="category_id", referencedColumnName="id")
    val category: CategoryEntity? = null

    @Column(name="slug", nullable=false)
    val slug: String = ""

    @Column(name="title", nullable=false)
    val title: String = ""

    @Column(name="content", nullable=false)
    val content: String = ""

    @Column(columnDefinition="tinyint(1) default 0", nullable=false)
    val draft: Boolean = false

    @Column(name="publish", nullable=true)
    val publish: Date? = null

}
