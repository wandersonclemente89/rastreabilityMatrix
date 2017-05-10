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
public class TeamHasBUCTest {
    
    public TeamHasBUCTest() {
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
     * Test of getBUCId method, of class TeamHasBUC.
     */
    @Test
    public void testGetBUCId() {
        System.out.println("getBUCId");
        TeamHasBUC instance = new TeamHasBUC();
        int expResult = 0;
        int result = instance.getBUCId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTeamId method, of class TeamHasBUC.
     */
    @Test
    public void testGetTeamId() {
        System.out.println("getTeamId");
        TeamHasBUC instance = new TeamHasBUC();
        int expResult = 0;
        int result = instance.getTeamId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBUCId method, of class TeamHasBUC.
     */
    @Test
    public void testSetBUCId() {
        System.out.println("setBUCId");
        int BUCId = 0;
        TeamHasBUC instance = new TeamHasBUC();
        instance.setBUCId(BUCId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTeamId method, of class TeamHasBUC.
     */
    @Test
    public void testSetTeamId() {
        System.out.println("setTeamId");
        int teamId = 0;
        TeamHasBUC instance = new TeamHasBUC();
        instance.setTeamId(teamId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
