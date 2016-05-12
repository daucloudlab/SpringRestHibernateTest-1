package kz.tezdet.lessons.controllers;

import kz.tezdet.lessons.models.Employee;
import kz.tezdet.lessons.models.Status;
import kz.tezdet.lessons.services.DataService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RestController {
    @Autowired
    DataService dataService ;

    static final Logger logger = Logger.getLogger(RestController.class);

    @RequestMapping(value = "employee/test", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Map<String, Object>> test(){
        Map<String, Object> map = new HashMap<String, Object>() ;
        map.put("message","Test") ;
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK) ;
    }

    @RequestMapping(value = "employee/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {
        try {
            dataService.addEntity(employee);
            return new ResponseEntity<Void>(HttpStatus.ACCEPTED) ;
        } catch (Exception e) {
            // e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST) ;
        }

    }

    @RequestMapping(value = "employee/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
        Employee employee = null;
        try {
            employee = dataService.getEntityById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (employee == null)
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND) ;
        else
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "employee/list", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getEmployee() {

        List employeeList = null;
        try {
            employeeList = dataService.getEntityList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK) ;
    }

    @RequestMapping(value = "employee/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id) {

        try {
            dataService.deleteEntity(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND) ;
        }

    }
}
