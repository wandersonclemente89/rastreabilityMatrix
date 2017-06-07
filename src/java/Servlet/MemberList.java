package Servlet;

import Database.EmployeesDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Employees;

/**
 *
 * @author flavio.henrique
 */
public class MemberList extends HttpServlet {

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
        
       
        EmployeesDAO employeesDAO = new EmployeesDAO();
        List<Employees> employees = employeesDAO.readWithTeamInformation();
        
        request.setAttribute("members", employees);
        
        String jsp = "/WEB-INF/jsp/memberList.jsp";
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
