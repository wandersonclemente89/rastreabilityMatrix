/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Database.TechnicalRequirementsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.TechnicalRequirements;

/**
 *
 * @author felipe.padua
 */
@WebServlet(name = "TRDelete", urlPatterns = {"/tr/delete"})
public class TRDelete extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        
        TechnicalRequirements tr = new TechnicalRequirements();
        tr.setId(id);
        
        
        TechnicalRequirementsDAO trDAO = new TechnicalRequirementsDAO();
        int bucID = trDAO.getBucIDbyTRID(id);
        trDAO.delete(tr);
        
        response.sendRedirect("/rastreabilityMatrixICC/buc?id="+bucID);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //
    }

 

}
