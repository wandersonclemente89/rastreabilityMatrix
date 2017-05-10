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
import model.bean.TechnicalRequirements;

/**
 *
 * @author wanderson.barros
 */
public class TechnicalRequirementsDAO {
    public void insert(TechnicalRequirements technicalRequirements){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("INSERT INTO TECHNICAL_REQUIREMENTS (name,description,comments,business_requirements,status) values (?,?,?,?,?)");
            stmt.setString(1, technicalRequirements.getName());
            stmt.setString(2, technicalRequirements.getDescription());
            stmt.setString(3, technicalRequirements.getComments());
            stmt.setInt(4, technicalRequirements.getBusinessRequirementId());
            stmt.setInt(5, technicalRequirements.getStatusId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public void delete(TechnicalRequirements technicalRequirements){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("DELETE FROM TECHNICAL_REQUIREMENTS WHERE ID=?");
            stmt.setInt(1, technicalRequirements.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public void update(TechnicalRequirements technicalRequirements){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("UPDATE TECHNICAL_REQUIREMENTS SET name=?, description=?, comments=?, business_requirements_id=?, status_id=? WHERE id=?");
            stmt.setString(1, technicalRequirements.getName());
            stmt.setString(2, technicalRequirements.getDescription());
            stmt.setString(3, technicalRequirements.getComments());
            stmt.setInt(4, technicalRequirements.getBusinessRequirementId());
            stmt.setInt(5, technicalRequirements.getStatusId());
            stmt.setInt(6, technicalRequirements.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
    
    public List<TechnicalRequirements> read(){
        Connection conn = ConnectionDb.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<TechnicalRequirements> technicalRequirementList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM technical_requirements");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                TechnicalRequirements technicalRequirements = new TechnicalRequirements();
                technicalRequirements.setId(rs.getInt("ID"));
                technicalRequirements.setName(rs.getString("NAME"));
                technicalRequirements.setDescription(rs.getString("DESCRIPTION"));
                technicalRequirements.setComments(rs.getString("COMMENTS"));
                technicalRequirements.setBusinessRequirementId(rs.getInt("BUSINESS_REQUIREMENTS_ID"));
                technicalRequirements.setStatusId(rs.getInt("STATUS_ID"));
                
                technicalRequirementList.add(technicalRequirements);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn, stmt,rs);
        }
        
        return technicalRequirementList;
    }
}
