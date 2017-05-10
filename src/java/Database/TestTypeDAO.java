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
import model.bean.TestType;

/**
 *
 * @author felipe.padua
 */
public class TestTypeDAO {
    public void insert(TestType testType){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("INSERT INTO TEST_TYPE (name) values (?)");
            stmt.setString(1, testType.getName());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public void delete(TestType testType){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("DELETE FROM TEST_TYPE WHERE ID=?");
            stmt.setInt(1, testType.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public void update(TestType testType){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("UPDATE TEST_TYPE SET name=? WHERE id=?");
            stmt.setString(1, testType.getName());
            stmt.setInt(2, testType.getId());           
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public List<TestType> read(){
        Connection conn = ConnectionDb.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<TestType> testTypeList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM TEST_TYPE");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                TestType testType = new TestType();
                testType.setId(rs.getInt("ID"));
                testType.setName(rs.getString("NAME"));
      
                testTypeList.add(testType);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn, stmt,rs);
        }
        
        return testTypeList;
    }
    
}
