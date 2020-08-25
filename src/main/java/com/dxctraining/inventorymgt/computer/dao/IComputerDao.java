package com.dxctraining.inventorymgt.computer.dao;

import java.util.List;

import com.dxctraining.inventorymgt.computer.entities.Computer;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;

public interface IComputerDao {

    Computer findComputerById(int id);

    Computer add(Computer computer);

    void remove(int id);
	List<Computer> displayAllComputers();
    
}