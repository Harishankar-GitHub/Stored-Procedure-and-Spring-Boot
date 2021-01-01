package com.example.main;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.main.entity.Person;
import com.example.main.repository.EntityManagerRepository;
import com.example.main.repository.PersonJPARepository;
import com.example.main.repository.SimpleJdbcCallExample;

@SpringBootApplication
public class StoredProcedureAndSpringBootApplication implements CommandLineRunner
{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(StoredProcedureAndSpringBootApplication.class, args);
	}
	
	@Autowired
	private PersonJPARepository personJPARepository;
	
	@Autowired
	private EntityManagerRepository entityManagerRepository;
	
	@Autowired
	private SimpleJdbcCallExample simpleJdbcCall;

	@Override
	public void run(String... args) throws Exception
	{
		Optional<Person> person = personJPARepository.findById(1);
		
		if (person.get() != null)
		{
			logger.info(person.get().getFirstName());
		}
		else
		{
			logger.info("No records found!");
		}
		
		String inParam = "Happy coding !!!";
		
		entityManagerRepository.callingSPWithINParameter();
		
		logger.info(entityManagerRepository.callingSPWithINOUTParameters(inParam));
		
		logger.info("Result from SimpleJdbcCall -> {}", simpleJdbcCall.callStoredProcedure("Input param from SimpleJdbcCall"));
	}

}
