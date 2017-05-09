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
import model.bean.BUC;

/**
 *
 * @author wanderson.barros
 */
public class BUCTable {
     public void insertBUC(BUC buc){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("INSERT INTO BUC (name) values (?)");
            stmt.setString(1, buc.getName());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TeamTable.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionDb.closeConnection(conn);
        }
    }
    
    public void deleteTeam(BUC buc){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("DELETE FROM BUC WHERE ID=?");
            stmt.setInt(1, buc.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TeamTable.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionDb.closeConnection(conn);
        }
    }
}
