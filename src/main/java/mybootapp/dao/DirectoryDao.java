package mybootapp.dao;

import mybootapp.model.Person;
import mybootapp.model.Group;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.*;
import java.util.Collection;

@Service// obligatoire?
@Repository
@Transactional// Repository et Transactional => la classe va manipuler des données et chaque méthode doit être exécutée dans une transaction
public class DirectoryDao { //implements IDirectoryDao {

    @PersistenceContext()//réclame l'injection d'une EM, multi thread OK (un thread est associé à chaque requête et un EM à chaque thread)
    EntityManager em;

    //private EntityManagerFactory factory = null;

    /* La classe Persistence est utilisée pour analyser les paramètres de connection (fichier persistence.xml)
    et trouver l'unité de persistance passée en paramètre (myBase dans cet exemple).
    A l'issue de cette étape nous récupérons une instance de l'interface EntityManagerFactory.
    Cette usine, qui est généralement un singleton, nous permettra, dans un deuxième temps, d'ouvrir des connections vers la base de données.
     */
    /*@PostConstruct
    public void init() {
        factory = Persistence.createEntityManagerFactory("myBase");//myBase ?
    }

    @PreDestroy
    public void close() {
        if (factory != null) {
            factory.close();
        }
    }*/

    public Person addPerson(Person p) {
        em.persist(p);
        return p;
    }

    public Person searchPerson(long id) {
        Person p = em.find(Person.class, id);
        return p;
    }

    public Person updatePerson(Person p) {
        em.merge(p);
        return p;
    }

    public void deletePerson(long id) {
        Person p = em.find(Person.class, id);
        em.remove(p);
    }

    public Collection<Person> searchAllPersons() {
        String query = "SELECT p FROM Person p";
        TypedQuery<Person> q = em.createQuery(query, Person.class);
        return q.getResultList();
    }

    public Collection<Person> searchPersonsByLastName(String lastName) {
        String query = "SELECT p FROM Person p WHERE p.lastName LIKE :lastName";
        TypedQuery<Person> q = em.createQuery(query, Person.class);
        q.setParameter("lastName", "%"+lastName+"%");
        try {
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public Collection<Person> searchPersonsByEmailAddress(String emailAddress) {
        String query = "SELECT p FROM Person p WHERE p.emailAddress LIKE :emailAddress";
        TypedQuery<Person> q = em.createQuery(query, Person.class);
        q.setParameter("emailAddress", "%"+emailAddress+"%");
        try {
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public Collection<Group> searchAllGroups() {
        String query = "SELECT g FROM Group g";
        TypedQuery<Group> q = em.createQuery(query, Group.class);
        return q.getResultList();
    }

    public Collection<Group> searchGroupsByName(String name) {
        String query = "SELECT g FROM Group g WHERE g.name LIKE :name";
        TypedQuery<Group> q = em.createQuery(query, Group.class);
        q.setParameter("name", "%"+name+"%");
        try {
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public Collection<Person> searchPersonsFromGroup(long groupId) {
        String query = "SELECT p FROM Person p WHERE p.userGroup.id = :groupId";
        TypedQuery<Person> q = em.createQuery(query, Person.class);
        q.setParameter("groupId", groupId);
        try {
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public Collection<Person> searchPersonsFromGroupv2(String name) {
        String query = "SELECT p FROM Person p WHERE p.userGroup.name = :name";
        TypedQuery<Person> q = em.createQuery(query, Person.class);
        q.setParameter("name", name);
        try {
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    /*
     * Fermeture d'un EM (avec rollback éventuellement)
     */
    /*private void closeEntityManager(EntityManager em) {
        if (em == null || !em.isOpen())
            return;

        var t = em.getTransaction();
        if (t.isActive()) {
            try {
                t.rollback();
            } catch (PersistenceException e) {
                e.printStackTrace(System.err);
            }
        }
        em.close();
    }*/
}
