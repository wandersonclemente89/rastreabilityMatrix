/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Database.EmployeesDAO;
import Database.TeamDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
public class MemberUpdate extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        
        EmployeesDAO employeesDAO = new EmployeesDAO();
        Employees  employees =  employeesDAO.getBySignum(id);
        
        TeamDAO teamDAO = new TeamDAO();
        List<Team> teams = teamDAO.read();
        String teamName = teamDAO.getById(employees.getTeamId()).getName();
        
        request.setAttribute("teams", teams);
        request.setAttribute("member", employees);
        request.setAttribute("teamName", teamName);
        
        String jsp = "/WEB-INF/jsp/memberForm.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
        dispatcher.forward(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String signum = request.getParameter("signum");
       String name = request.getParameter("name");
       String role = request.getParameter("role");
       int teamID = Integer.parseInt(request.getParameter("team"));
       
       EmployeesDAO employeesDAO = new EmployeesDAO();

       
       Employees employees = employeesDAO.getBySignum(signum);
       employees.setName(name);
       employees.setRole(role);
       employees.setTeamId(teamID);
       
       employeesDAO.update(employees);
       
        response.sendRedirect("list");   
    }


}
