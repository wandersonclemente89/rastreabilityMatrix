/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Database.BUCDAO;
import Database.BUCHasSprintDAO;
import Database.SprintDAO;
import Database.TeamDAO;
import Database.TeamHasBUCDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.BUC;
import model.bean.BUCHasSprint;
import model.bean.Sprint;
import model.bean.Team;
import model.bean.TeamHasBUC;

/**
 *
 * @author wanderson.barros
 */
public class BUCUpdate extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        
        BUCDAO bucDAO = new BUCDAO();
        BUC buc = bucDAO.getById(id);
        
        TeamDAO teamDAO = new TeamDAO();
        TeamHasBUCDAO teamHasBUCDAO = new TeamHasBUCDAO();
        List<Team> teams = teamDAO.read();
        List<TeamHasBUC> selectedTeams = teamHasBUCDAO.getById(id);
        
        request.setAttribute("teams", teams);
        request.setAttribute("selectedTeams", selectedTeams);
        request.setAttribute("buc", buc);
        
        
        String jsp = "/WEB-INF/jsp/bucForm.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
        dispatcher.forward(request, response);
  
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("name");
        String [] selectedTeams = request.getParameterValues("teams");
        
        BUCDAO bUCDAO = new BUCDAO();
        TeamHasBUCDAO teamHasBUCDAO = new TeamHasBUCDAO();
        TeamDAO teamDAO = new TeamDAO();
        
        BUC buc = bUCDAO.getById(id);
        buc.setName(nome);
        bUCDAO.update(buc);
        teamHasBUCDAO.deleteById(id);
        for (int i=0; selectedTeams!=null && i< selectedTeams.length;i++){
            TeamHasBUC teamHasBUC = new TeamHasBUC();
            teamHasBUC.setBUCId(id);
            teamHasBUC.setTeamId(Integer.parseInt(selectedTeams[i]));
            
            teamHasBUCDAO.insert(teamHasBUC);
        }
        
        

        response.sendRedirect("list");   
    }

   
}
