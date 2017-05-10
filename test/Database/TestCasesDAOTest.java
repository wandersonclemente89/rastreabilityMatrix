/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.util.List;
import model.bean.TestCases;
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
public class TestCasesDAOTest {
    
    public TestCasesDAOTest() {
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
     * Test of insert method, of class TestCasesDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        TestCases testCase = null;
        TestCasesDAO instance = new TestCasesDAO();
        instance.insert(testCase);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class TestCasesDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        TestCases testCase = null;
        TestCasesDAO instance = new TestCasesDAO();
        instance.delete(testCase);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class TestCasesDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        TestCases testCases = null;
        TestCasesDAO instance = new TestCasesDAO();
        instance.update(testCases);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class TestCasesDAO.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        TestCasesDAO instance = new TestCasesDAO();
        List<TestCases> expResult = null;
        List<TestCases> result = instance.read();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
