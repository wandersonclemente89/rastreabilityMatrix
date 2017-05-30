/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Database.TestCasesDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.TestCases;

/**
 *
 * @author wanderson.barros
 */
public class TCAdd extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String fullPath = request.getParameter("fullPath");
        int owner = Integer.parseInt(request.getParameter("owner"));
        int testType = Integer.parseInt(request.getParameter("testType"));
        int statusID = Integer.parseInt(request.getParameter("status"));
        String [] technicalRequirement = request.getParameterValues("technicalRequirement");
        int [] technicalRequirementIds = new int [technicalRequirement.length];
        
        for(int i=0; i<technicalRequirement.length; i++){
                technicalRequirementIds[i] = Integer.parseInt(technicalRequirement[i]);
        }
        
        TestCasesDAO tcdao = new TestCasesDAO();
        TestCases tc =  new TestCases();
            
        tc.setName(name);
        tc.setFullPath(fullPath);
        tc.setStatusId(statusID);
        tc.setTestTypeId(testType);
        tc.setTeamId(owner);
        
        tcdao.insert(tc);
       
        
        response.sendRedirect("/rastreabilityMatrixICC/buc?id="+request.getParameter("id"));
    }
}
