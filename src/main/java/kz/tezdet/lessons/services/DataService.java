package kz.tezdet.lessons.services;

import kz.tezdet.lessons.models.Employee;

import java.util.List;

public interface DataService {
    public boolean addEntity(Employee employee) throws Exception;
    public Employee getEntityById(int id) throws Exception;
    public List getEntityList() throws Exception;
    public boolean deleteEntity(int id) throws Exception;

}
