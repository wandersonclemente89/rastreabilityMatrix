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
    private int businessRequirementId;
    private int statusId;
    private String brName;
    private String statusName;

    public String getBrName() {
        return brName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setBrName(String brName) {
        this.brName = brName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
    

    public int getBusinessRequirementId() {
        return businessRequirementId;
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
        this.businessRequirementId = BusinessRequirementId;
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
