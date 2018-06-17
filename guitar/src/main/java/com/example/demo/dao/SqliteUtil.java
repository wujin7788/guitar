package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqliteUtil {

    public static Connection getConnection(){
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Administrator\\Desktop\\guitar\\guitar.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){
        Connection conn = SqliteUtil.getConnection();
        String sql = "create table guitar(id Integer primary key autoincrement," +
                "name varchar(100)," +
                "price DOUBLE," +
                "wood varchar(100) ," +
                "color varchar(50))";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
