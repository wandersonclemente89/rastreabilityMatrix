
package Servlet;

import Database.BUCDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.BUC;

public class bucAdd extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String jsp = "/WEB-INF/jsp/bucAdd.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        
        BUC buc = new BUC();
        buc.setName(name);
        
        BUCDAO bucDAO =  new BUCDAO();
        bucDAO.insert(buc);

        response.sendRedirect("/buc/list");    
    }


}
