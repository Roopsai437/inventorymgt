package com.dxctraining.inventorymgt.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt.computer.entities.Computer;
import com.dxctraining.inventorymgt.computer.service.IComputerService;
import com.dxctraining.inventorymgt.dto.CreateComputerRequest;
import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

import java.util.*;

import javax.annotation.PostConstruct;

@Controller
public class ComputerController extends Item {

    @Autowired
    private IComputerService computerservice;
    @Autowired
    private ISupplierService supplierservice;
    @PostConstruct
    public void init(){
    	Supplier supplier1=new Supplier("sai");
        supplier1=supplierservice.add(supplier1);
        Supplier supplier2=new Supplier("gopi");
        supplier2=supplierservice.add(supplier2);   
       Computer computer1=new Computer("hp",supplier1,1000);
        computer1=computerservice.add(computer1);
        Computer computer2=new Computer("acer",supplier2,500);
        computer2=computerservice.add(computer2);
    }
   @GetMapping("/computer")
    public ModelAndView computerDetails(@RequestParam("id")int id){
      Computer computer=computerservice.findComputerById(id);
       ModelAndView modelAndView=new ModelAndView("cdetails","computer",computer);
       return modelAndView;
       
    }
    @GetMapping("/listofcomputers")
    public ModelAndView allcom(){
       List<Computer>values=computerservice.displayAllComputer();
        ModelAndView modelAndView=new ModelAndView("clist","computers",values);
        return modelAndView;
    }
        
}

