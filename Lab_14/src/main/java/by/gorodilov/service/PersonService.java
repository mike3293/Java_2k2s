package by.gorodilov.service;

import by.gorodilov.exception.RepositoryException;
import by.gorodilov.exception.ServiceException;
import by.gorodilov.model.Person;
import by.gorodilov.repository.PersonRepository;
import by.gorodilov.repository.RepositoryCreator;

import java.util.List;
// Service with person - get all, save new person

public class PersonService {

    public List<Person> findAll() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {

            PersonRepository personRepository = repositoryCreator.getPersonRepository();
            return personRepository.findAll();
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void save(Person person) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {

            PersonRepository personRepository = repositoryCreator.getPersonRepository();
            personRepository.save(person);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }
}
