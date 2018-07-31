package task1_start_server.main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import task1_start_server.servlets.MirrorServlet;

public class Main {
    public static void main(String[] args) throws Exception {

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new MirrorServlet()), "/mirror");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();
    }
}
