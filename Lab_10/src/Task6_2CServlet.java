import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Task6_2CServletTest")
public class Task6_2CServlet extends HttpServlet {

    public Task6_2CServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String str = "";
        try {
            HttpSession session = request.getSession();
            str += session.getAttribute("Attribute3").toString() + "<br><br>";
        } catch (NullPointerException e) {
            str += "Session fail<br>";
        }
        request.setAttribute("mystr3", str);
        request.getRequestDispatcher("index.jsp").
                forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        response.setContentType("text/html");

    }
}