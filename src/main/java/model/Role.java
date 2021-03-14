package model;


import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long role_id;

    @Column(name = "role_name")
    private String roleName;
    @ManyToOne
    @JoinColumn(name = "series_id", nullable = false)
    private Series series;
    @OneToOne
    @JoinColumn(name = "actor_id", nullable = false)
    private Actor actor;

    public Role() {
    }

    public Role(String roleName, Series series, Actor actor) {
        this.roleName = roleName;
        this.series = series;
        this.actor = actor;
    }

    public Role(long role_id, String roleName, Series series, Actor actor) {
        this.role_id = role_id;
        this.roleName = roleName;
        this.series = series;
        this.actor = actor;
    }

    public long getRole_id() {
        return role_id;
    }

    public String getRoleName() {
        return roleName;
    }

    public Series getSeries() {
        return series;
    }

    public Actor getActor() {
        return actor;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }
}
