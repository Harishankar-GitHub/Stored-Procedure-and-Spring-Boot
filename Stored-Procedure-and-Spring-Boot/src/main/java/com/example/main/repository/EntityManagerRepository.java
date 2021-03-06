package com.example.main.repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.main.utils.Constants;

@Repository
public class EntityManagerRepository
{
	@Autowired
	private EntityManager em;
	
	public void callingSPWithINParameter()
	{
        StoredProcedureQuery procedure = em.createStoredProcedureQuery(Constants.IN_PROCEDURE_NAME);
        		
        procedure.registerStoredProcedureParameter("inParam1", String.class, ParameterMode.IN);
        procedure.setParameter("inParam1", "Hello world!");
        
        procedure.execute();
    }
	
	public String callingSPWithINOUTParameters(String inParam)
	{
        StoredProcedureQuery procedure = em.createStoredProcedureQuery(Constants.INOUT_PROCEDURE_NAME);
        		
        procedure.registerStoredProcedureParameter("inParam1", String.class, ParameterMode.IN);
        
        procedure.registerStoredProcedureParameter("outParam1", String.class, ParameterMode.OUT);
        
        procedure.setParameter("inParam1", inParam);
        
        procedure.execute();
        
        String result = (String) procedure.getOutputParameterValue("outParam1");
        return result;
    }	
}
