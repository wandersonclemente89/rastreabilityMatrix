
package Servlet;

import Database.BUCDAO;
import Database.EmployeesDAO;
import Database.TeamDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.BUC;
import model.bean.Employees;
import model.bean.Team;

/**
 *
 * @author flavio.henrique
 */
public class TeamDashboard extends HttpServlet {

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
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        TeamDAO teamDAO = new TeamDAO();
        Team team = teamDAO.getById(id);
        request.setAttribute("team", team);
        

        EmployeesDAO employeesDAO = new EmployeesDAO();
        List<Employees> employeesList = employeesDAO.getByIdTeam(id);
        request.setAttribute("memberList", employeesList);
        
        BUCDAO bucDAO = new BUCDAO();
        List<BUC> bucList = bucDAO.getByIdTeam(id);
        request.setAttribute("bucList", bucList);
        
        String jsp = "/WEB-INF/jsp/team.jsp";
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
    }

}
