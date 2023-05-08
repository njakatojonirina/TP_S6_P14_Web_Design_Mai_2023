package com.example.demo.service;
import java.sql.*;

import com.example.demo.connectBase.ConnectBase;

public class LimiteService {
    public int getLimite() throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        int reponse = 0;
        try {
            ConnectBase connex = new ConnectBase();
            String requete = "select * from limite";
            con = connex.Connect();
            stmt = con.prepareStatement(requete);
            res = stmt.executeQuery();
            while (res.next()) {
                reponse = res.getInt("valeur");
                break;
            }
        } catch (Exception e) {
            throw e;
        }
        return reponse;
    }
    public int pagination() throws Exception{
        int reponse = 0;
        try {
            int limite = getLimite();
            int nombre_page = new V_articleService().getNombrePage();
            reponse = nombre_page/limite;
            System.out.print(limite);
            System.out.print(nombre_page);
            if (nombre_page%limite != 0) {
                reponse = reponse+1;
            }else{
                reponse=reponse;
            }
        } catch (Exception e) {
            throw e;
        }
        return reponse;
    }

}
