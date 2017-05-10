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
public class BUCHasSprintTest {
    
    public BUCHasSprintTest() {
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
     * Test of getBUCId method, of class BUCHasSprint.
     */
    @Test
    public void testGetBUCId() {
        System.out.println("getBUCId");
        BUCHasSprint instance = new BUCHasSprint();
        int expResult = 0;
        int result = 0;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSprintId method, of class BUCHasSprint.
     */
    @Test
    public void testGetSprintId() {
        System.out.println("getSprintId");
        BUCHasSprint instance = new BUCHasSprint();
        int expResult = 0;
        int result = instance.getSprintId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBUCId method, of class BUCHasSprint.
     */
    @Test
    public void testSetBUCId() {
        System.out.println("setBUCId");
        int BUCId = 0;
        BUCHasSprint instance = new BUCHasSprint();
        instance.setBUCId(BUCId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSprintId method, of class BUCHasSprint.
     */
    @Test
    public void testSetSprintId() {
        System.out.println("setSprintId");
        int sprintId = 0;
        BUCHasSprint instance = new BUCHasSprint();
        instance.setSprintId(sprintId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
