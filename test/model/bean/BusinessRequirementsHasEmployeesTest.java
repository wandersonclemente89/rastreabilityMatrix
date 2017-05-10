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
public class BusinessRequirementsHasEmployeesTest {
    
    public BusinessRequirementsHasEmployeesTest() {
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
     * Test of getBRId method, of class BusinessRequirementsHasEmployees.
     */
    @Test
    public void testGetBRId() {
        System.out.println("getBRId");
        BusinessRequirementsHasEmployees instance = new BusinessRequirementsHasEmployees();
        int expResult = 0;
        int result = instance.getBRId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployeesSignum method, of class BusinessRequirementsHasEmployees.
     */
    @Test
    public void testGetEmployeesSignum() {
        System.out.println("getEmployeesSignum");
        BusinessRequirementsHasEmployees instance = new BusinessRequirementsHasEmployees();
        int expResult = 0;
        String result = instance.getEmployeesSignum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBRId method, of class BusinessRequirementsHasEmployees.
     */
    @Test
    public void testSetBRId() {
        System.out.println("setBRId");
        int BRId = 0;
        BusinessRequirementsHasEmployees instance = new BusinessRequirementsHasEmployees();
        instance.setBRId(BRId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmployeesSignum method, of class BusinessRequirementsHasEmployees.
     */
    @Test
    public void testSetEmployeesSignum() {
        System.out.println("setEmployeesSignum");
        String employeesSignum = null;
        BusinessRequirementsHasEmployees instance = new BusinessRequirementsHasEmployees();
        instance.setEmployeesSignum(employeesSignum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
