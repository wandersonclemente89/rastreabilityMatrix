
package Servlet;

import Database.BUCDAO;
import Database.BusinessRequirementsDAO;
import Database.TestCasesDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.BUC;
import model.bean.BusinessRequirements;
import model.bean.TestCases;

/**
 *
 * @author flavio.henrique
 */
public class Report extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int bucId = Integer.parseInt(request.getParameter("bucId"));
        
        BUCDAO bucdao = new BUCDAO();
        BUC buc = bucdao.getById(bucId);
        
        BusinessRequirementsDAO brdao = new BusinessRequirementsDAO();
        List<BusinessRequirements> businessRequirements = null;
        
        TestCasesDAO tcdao = new TestCasesDAO();
        List<TestCases> testCases = null;
        
        if(buc!=null){
            businessRequirements = brdao.getALLBRByBuc(bucId);
            testCases = tcdao.getTCperBR(bucId);
        }else {
            businessRequirements = brdao.read();
            testCases = tcdao.read();
        }
        
        request.setAttribute("BUC", buc);
        request.setAttribute("businessRequirements", businessRequirements);
        request.setAttribute("testCases", testCases);
        
        String jsp = "/WEB-INF/jsp/report.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
