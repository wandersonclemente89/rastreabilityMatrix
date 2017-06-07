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

    /**
     * Insert a new Sprint into database
     * @param sprint Object from Sprint class
     */
    public void insert(Sprint sprint){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("INSERT INTO sprint (name) values (?)");
            stmt.setString(1, sprint.getName());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    /**
     * Delete a sprint from database
     * @param sprint Object from Sprint Class
     */
    public void delete(Sprint sprint){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("DELETE FROM sprint WHERE ID=?");
            stmt.setInt(1, sprint.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    /**
     * Returns a Sprint object from its ID
     * @param id The ID of the sprint
     * @return Sprint Object
     */
    public Sprint getById(int id){
        Connection conn = ConnectionDb.getConnection();
        ResultSet rs =null;
        Sprint sprint = null;
        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("SELECT * FROM sprint WHERE ID=?");
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
        
    /**
     * Update a Sprint information
     * @param sprint Object from Sprint class
     */
    public void update(Sprint sprint){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("UPDATE sprint SET name=? WHERE id=?");
            stmt.setString(1, sprint.getName());
            stmt.setInt(2, sprint.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    /**
     * Returns the Sprint ID from its name
     * @param sprintName Sprint's name
     * @return The ID of the Sprint
     */
    public int getIDbyName(String sprintName){
        Connection conn = ConnectionDb.getConnection();
        ResultSet rs =null;
        int sprintId = -1;
        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("SELECT * FROM sprint WHERE NAME=?");
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

    /**
     * Returns a List of all Sprints in database
     * @return List of Sprints
     */
    public List<Sprint> read(){
        Connection conn = ConnectionDb.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Sprint> sprintList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM sprint");
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
