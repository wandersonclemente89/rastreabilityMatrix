/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Database.BusinessRequirementsDAO;
import Database.BusinessRequirementsHasEmployeesDAO;
import Database.EmployeesDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.BusinessRequirements;
import model.bean.BusinessRequirementsHasEmployees;
import model.bean.Employees;

/**
 *
 * @author wanderson.barros
 */
public class BRAdd extends HttpServlet {
    
     
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      //  int id = Integer.parseInt(request.getParameter("id"));
        EmployeesDAO employeesDAO = new EmployeesDAO();
        List<Employees> members = employeesDAO.getByIdTeam(2);
        
        BusinessRequirementsDAO brdao = new BusinessRequirementsDAO();
        List<BusinessRequirements> businessRequirements = brdao.read();
        
        request.setAttribute("businessRequirements", businessRequirements);
        
        String jsp = "/WEB-INF/jsp/buc.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
        dispatcher.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String customerNeeds =  request.getParameter("customerNeeds");
        String comments = request.getParameter("comments");
        String [] members = request.getParameterValues("members");
        
        BusinessRequirementsDAO businessRequirementsDAO = new BusinessRequirementsDAO();
        EmployeesDAO employeesDAO = new EmployeesDAO();
        BusinessRequirements br = new BusinessRequirements();

        br.setName(name);
        br.setComments(comments);
        br.setCustomerNeeds(customerNeeds);
        br.setDescription(description);
        br.setStatusId(1);
        
        businessRequirementsDAO.insert(br);
        
        for (int i=0;members!=null && i <members.length;i++){
            BusinessRequirementsHasEmployees brHasEmployees = new BusinessRequirementsHasEmployees();
            BusinessRequirementsHasEmployeesDAO brHasEmployeesDAO = new BusinessRequirementsHasEmployeesDAO();
           
            brHasEmployees.setBRId(businessRequirementsDAO.getIDbyName(name));
            brHasEmployees.setEmployeesSignum(employeesDAO.getSignumbyName(members[i]));
            
            brHasEmployeesDAO.insert(brHasEmployees);
        }
        
        doGet(request, response);
        //response.sendRedirect("/rastreabilityMatrixICC/buc?id=5"); 
    }


}