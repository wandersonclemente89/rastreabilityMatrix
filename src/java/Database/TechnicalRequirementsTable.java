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
import model.bean.TechnicalRequirements;

/**
 *
 * @author wanderson.barros
 */
public class TechnicalRequirementsTable {
    public void insertTR(TechnicalRequirements technicalRequirements){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("INSERT INTO TECHNICAL_REQUIREMENTS (name,description,comments,business_requirements,status) values (?,?,?,?,?)");
            stmt.setString(1, technicalRequirements.getName());
            stmt.setString(2, technicalRequirements.getDescription());
            stmt.setString(3, technicalRequirements.getComments());
            stmt.setInt(4, technicalRequirements.getBusinessRequirementId());
            stmt.setInt(5, technicalRequirements.getStatusId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TeamTable.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionDb.closeConnection(conn);
        }
    }
    
    public void deleteTR(TechnicalRequirements technicalRequirements){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("DELETE FROM TECHNICAL_REQUIREMENTS WHERE ID=?");
            stmt.setInt(1, technicalRequirements.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TeamTable.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionDb.closeConnection(conn);
        }
    }
}
