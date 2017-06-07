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
            stmt = conn.prepareStatement("INSERT INTO technical_requirements (name,description,comments,business_requirements_id,status_id) values (?,?,?,?,?)");
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
            stmt = conn.prepareStatement("DELETE FROM technical_requirements WHERE ID=?");
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
            stmt = conn.prepareStatement("UPDATE technical_requirements SET name=?, description=?, comments=?, business_requirements_id=?, status_id=? WHERE id=?");
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
    
    
    public List<TechnicalRequirements> getAllTRByBuc(int bucId){
        Connection conn = ConnectionDb.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<TechnicalRequirements> technicalRequirementList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("select TR.ID, TR.NAME, TR.DESCRIPTION, TR.COMMENTS, BR.NAME as BRNAME, S.NAME as SNAME from technical_requirements as TR inner join business_requirements as BR on TR.BUSINESS_REQUIREMENTS_ID = BR.ID inner join buc as B on B.ID = BR.buc_ID inner join status as S on S.ID = TR.STATUS_ID where B.ID = ?");
            stmt.setInt(1, bucId);
            rs = stmt.executeQuery();
    
            while(rs.next()){
                TechnicalRequirements technicalRequirements = new TechnicalRequirements();
                technicalRequirements.setId(rs.getInt("ID"));
                technicalRequirements.setName(rs.getString("NAME"));
                technicalRequirements.setDescription(rs.getString("DESCRIPTION"));
                technicalRequirements.setComments(rs.getString("COMMENTS"));
                technicalRequirements.setBrName(rs.getString("BRNAME"));
                technicalRequirements.setStatusName(rs.getString("SNAME"));
                
                technicalRequirementList.add(technicalRequirements);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn, stmt,rs);
        }
        
        return technicalRequirementList;
    }
    
    
    /*
    public int getBucIDbyTRID(int trID){
        Connection conn = ConnectionDb.getConnection();
        ResultSet rs = null;
        ResultSet rs2 = null;
        int brID = -1;
        int bucID = -1;
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        try { 
            stmt = conn.prepareStatement("SELECT business_requirements_id FROM technical_requirements WHERE ID=?");
            stmt.setInt(1, trID);
            rs = stmt.executeQuery();
            while (rs.next())
                brID = rs.getInt("business_requirements_id");
            
            stmt2 = conn.prepareStatement("SELECT buc_id FROM business_requirements WHERE ID=?");
            stmt2.setInt(1, brID);
            rs2 = stmt2.executeQuery();
            while (rs2.next())
                bucID = rs2.getInt("BUC_ID");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
            ConnectionDb.closeConnection(conn,stmt2);
        }
        return bucID;
    }
    */
 
}
