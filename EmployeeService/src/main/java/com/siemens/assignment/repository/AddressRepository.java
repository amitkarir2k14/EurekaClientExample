package com.siemens.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siemens.assignment.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	public Address findByAddressId(Long id);

}