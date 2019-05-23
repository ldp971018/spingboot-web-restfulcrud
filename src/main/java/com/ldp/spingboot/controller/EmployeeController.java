package com.ldp.spingboot.controller;

import com.ldp.spingboot.dao.DepartmentDao;
import com.ldp.spingboot.dao.EmployeeDao;
import com.ldp.spingboot.entities.Department;
import com.ldp.spingboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collection;

/**
 * @author Return
 * @create 2019-05-23 13:58
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 通过get请求的emps
     * @param model
     * @return
     */
    @GetMapping("/emps")
    public String emps(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        return "emp/list";
    }

    /**
     * 前往添加页面
     */
    @GetMapping("/emp")
    public String toEmpAdd(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    /**
     * 进行添加
     * @param employee
     * @return
     */

    @PostMapping("/emp")
    public String empAdd(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        //redirect 表示重定向 forword表示转发
        return  "redirect:/emps";
    }

    /**
     *  前往修改页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value ={"/emp/{id}"})
    public String empView(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        //修改添加二+1
        return "emp/add";
    }


    /**
     * 修改页面数据
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String empModify(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        //redirect 表示重定向 forword表示转发
        return  "redirect:/emps";
    }

    /**
     * 根据指定id删除信息
     * @param id
     * @return
     */
    @DeleteMapping(value = {"/emp/{id}"})
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        //redirect 表示重定向 forword表示转发
        return  "redirect:/emps";
    }

}
