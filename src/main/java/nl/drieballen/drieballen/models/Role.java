package nl.drieballen.drieballen.models;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public Role(ERole name){
        this.name = name;
    }

    public Integer getId(){
        return id;
    }

    public ERole getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
