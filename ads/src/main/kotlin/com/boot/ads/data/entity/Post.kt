package com.boot.ads.data.entity

import org.springframework.data.jpa.domain.AbstractPersistable
import java.sql.Date
import javax.persistence.*
import javax.persistence.ManyToMany



@Entity
@Table(name = "posts")
class Post: AbstractPersistable<Long>() {

    // lateinit var

    // userId: reference to User.id

    @ManyToOne(optional=true, fetch=FetchType.LAZY)
    @JoinColumn(name="category_id", referencedColumnName="id")
    val category: Category? = null

    @ManyToMany
    @JoinTable(name = "posts_tags",
            joinColumns = [JoinColumn(name = "content_object_id", referencedColumnName = "id")],
            inverseJoinColumns = [JoinColumn(name = "tag_id", referencedColumnName = "id")])
    var tags: List<Tag>? = null

    @Column(name="external_link", nullable=true)
    val externalLink: String? = null

    @Column(name="slug", nullable=false)
    val slug: String = ""

    @Column(name="image", nullable=false)
    val image: String = ""

    @Column(name="title", nullable=false)
    val title: String = ""

    @Column(name="content", nullable=true)
    val content: String? = null

    @Column(columnDefinition="tinyint(1) default 0", nullable=false)
    val publish: Boolean = false

    @Column(name="publish_at", nullable=true)
    val publishAt: Date? = null

}
