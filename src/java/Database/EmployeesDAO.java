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
import model.bean.Employees;

/**
 *
 * @author felipe.padua
 */
public class EmployeesDAO {
    public void insert(Employees employee){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("INSERT INTO EMPLOYEES (signum,name,role,teamId) values (?,?,?,?)");
            stmt.setInt(1, employee.getSignum());
            stmt.setString(2, employee.getName());
            stmt.setString(3, employee.getRole());
            stmt.setInt(4, employee.getTeamId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public void delete(Employees employee){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("DELETE FROM EMPLOYEES WHERE SIGNUM=?");
            stmt.setInt(1, employee.getSignum());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
        
    public void update(Employees employee){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("UPDATE EMPLOYEES SET name=?, role=?, team_id=? WHERE signum=?");
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getRole());
            stmt.setInt(3, employee.getTeamId()); 
            stmt.setInt(4, employee.getSignum());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }

    public List<Employees> read(){
        Connection conn = ConnectionDb.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Employees> employesList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM EMPLOYEES");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Employees employee = new Employees();
                employee.setSignum(rs.getInt("SIGNUM"));
                employee.setName(rs.getString("NAME"));
                employee.setRole(rs.getString("ROLE"));
                employee.setTeamId(rs.getInt("TEAM_ID"));
                
                employesList.add(employee);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn, stmt,rs);
        }
        
        return employesList;
    }
        
}
