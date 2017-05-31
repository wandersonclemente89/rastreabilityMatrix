
package Servlet;

import Database.BUCDAO;
import Database.BusinessRequirementsDAO;
import Database.EmployeesDAO;
import Database.StatusDAO;
import Database.TeamDAO;
import Database.TechnicalRequirementsDAO;
import Database.TestCasesDAO;
import Database.TestTypeDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.BUC;
import model.bean.BusinessRequirements;
import model.bean.Employees;
import model.bean.Status;
import model.bean.Team;
import model.bean.TechnicalRequirements;
import model.bean.TestCases;
import model.bean.TestType;

/**
 *
 * @author flavio.henrique
 */
public class Buc extends HttpServlet {

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
        BUCDAO bucDAO = new BUCDAO();
        BUC buc = bucDAO.getById(id);
        
        BusinessRequirementsDAO brdao = new BusinessRequirementsDAO();
        List<BusinessRequirements> businessRequirements = null;
        
        TechnicalRequirementsDAO trdao = new TechnicalRequirementsDAO();
        List<TechnicalRequirements> technicalRequirements =  null;
        
        TestTypeDAO testTypeDAO = new TestTypeDAO();
        List<TestType> testTypes = testTypeDAO.read();
        
        StatusDAO statusDAO = new StatusDAO();
        List<Status> statuses = statusDAO.read();
        
        TestCasesDAO tcdao = new TestCasesDAO();
        List<TestCases> testCases = null;
        
        EmployeesDAO employeesDAO = new EmployeesDAO();
        List<Employees> employees = null;
        
        TeamDAO teamDAO = new TeamDAO();
        List<Team> teams = null;
        
        
        if (buc != null) { 
            employees = employeesDAO.getEmployeeListByBuc(id);
            teams = teamDAO.getTeamsByBuc(id);
            technicalRequirements = trdao.getAllTRByBuc(id);
            businessRequirements = brdao.getALLBRByBuc(id);
            testCases = tcdao.getALLTCByBuc(id);
        } else {
            employees = employeesDAO.read();
            teams = teamDAO.read();
            technicalRequirements = trdao.read();
            businessRequirements = brdao.read();
            testCases = tcdao.read();
        }
        
              
        request.setAttribute("businessRequirements", businessRequirements);
        request.setAttribute("technicalRequirements", technicalRequirements);
        request.setAttribute("testCases", testCases);
        request.setAttribute("members", employees);
        request.setAttribute("testTypes", testTypes);
        request.setAttribute("statuses", statuses);
        request.setAttribute("BUC", buc);
        request.setAttribute("teams", teams);
        
        String jsp = "/WEB-INF/jsp/buc.jsp";
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
