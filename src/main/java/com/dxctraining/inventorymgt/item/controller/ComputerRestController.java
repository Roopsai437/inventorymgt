package com.dxctraining.inventorymgt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.dxctraining.inventorymgt.computer.entities.Computer;
import com.dxctraining.inventorymgt.computer.service.IComputerService;
import com.dxctraining.inventorymgt.dto.CreateComputerRequest;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;
@RestController
@RequestMapping("/computer")
public class ComputerRestController {
	 @Autowired
	public IComputerService computerservice;
	 @Autowired
	public ISupplierService supplierservice;
	 @PostMapping("/add")
	 @ResponseStatus(HttpStatus.CREATED)
	    public Computer create(@RequestBody CreateComputerRequest requestdata) {
	        String name = requestdata.getName();
	        Supplier supplier=requestdata.getSupplier();
	        int disksize=requestdata.getDisksize();
	      Computer computer = new Computer(name,supplier,disksize);
	        computer = computerservice.add(computer);
	        return computer;
	    }
	 @GetMapping("/get/{id}")
	 @ResponseStatus(HttpStatus.FOUND)
	    public Computer findComputer(@PathVariable("id") int id) {
	        Computer computer = computerservice.findComputerById(id);
	        return computer;
	    }
	
	
}
