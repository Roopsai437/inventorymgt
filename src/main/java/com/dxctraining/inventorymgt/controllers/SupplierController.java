package com.dxctraining.inventorymgt.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.dxctraining.inventorymgt.controllers.SessionData;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

import java.util.*;

@Controller
public class SupplierController {

    @Autowired
    private ISupplierService supplierservice;
    @Autowired
    private SessionData sessiondata;


  
    @GetMapping("/profile")
    public ModelAndView supplierDetails(@RequestParam("id")int id){
      Supplier supplier=supplierservice.findSupplierById(id);
       ModelAndView modelAndView=new ModelAndView("details","supplier",supplier);
       return modelAndView;
    }
    @GetMapping("/listall")
    public ModelAndView all(){
       List<Supplier>values=supplierservice.displayAllSuppliers();
        ModelAndView modelAndView=new ModelAndView("list","suppliers",values);
        return modelAndView;
    }
    @GetMapping("/supregister")
	public ModelAndView registerSupplier() {
		ModelAndView modelView = new ModelAndView("supregister");
		return modelView;
	}

	@GetMapping("/processregister")
	public ModelAndView processRegister(@RequestParam("name") String name) {
		System.out.println(" name is" + name);
		Supplier supplier = new Supplier(name);
		supplier = supplierservice.add(supplier);
		ModelAndView modelview = new ModelAndView("details", "supplier", supplier);
		return modelview;
	}
	@GetMapping("/loginform")
	public ModelAndView login() {
		ModelAndView modelView = new ModelAndView("loginform");
		return modelView;
	}

	@GetMapping("/processlogin")
	public ModelAndView processLogin(@RequestParam("name") String name, @RequestParam("id") int id) {
		Supplier supplier = supplierservice.findSupplierById(id);
		ModelAndView modelView = new ModelAndView("details", "supplier", supplier);
		return modelView;
	}
	
	@GetMapping("/logout")
    public ModelAndView logout(){
       sessiondata.clear();
       ModelAndView modelAndView=new ModelAndView("login");
       return modelAndView;
    }
}

  