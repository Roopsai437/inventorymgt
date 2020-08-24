package com.dxctraining.inventorymgt.item.dto;

import com.dxctraining.inventorymgt.item.entities.Item;

public class CreateComputerRequest extends Item {

		private String name;
		private int disksize;
		private String password;	
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getDisksize() {
			return disksize;
		}
		public void setDisksize(int disksize) {
			this.disksize = disksize;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}