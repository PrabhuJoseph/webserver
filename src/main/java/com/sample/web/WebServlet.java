package com.sample.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.servlet.DefaultServlet;

public class WebServlet extends DefaultServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getRequestURI().equals("/")) {
            StringBuilder location = new StringBuilder();
            location.append("index.html");
            response.sendRedirect(location.toString());
        } else {
            super.doGet(request, response);
        }
    }
}