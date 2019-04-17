package com.PIK.impl;

import com.PIK.dao.CustomerDAO;
import com.PIK.domain.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

@Repository
@Qualifier(CustomerDAO.BEAN_NAME)
public class CustomerDAOImpl  implements CustomerDAO{

    @Autowired
    @Qualifier(value = "sessionFactory")
    private SessionFactory sessionFactory;

    @Transactional
    protected Session getSession(){
        return sessionFactory.openSession();
    }


    public Customer getById(Long id) {
        return (Customer) this.getSession()
                .createCriteria(Customer.class)
                .add(Restrictions.eq("id", id.intValue()))
                .uniqueResult();
    }

    public Customer getById(String id) {
        CriteriaBuilder cb = this.getSession().getCriteriaBuilder();
        CriteriaQuery<Customer> cq =  cb.createQuery(Customer.class);
        Root<Customer> customerRoot = cq.from(Customer.class);
        cq.select(customerRoot).where(cb.equal(customerRoot.get("id"), id));

        TypedQuery<Customer> query = getSession().createQuery(cq);
        return query.getSingleResult();
    }
}
