package com.example.demo.service;
import java.sql.*;
import java.util.ArrayList;

import com.example.demo.connectBase.ConnectBase;
import com.example.demo.model.*;

public class ArticleService {
    public void newArticle(Article article) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            ConnectBase connex = new ConnectBase();
            String requete = "insert into article (idtype , introduction , corps , resumer , contenue) values ("+article.getIdtype()+",'"+article.getIntroduction()+"','"+article.getCorps()+"','"+article.getResumer()+"','"+article.getContenue()+"')";
            con = connex.Connect();
            stmt = con.prepareStatement(requete);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    public ArrayList<Article> GetAll() throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        ArrayList<Article> list = new ArrayList<Article>();
        try {
            ConnectBase connex = new ConnectBase();
            String requete = "select * from article";
            con = connex.Connect();
            stmt = con.prepareStatement(requete);
            res = stmt.executeQuery();
            Article article = null;
            while (res.next()) {
                article = new Article();
                article.setId(res.getInt("id"));
                article.setIdtype(res.getInt("idtype"));
                article.setIntroduction(res.getString("introduction"));
                article.setCorps(res.getString("corps"));
                article.setResumer(res.getString("resumer"));
                article.setContenue(res.getString("contenue"));
                list.add(article);
            }
        } catch (Exception e) {
            throw e;
        }
        return list;
    }
}
