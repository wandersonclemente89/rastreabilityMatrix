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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author wanderson.barros
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({model.bean.BUCTest.class, model.bean.SprintTest.class, model.bean.TechnicalRequirementsTest.class, model.bean.EmployeesTest.class, model.bean.BusinessRequirementsTest.class, model.bean.TeamHasBUCTest.class, model.bean.StatusTest.class, model.bean.BusinessRequirementsHasEmployeesTest.class, model.bean.TestTypeTest.class, model.bean.BUCHasSprintTest.class, model.bean.TeamTest.class, model.bean.TestCasesTest.class, model.bean.TechnicalRequirementsHasTestCasesTest.class})
public class BeanSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
