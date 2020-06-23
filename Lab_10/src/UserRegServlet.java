import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

@WebServlet("/UserRegServletTest")
public class UserRegServlet extends HttpServlet {
    public UserRegServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String inputLogin = request.getParameter("Login");
        String inputPassword = request.getParameter("Password");

        User cUser = null;

        DataBase db = new DataBase();

        ArrayList<User> users = db.GetUsers();

        for (User us : users) {
            if (us.name.equals(inputLogin))
                cUser = us;
        }

        if (cUser != null)
            response.getWriter().println("<br><h1>ERROR</h1><br>");
        else {
            db.PutUser(new User(inputLogin,inputPassword,"User"));
            response.getWriter().println("<br><div><h3>Hello :" + inputLogin + " " + "User" +"<br>"+ LocalDateTime.now() +"</h3></div><br>");
        }
    }
}
