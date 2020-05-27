package by.gorodilov.command;

import by.gorodilov.exception.IncorrectDataException;
import by.gorodilov.exception.ServiceException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {
    CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws  ServiceException, IncorrectDataException, ServletException, IOException;
}
