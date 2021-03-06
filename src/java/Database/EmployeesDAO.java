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
            stmt = conn.prepareStatement("INSERT INTO employees (signum,name,role,team_Id) values (?,?,?,?)");
            stmt.setString(1, employee.getSignum());
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
            stmt = conn.prepareStatement("DELETE FROM employees WHERE SIGNUM=?");
            stmt.setString(1, employee.getSignum());
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
            stmt = conn.prepareStatement("UPDATE employees SET name=?, role=?, team_id=? WHERE signum=?");
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getRole());
            stmt.setInt(3, employee.getTeamId()); 
            stmt.setString(4, employee.getSignum());
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
            stmt = conn.prepareStatement("SELECT * FROM employees");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Employees employee = new Employees();
                employee.setSignum(rs.getString("SIGNUM"));
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
    
    public List<Employees> getByIdTeam(int teamId){
        Connection conn = ConnectionDb.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Employees> employeesList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM employees WHERE TEAM_ID = ?");
            stmt.setInt(1, teamId);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Employees employees = new Employees();
                employees.setSignum(rs.getString("SIGNUM"));
                employees.setName(rs.getString("NAME"));
                employees.setRole(rs.getString("ROLE"));
      
                employeesList.add(employees);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn, stmt,rs);
        }
        
        return employeesList;
    }
        public Employees getBySignum(String signum){
        Connection conn = ConnectionDb.getConnection();
        ResultSet rs =null;
        Employees employees = null;
        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("SELECT * FROM employees WHERE SIGNUM=?");
            stmt.setString(1, signum);
            rs = stmt.executeQuery();
            if (rs.next()){
                employees = new Employees();
                employees.setSignum(rs.getString("SIGNUM"));
                employees.setName(rs.getString("NAME"));
                employees.setRole(rs.getString("ROLE"));
                employees.setTeamId(rs.getInt("TEAM_ID"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
        return employees;
    }
    
    public String getSignumbyName(String employeeName){
        Connection conn = ConnectionDb.getConnection();
        ResultSet rs =null;
        String signum = null;
        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("SELECT * FROM employees WHERE NAME=?");
            stmt.setString(1, employeeName);
            rs = stmt.executeQuery();
            while (rs.next())
                signum = rs.getString("signum");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
        return signum;
    }
    public List<Employees> getEmployeeListByBuc(int bucId){
        Connection conn = ConnectionDb.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Employees> employeesList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT E.SIGNUM, E.NAME, E.ROLE FROM employees as E inner join team as T on E.TEAM_ID = T.ID inner join team_has_buc as TB on T.ID = TB.TEAM_ID inner join buc as B on B.ID = TB.BUC_ID where B.ID = ?");
            stmt.setInt(1, bucId);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Employees employees = new Employees();
                employees.setSignum(rs.getString("SIGNUM"));
                employees.setName(rs.getString("NAME"));
                employees.setRole(rs.getString("ROLE"));
      
                employeesList.add(employees);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn, stmt,rs);
        }
        
        return employeesList;
    }
    public List<Employees> readWithTeamInformation(){
        Connection conn = ConnectionDb.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Employees> employeesList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("select E.signum, E.name, E.role, T.name as tname, T.project from employees as E inner join team as T on E.team_id = T.id");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Employees employees = new Employees();
                employees.setSignum(rs.getString("SIGNUM"));
                employees.setName(rs.getString("NAME"));
                employees.setRole(rs.getString("ROLE"));
                employees.setEmployeeTeamName(rs.getString("tname"));
                employees.setEmployeeProject(rs.getString("project"));
      
                employeesList.add(employees);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn, stmt,rs);
        }
        
        return employeesList;
    }
}
