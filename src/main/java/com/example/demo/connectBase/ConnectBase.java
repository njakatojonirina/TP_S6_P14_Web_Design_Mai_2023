package com.example.demo.connectBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectBase {
    Connection connectPostgres ;
    public Connection Connect(){
        Connection con = null;
        try{
            Class.forName("org.postgresql.Driver");
            // con  = DriverManager.getConnection("jdbc:postgresql://containers-us-west-133.railway.app:7816/railway" , "postgres" , "ZzrqsXOVSYprINJwIDYL") ;
            con = (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/webdesignmai2023","webdesignmai","webdesignmai");
            System.out.println("connecter");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
