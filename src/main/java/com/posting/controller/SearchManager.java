package com.posting.controller;

import com.posting.entity.Material;
import com.posting.entity.Period;
import com.posting.entity.Price;
import com.posting.entity.Service;
import com.posting.persistence.GenericDao;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SearchManager", value = "/search")
public class SearchManager extends HttpServlet {
    private final String PERIOD_SEARCH = "period";
    private final String MATERIAL_SEARCH = "material";
    private final String SERVICE_SEARCH = "service";
    private final String PRICE_SEARCH = "price";
    private GenericDao<Object> searchDao;
    private ArrayList<Object> results;
    private int searchItem;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getSearchObjectType(request);
        if (request.getParameter("submit") == "viewAll") {
            getAllResults();
        } else if (request.getParameter("submit") == "search") {
            getSearchResult();
        }
        HttpSession session = request.getSession();
        session.setAttribute("results", results);
        String url = "/index.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void getSearchObjectType(HttpServletRequest request) {
        if (request.getParameter("tables").compareTo(PERIOD_SEARCH) == 0) {
            setDaoType(new Period());
        } else if (request.getParameter("tables").compareTo(MATERIAL_SEARCH) == 0) {
            setDaoType(new Material());
        } else if (request.getParameter("tables").compareTo(SERVICE_SEARCH) == 0) {
            setDaoType(new Service());
        } else if (request.getParameter("tables").compareTo(PRICE_SEARCH) == 0) {
            setDaoType(new Price());
        }
        searchItem = Integer.parseInt(request.getParameter("searchItem"));
    }

    public void setDaoType(Object object) {
        searchDao = new GenericDao(object.getClass());
    }

    public void getAllResults() {
        results.addAll(searchDao.getAll());
    }

    public void getSearchResult() {
        results.add(searchDao.getById(searchItem));
    }
}
