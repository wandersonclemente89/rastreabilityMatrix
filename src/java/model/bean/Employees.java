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
public class Employees {
    private String signum;
    private String name;
    private String role;
    private int teamId;

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getSignum() {
        return signum;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSignum(String signum) {
        this.signum = signum;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
    
    
}
