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
public class TeamHasBUC {
    private int teamId;
    private int BUCId;

    public int getBUCId() {
        return BUCId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setBUCId(int BUCId) {
        this.BUCId = BUCId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
    
    
}
