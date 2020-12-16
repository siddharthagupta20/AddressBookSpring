package com.cg.adbsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.adbsp.model.AddressBookData;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookData,String> {

}
