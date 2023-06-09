package com.posting.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/** GenericDao class
 * This class represents the generic dao
 * @author npeck
 */
public class GenericDao<T> {
    private Class<T> type;

    /**
     * Instantiates a generic dao
     * @param type the entity type.
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }
    /**
     * method getOrderById
     * retrieves a entity based on a specific Id
     * @param id - entity passed to the method
     * @return entity - entity based on the Id
     */
    public <T>T getById(int id) {
        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;
    }

    /** method getAllOrders
     * Method that selects all entities from the order database.
     * @return executeQuery(sql) results from the database query
     */
    public ArrayList<T> getAll() {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createQuery(query).getResultList();
        ArrayList<T> resultList = new ArrayList<T>(list);
        session.close();
        return resultList;
    }
    /**
     * insert entity
     * @param entity  entity to be inserted or updated
     */
    public int insert(T entity) {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }
    /**
     * update entity
     * @param entity  entity to be inserted or updated
     */
    public void saveOrUpdate(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
    }
    /**
     * Delete a entity
     * @param entity Order to be deleted
     */
    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }
    /**
     * getSession method
     * Returns a open session from the SessionFactory provider
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }
}
