package kz.tezdet.lessons.dao;


import kz.tezdet.lessons.models.Employee;

import java.util.List;

public interface DataDao {
    public boolean addEntity(Employee employee) throws Exception;
    public Employee getEntityById(int id) throws Exception;
    public List getEntityList() throws Exception;
    public boolean deleteEntity(int id) throws Exception;
}
