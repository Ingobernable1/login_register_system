package pl.ingobernable;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

class App {

    public static void main(String[] args) throws Exception {

        WebAppContext webApp = new WebAppContext();
        webApp.setResourceBase("src/main/webapp");
        webApp.setContextPath("/");

        Server server = new Server(8080);
        server.setHandler(webApp);

        server.start();
        server.join();
    }
}
