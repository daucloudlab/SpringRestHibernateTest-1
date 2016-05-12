package kz.tezdet.lessons.services;


import kz.tezdet.lessons.dao.DataDao;
import kz.tezdet.lessons.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DataServiceImpl implements DataService{
    @Autowired
    DataDao dataDao ;

    @Override
    public boolean addEntity(Employee employee) throws Exception {
        return dataDao.addEntity(employee);
    }

    @Override
    public Employee getEntityById(int id) throws Exception {
        return dataDao.getEntityById(id);
    }

    @Override
    public List getEntityList() throws Exception {
        return dataDao.getEntityList();
    }

    @Override
    public boolean deleteEntity(int id) throws Exception {
        return dataDao.deleteEntity(id);
    }
}
