
package Servlet;

import Database.BUCDAO;
import Database.BUCHasSprintDAO;
import Database.SprintDAO;
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

/**
 *
 * @author wanderson.barros
 */
public class SprintUpdate extends HttpServlet {

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
        
        
        SprintDAO sprintDAO = new SprintDAO();
        sprintDAO.getById(id);
        Sprint sprint = sprintDAO.getById(id);
        
        BUCDAO bucDAO = new BUCDAO();
        BUCHasSprintDAO bUCHasSprintDAO = new BUCHasSprintDAO();
        List<BUC> bucs = bucDAO.read();
        List<BUCHasSprint> selectedbucs = bUCHasSprintDAO.getById(id);
        
        request.setAttribute("bucs", bucs);
        request.setAttribute("selectedBucs", selectedbucs);
        request.setAttribute("sprint", sprint);
        
        
        String jsp = "/WEB-INF/jsp/sprintForm.jsp";
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
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("name");
        String [] selectedBucs = request.getParameterValues("bucs");
        
        SprintDAO sprintDAO = new SprintDAO();
        BUCHasSprintDAO bUCHasSprintDAO = new BUCHasSprintDAO();
        BUCDAO bucdao = new BUCDAO();
        
        Sprint sprint = sprintDAO.getById(id);
        sprint.setName(nome);
        sprintDAO.update(sprint);
        bUCHasSprintDAO.deleteById(id);
        for (int i=0; selectedBucs!=null && i< selectedBucs.length;i++){
            BUCHasSprint bUCHasSprint = new BUCHasSprint();
            bUCHasSprint.setSprintId(id);
            bUCHasSprint.setBUCId(Integer.parseInt(selectedBucs[i]));
            
            bUCHasSprintDAO.insert(bUCHasSprint);
        }

        response.sendRedirect("list");    
    }

 
}
