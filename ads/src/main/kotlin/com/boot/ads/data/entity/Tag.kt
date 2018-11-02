package com.boot.ads.data.entity

import org.springframework.data.jpa.domain.AbstractPersistable
import javax.persistence.*


@Entity
@Table(name = "taggit_tag")
class Tag: AbstractPersistable<Long>() {

    @Column(name="name", nullable=false)
    val name: String = ""

    @Column(name="slug", nullable=false)
    val slug: String = ""

    @ManyToMany
    @JoinTable(name = "posts_tags",
            joinColumns = [JoinColumn(name = "tag_id", referencedColumnName = "id")],
            inverseJoinColumns = [JoinColumn(name = "content_object_id", referencedColumnName = "id")])
    var posts: List<Post>? = null

}


@Entity
@Table(name = "posts_tags")
class PostsTag: AbstractPersistable<Long>() {

    @ManyToOne(optional=false, fetch= FetchType.LAZY)
    @JoinColumn(name="post_id", referencedColumnName="id") // name="content_object_id"
    val post: Post = Post()

    @ManyToOne(optional=false, fetch= FetchType.LAZY)
    @JoinColumn(name="tag_id", referencedColumnName="id")
    val tag: Tag = Tag()

}
