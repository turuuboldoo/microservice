package com.example.postgres.repostory

import com.example.postgres.model.Article
import org.springframework.data.repository.CrudRepository

interface ArticlesRepository : CrudRepository<Article, Long> {
    fun findAllByOrderByIdDesc(): Iterable<Article?>?
}
