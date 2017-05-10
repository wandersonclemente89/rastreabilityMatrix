/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.util.List;
import model.bean.TechnicalRequirements;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wanderson.barros
 */
public class TechnicalRequirementsDAOTest {
    
    public TechnicalRequirementsDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class TechnicalRequirementsDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        TechnicalRequirements technicalRequirements = null;
        TechnicalRequirementsDAO instance = new TechnicalRequirementsDAO();
        instance.insert(technicalRequirements);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class TechnicalRequirementsDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        TechnicalRequirements technicalRequirements = null;
        TechnicalRequirementsDAO instance = new TechnicalRequirementsDAO();
        instance.delete(technicalRequirements);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class TechnicalRequirementsDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        TechnicalRequirements technicalRequirements = null;
        TechnicalRequirementsDAO instance = new TechnicalRequirementsDAO();
        instance.update(technicalRequirements);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class TechnicalRequirementsDAO.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        TechnicalRequirementsDAO instance = new TechnicalRequirementsDAO();
        List<TechnicalRequirements> expResult = null;
        List<TechnicalRequirements> result = instance.read();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
