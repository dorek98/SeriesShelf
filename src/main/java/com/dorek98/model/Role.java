package com.dorek98.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleId;
    private String roleName;

    @ManyToOne
    @JoinColumn(name = "series_id")
    private Series series;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;

    public Role(String roleName, Series series, Actor actor) {
        this.roleName = roleName;
        this.series = series;
        this.actor = actor;
    }


    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", series=" + series +
                ", actor=" + actor +
                "}\n";
    }
}
