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
            stmt = conn.prepareStatement("INSERT INTO TEST_CASES (name,full_path,team_Id,status_id,test_type_id) values (?,?,?,?,?)");
            stmt.setString(1, testCase.getName());
            stmt.setString(2, testCase.getFullPath());
            stmt.setInt(3, testCase.getTeamId());
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
            stmt = conn.prepareStatement("UPDATE TEST_CASES SET name=?, full_path=?, team_id=?, status_id=?, test_type_id=? WHERE id=?");
            stmt.setString(1, testCases.getName());
            stmt.setString(2, testCases.getFullPath());
            stmt.setInt(3, testCases.getTeamId());
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
                testCases.setTeamId(rs.getInt("TEAM_ID"));
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
    public List<TestCases> getALLTCByBuc(int bucId){
        Connection conn = ConnectionDb.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<TestCases> testCaseList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("select TC.ID, TC.NAME, TC.FULL_PATH, S.NAME as SNAME, TT.NAME as TTNAME, T.NAME as TNAME, TR.NAME as TRNAME from test_cases as TC inner join technical_requirements_has_test_cases as TRHASTC on TC.ID = TRHASTC.TEST_CASES_ID inner join technical_requirements as TR on TR.ID = TRHASTC.TECHNICAL_REQUIREMENTS_ID join business_requirements as BR on TR.BUSINESS_REQUIREMENTS_ID = BR.ID inner join BUC as B on B.ID = BR.buc_ID inner join status as S on S.ID = TC.STATUS_ID inner join test_type as TT on TC.TEST_TYPE_ID = TT.ID inner join team as T on T.ID = TC.team_ID where B.ID=?");
            stmt.setInt(1, bucId);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                TestCases testCases = new TestCases();
                testCases.setId(rs.getInt("ID"));
                testCases.setName(rs.getString("NAME"));
                testCases.setFullPath(rs.getString("FULL_PATH"));
                testCases.setTeamName(rs.getString("TNAME"));
                testCases.setStatusName(rs.getString("SNAME"));
                testCases.setTestTypeName(rs.getString("TTNAME"));
                testCases.settRName(rs.getString("TRNAME"));
                
                testCaseList.add(testCases);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn, stmt,rs);
        }
        
        return testCaseList;
    }
    
    public int getIDbyName(String tcName){
        Connection conn = ConnectionDb.getConnection();
        ResultSet rs =null;
        int sprintId = -1;
        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("SELECT * FROM test_cases WHERE NAME=?");
            stmt.setString(1, tcName);
            rs = stmt.executeQuery();
            while (rs.next())
                sprintId = rs.getInt("id");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
        return sprintId;
    }
    
}
