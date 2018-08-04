package task3_authorization_db.servlets;

import task3_authorization_db.db_service.DBException;
import task3_authorization_db.db_service.DBService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    DBService dbService;

    public SignUpServlet(DBService dbService) {
        this.dbService = dbService;
    }
    //sign up
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (login != null && password != null) {
            try {
                dbService.addUser(login, password);
            } catch (DBException e) {
                e.printStackTrace();
            }
        }
    }
}
