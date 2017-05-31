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
    private String statusName;
    private String teamName;
    private String testTypeName;
    private String tRName;

    public String getStatusName() {
        return statusName;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTestTypeName() {
        return testTypeName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String gettRName() {
        return tRName;
    }

    public void setTestTypeName(String testTypeName) {
        this.testTypeName = testTypeName;
    }

    public void settRName(String tRName) {
        this.tRName = tRName;
    }
    
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
