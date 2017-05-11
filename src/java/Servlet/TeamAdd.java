
package Servlet;

import Database.TeamDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Team;

/**
 *
 * @author flavio.henrique
 */
@WebServlet(name = "TeamAdd", urlPatterns = {"/team/add"})
public class TeamAdd extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        
        String jsp = "/WEB-INF/jsp/teamAdd.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("name");
        String project = request.getParameter("project");
        
        Team team = new Team();
        team.setName(nome);
        team.setProject(project);
        
        TeamDAO teamDAO = new TeamDAO();
        teamDAO.insert(team);

        response.sendRedirect("/team/list");    
    }



}
