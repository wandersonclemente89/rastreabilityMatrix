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
import model.bean.BUCHasSprint;

/**
 *
 * @author wanderson.barros
 */
public class BUCHasSprintDAO {
    public void insert(BUCHasSprint bUCHasSprint){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("INSERT INTO BUC_has_SPRINT (buc_id,sprint_id) values (?,?)");
            stmt.setInt(1, bUCHasSprint.getBUCId());
            stmt.setInt(2, bUCHasSprint.getSprintId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public void delete(BUCHasSprint bUCHasSprint){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("DELETE FROM BUC_has_SPRINT WHERE BUC_ID=? and SPRINT_ID=?");
            stmt.setInt(1, bUCHasSprint.getBUCId());
            stmt.setInt(2, bUCHasSprint.getSprintId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public void update(BUCHasSprint bUCHasSprint){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("UPDATE BUC_has_SPRINT SET buc_id=?, sprint_id=? WHERE BUC_ID=? and SPRINT_ID=?");
            stmt.setInt(1, bUCHasSprint.getBUCId());
            stmt.setInt(2, bUCHasSprint.getSprintId());
            stmt.setInt(3, bUCHasSprint.getBUCId());
            stmt.setInt(4, bUCHasSprint.getSprintId());           
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public List<BUCHasSprint> read(){
        Connection conn = ConnectionDb.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<BUCHasSprint> bUCHasSprintList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM buc_has_sprint");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                BUCHasSprint bUCHasSprint = new BUCHasSprint();
                bUCHasSprint.setBUCId(rs.getInt("BUC_ID"));
                bUCHasSprint.setSprintId(rs.getInt("SPRINT_ID"));
      
                bUCHasSprintList.add(bUCHasSprint);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn, stmt,rs);
        }
        
        return bUCHasSprintList;
    }
    
    public List<BUCHasSprint> getById(int sprintId){
        Connection conn = ConnectionDb.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<BUCHasSprint> bUCHasSprintList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM buc_has_sprint WHERE SPRINT_ID = ?");
            stmt.setInt(1, sprintId);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                BUCHasSprint bUCHasSprint = new BUCHasSprint();
                bUCHasSprint.setBUCId(rs.getInt("BUC_ID"));
                bUCHasSprint.setSprintId(rs.getInt("SPRINT_ID"));
      
                bUCHasSprintList.add(bUCHasSprint);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn, stmt,rs);
        }
        
        return bUCHasSprintList;
    }
    public void deleteById(int sprintId){
        Connection conn = ConnectionDb.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("DELETE FROM buc_has_sprint WHERE SPRINT_ID = ?");
            stmt.setInt(1, sprintId);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn, stmt);
        }
    }
}
