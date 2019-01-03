package com.netcracker.barkun.dao.impl;

import com.netcracker.barkun.dao.CustomerDao;
import com.netcracker.barkun.entity.Customer;
import com.netcracker.barkun.utils.PostgreSQLDatabaseManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    private EntityManager entityManager = PostgreSQLDatabaseManager.getInstance().getEntityManager();

    @Override
    public Customer createCustomer(Customer customer) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(customer);
        tx.commit();
        return customer;
    }

    @Override
    public List<Customer> findAllCustomer() {
        EntityTransaction tx = entityManager.getTransaction();
        List<Customer> customerList;
        tx.begin();
        customerList = entityManager.createQuery("SELECT Customer FROM Customer Customer", Customer.class).getResultList();
        tx.commit();
        return customerList;
    }

    @Override
    public Customer findById(Long id) {
        EntityTransaction tx = entityManager.getTransaction();
        Customer foundCustomer;
        tx.begin();
        foundCustomer = entityManager.find(Customer.class, id);
        tx.commit();
        return foundCustomer;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(customer);
        tx.commit();
        return customer;
    }

    @Override
    public void removeCustomer(Long id) {
        EntityTransaction tx = entityManager.getTransaction();
        Customer removeCustomer;
        tx.begin();
        removeCustomer = entityManager.getReference(Customer.class,id);
        entityManager.remove(removeCustomer);
        tx.commit();
    }
}
