import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    public UserServlet() {
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
                if (us.password.equals(inputPassword)) {
                    cUser = us;
                    break;
                }
        }

        if (cUser != null) {
            response.getWriter().println("<br><div><h3>Hello :" + cUser.role + " " + cUser.name + "<br>" + LocalDateTime.now() + "</h3></div><br>");

            boolean isLastTime = false;
            boolean isRole = false;
            boolean isCounter = false;

            Cookie ck[] = request.getCookies();
            for (int i = 0; i < ck.length; i++) {
                response.getWriter().print("<br>" + ck[i].getName() + " " + ck[i].getValue());//printing name and value of cookie
                switch (ck[i].getName()) {
                    case "Last":
                        isLastTime = true;
                        ck[i].setValue(LocalDateTime.now().toString());
                        break;
                    case "Role":
                        isRole = true;
                        ck[i].setValue(cUser.role);
                        break;
                    case "Counter":
                        isCounter = true;
                        int rc = Integer.parseInt(ck[i].getValue()) + 1;
                        ck[i].setValue(String.valueOf(rc));
                        break;
                }
                response.addCookie(ck[i]);//adding cookie in the response
            }
            if (!isLastTime) {
                Cookie cookie = new Cookie("Last", LocalDateTime.now().toString());//deleting value of cookie
                response.addCookie(cookie);//adding cookie in the response
                response.getWriter().print("<br>" + cookie.getName() + " " + cookie.getValue());//printing name and value of cookie
            }
            if (!isRole) {
                Cookie cookie = new Cookie("Role", cUser.role);//deleting value of cookie
                response.addCookie(cookie);//adding cookie in the response
                response.getWriter().print("<br>" + cookie.getName() + " " + cookie.getValue());//printing name and value of cookie
            }
            if (!isCounter) {
                Cookie cookie = new Cookie("Counter", "0");//deleting value of cookie
                response.addCookie(cookie);//adding cookie in the response
                response.getWriter().print("<br>" + cookie.getName() + " " + cookie.getValue());//printing name and value of cookie
            }
        } else
            response.getWriter().println("<br><h1>ERROR</h1><br>");
    }
}
