package mybootapp.model;

import mybootapp.model.Person;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import lombok.NoArgsConstructor;

@Entity(name = "Group")
@NoArgsConstructor
@Table(name = "TGroup")
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic()
    @Column(name = "name_group", length = 200, nullable = false)
    private String name;

    //@Basic
    @OneToMany(mappedBy = "userGroup", cascade = CascadeType.ALL)
    private Set<Person> persons;

    public Group(String name)
    {
        this.name = name;
    }

    public long getGroupId(){
        return this.id;
    }
}
