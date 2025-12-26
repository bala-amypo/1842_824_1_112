package com.example.demo.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/status")
public class SimpleStatusServlet extends HttpServlet {
    
    // Change from protected to public so the test class can access it
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain");
        // Ensure this text matches exactly what t01 expects
        resp.getWriter().print("Digital Credential Verification Engine is running");
    }
}