/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Sprint;

/**
 *
 * @author felipe.padua
 */
public class SprintDAO {
    public void insert(Sprint sprint){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("INSERT INTO SPRINT (name) values (?)");
            stmt.setString(1, sprint.getName());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public void delete(Sprint sprint){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("DELETE FROM SPRINT WHERE ID=?");
            stmt.setInt(1, sprint.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public Sprint getById(int id){
        Connection conn = ConnectionDb.getConnection();
        ResultSet rs =null;
        Sprint sprint = null;
        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("SELECT * FROM SPRINT WHERE ID=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()){
                sprint = new Sprint();
                sprint.setId(rs.getInt("ID"));
                sprint.setName(rs.getString("NAME"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
        return sprint;
    }
        
    public void update(Sprint sprint){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("UPDATE SPRINT SET name=? WHERE id=?");
            stmt.setString(1, sprint.getName());
            stmt.setInt(2, sprint.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public int getIDbyName(String sprintName){
        Connection conn = ConnectionDb.getConnection();
        ResultSet rs =null;
        int sprintId = -1;
        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("SELECT * FROM SPRINT WHERE NAME=?");
            stmt.setString(1, sprintName);
            rs = stmt.executeQuery();
            while (rs.next())
                sprintId = rs.getInt("id");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
        return sprintId;
    }

    public List<Sprint> read(){
        Connection conn = ConnectionDb.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Sprint> sprintList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM SPRINT");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Sprint sprint = new Sprint();
                sprint.setId(rs.getInt("ID"));
                sprint.setName(rs.getString("NAME"));                
                sprintList.add(sprint);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn, stmt,rs);
        }
        
        return sprintList;
    }
}
