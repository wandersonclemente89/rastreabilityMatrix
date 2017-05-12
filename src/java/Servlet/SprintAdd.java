
package Servlet;

import Database.BUCDAO;
import Database.BUCHasSprintDAO;
import Database.SprintDAO;
import Database.TeamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
 * @author flavio.henrique
 */
@WebServlet(name = "SprintAdd", urlPatterns = {"/sprint/add"})
public class SprintAdd extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        BUCDAO bucDAO = new BUCDAO();
        List<BUC> bucs = bucDAO.read();
        
        request.setAttribute("bucs", bucs);
        
        String jsp = "/WEB-INF/jsp/sprintAdd.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sprintName = request.getParameter("name");
        String [] bucList = request.getParameterValues("bucs");
        
         Sprint sprint = new Sprint();
        sprint.setName(sprintName);
        
        SprintDAO sprintDAO = new SprintDAO();
        BUCDAO bucDAO =  new BUCDAO();
        sprintDAO.insert(sprint);
        

        for (int i=0;bucList!=null && i <bucList.length;i++){
            BUCHasSprint bucHasPrint = new BUCHasSprint();
            BUCHasSprintDAO bUCHasSprintDAO = new BUCHasSprintDAO();
            
            bucHasPrint.setBUCId(Integer.parseInt(bucList[i]));
            bucHasPrint.setSprintId(sprintDAO.getIDbyName(sprintName));
            
            bUCHasSprintDAO.insert(bucHasPrint);
        }
        
        response.sendRedirect("list");    
    }



}
