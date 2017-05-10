/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.util.List;
import model.bean.BusinessRequirements;
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
public class BusinessRequirementsDAOTest {
    
    public BusinessRequirementsDAOTest() {
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
     * Test of insert method, of class BusinessRequirementsDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        BusinessRequirements businessRequirements = null;
        BusinessRequirementsDAO instance = new BusinessRequirementsDAO();
        instance.insert(businessRequirements);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class BusinessRequirementsDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        BusinessRequirements businessRequirements = null;
        BusinessRequirementsDAO instance = new BusinessRequirementsDAO();
        instance.delete(businessRequirements);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class BusinessRequirementsDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        BusinessRequirements businessRequirements = null;
        BusinessRequirementsDAO instance = new BusinessRequirementsDAO();
        instance.update(businessRequirements);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class BusinessRequirementsDAO.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        BusinessRequirementsDAO instance = new BusinessRequirementsDAO();
        List<BusinessRequirements> expResult = null;
        List<BusinessRequirements> result = instance.read();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
