
package Servlet;

import Database.SprintDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Sprint;

/**
 *
 * @author wanderson.barros
 */
public class SprintDelete extends HttpServlet {

   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        Sprint sprint = new Sprint();
        sprint.setId(id);
        
        SprintDAO sprintDAO = new SprintDAO();
        sprintDAO.delete(sprint);
        
        response.sendRedirect("list");  
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
}
