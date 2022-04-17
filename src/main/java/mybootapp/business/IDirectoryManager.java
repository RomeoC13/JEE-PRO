package mybootapp.business;

import mybootapp.model.Person;
import mybootapp.model.Group;

import java.util.Collection;

public interface IDirectoryManager {

    //créer un utilisateur anonyme
    //User newUser();

    //chercher une personne
    //Person findPerson(User user, long personId);

    // chercher un groupe
    //Group findGroup(User user, long groupId);

    /*Group searchGroup(long groupId);*/

    // identifier un utilisateur
    //boolean login(User user, long personId, String password);

    // oublier l'utilisateur
    //void logout(User user);

    // enregistrer une personne
    //void savePerson(User user, Person p);
    /*void savePerson(Person p);*/

    Collection<Person> searchAllPersons();
    Collection<Person> searchPersonsByLastName(String lastName);
    Collection<Person> searchPersonsByEmailAddress(String emailAddress);
    Collection<Group> searchAllGroups();
    Collection<Group> searchGroupsByName(String name);
    Collection<Person> searchPersonsFromGroup(long groupId);
    Collection<Person> searchPersonsFromGroupv2(String name);
}
