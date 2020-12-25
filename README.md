### :sparkles: Stored Procedure and Spring Boot :sparkles:

#### Installing Oracle Sql Developer

- Oracle XE to create local database - [Installation URL](https://www.oracle.com/database/technologies/xe-downloads.html)
```
	While installing Oracle XE, set up password. This password is for SYS & SYSTEM user.
```
- Sql Developer to connect to our local database - [Installation URL](https://www.oracle.com/tools/downloads/sqldev-downloads.html)
```
	* After installing, open Sql Developer. Click on + icon to connect to a database.
	* Give any name for the connection. For example: Local DB
	* Username: SYSTEM
	* Password: We set password for SYS & SYSTEM during Oracle XE Setup.
	* Hostname, Port and SID can be left as default.
```
- To test connection
```
	* Start menu -> Scroll down to alphabet 'O' and expand Oracle Database folder.
	* Open SQL Command Line and type connect system. After this enter password.
	* (Or) Type connect system/password and click enter.
	* By doing this, we can test the connection.
	
	* In the same Oracle Database folder, we have option to Start/Stop Database.
```

#### Connecting Spring Boot and Oracle Database

- We have to add the below dependencies in pom.xml
```
	<dependency>
		<groupId>com.oracle.database.jdbc</groupId>
		<artifactId>ojdbc8</artifactId>
		<scope>runtime</scope>
	</dependency>
	 
	<dependency>
		<groupId>com.zaxxer</groupId>
		<artifactId>HikariCP</artifactId>
	</dependency>
```
- We have to specify the URL and Credentials of the database in application.properties file.
```
	spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
	spring.datasource.username=DATABASE_USERNAME (In our case username is SYSTEM)
	spring.datasource.password=DATABASE_PASSWORD
	spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
```

##### :tada: And that's it. Spring Boot application is now connected with Oracle database! :tada:

#### Calling Stored Procedure from Spring Boot application

- There are many ways to call a stored procedure from Spring Boot application.
- In this project, I have used EntityManager's StoredProcedureQuery which works fine.
- I also tried to use @NamedStoredProcedureQueries annotation and @Procedure annotation to call a stored procedure from JPA.
	But that is not working as expected.
	
#### Syntax to call a stored procedure using EntityManager's StoredProcedureQuery
```
	@Autowired
	private EntityManager em;
	
	public String callingSPWithINOUTParameters(String inParam)
	{
        StoredProcedureQuery procedure = em.createStoredProcedureQuery("package.storedProcedureName");
        		
        procedure.registerStoredProcedureParameter("inParam1", String.class, ParameterMode.IN);
        procedure.registerStoredProcedureParameter("outParam1", String.class, ParameterMode.OUT);
        procedure.setParameter("inParam1", inParam);
        
        procedure.execute();
        
        String result = (String) procedure.getOutputParameterValue("outParam1");
        return result;
	}
```

##### :tada: Will add different implementations/use cases with stored procedures in this project. :tada:
