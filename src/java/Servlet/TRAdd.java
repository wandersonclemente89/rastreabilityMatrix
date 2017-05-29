/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Database.BUCDAO;
import Database.BusinessRequirementsDAO;
import Database.EmployeesDAO;
import Database.StatusDAO;
import Database.TechnicalRequirementsDAO;
import Database.TestCasesDAO;
import Database.TestTypeDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.BUC;
import model.bean.BusinessRequirements;
import model.bean.Employees;
import model.bean.Status;
import model.bean.TechnicalRequirements;
import model.bean.TestCases;
import model.bean.TestType;

/**
 *
 * @author wanderson.barros
 */
public class TRAdd extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // int id = Integer.parseInt(request.getParameter("id"));
       // BUCDAO bucDAO = new BUCDAO();
       // BUC buc = bucDAO.getById(id);
        
         String jsp = "/buc";
        RequestDispatcher dispatcher = request.getRequestDispatcher(jsp);
        dispatcher.forward(request, response);
        
        
    }

        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String name = request.getParameter("name");
        String description = request.getParameter("description");
        String comments = request.getParameter("comments");
        int businessRequirementID = Integer.parseInt(request.getParameter("businessRequirements"));
        int statusID = Integer.parseInt(request.getParameter("status"));
        
        TechnicalRequirementsDAO trdao = new TechnicalRequirementsDAO();
        EmployeesDAO employeesDAO = new EmployeesDAO();
        TechnicalRequirements tr = new TechnicalRequirements();

        tr.setName(name);
        tr.setComments(comments);
        tr.setDescription(description);
        tr.setBusinessRequirementId(businessRequirementID);
        tr.setStatusId(statusID);
        
        trdao.insert(tr);
        /*
        for (int i=0;members!=null && i <members.length;i++){
            BusinessRequirementsHasEmployees brHasEmployees = new BusinessRequirementsHasEmployees();
            BusinessRequirementsHasEmployeesDAO brHasEmployeesDAO = new BusinessRequirementsHasEmployeesDAO();
           
            brHasEmployees.setBRId(trdao.getIDbyName(name));
            brHasEmployees.setEmployeesSignum(employeesDAO.getSignumbyName(members[i]));
            
            brHasEmployeesDAO.insert(brHasEmployees);
        }
        */
        //doGet(request, response);
        response.sendRedirect("/rastreabilityMatrixICC/buc?id=5"); 
    }

    

}
