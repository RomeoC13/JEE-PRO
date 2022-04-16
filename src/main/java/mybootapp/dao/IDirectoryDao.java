package mybootapp.dao;

import mybootapp.model.Person;
import mybootapp.model.Group;
import java.util.Collection;

public interface IDirectoryDao {
    Person addPerson(Person p);//Create
    Person searchPerson(long id);//Read
    Person updatePerson(Person p);//Update
    void deletePerson(long id);//Delete
    Collection<Person> searchAllPersons();
    Collection<Person> searchPersonsByLastName(String lastName);
    Collection<Person> searchPersonsByEmailAddress(String emailAddress);
    Collection<Group> searchAllGroups();
    Collection<Group> searchGroupsByName(String name);
    Collection<Person> searchPersonsFromGroup(long groupId);
    Collection<Person> searchPersonsFromGroupv2(String name);
}
