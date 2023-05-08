package com.example.demo.controller;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.*;
import com.example.demo.service.*;

@RestController
@CrossOrigin
public class AllController {
    @GetMapping("/getAllType")
    private ArrayList<Type> getAllType() throws Exception{
        ArrayList<Type> list = null;
        TypeService sTypeService = new TypeService();
        try {
            list = sTypeService.GetAll();
        } catch (Exception e) {
            throw e;
        }
        return list;
    }
    @GetMapping("/getAllArticle")
    private ArrayList<Article> getAllArticle() throws Exception{
        ArrayList<Article> list = null;
        ArticleService sArticleService = new ArticleService();
        try {
            list = sArticleService.GetAll();
        } catch (Exception e) {
            throw e;
        }
        return list;
    }
    @GetMapping("/getAllV_article/{depart}")
    private ArrayList<V_article> getAllV_article(@PathVariable("depart") int depart) throws Exception{
        ArrayList<V_article> list = null;
        V_articleService sV_articleService = new V_articleService();
        try {
            list = sV_articleService.GetAll(depart);
        } catch (Exception e) {
            throw e;
        }
        return list;
    }
    @GetMapping("/getDetailsArticle/{id}")
    private ArrayList<V_article> getDetailsArticle(@PathVariable("id") String id) throws Exception{
        ArrayList<V_article> list = null;
        V_articleService sV_articleService = new V_articleService();
        try {
            list = sV_articleService.getDetailsArticle(id);
        } catch (Exception e) {
            throw e;
        }
        return list;
    }
    @PostMapping("/newArticle")
    private void newArticle(@RequestBody Article articleStr) throws Exception{
        ArticleService sarticleService = new ArticleService();
        try {
            Article article = articleStr;
            sarticleService.newArticle(article);
        } catch (Exception e) {
            throw e;
        }
    }
    @GetMapping("/pagination")
    private int pagination() throws Exception{
        int reponse = 0;
        LimiteService slimiteService = new LimiteService();
        try {
            reponse = slimiteService.pagination();
        } catch (Exception e) {
            throw e;
        }
        return reponse;
    }
    @GetMapping("/getLimite")
    private int getLimite() throws Exception{
        int reponse = 0;
        LimiteService slimiteService = new LimiteService();
        try {
            reponse = slimiteService.getLimite();
        } catch (Exception e) {
            throw e;
        }
        return reponse;
    }
}
