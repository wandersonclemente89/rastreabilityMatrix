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
public class BusinessRequirements {
    private int id;
    private String name;
    private String description;
    private String customerNeeds;
    private String comments;
    private int statusId;
    private int bucId;

    public int getBucId() {
        return bucId;
    }

    public void setBucId(int bucId) {
        this.bucId = bucId;
    }
    
    
    public String getComments() {
        return comments;
    }

    public String getCustomerNeeds() {
        return customerNeeds;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setCustomerNeeds(String customerNeeds) {
        this.customerNeeds = customerNeeds;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }
    
    
}
