package by.gorodilov.service;

import by.gorodilov.exception.RepositoryException;
import by.gorodilov.exception.ServiceException;
import by.gorodilov.model.User;
import by.gorodilov.repository.RepositoryCreator;
import by.gorodilov.repository.SQLHelper;
import by.gorodilov.repository.UserRepository;
import by.gorodilov.repository.paramspecification.UserByLogin;
import by.gorodilov.repository.paramspecification.UserByLoginPassword;

// Service with user - login, save user

import java.util.Optional;

public class UserService {

    public Optional<User> login(String login, byte[] password) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {

            UserRepository userRepository = repositoryCreator.getUserRepository();
            UserByLoginPassword params = new UserByLoginPassword(login, password);
            return userRepository.queryForSingleResult(SQLHelper.SQL_GET_USER, params);

        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }


    public Integer save(User user) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {

            UserRepository userRepository = repositoryCreator.getUserRepository();
            UserByLogin param = new UserByLogin(user.getLogin());
            if (!userRepository.queryForSingleResult(SQLHelper.SQL_CHECK_LOGIN, param).isPresent()) {
                return userRepository.save(user);
            } else {
                return 0;
            }
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }
}
