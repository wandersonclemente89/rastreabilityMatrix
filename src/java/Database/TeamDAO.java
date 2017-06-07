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
import model.bean.Team;

/**
 *
 * @author wanderson.barros
 */
public class TeamDAO {    
    
    public void insert(Team team){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {    
            stmt = conn.prepareStatement("INSERT INTO team (name,project) values (?,?)");
            stmt.setString(1, team.getName());
            stmt.setString(2, team.getProject());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public void delete(Team team){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("DELETE FROM team WHERE id=?");
            stmt.setInt(1, team.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
  
    public void update(Team team){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("UPDATE team SET name=?, project=? WHERE id=?");
            stmt.setString(1, team.getName());
            stmt.setString(2, team.getProject());
            stmt.setInt(3, team.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public Team getById(int id){
        Connection conn = ConnectionDb.getConnection();
        ResultSet rs =null;
        Team team = null;
        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("SELECT * FROM team WHERE id=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()){
                team = new Team();
                team.setId(rs.getInt("id"));
                team.setName(rs.getString("name"));
                team.setProject(rs.getString("project"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
        return team;
    }
    
    public List<Team> read(){
        Connection conn = ConnectionDb.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Team> teamList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM team");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Team team = new Team();
                team.setId(rs.getInt("id"));
                team.setName(rs.getString("name"));
                team.setProject(rs.getString("project"));
                
                teamList.add(team);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn, stmt,rs);
        }
        
        return teamList;
    }
    
    public int getIDbyName(String teamName){
        Connection conn = ConnectionDb.getConnection();
        ResultSet rs =null;
        int teamId = -1;
        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("SELECT * FROM team WHERE name=?");
            stmt.setString(1, teamName);
            rs = stmt.executeQuery();
            while (rs.next())
                teamId = rs.getInt("id");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
        return teamId;
    }
    
   public List<Team> getTeamsByBuc(int bucId){
        Connection conn = ConnectionDb.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Team> teamList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT T.id , T.name, T.project FROM buc as B inner join team_has_buc as TB on B.id = TB.BUC_ID inner join team as T on TB.team_id = T.ID where B.id = ?");
            stmt.setInt(1, bucId);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Team team = new Team();
                team.setId(rs.getInt("id"));
                team.setName(rs.getString("name"));
                team.setProject(rs.getString("project"));
                
                teamList.add(team);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn, stmt,rs);
        }
        
        return teamList;
    } 
    
}
