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
import model.bean.BusinessRequirementsHasEmployees;

/**
 *
 * @author felipe.padua
 */
public class BusinessRequirementsHasEmployeesDAO {
    public void insert(BusinessRequirementsHasEmployees businessRequirementsHasEmployees){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("INSERT INTO business_requirements_has_employess (BUSINESS_REQUIREMENTS_ID,EMPLOYEES_SIGNUM) values (?,?)");
            stmt.setInt(1, businessRequirementsHasEmployees.getBRId());
            stmt.setString(2, businessRequirementsHasEmployees.getEmployeesSignum());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public void delete(BusinessRequirementsHasEmployees businessRequirementsHasEmployees){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("DELETE FROM business_requirements_has_employess WHERE BUSINESS_REQUIREMENTS_ID=? and EMPLOYEES_SIGNUM=?");
            stmt.setInt(1, businessRequirementsHasEmployees.getBRId());
            stmt.setString(2, businessRequirementsHasEmployees.getEmployeesSignum());
            stmt.executeUpdate();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public void update(BusinessRequirementsHasEmployees businessRequirementsHasEmployees){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("UPDATE business_requirements_has_employess SET BUSINESS_REQUIREMENTS_ID=?, EMPLOYEES_SIGNUM=? WHERE BUSINESS_REQUIREMENTS_ID=? and EMPLOYEES_SIGNUM=?");
            stmt.setInt(1, businessRequirementsHasEmployees.getBRId());
            stmt.setString(2, businessRequirementsHasEmployees.getEmployeesSignum());
            stmt.setInt(3, businessRequirementsHasEmployees.getBRId());
            stmt.setString(4, businessRequirementsHasEmployees.getEmployeesSignum());           
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public List<BusinessRequirementsHasEmployees> read(){
        Connection conn = ConnectionDb.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<BusinessRequirementsHasEmployees> BusinessRequirementsHasEmployeesList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM business_requirements_has_employess");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                BusinessRequirementsHasEmployees businessRequirementsHasEmployees = new BusinessRequirementsHasEmployees();
                businessRequirementsHasEmployees.setBRId(rs.getInt("BUSINESS_REQUIREMENTS_ID"));
                businessRequirementsHasEmployees.setEmployeesSignum(rs.getString("EMPLOYEES_SIGNUM"));
      
                BusinessRequirementsHasEmployeesList.add(businessRequirementsHasEmployees);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn, stmt,rs);
        }
        
        return BusinessRequirementsHasEmployeesList;
    }
    
}
