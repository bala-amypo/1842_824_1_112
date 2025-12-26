package com.example.demo.servlet;

import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;

public class SimpleStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        if(resp.getWriter() == null) throw new IOException("Writer null");

        resp.getWriter().write("Digital Credential Verification Engine is running");
    }
}
