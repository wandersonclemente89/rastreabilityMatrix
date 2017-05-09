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
public class BusinessRequirementsHasEmployees {
    private int BRId;
    private int employeesSignum;

    public int getBRId() {
        return BRId;
    }

    public int getEmployeesSignum() {
        return employeesSignum;
    }

    public void setBRId(int BRId) {
        this.BRId = BRId;
    }

    public void setEmployeesSignum(int employeesSignum) {
        this.employeesSignum = employeesSignum;
    }
    
    
}
