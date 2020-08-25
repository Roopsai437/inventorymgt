package com.dxctraining.inventorymgt.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt.computer.entities.Computer;
import com.dxctraining.inventorymgt.computer.service.IComputerService;
import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.phone.entities.Phone;
import com.dxctraining.inventorymgt.phone.service.IPhoneService;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

import java.util.*;

import javax.annotation.PostConstruct;

@Controller
public class PhoneController extends Item {

    @Autowired
    private IPhoneService phoneservice;
    @Autowired
    private ISupplierService supplierservice;

    
    @PostConstruct
    public void init(){
    	Supplier supplier1=new Supplier("sai");
        supplier1=supplierservice.add(supplier1);
        Supplier supplier2=new Supplier("gopi");
        supplier2=supplierservice.add(supplier2);   
       Phone phone1=new Phone("samsung",supplier1,64);
        phone1=phoneservice.add(phone1);
        Phone phone2=new Phone("realme",supplier2,128);
        phone2=phoneservice.add(phone2);
        
    }
   @GetMapping("/phone")
    public ModelAndView phoneDetails(@RequestParam("id")int id){
      Phone phone=phoneservice.findPhoneById(id);
       ModelAndView modelAndView=new ModelAndView("pdetails","phone",phone);
       return modelAndView;
       
    }
    @GetMapping("/listofphones")
    public ModelAndView allph(){
       List<Phone>values=phoneservice.displayAllPhones();
        ModelAndView modelAndView=new ModelAndView("plist","phones",values);
        return modelAndView;
}
}
  