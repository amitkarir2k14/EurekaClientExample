package com.siemens.assignment.entity.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.siemens.assignment.entity.Address;
import com.siemens.assignment.repository.AddressRepository;

@Component
public class AddressEntitymanager {

	@Autowired
	private AddressRepository addressRepo;
	
	public Address save(Address address) {
		return addressRepo.save(address);
	}
	
	public Address findOne(Long id) {
		return addressRepo.findByAddressId(id);
	}
	
	public List<Address> findAll() {
		return addressRepo.findAll();
	}
}
