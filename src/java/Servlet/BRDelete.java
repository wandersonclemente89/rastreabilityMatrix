/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Database.BusinessRequirementsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.BusinessRequirements;

/**
 *
 * @author felipe.padua
 */
@WebServlet(name = "BRDelete", urlPatterns = {"/br/delete"})
public class BRDelete extends HttpServlet {

    /**
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
        

        
        BusinessRequirements br = new BusinessRequirements();
        br.setId(id);
        
        
        BusinessRequirementsDAO brDAO = new BusinessRequirementsDAO();
        int bucID = brDAO.getBucIDbyBRID(id);
        brDAO.delete(br);
        
        response.sendRedirect("/rastreabilityMatrixICC/buc?id="+bucID);

    }

    /**
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
