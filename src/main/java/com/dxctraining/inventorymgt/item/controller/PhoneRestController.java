package com.dxctraining.inventorymgt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.dxctraining.inventorymgt.dto.CreatePhoneRequest;
import com.dxctraining.inventorymgt.phone.entities.Phone;
import com.dxctraining.inventorymgt.phone.service.IPhoneService;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;
@RestController
@RequestMapping("/phone")
public class PhoneRestController {
	 @Autowired
	public IPhoneService phoneservice;
	 @Autowired
	public ISupplierService supplierservice;
	 @PostMapping("/add")
	 @ResponseStatus(HttpStatus.CREATED)
	    public Phone create(@RequestBody CreatePhoneRequest requestdata) {
	        String name = requestdata.getName();
	        Supplier supplier=requestdata.getSupplier();
	        int storagesize=requestdata.getStoragesize();
	      Phone phone= new Phone(name,supplier,storagesize);
	        phone = phoneservice.add(phone);
	        return phone;
	    }
	 @GetMapping("/get/{id}")
	 @ResponseStatus(HttpStatus.FOUND)
	    public Phone findPhone(@PathVariable("id") int id) {
	        Phone phone = phoneservice.findPhoneById(id);
	        return phone;
	    }
	
}

