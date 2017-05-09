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
public class TechnicalRequirements {
    private int id;
    private String name;
    private String description;
    private String comments;
    private int BusinessRequirementId;
    private int statusId;

    public int getBusinessRequirementId() {
        return BusinessRequirementId;
    }

    public String getComments() {
        return comments;
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

    public void setBusinessRequirementId(int BusinessRequirementId) {
        this.BusinessRequirementId = BusinessRequirementId;
    }

    public void setComments(String comments) {
        this.comments = comments;
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
