import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;

@WebServlet("/TimeServletTest")
public class TimeServlet extends HttpServlet {

    public TimeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("Current time :"+LocalTime.now()+"<br>");
        response.getWriter().println("<br>Request session ID: "+request.getRequestedSessionId()+"<br>");
        response.getWriter().println("<br>Server name: "+request.getServerName()+"<br>");
        response.getWriter().println("<br>Server port: " + request.getServerPort() + "<br>");
        response.getWriter().println("<br>Client IP: "+request.getRemoteAddr()+"<br>");
        response.getWriter().println("<br>Server IP: "+request.getLocalAddr()+"<br>");
    }
}