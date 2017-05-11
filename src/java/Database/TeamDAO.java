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
            stmt = conn.prepareStatement("INSERT INTO TEAM (name,project) values (?,?)");
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
            stmt = conn.prepareStatement("DELETE FROM TEAM WHERE ID=?");
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
            stmt = conn.prepareStatement("UPDATE TEAM SET name=?, project=? WHERE id=?");
            stmt.setString(1, team.getName());
            stmt.setString(2, team.getProject());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
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
                team.setId(rs.getInt("ID"));
                team.setName(rs.getString("NAME"));
                team.setProject(rs.getString("PROJECT"));
                
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
