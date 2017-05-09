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
import model.bean.BusinessRequirements;

/**
 *
 * @author wanderson.barros
 */
public class BusinessRequirementsTable {
       public void insertBR(BusinessRequirements businessRequirements){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("INSERT INTO BUSINESS_REQUIREMENTS (name,description,customer_needs,comments,status) values (?,?,?,?,?)");
            stmt.setString(1, businessRequirements.getName());
            stmt.setString(2, businessRequirements.getDescription());
            stmt.setString(3, businessRequirements.getCustomerNeeds());
            stmt.setString(4, businessRequirements.getComments());
            stmt.setInt(5, businessRequirements.getStatusId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TeamTable.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionDb.closeConnection(conn);
        }
    }
    
    public void deleteBR(BusinessRequirements businessRequirements){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("DELETE FROM BUSINESS_REQUIREMENTS WHERE ID=?");
            stmt.setInt(1, businessRequirements.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TeamTable.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionDb.closeConnection(conn);
        }
    }

}
