/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author wanderson.barros
 */
public class TechnicalRequirementsHasTestCases {
    private int TRId;
    private int TestCaseId;

    public int getTRId() {
        return TRId;
    }

    public int getTestCaseId() {
        return TestCaseId;
    }

    public void setTRId(int TRId) {
        this.TRId = TRId;
    }

    public void setTestCaseId(int TestCaseId) {
        this.TestCaseId = TestCaseId;
    }
    
    
}
