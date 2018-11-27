package com.boot.ads.data.entity

import org.springframework.data .jpa.domain.AbstractPersistable
import javax.persistence.*


//import javax.validation.constraints.NotNull
//import javax.validation.constraints.Pattern
//import javax.validation.constraints.Size

@Entity
@Table(name = "categories")
class Category: AbstractPersistable<Long>() {

    // lateinit var

    @OneToMany(orphanRemoval=true, fetch=FetchType.LAZY) // cascade = CascadeType.ALL,
    @JoinColumn(name="parent_id")
    val children: List<Category>? = null

    @ManyToOne(optional=true, fetch=FetchType.LAZY)
    @JoinColumn(name="parent_id", referencedColumnName="id")
    val parent: Category? = null

    @OneToMany(orphanRemoval=true, fetch=FetchType.LAZY) // cascade = CascadeType.ALL,
    @JoinColumn(name="category_id", referencedColumnName="id")
    val posts: List<Post>? = null

    @Column(name="name", nullable=false)
    val name: String = ""

    @Column(name="slug", nullable=false)
    val slug: String = ""
}

