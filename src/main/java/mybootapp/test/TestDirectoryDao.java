package mybootapp.test;

import mybootapp.dao.IDirectoryDao;
import mybootapp.dao.DirectoryDao;
import mybootapp.dao.SpringDaoConfig;
import mybootapp.model.Group;
import mybootapp.model.Person;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringDaoConfig.class)
public class TestDirectoryDao {

    @Autowired
    //IDirectoryDao dao;//Instanciée une seule fois car la création d'une EMF est très coûteuse
    DirectoryDao dao;

    @Test
    @Transactional
    @Rollback
    @Order(1)
    public void testAddAndSearchPerson() {
        // Création
        Person p1 = new Person(new Group("groupe1"), "Jean", "Dupont", "jean@protonmail.com", "jean.com", new Date(01/01/1921), "password_jean");
        p1 = dao.addPerson(p1);
        //assertTrue(p1.getId() > 0);
        // relecture
        Person p2 = dao.searchPerson(p1.getId());
        assertEquals("Jean", p2.getFirstName());
        assertEquals(p1.getId(), p2.getId());
    }

    @Test
    @Transactional
    @Rollback
    @Order(2)
    public void testUpdatePerson() {
        Person p1 = new Person(new Group("groupe1"), "Jean", "Dupont", "jean@protonmail.com", "jean.com", new Date(01/01/1921), "password_jean");
        dao.addPerson(p1);
        p1.setFirstName("Victor");
        dao.updatePerson(p1);
        Person p = dao.searchPerson(p1.getId());
        assertEquals("Victor", p.getFirstName());
    }

    @Test
    @Transactional
    @Rollback
    @Order(3)
    public void testDeletePerson() {
        Person p1 = new Person(new Group("groupe1"), "Jean", "Dupont", "jean@protonmail.com", "jean.com", new Date(01/01/1921), "password_jean");
        dao.addPerson(p1);
        dao.deletePerson(p1.getId());
        //assertEquals(null, dao.findPerson(p1.getId()));
    }

    @Test
    @Transactional
    @Rollback
    @Order(4)
    public void testSearchAllPersons() {
        Group groupe1 = new Group("groupe 1");
        Group groupe2 = new Group("groupe 2");

        Person p1 = new Person(groupe1, "Jean", "Dupont", "jean@protonmail.com", "jean.com", new Date(01/01/1921), "password_jean");
        Person p2 = new Person(groupe1, "Pierre", "Dupont", "pierre@protonmail.com", "pierre.com", new Date(01/01/1921), "password_pierre");
        Person p3 = new Person(groupe2, "Thomas", "Dupont", "thomas@protonmail.ch", "thomas.com", new Date(01/01/1921), "password_thomas");

        dao.addPerson(p1);
        dao.addPerson(p2);
        dao.addPerson(p3);

        Collection<Person> ps = dao.searchAllPersons();
        assertNotNull(ps, "not 3 persons <testFindAllPersons()>");
        assertEquals(3, ps.size());
    }

    @Test
    @Transactional
    @Rollback
    @Order(5)
    public void testSearchPersonsByLastName() {
        Group groupe1 = new Group("groupe 1");
        Group groupe2 = new Group("groupe 2");

        Person p1 = new Person(groupe1, "Jean", "Dupont", "jean@protonmail.com", "jean.com", new Date(01/01/1921), "password_jean");
        Person p2 = new Person(groupe1, "Pierre", "Dupont", "pierre@protonmail.com", "pierre.com", new Date(01/01/1921), "password_pierre");
        Person p3 = new Person(groupe2, "Thomas", "Lecomte", "thomas@protonmail.ch", "thomas.com", new Date(01/01/1921), "password_thomas");

        dao.addPerson(p1);
        dao.addPerson(p2);
        dao.addPerson(p3);

        Collection<Person> ps = dao.searchPersonsByLastName("Dupont");
        assertNotNull(ps, "not 2 persons called Dupont <testFindPersonsByLastName()>");
        assertEquals(2, ps.size());
    }

    @Test
    @Transactional
    @Rollback
    @Order(6)
    public void testSearchPersonsByEmailAddress() {
        Group groupe1 = new Group("groupe 1");
        Group groupe2 = new Group("groupe 2");

        Person p1 = new Person(groupe1, "Jean", "Dupont", "jean@protonmail.com", "jean.com", new Date(01/01/1921), "password_jean");
        Person p2 = new Person(groupe1, "Pierre", "Dupont", "pierre@protonmail.com", "pierre.com", new Date(01/01/1921), "password_pierre");
        Person p3 = new Person(groupe2, "Thomas", "Dupont", "thomas@protonmail.ch", "thomas.com", new Date(01/01/1921), "password_thomas");

        dao.addPerson(p1);
        dao.addPerson(p2);
        dao.addPerson(p3);

        Collection<Person> ps = dao.searchPersonsByEmailAddress("protonmail.com");
        assertNotNull(ps, "not 2 persons <testFindPersonsByEmailAddress()>");
        assertEquals(2, ps.size());
    }

