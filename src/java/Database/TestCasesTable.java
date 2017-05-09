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
import model.bean.TestCases;

/**
 *
 * @author wanderson.barros
 */
public class TestCasesTable {
    public void insertTestCase(TestCases  testCase){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("INSERT INTO TEST_CASES (name,full_path,employees_signum,status,test_type) values (?,?,?,?,?)");
            stmt.setString(1, testCase.getName());
            stmt.setString(2, testCase.getFullPath());
            stmt.setString(3, testCase.getEmployeesSignum());
            stmt.setInt(4, testCase.getStatusId());
            stmt.setInt(5, testCase.getTestTypeId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TeamTable.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionDb.closeConnection(conn);
        }
    }
    
    public void deleteTestCase(TestCases  testCase){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("DELETE FROM TEST_CASES WHERE ID=?");
            stmt.setInt(1, testCase.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TeamTable.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionDb.closeConnection(conn);
        }
    }
}
