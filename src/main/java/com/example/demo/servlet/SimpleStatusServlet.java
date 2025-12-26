package com.example.demo.servlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleStatusServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        if (out == null) throw new IOException("No writer");
        out.print("Digital Credential Verification Engine is running");
    }
}