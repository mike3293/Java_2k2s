package by.gorodilov.command.factory;

import by.gorodilov.command.Command;
import by.gorodilov.command.LoginPageCommand;
import by.gorodilov.command.RegisterPageCommand;
import by.gorodilov.command.authorithation.LoginCommand;
import by.gorodilov.command.authorithation.RegisterNewUserCommand;
import by.gorodilov.command.authorithation.SingOutCommand;
import by.gorodilov.command.grouppresons.AddNewPersonCommand;
import by.gorodilov.command.grouppresons.WelcomeCommand;

//Создает команды

public class CommandFactory {
    public static Command create(String command) {
        command = command.toUpperCase();
        System.out.println(command);
        CommandType commandEnum = CommandType.valueOf(command);
        Command resultCommand;
        switch (commandEnum) {
            case LOGIN: {
                resultCommand = new LoginCommand();
                break;
            }
            case REGISTER_NEW_USER: {
                resultCommand = new RegisterNewUserCommand();
                break;
            }
            case SIGN_OUT: {
                resultCommand = new SingOutCommand();
                break;
            }
            case ADD_NEW_PERSON:{
                resultCommand = new AddNewPersonCommand();
                break;
            }
            case LOGIN_PAGE:{
                resultCommand = new LoginPageCommand();
                break;
            }
            case WELCOME:{
                resultCommand = new WelcomeCommand();
                break;
            }
            case REGISTRATION_PAGE:{
                resultCommand = new RegisterPageCommand();
                break;
            }

            default: {
                throw new IllegalArgumentException("Invalid command" + commandEnum);
            }
        }
        return resultCommand;
    }
}
