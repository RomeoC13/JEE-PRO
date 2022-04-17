package mybootapp.business;

import mybootapp.dao.IDirectoryDao;
import mybootapp.dao.DirectoryDao;
import mybootapp.dao.SpringDaoConfig;
import mybootapp.model.Group;
import mybootapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.Collection;

@Service("directoryManager")
@ContextConfiguration(classes = SpringDaoConfig.class)
@ComponentScan(basePackages= "mybootapp.dao")
public class DirectoryManager { //implements IDirectoryManager {

    @Autowired
    DirectoryDao dao;

    public Collection<Person> searchAllPersons() {
        return dao.searchAllPersons();
    }

    public Collection<Person> searchPersonsByLastName(String lastName) {
        return dao.searchPersonsByLastName(lastName);
    }

    public Collection<Person> searchPersonsByEmailAddress(String emailAddress) {
        return dao.searchPersonsByEmailAddress(emailAddress);
    }

    public Collection<Group> searchAllGroups() {
        return dao.searchAllGroups();
    }

    public Collection<Group> searchGroupsByName(String name) {
        return dao.searchGroupsByName(name);
    }

    public Collection<Person> searchPersonsFromGroup(long groupId) {
        return dao.searchPersonsFromGroup(groupId);
    }

    public Collection<Person> searchPersonsFromGroupv2(String name) {
        return dao.searchPersonsFromGroupv2(name);
    }
}
