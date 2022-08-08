package com.example.postgres.controller

import com.example.postgres.dao.ArticlesDao
import com.example.postgres.model.Article
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/articles")
class ArticlesController(
    @Autowired private val dao: ArticlesDao
) {

    @GetMapping
    fun getArticles() = mapOf("data" to dao.getAllArticles())

    @GetMapping("/{id}")
    fun getArticle(@PathVariable("id") id: Long) = mapOf("data" to dao.getArticle(id))

    @PostMapping
    fun createArticle(@RequestBody article: Article) = mapOf("data" to dao.saveArticles(article))

    @PutMapping("/{id}")
    fun updateArticle(@RequestBody article: Article) = mapOf("data" to dao.saveArticles(article))

    @DeleteMapping("/{id}")
    fun deleteArticle(@PathVariable("id") id: Long): Map<*, *> {
        dao.deleteArticle(id)
        return mapOf("message" to "success")
    }
}
