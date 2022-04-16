package mybootapp.model;

import mybootapp.model.Group;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Person")//la classe est un EJB Entity qui va représenter les données de la base de données relationnelle.
@Data
@NoArgsConstructor
@Table(name = "TPerson")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()//clef primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY)//politique de construction automatique de la clef primaire
	private long id;

	@Basic()
	@Column(name = "first_name", length = 200, nullable = false)//préciser la correspondance entre colonne d'une table et propriété d'une classe
	//unique=true
	private String firstName;

	@Basic()
	@Column(name = "last_name", length = 200, nullable = false)
	private String lastName;

	@Basic()
	@Column(name = "email_address", length = 200, nullable = false)
	private String emailAddress;

	@Basic()
	@Column(name = "website", length = 200, nullable = false)
	private String website;

	@Basic()//indique que la propriété est persistante (gérée par JPA)
	@Temporal(TemporalType.DATE)
	@Column(name = "birth_day")
	private Date birthDay;

	@Basic()
	@Column(name = "password", length = 21, nullable = false)
	private String password;

	//@Basic()
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Group userGroup;

	@Version()
	private long version = 0;

    /*@Transient//la propriété n'est PAS persistante
    public static long updateCounter = 0;*/

    /*public Person() {
        super();
    }*/

    /*public Person(String firstName, Date birthDay) {
        super();
        this.firstName = firstName;
        this.birthDay = birthDay;
    }*/

	public Person(/*long id,*/ Group userGroup, String firstName, String lastName, String emailAddress, String website, Date birthday, String password)
	{
		//this.id = id;
		this.userGroup = userGroup;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.website = website;
		this.birthDay = birthday;
		this.password = password;
	}

    /*@PreUpdate
    public void beforeUpdate() {
        System.err.println("PreUpdate of " + this);
    }

    @PostUpdate
    public void afterUpdate() {
        System.err.println("PostUpdate of " + this);
        updateCounter++;
    }*/
}
