
package Servlet;

import Database.TeamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Team;

/**
 *
 * @author wanderson.barros
 */
public class TeamDelete extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        Team team = new Team();
        team.setId(id);
        
        TeamDAO teamDAO = new TeamDAO();
        teamDAO.update(team);
        
        response.sendRedirect("list");    
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
