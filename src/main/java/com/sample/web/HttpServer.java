package com.sample.web;

import java.net.URL;
import java.io.File;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import com.sun.jersey.spi.container.servlet.ServletContainer;

public class HttpServer {

    public void startServer() throws Exception {
        Server webServer = new Server(8080);

        String appName = "sample";
        WebAppContext ctx = new WebAppContext();
        ctx.setDefaultsDescriptor(null);

        ServletHolder holder = new ServletHolder(new WebServlet());
        ctx.addServlet(holder, "/");
        ctx.setDisplayName(appName);
        ctx.setContextPath("/");

        ServletHolder sh = new ServletHolder(ServletContainer.class);
        sh.setInitParameter("com.sun.jersey.config.property.resourceConfigClass",
                "com.sun.jersey.api.core.PackagesResourceConfig");
        sh.setInitParameter("com.sun.jersey.config.property.packages", WebService.class.getPackage().getName());

        ctx.addServlet(sh, "/ws/v1/sample");

        String appDir = getWebAppsPath(appName);
        ctx.setWar(appDir + "/" + appName);

        HandlerCollection handlers = new HandlerCollection();
        handlers.addHandler(ctx);

        webServer.setHandler(handlers);
        webServer.start();
    }

    protected String getWebAppsPath(String appName) throws Exception {
        URL resourceUrl = null;
        File webResourceDevLocation = new File("src/main/webapps", appName);
        if (webResourceDevLocation.exists()) {
            resourceUrl = webResourceDevLocation.getParentFile().toURI().toURL();
        } else {
            throw new Exception("Webapps path does not exist");
        }
        String urlString = resourceUrl.toString();
        return urlString.substring(0, urlString.lastIndexOf('/'));
    }

    public static void main(String[] args) throws Exception {
        HttpServer server = new HttpServer();
        server.startServer();
    }
}
