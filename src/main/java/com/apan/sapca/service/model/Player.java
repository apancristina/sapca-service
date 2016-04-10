package com.apan.sapca.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by apanc on 1/22/2016.
 */
public class Player {

    private long id;

    @JsonIgnore
    private Team team;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
