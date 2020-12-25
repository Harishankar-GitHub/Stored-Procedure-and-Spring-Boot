package com.example.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.main.entity.Person;

@Repository
public interface PersonJPARepository extends JpaRepository<Person, Integer> 
{
	
	// NOTE - Calling SP using JPA doesn't work properly.
	// NOTE - Calling SP using EntityManager works fine. Refer PersonEntityManagerRepository.java file.
	
//	********************************************************************************************
	
//	@Procedure(procedureName = "test_pkg.in_and_out_test")
//	String calling_SP(@Param("inParam1") String inParam1);
	
//	@Procedure(name = "in_only_test")
//	void inOnlyTest(@Param("inParam1") String inParam1);
//	@Procedure(name = "in_and_out_test")
//	String inAndOutTest(@Param("inParam1") String inParam1);
	
	@Procedure(name = "in_and_out_test")
	String inAndOutTest(String inParam1);

}
