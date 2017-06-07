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
import model.bean.BUC;

/**
 *
 * @author wanderson.barros
 */
public class BUCDAO {

    public void insert(BUC buc) {
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO buc (name) values (?)");
            stmt.setString(1, buc.getName());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDb.closeConnection(conn, stmt);
        }
    }

    public void delete(BUC buc) {
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("DELETE FROM buc WHERE id=?");
            stmt.setInt(1, buc.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDb.closeConnection(conn, stmt);
        }
    }

    public int getIDbyName(String bucName) {
        Connection conn = ConnectionDb.getConnection();
        ResultSet rs = null;
        int bucId = -1;
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM buc WHERE name=?");
            stmt.setString(1, bucName);
            rs = stmt.executeQuery();
            while (rs.next()) {
                bucId = rs.getInt("id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDb.closeConnection(conn, stmt);
        }
        return bucId;
    }

    public BUC getById(int id) {
        Connection conn = ConnectionDb.getConnection();
        ResultSet rs = null;
        BUC buc = new BUC();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM buc WHERE id=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                buc.setId(rs.getInt("id"));
                buc.setName(rs.getString("name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDb.closeConnection(conn, stmt);
        }
        return buc;
    }

    public void update(BUC buc) {
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("UPDATE buc SET name=? WHERE id=?");
            stmt.setString(1, buc.getName());
            stmt.setInt(2, buc.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDb.closeConnection(conn, stmt);
        }
    }

    public List<BUC> read() {
        Connection conn = ConnectionDb.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<BUC> bucList = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM buc");
            rs = stmt.executeQuery();

            while (rs.next()) {
                BUC buc = new BUC();
                buc.setId(rs.getInt("id"));
                buc.setName(rs.getString("name"));

                bucList.add(buc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDb.closeConnection(conn, stmt, rs);
        }

        return bucList;
    }

    public List<BUC> getByIdTeam(int idTeam) {
        Connection conn = ConnectionDb.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<BUC> bucList = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT *, rm_db.buc.name as bucName FROM rm_db.buc "
                    + "join rm_db.team_has_buc on  rm_db.buc.id = rm_db.team_has_buc.buc_id "
                    + "join rm_db.team on rm_db.team.id = rm_db.team_has_buc.team_id "
                    + "where rm_db.team.id = ?;");
            stmt.setInt(1, idTeam);
            rs = stmt.executeQuery();

            while (rs.next()) {
                BUC buc = new BUC();
                buc.setId(rs.getInt("buc_id"));
                buc.setName(rs.getString("bucName"));

                bucList.add(buc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDb.closeConnection(conn, stmt, rs);
        }

        return bucList;
    }
}
