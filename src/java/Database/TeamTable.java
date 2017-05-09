/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Team;

/**
 *
 * @author wanderson.barros
 */
public class TeamTable {    
    
    public void insertTeam(Team team){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("INSERT INTO TEAM (name,project) values (?,?)");
            stmt.setString(1, team.getTeam());
            stmt.setString(2, team.getProject());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TeamTable.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionDb.closeConnection(conn);
        }
    }
    
    public void deleteTeam(Team team){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("DELETE FROM TEAM WHERE ID=?");
            stmt.setInt(1, team.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TeamTable.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionDb.closeConnection(conn);
        }
    }
    
    
    
    
}
