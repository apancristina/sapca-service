package com.apan.sapca.service.model;

import java.util.List;

/**
 * Created by apanc on 1/23/2016.
 */
public class Game {

    private long id;

    private List<Team> teams;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
