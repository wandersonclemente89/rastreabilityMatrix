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
import model.bean.TeamHasBUC;

/**
 *
 * @author felipe.padua
 */
public class TeamHasBUCDAO {
    public void insert(TeamHasBUC teamHasBUC){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("INSERT INTO team_has_buc (team_id,buc_id) values (?,?)");
            stmt.setInt(1, teamHasBUC.getTeamId());
            stmt.setInt(2, teamHasBUC.getBUCId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public void delete(TeamHasBUC teamHasBUC){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("DELETE FROM team_has_buc WHERE TEAM_ID=? and BUC_IDD=?");
            stmt.setInt(1, teamHasBUC.getTeamId());
            stmt.setInt(2, teamHasBUC.getBUCId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public void update(TeamHasBUC teamHasBUC){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("UPDATE team_has_buc SET team_id=?, buc_id=? WHERE TEAM_ID=? and BUC_ID=?");
            stmt.setInt(1, teamHasBUC.getTeamId());
            stmt.setInt(2, teamHasBUC.getBUCId());
            stmt.setInt(3, teamHasBUC.getTeamId());
            stmt.setInt(4, teamHasBUC.getBUCId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public List<TeamHasBUC> read(){
        Connection conn = ConnectionDb.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<TeamHasBUC> teamHasBUCList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM team_has_buc");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                TeamHasBUC teamHasBUC = new TeamHasBUC();
                teamHasBUC.setTeamId(rs.getInt("TEAM_ID"));
                teamHasBUC.setBUCId(rs.getInt("BUC_ID"));             
      
                teamHasBUCList.add(teamHasBUC);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn, stmt,rs);
        }
        
        return teamHasBUCList;
    }
    
    public List<TeamHasBUC> getById(int bucId){
        Connection conn = ConnectionDb.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<TeamHasBUC> teamHasBUCList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM team_has_buc WHERE BUC_ID = ?");
            stmt.setInt(1, bucId);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                TeamHasBUC teamHasBUC = new TeamHasBUC();
                teamHasBUC.setBUCId(rs.getInt("BUC_ID"));
                teamHasBUC.setTeamId(rs.getInt("TEAM_ID"));
      
                teamHasBUCList.add(teamHasBUC);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn, stmt,rs);
        }
        
        return teamHasBUCList;
    }
    public void deleteById(int bucId){
        Connection conn = ConnectionDb.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("DELETE FROM team_has_buc WHERE BUC_ID = ?");
            stmt.setInt(1, bucId);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn, stmt);
        }
    }
}
