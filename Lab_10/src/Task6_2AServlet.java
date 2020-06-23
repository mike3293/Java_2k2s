import javax.servlet.*;

import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

@WebServlet("/Task6_2AServletTest")
public class Task6_2AServlet extends HttpServlet {

    public Task6_2AServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String str = "<br>";
        try {
            str += request.getAttribute("Attribute1").toString() + "<br>";
        } catch (NullPointerException e) {
            str += "Attribute fail<br>";
        }
        request.setAttribute("mystr1", str);
        request.getRequestDispatcher("index.jsp").
                forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        response.setContentType("text/html");

    }
}