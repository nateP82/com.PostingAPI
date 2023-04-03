package com.posting.controller;

import com.posting.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao genericDao;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.info("doGet method running");
        String url = "/services/";


    }



    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.info("doPost method running");


    }
}
