package com.example.postgres.dao

import com.example.postgres.model.Article
import java.util.Optional

interface ArticlesDao {
    fun getArticle(id: Long): Optional<Article>?
    fun getAllArticles(): Iterable<Article?>?
    fun saveArticles(article: Article): Article
    fun deleteArticle(id: Long)
}