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
import model.bean.TechnicalRequirementsHasTestCases;

/**
 *
 * @author felipe.padua
 */
public class TechnicalRequirementsHasTestCasesDAO {
    public void insert(TechnicalRequirementsHasTestCases technicalRequirementsHasTestCases){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("INSERT INTO technical_requirements_has_test_cases (TECHNICAL_REQUIREMENTS_ID,TEST_CASES_ID) values (?,?)");
            stmt.setInt(1, technicalRequirementsHasTestCases.getTRId());
            stmt.setInt(2, technicalRequirementsHasTestCases.getTestCaseId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public void delete(TechnicalRequirementsHasTestCases technicalRequirementsHasTestCases){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("DELETE FROM technical_requirements_has_test_cases WHERE TECHNICAL_REQUIREMENTS_ID=? and TEST_CASES_ID=?");
            stmt.setInt(1, technicalRequirementsHasTestCases.getTRId());
            stmt.setInt(2, technicalRequirementsHasTestCases.getTestCaseId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public void update(TechnicalRequirementsHasTestCases technicalRequirementsHasTestCases){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("UPDATE technical_requirements_has_test_cases SET TECHNICAL_REQUIREMENTS_ID=?, TEST_CASES_ID=? WHERE TECHNICAL_REQUIREMENTS_ID=? and TEST_CASES_ID=?");
            stmt.setInt(1, technicalRequirementsHasTestCases.getTRId());
            stmt.setInt(2, technicalRequirementsHasTestCases.getTestCaseId());
            stmt.setInt(3, technicalRequirementsHasTestCases.getTRId());
            stmt.setInt(4, technicalRequirementsHasTestCases.getTestCaseId());          
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public List<TechnicalRequirementsHasTestCases> read(){
        Connection conn = ConnectionDb.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<TechnicalRequirementsHasTestCases> technicalRequirementsHasTestCasesList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM technical_requirements_has_test_cases");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                TechnicalRequirementsHasTestCases technicalRequirementsHasTestCases = new TechnicalRequirementsHasTestCases();
                technicalRequirementsHasTestCases.setTRId(rs.getInt("TECHNICAL_REQUIREMENTS_ID"));
                technicalRequirementsHasTestCases.setTestCaseId(rs.getInt("TEST_CASES_ID"));
      
                technicalRequirementsHasTestCasesList.add(technicalRequirementsHasTestCases);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn, stmt,rs);
        }
        
        return technicalRequirementsHasTestCasesList;
    }
    
    
}
