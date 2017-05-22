
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
public class MemberAdd extends HttpServlet {

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
        
        Team team = new Team();
        TeamDAO teamDAO = new TeamDAO();
        List<Team> teams = teamDAO.read();
        
        request.setAttribute("teams", teams);
        
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
        
        String name = request.getParameter("name");
        String role = request.getParameter("role");
        String signum = request.getParameter("signum");
        String teamId = request.getParameter("team");
        
   
        Employees employees = new Employees();
        employees.setName(name);
        employees.setRole(role);
        employees.setSignum(signum);
        employees.setTeamId(Integer.parseInt(teamId));
        
        
        EmployeesDAO employeesDAO =  new EmployeesDAO();
        employeesDAO.insert(employees);

        response.sendRedirect("list");  
    }

}
