package com.ll.exam.controller.article;

import com.ll.exam.dto.ArticleDto;
import com.ll.exam.model.Article;

import java.util.List;

public class ArticleService {
    private ArticleRepository articleRepository;

    public ArticleService() {
        articleRepository = new ArticleRepository();
    }

    public List<ArticleDto> findAll() {
        return articleRepository.findAll();
    }

    public Article findById(long id) {
        return articleRepository.findById(id);
    }

    public long deleteById(long id) {
        return articleRepository.deleteById(id);
    }
}
