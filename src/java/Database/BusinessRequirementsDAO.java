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
import model.bean.BusinessRequirements;

/**
 *
 * @author wanderson.barros
 */
public class BusinessRequirementsDAO {
       public void insert(BusinessRequirements businessRequirements){
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
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public void delete(BusinessRequirements businessRequirements){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("DELETE FROM BUSINESS_REQUIREMENTS WHERE ID=?");
            stmt.setInt(1, businessRequirements.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public void update(BusinessRequirements businessRequirements){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("UPDATE BUSINESS_REQUIREMENTS SET name=?, description=?, comments=?, customer_needs=?, status_id=? WHERE id=?");
            stmt.setString(1, businessRequirements.getName());
            stmt.setString(2, businessRequirements.getDescription());
            stmt.setString(3, businessRequirements.getComments());
            stmt.setString(4, businessRequirements.getCustomerNeeds());
            stmt.setInt(5, businessRequirements.getStatusId());
            stmt.setInt(6, businessRequirements.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public List<BusinessRequirements> read(){
        Connection conn = ConnectionDb.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<BusinessRequirements> BusinessRequirementList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM business_requirements");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                BusinessRequirements businessRequirements = new BusinessRequirements();
                businessRequirements.setId(rs.getInt("ID"));
                businessRequirements.setName(rs.getString("NAME"));
                businessRequirements.setDescription(rs.getString("DESCRIPTION"));
                businessRequirements.setCustomerNeeds(rs.getString("CUSTOMER_NEEDS"));
                businessRequirements.setComments(rs.getString("COMMENTS"));
                businessRequirements.setStatusId(rs.getInt("STATUS_ID"));
                
                BusinessRequirementList.add(businessRequirements);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn, stmt,rs);
        }
        
        return BusinessRequirementList;
    }

}
