package Servlet;

import Database.TeamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Team;

/**
 *
 * @author flavio.henrique
 */
public class TeamUpdate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        TeamDAO teamDAO = new TeamDAO();
        teamDAO.getById(id);
        Team team = teamDAO.getById(id);
        
        request.setAttribute("team", team);
        
        String jsp = "/WEB-INF/jsp/teamForm.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("name");
        String project = request.getParameter("project");
        
        TeamDAO teamDAO = new TeamDAO();
        Team team = teamDAO.getById(id);
        team.setName(nome);
        team.setProject(project);
        teamDAO.update(team);

        response.sendRedirect("list");    
    }

}
