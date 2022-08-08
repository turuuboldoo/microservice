package com.example.postgres.service

import com.example.postgres.dao.ArticlesDao
import com.example.postgres.model.Article
import com.example.postgres.repostory.ArticlesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ArticleService(
    @Autowired val repository: ArticlesRepository
) : ArticlesDao {

    override fun getArticle(id: Long) = repository.findById(id)

    override fun getAllArticles() = repository.findAllByOrderByIdDesc()

    override fun saveArticles(article: Article) = repository.save(article)

    override fun deleteArticle(id: Long) = repository.deleteById(id)
}
