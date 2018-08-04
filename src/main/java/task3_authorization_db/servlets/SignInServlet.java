package task3_authorization_db.servlets;


import task3_authorization_db.db_service.DBException;
import task3_authorization_db.db_service.DBService;
import task3_authorization_db.db_service.data_sets.UsersDataSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
    DBService dbService;

    public SignInServlet(DBService dbService) {
        this.dbService = dbService;
    }

    //sign in
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("password");

        if (login == null || pass == null) {
            resp.setContentType("text/html;charset=utf-8");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        try {
            UsersDataSet profile = dbService.getUserByLogin(login);
            if (profile == null || !profile.getPassword().equals(pass)) {
                resp.setContentType("text/html;charset=utf-8");
                resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                resp.getWriter().println("Unauthorized");
                return;
            } else {
                resp.setContentType("text/html;charset=utf-8");
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.getWriter().println("Authorized: " + login);
            }
        } catch (DBException e) {

        }

    }
}