    @Test
    @Transactional
    @Rollback
    @Order(7)
    public void testSearchAllGroups() {
        Group groupe1 = new Group("groupe 1");
        Group groupe2 = new Group("groupe 2");

        Person p1 = new Person(groupe1, "Jean", "Dupont", "jean@protonmail.com", "jean.com", new Date(01/01/1921), "password_jean");
        Person p2 = new Person(groupe1, "Pierre", "Dupont", "pierre@protonmail.com", "pierre.com", new Date(01/01/1921), "password_pierre");
        Person p3 = new Person(groupe2, "Thomas", "Dupont", "thomas@protonmail.ch", "thomas.com", new Date(01/01/1921), "password_thomas");

        dao.addPerson(p1);
        dao.addPerson(p2);
        dao.addPerson(p3);

        Collection<Group> groups = dao.searchAllGroups();
        assertNotNull(groups, "not 2 groups <testSearchAllGroups()>");
        assertEquals(2, groups.size());
    }

    @Test
    @Transactional
    @Rollback
    @Order(8)
    public void testSearchGroupsByName() {
        Group groupe1 = new Group("groupe 1");
        Group groupe2 = new Group("groupe 2");

        Person p1 = new Person(groupe1, "Jean", "Dupont", "jean@protonmail.com", "jean.com", new Date(01/01/1921), "password_jean");
        Person p2 = new Person(groupe1, "Pierre", "Dupont", "pierre@protonmail.com", "pierre.com", new Date(01/01/1921), "password_pierre");
        Person p3 = new Person(groupe2, "Thomas", "Dupont", "thomas@protonmail.ch", "thomas.com", new Date(01/01/1921), "password_thomas");

        dao.addPerson(p1);
        dao.addPerson(p2);
        dao.addPerson(p3);

        Collection<Group> groups = dao.searchGroupsByName("groupe");
        assertNotNull(groups, "not 2 groups <testSearchGroupsByName>");
        assertEquals(2, groups.size());
    }

    @Test
    @Transactional
    @Rollback
    @Order(9)
    public void testSearchPersonsFromGroup() {
        Group groupe1 = new Group("groupe 1");
        Group groupe2 = new Group("groupe 2");

        Person p1 = new Person(groupe1, "Jean", "Dupont", "jean@protonmail.com", "jean.com", new Date(01/01/1921), "password_jean");
        Person p2 = new Person(groupe1, "Pierre", "Dupont", "pierre@protonmail.com", "pierre.com", new Date(01/01/1921), "password_pierre");
        Person p3 = new Person(groupe2, "Thomas", "Dupont", "thomas@protonmail.ch", "thomas.com", new Date(01/01/1921), "password_thomas");

        dao.addPerson(p1);
        dao.addPerson(p2);
        dao.addPerson(p3);

        Collection<Person> ps = dao.searchPersonsFromGroup(p1.getUserGroup().getGroupId());
        assertNotNull(ps, "not 2 persons in groupe 1 <testSearchPersonsFromGroup>");
        assertEquals(2, ps.size());
    }

    @Test
    @Transactional
    @Rollback
    @Order(10)
    public void testSearchPersonsFromGroupv2() {
        Group groupe1 = new Group("groupe 1");
        Group groupe2 = new Group("groupe 2");

        Person p1 = new Person(groupe1, "Jean", "Dupont", "jean@protonmail.com", "jean.com", new Date(01/01/1921), "password_jean");
        Person p2 = new Person(groupe1, "Pierre", "Dupont", "pierre@protonmail.com", "pierre.com", new Date(01/01/1921), "password_pierre");
        Person p3 = new Person(groupe2, "Thomas", "Dupont", "thomas@protonmail.ch", "thomas.com", new Date(01/01/1921), "password_thomas");

        dao.addPerson(p1);
        dao.addPerson(p2);
        dao.addPerson(p3);

        Collection<Person> ps = dao.searchPersonsFromGroupv2("groupe 1");
        assertNotNull(ps, "not 2 persons in groupe 1 <testSearchPersonsFromGroup>");
        assertEquals(2, ps.size());
    }
}
