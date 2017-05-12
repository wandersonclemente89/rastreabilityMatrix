
package Servlet;

import Database.BUCDAO;
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
import model.bean.Team;
import model.bean.TeamHasBUC;

public class bucAdd extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         Team team = new Team();
        TeamDAO teamDAO = new TeamDAO();
        List<Team> teams = teamDAO.read();
        
        request.setAttribute("teams", teams);
        
        String jsp = "/WEB-INF/jsp/bucForm.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String bucName = request.getParameter("name");
        String[] teamList = request.getParameterValues("teams");
                
        BUC buc = new BUC();
        buc.setName(bucName);
        
        TeamDAO teamDAO = new TeamDAO();
        BUCDAO bucDAO =  new BUCDAO();
        bucDAO.insert(buc);
        

        for (int i=0;teamList!=null && i <teamList.length;i++){
            TeamHasBUC teamHasBUC = new TeamHasBUC();
            TeamHasBUCDAO teamHasBUCDAO = new TeamHasBUCDAO();
            
            teamHasBUC.setBUCId(bucDAO.getIDbyName(bucName));
            teamHasBUC.setTeamId(Integer.parseInt(teamList[i]));
            
            teamHasBUCDAO.insert(teamHasBUC);
        }
        
        response.sendRedirect("list");    
    }


}
