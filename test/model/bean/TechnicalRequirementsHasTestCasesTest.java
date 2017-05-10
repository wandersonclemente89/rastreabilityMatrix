/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

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
public class TechnicalRequirementsHasTestCasesTest {
    
    public TechnicalRequirementsHasTestCasesTest() {
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
     * Test of getTRId method, of class TechnicalRequirementsHasTestCases.
     */
    @Test
    public void testGetTRId() {
        System.out.println("getTRId");
        TechnicalRequirementsHasTestCases instance = new TechnicalRequirementsHasTestCases();
        int expResult = 0;
        int result = instance.getTRId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTestCaseId method, of class TechnicalRequirementsHasTestCases.
     */
    @Test
    public void testGetTestCaseId() {
        System.out.println("getTestCaseId");
        TechnicalRequirementsHasTestCases instance = new TechnicalRequirementsHasTestCases();
        int expResult = 0;
        int result = instance.getTestCaseId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTRId method, of class TechnicalRequirementsHasTestCases.
     */
    @Test
    public void testSetTRId() {
        System.out.println("setTRId");
        int TRId = 0;
        TechnicalRequirementsHasTestCases instance = new TechnicalRequirementsHasTestCases();
        instance.setTRId(TRId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTestCaseId method, of class TechnicalRequirementsHasTestCases.
     */
    @Test
    public void testSetTestCaseId() {
        System.out.println("setTestCaseId");
        int TestCaseId = 0;
        TechnicalRequirementsHasTestCases instance = new TechnicalRequirementsHasTestCases();
        instance.setTestCaseId(TestCaseId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
