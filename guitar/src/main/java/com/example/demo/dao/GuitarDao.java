package com.example.demo.dao;

import com.example.demo.entity.Guitar;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
public class GuitarDao {

    public List<Guitar> findAllGuitar(){
        Connection conn = SqliteUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs =null;
        String sql = "select * from guitar";
        try {
           ps = conn.prepareStatement(sql);
           rs = ps.executeQuery();
           List<Guitar> list = new ArrayList<>();
           while (rs.next()){
               Guitar guitar = new Guitar();
               guitar.setId(rs.getInt("id"));
               guitar.setName(rs.getString("name"));
               guitar.setPrice(rs.getDouble("price"));
               guitar.setWood(rs.getString("wood"));
               guitar.setColor(rs.getString("color"));
               list.add(guitar);
           }
           return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                ps.close();
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void addGuitar(Guitar guitar){
        Connection conn = SqliteUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into guitar(name,price,wood,color) values(?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,guitar.getName());
            ps.setDouble(2,guitar.getPrice());
            ps.setString(3,guitar.getWood());
            ps.setString(4,guitar.getColor());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteById(Integer id) {
        Connection conn = SqliteUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "delete from guitar where id =?";
        try {
            ps =conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public List<Guitar> findByName(String name) {
        Connection conn = SqliteUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from guitar where name =？";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            List<Guitar> list = new ArrayList<>();
            while (rs.next()) {
                Guitar guitar = new Guitar();
                guitar.setId(rs.getInt("id"));
                guitar.setName(rs.getString("name"));
                guitar.setPrice(rs.getDouble("price"));
                guitar.setWood(rs.getString("wood"));
                guitar.setColor(rs.getString("color"));
                list.add(guitar);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
