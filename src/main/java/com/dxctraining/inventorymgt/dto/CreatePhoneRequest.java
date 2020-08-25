package com.dxctraining.inventorymgt.dto;

import com.dxctraining.inventorymgt.item.entities.Item;

public class CreatePhoneRequest extends Item {		
		private String name;
		private int storagesize;
		public String getName() {
			return name;
		}	
		public int getStoragesize() {
			return storagesize;
		}

		public void setStoragesize(int storagesize) {
			this.storagesize = storagesize;
		}

		public void setName(String name) {
			this.name = name;
		}
	
		

	}

