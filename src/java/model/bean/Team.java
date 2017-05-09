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
public class Team {
    private int id;
    private String team;
    private String project;

    public int getId() {
        return id;
    }

    public String getProject() {
        return project;
    }

    public String getTeam() {
        return team;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setProject(String project) {
        this.project = project;
    }

    
    
    
}
