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
public class TestCases {
    private int id;
    private String name;
    private String fullPath;
    private int teamId;
    private int statusId;
    private int testTypeId;

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

  
    public String getFullPath() {
        return fullPath;
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

    public int getTestTypeId() {
        return testTypeId;
    }

   

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
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

    public void setTestTypeId(int testTypeId) {
        this.testTypeId = testTypeId;
    }
    
    
}
