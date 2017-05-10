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
public class TeamTest {
    
    public TeamTest() {
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
     * Test of getId method, of class Team.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Team instance = new Team();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProject method, of class Team.
     */
    @Test
    public void testGetProject() {
        System.out.println("getProject");
        Team instance = new Team();
        String expResult = "";
        String result = instance.getProject();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Team.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Team instance = new Team();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Team.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Team instance = new Team();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Team.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Team instance = new Team();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProject method, of class Team.
     */
    @Test
    public void testSetProject() {
        System.out.println("setProject");
        String project = "";
        Team instance = new Team();
        instance.setProject(project);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
