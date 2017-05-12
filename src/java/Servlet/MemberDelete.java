/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Database.EmployeesDAO;
import Database.TeamDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Employees;
import model.bean.Team;

/**
 *
 * @author wanderson.barros
 */
public class MemberDelete extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String signum = request.getParameter("id");
        
        Employees employees = new Employees();
        employees.setSignum(signum);
        
        EmployeesDAO employeesDAO = new EmployeesDAO();
        employeesDAO.delete(employees);
        
        response.sendRedirect("list"); 
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
    }

}
