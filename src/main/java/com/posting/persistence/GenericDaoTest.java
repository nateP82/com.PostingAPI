package com.posting.persistence;

import com.posting.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenericDaoTest {
    private GenericDao<Price> priceDao;
    private GenericDao<Period> periodDao;
    private GenericDao<Material> materialDao;
    private GenericDao<Service> serviceDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        priceDao = new GenericDao(Price.class);
        periodDao = new GenericDao(Period.class);
        materialDao = new GenericDao(Material.class);
        serviceDao = new GenericDao(Service.class);
    }

    @Test
    void getById() {
        Period period = periodDao.getById(1);
        assertNotNull(periodDao.getById(1));
        System.out.println(period.toString());
    }

    @Test
    void getAll() {
        List<Period> resultList = periodDao.getAll();
        assertEquals(4, resultList.size());
        for(int i = 0; i < resultList.size(); i++) {
            System.out.println(resultList.get(i).toString());
        }
    }
}