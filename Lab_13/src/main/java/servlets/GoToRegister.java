package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name="Register", urlPatterns = "/GoToRegister")
public class GoToRegister extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            if(request.getAttribute("message") == null)
                request.setAttribute("message","");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}