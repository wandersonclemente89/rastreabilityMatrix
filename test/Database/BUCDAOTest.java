/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.util.List;
import model.bean.BUC;
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
public class BUCDAOTest {
    
    public BUCDAOTest() {
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
     * Test of insert method, of class BUCDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        BUC buc = null;
        BUCDAO instance = new BUCDAO();
        instance.insert(buc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class BUCDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        BUC buc = null;
        BUCDAO instance = new BUCDAO();
        instance.delete(buc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class BUCDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        BUC buc = null;
        BUCDAO instance = new BUCDAO();
        instance.update(buc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class BUCDAO.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        BUCDAO instance = new BUCDAO();
        List<BUC> expResult = null;
        List<BUC> result = instance.read();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
