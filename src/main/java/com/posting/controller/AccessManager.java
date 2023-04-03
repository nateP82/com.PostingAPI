package com.posting.controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AccessManager web servlet that interacts with our services endpoint
 * @author npeck
 */
@WebServlet (
        urlPatterns = {"/accessServices"}
)
public class AccessManager extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


    }



    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


    }
}
