package com.posting.controller;

import com.posting.entity.Service;
import com.posting.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * AccessManager web servlet that interacts with our services endpoint
 * @author npeck
 */
@WebServlet (
        name = "AccessManager",
        urlPatterns = {"/accessServices"}
)
public class AccessManager extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private ArrayList<Object> results;
    GenericDao genericDao;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.info("doGet method running");
        results = new ArrayList<Object>();
        HttpSession session = request.getSession();

        genericDao = new GenericDao(Service.class);
        Service returnedService = (Service) genericDao.getById(1);
        results.add(returnedService);
        session.setAttribute("results", results);
        session.setAttribute("processed", true);
        String url = "/index.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }



    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.info("doPost method running");


    }
}
