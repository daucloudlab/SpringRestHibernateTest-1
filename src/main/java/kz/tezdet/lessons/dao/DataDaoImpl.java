package kz.tezdet.lessons.dao;


import kz.tezdet.lessons.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public class DataDaoImpl implements DataDao{

    @Autowired
    SessionFactory sessionFactory ;

    Session session = null;
    Transaction tx = null;

    @Override
    public boolean addEntity(Employee employee) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(employee);
        tx.commit();
        session.close();

        return false;
    }

    @Override
    public Employee getEntityById(int id) throws Exception {
        session = sessionFactory.openSession();
        Employee employee = (Employee) session.get(Employee.class,
                new Integer(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return employee;
    }

    @Override
    public List getEntityList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Employee> employeeList = session.createQuery("from Employee").list();
        tx.commit();
        session.close();
        return employeeList;
    }

    @Override
    public boolean deleteEntity(int id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.get(Employee.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }
}
