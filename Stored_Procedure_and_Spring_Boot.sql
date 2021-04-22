-- Table Creation Scripts

CREATE TABLE PERSON
(
	ID INTEGER PRIMARY KEY,
	FIRST_NAME VARCHAR(50),
	LAST_NAME VARCHAR(50),
	ADDRESS VARCHAR(255)
);

SELECT * FROM PERSON;

DROP TABLE PERSON;

-- Table Creation Scripts

-- Data

INSERT INTO PERSON
	(id, first_name, last_name, address) values
	(1, 'Hari', 'Shankar', 'Chennai');

-- Data

-- Stored Procedure

/
CREATE OR REPLACE PACKAGE test_pkg AS
PROCEDURE in_only_test (inParam1 IN VARCHAR2);
PROCEDURE in_and_out_test (inParam1 IN VARCHAR2, outParam1 OUT VARCHAR2);
END test_pkg;
/
CREATE OR REPLACE PACKAGE BODY test_pkg AS
PROCEDURE in_only_test(inParam1 IN VARCHAR2) AS
BEGIN
DBMS_OUTPUT.PUT_LINE('in_only_test');
END in_only_test;
PROCEDURE in_and_out_test(inParam1 IN VARCHAR2, outParam1 OUT VARCHAR2) AS
BEGIN
outParam1 := 'Woohoo I am an outparam, and this is my inparam - ' || inParam1;
END in_and_out_test;
END test_pkg;
/

-- Stored Procedure

