/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.util.List;
import model.bean.Team;
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
public class TeamDAOTest {
    
    public TeamDAOTest() {
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
     * Test of insert method, of class TeamDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Team team = null;
        TeamDAO instance = new TeamDAO();
        instance.insert(team);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class TeamDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Team team = null;
        TeamDAO instance = new TeamDAO();
        instance.delete(team);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class TeamDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Team team = null;
        TeamDAO instance = new TeamDAO();
        instance.update(team);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class TeamDAO.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        TeamDAO instance = new TeamDAO();
        List<Team> expResult = null;
        List<Team> result = instance.read();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
