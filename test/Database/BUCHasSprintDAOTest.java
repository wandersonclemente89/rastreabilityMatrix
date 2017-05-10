/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.util.List;
import model.bean.BUCHasSprint;
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
public class BUCHasSprintDAOTest {
    
    public BUCHasSprintDAOTest() {
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
     * Test of insert method, of class BUCHasSprintDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        BUCHasSprint bUCHasSprint = null;
        BUCHasSprintDAO instance = new BUCHasSprintDAO();
        instance.insert(bUCHasSprint);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class BUCHasSprintDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        BUCHasSprint bUCHasSprint = null;
        BUCHasSprintDAO instance = new BUCHasSprintDAO();
        instance.delete(bUCHasSprint);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class BUCHasSprintDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        BUCHasSprint bUCHasSprint = null;
        BUCHasSprintDAO instance = new BUCHasSprintDAO();
        instance.update(bUCHasSprint);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class BUCHasSprintDAO.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        BUCHasSprintDAO instance = new BUCHasSprintDAO();
        List<BUCHasSprint> expResult = null;
        List<BUCHasSprint> result = instance.read();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
