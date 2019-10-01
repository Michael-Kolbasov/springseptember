package com.epam.spring.repository.jdbcandtemplateandhibernate.hibernate;

import com.epam.spring.model.Cat;
import com.epam.spring.repository.jdbcandtemplateandhibernate.CatRepository;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository("hibernateRepository")
public class CatRepositoryHibernateImpl implements CatRepository {

    @Setter(onMethod_= {@Autowired})
    private SessionFactory sessionFactory;

    @Override
    public List<Cat> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Cat> cats = session.createQuery("from Cat", Cat.class).list();
        //List<Cat> cats = session.createNativeQuery(SqlConstants.FIND_ALL_CATS, Cat.class).list();
        transaction.commit();
        return cats;
    }

    @Override
    public Cat findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        EntityManagerFactory entityManagerFactory = session.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cat> query = criteriaBuilder.createQuery(Cat.class);
        Root<Cat> from = query.from(Cat.class);
        query.select(from).where(criteriaBuilder.equal(from.get("id"), id));

        Cat cat = session.createQuery(query).getSingleResult();
        transaction.commit();
        return cat;
    }

    @Override
    public void save(Cat entity) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
    }

    @Override
    public void save(List<Cat> entities) {
        Session session = sessionFactory.getCurrentSession();

        for (int i = 0; i < entities.size(); i++) {

            if (i == 3) {
                throw new RuntimeException();
            }

            Cat cat = entities.get(i);
            session.save(cat);
        }
    }
}
