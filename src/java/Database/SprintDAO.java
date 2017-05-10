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
            stmt.setInt(1, sprint.getName());
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
        
    public void update(Sprint sprint){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("UPDATE SPRINT SET name=? WHERE id=?");
            stmt.setInt(1, sprint.getName());
            stmt.setInt(2, sprint.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
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
                sprint.setName(rs.getInt("NAME"));                
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
