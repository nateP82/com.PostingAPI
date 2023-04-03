package com.posting.controller;

import com.posting.entity.Material;
import com.posting.entity.Period;
import com.posting.entity.Price;
import com.posting.entity.Service;
import com.posting.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "SearchManager", value = "/search2")

public class SearchManager extends HttpServlet {
    private final String PERIOD_SEARCH = "period";
    private final String MATERIAL_SEARCH = "material";
    private final String SERVICE_SEARCH = "service";
    private final String PRICE_SEARCH = "price";
    private GenericDao<Object> searchDao;
    private ArrayList<Object> results;
    private int searchItem;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("doGet entered");
        getSearchObjectType(request);
        if (request.getParameter("submit").equals("viewAll")) {
            getAllResults();
        } else if (request.getParameter("submit").equals("search")) {
            getSearchResult();
        }
        HttpSession session = request.getSession();
        session.setAttribute("results", results);
        session.setAttribute("processed", true);

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
            searchDao = new GenericDao(Period.class);
        } else if (request.getParameter("tables").compareTo(MATERIAL_SEARCH) == 0) {
            searchDao = new GenericDao(Material.class);
        } else if (request.getParameter("tables").compareTo(SERVICE_SEARCH) == 0) {
            searchDao = new GenericDao(Service.class);
        } else if (request.getParameter("tables").compareTo(PRICE_SEARCH) == 0) {
            searchDao = new GenericDao(Price.class);
        }
        if (request.getParameter("searchItem").compareTo("") != 0) {
            searchItem = Integer.parseInt(request.getParameter("searchItem"));
        }
    }

    public void getAllResults() {
        results = searchDao.getAll();
    }

    public void getSearchResult() {
        results = searchDao.getById(searchItem);
    }

    public String getPERIOD_SEARCH() {
        return PERIOD_SEARCH;
    }

    public String getMATERIAL_SEARCH() {
        return MATERIAL_SEARCH;
    }

    public String getSERVICE_SEARCH() {
        return SERVICE_SEARCH;
    }

    public String getPRICE_SEARCH() {
        return PRICE_SEARCH;
    }

    public ArrayList<Object> getResults() {
        return results;
    }

    public void setResults(ArrayList<Object> results) {
        this.results = results;
    }

    public int getSearchItem() {
        return searchItem;
    }

    public void setSearchItem(int searchItem) {
        this.searchItem = searchItem;
    }
}
