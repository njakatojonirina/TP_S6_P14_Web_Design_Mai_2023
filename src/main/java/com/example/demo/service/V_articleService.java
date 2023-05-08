package com.example.demo.service;
import java.sql.*;
import java.util.ArrayList;

import com.example.demo.connectBase.ConnectBase;
import com.example.demo.model.*;

public class V_articleService {
    public ArrayList<V_article> GetAll(int depart) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        ArrayList<V_article> list = new ArrayList<V_article>();
        try {
            ConnectBase connex = new ConnectBase();
            int limite = new LimiteService().getLimite();
            String requete = "select * from v_article offset "+depart+" limit "+limite;
            con = connex.Connect();
            stmt = con.prepareStatement(requete);
            res = stmt.executeQuery();
            V_article article = null;
            while (res.next()) {
                article = new V_article();
                article.setId(res.getInt("id"));
                article.setIdtype(res.getInt("idtype"));
                article.setIntroduction(res.getString("introduction"));
                article.setCorps(res.getString("corps"));
                article.setResumer(res.getString("resumer"));
                article.setContenue(res.getString("contenue"));
                article.setType(res.getString("type"));
                list.add(article);
            }
        } catch (Exception e) {
            throw e;
        }
        return list;
    }
    public ArrayList<V_article> getDetailsArticle(String id) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        ArrayList<V_article> list = new ArrayList<V_article>();
        try {
            ConnectBase connex = new ConnectBase();
            String requete = "select * from v_article where id = "+id;
            con = connex.Connect();
            stmt = con.prepareStatement(requete);
            res = stmt.executeQuery();
            V_article article = null;
            while (res.next()) {
                article = new V_article();
                article.setId(res.getInt("id"));
                article.setIdtype(res.getInt("idtype"));
                article.setIntroduction(res.getString("introduction"));
                article.setCorps(res.getString("corps"));
                article.setResumer(res.getString("resumer"));
                article.setContenue(res.getString("contenue"));
                article.setType(res.getString("type"));
                list.add(article);
            }
        } catch (Exception e) {
            throw e;
        }
        return list;
    }
    public int getSize() throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        int reponse = 0;
        try {
            ConnectBase connex = new ConnectBase();
            String requete = "select count(*)id from v_article";
            con = connex.Connect();
            stmt = con.prepareStatement(requete);
            res = stmt.executeQuery();
            while (res.next()) {
                reponse = res.getInt("id");
            }
        } catch (Exception e) {
            throw e;
        }
        return reponse;
    }
    public int getNombrePage() throws Exception{
        int nombre_page = 0;
        try {
            nombre_page = getSize();
        } catch (Exception e) {
            throw e;
        }
        return nombre_page;
    }
}
