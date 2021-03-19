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

    @ManyToOne
    @JoinColumn(name = "actor_id", nullable = false)
    private Actor actor;

    public Role() {
    }

    public Role(String roleName, Series series, Actor actor) {
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

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", roleName='" + roleName + '\'' +
                ", series=" + series +
                ", actor=" + actor +
                "}\n";
    }
}
