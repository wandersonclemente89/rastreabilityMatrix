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
public class EmployeesTest {
    
    public EmployeesTest() {
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
     * Test of getName method, of class Employees.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Employees instance = new Employees();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRole method, of class Employees.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        Employees instance = new Employees();
        String expResult = "";
        String result = instance.getRole();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSignum method, of class Employees.
     */
    @Test
    public void testGetSignum() {
        System.out.println("getSignum");
        Employees instance = new Employees();
        int expResult = 0;
        int result = instance.getSignum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTeamId method, of class Employees.
     */
    @Test
    public void testGetTeamId() {
        System.out.println("getTeamId");
        Employees instance = new Employees();
        int expResult = 0;
        int result = instance.getTeamId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Employees.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Employees instance = new Employees();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRole method, of class Employees.
     */
    @Test
    public void testSetRole() {
        System.out.println("setRole");
        String role = "";
        Employees instance = new Employees();
        instance.setRole(role);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSignum method, of class Employees.
     */
    @Test
    public void testSetSignum() {
        System.out.println("setSignum");
        int signum = 0;
        Employees instance = new Employees();
        instance.setSignum(signum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTeamId method, of class Employees.
     */
    @Test
    public void testSetTeamId() {
        System.out.println("setTeamId");
        int teamId = 0;
        Employees instance = new Employees();
        instance.setTeamId(teamId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
