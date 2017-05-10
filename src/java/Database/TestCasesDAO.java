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
import model.bean.TestCases;

/**
 *
 * @author wanderson.barros
 */
public class TestCasesDAO {
    public void insert(TestCases  testCase){
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
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public void delete(TestCases  testCase){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("DELETE FROM TEST_CASES WHERE ID=?");
            stmt.setInt(1, testCase.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public void update(TestCases testCases){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("UPDATE TEST_CASES SET name=?, full_path=?, employees_signum=?, status_id=?, test_type_id=? WHERE id=?");
            stmt.setString(1, testCases.getName());
            stmt.setString(2, testCases.getFullPath());
            stmt.setString(3, testCases.getEmployeesSignum());
            stmt.setInt(4, testCases.getStatusId());
            stmt.setInt(5, testCases.getTestTypeId());           
            stmt.setInt(6, testCases.getId());           
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public List<TestCases> read(){
        Connection conn = ConnectionDb.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<TestCases> testCaseList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM test_cases");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                TestCases testCases = new TestCases();
                testCases.setId(rs.getInt("ID"));
                testCases.setName(rs.getString("NAME"));
                testCases.setFullPath(rs.getString("FULL_PATH"));
                testCases.setEmployeesSignum(rs.getString("EMPLOYEES_SIGNUM"));
                testCases.setStatusId(rs.getInt("STATUS_ID"));
                testCases.setTestTypeId(rs.getInt("TEST_TYPE_ID"));
                
                testCaseList.add(testCases);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn, stmt,rs);
        }
        
        return testCaseList;
    }
}
