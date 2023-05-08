package com.example.demo.service;

import java.sql.*;
import java.util.ArrayList;

import com.example.demo.connectBase.ConnectBase;
import com.example.demo.model.*;

public class TypeService {
    public void newType(Type type) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            ConnectBase connex = new ConnectBase();
            String requete = "insert into type (type) values ('"+type.getType()+"')";
            con = connex.Connect();
            stmt = con.prepareStatement(requete);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    public ArrayList<Type> GetAll() throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        ArrayList<Type> list = new ArrayList<Type>();
        try {
            ConnectBase connex = new ConnectBase();
            String requete = "select * from type";
            con = connex.Connect();
            stmt = con.prepareStatement(requete);
            res = stmt.executeQuery();
            Type type = null;
            while (res.next()) {
                type = new Type();
                type.setId(res.getInt("id"));
                type.setType(res.getString("type"));
                list.add(type);
            }
        } catch (Exception e) {
            throw e;
        }
        return list;
    }
}
