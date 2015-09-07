CREATE DATABASE WEBTOXPI;

CREATE TABLE USERS 
    (ID SERIAL PRIMARY KEY,
     LOGIN           TEXT    	UNIQUE NOT NULL,
     PASSWORD        TEXT    	NOT NULL,
     FIRSTNAME       TEXT    	NOT NULL,
     LASTNAME        TEXT    	NOT NULL,
     EMAIL           TEXT    	NOT NULL,
     PHONE		 	 TEXT		NOT NULL,
     ADDRESS1        TEXT    	NOT NULL,
     ADDRESS2        TEXT    	NULL,
     COUNTRY		 TEXT		NOT NULL,
     STATE		 	 TEXT		NOT NULL,
     ZIP		 	 TEXT		NOT NULL,
     SEX			 TEXT		NOT NULL,
     ORGANIZATION	 TEXT		NULL,
     ORGANADDRESS	 TEXT		NULL,
     PHOTO			 BYTEA		NULL,
     NOTES           TEXT    	NULL,
     REGISTEREDDT    TIMESTAMP	NOT NULL DEFAULT CURRENT_DATE,
     LASTVISITDT     TIMESTAMP	NOT NULL DEFAULT CURRENT_DATE);
INSERT INTO USERS (LOGIN, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, PHONE, ADDRESS1, COUNTRY, STATE, ZIP, SEX) VALUES ('admin', '', 'FIRSTNAME', 'LASTNAME', 'EMAIL', 'PHONE', 'ADDRESS1', 'COUNTRY', 'STATE', 'ZIP', 'M');

CREATE TABLE USERROLES 
    (ID SERIAL PRIMARY KEY,
     CODE        	TEXT    	UNIQUE NOT NULL,
     NAME        	TEXT    	NOT NULL,
     NOTES          TEXT    	NULL,
     REGISTEREDDT   TIMESTAMP	NOT NULL DEFAULT CURRENT_DATE,
     LASTVISITDT    TIMESTAMP	NOT NULL DEFAULT CURRENT_DATE);
INSERT INTO USERROLES (CODE, NAME, NOTES) VALUES ('MANAGER', 'Manager', '');
INSERT INTO USERROLES (CODE, NAME, NOTES) VALUES ('MEMBER', 'Member', '');
INSERT INTO USERROLES (CODE, NAME, NOTES) VALUES ('VIEWER', 'Viewer', '');


CREATE TABLE PROJECTTYPES 
    (ID SERIAL PRIMARY KEY,
     CODE        	TEXT    	UNIQUE NOT NULL,
     NAME        	TEXT    	NOT NULL,
     NOTES          TEXT    	NULL,
     REGISTEREDDT   TIMESTAMP	NOT NULL DEFAULT CURRENT_DATE,
     LASTVISITDT    TIMESTAMP	NOT NULL DEFAULT CURRENT_DATE);
INSERT INTO PROJECTTYPES (CODE, NAME) VALUES ('DEFAULT', 'Default');

CREATE TABLE PROJECTS 
    (ID SERIAL PRIMARY KEY,
     CODE        	TEXT    	UNIQUE NOT NULL,
     NAME        	TEXT    	NOT NULL,
     ACCESS        	INTEGER    	NOT NULL DEFAULT 0, -- 0-Private; 1-Selected; 2-For registered users (readonly); 3-For registered users (edit); 4-For all users (readonly); 5-For all users (edit);
     NOTES          TEXT    	NULL,
     OWNER        	INTEGER		NOT NULL REFERENCES USERS,
     PROJECTTYPE    INTEGER		NOT NULL REFERENCES PROJECTTYPES,
     REGISTEREDDT   TIMESTAMP	NOT NULL DEFAULT CURRENT_DATE,
     LASTVISITDT    TIMESTAMP	NOT NULL DEFAULT CURRENT_DATE);
INSERT INTO PROJECTS (CODE, NAME, ACCESS, OWNER, PROJECTTYPE) VALUES ('PROJECT', 'Project', 0, 1, 1);


CREATE TABLE IMPORTINFO 
    (ID SERIAL PRIMARY KEY,
     USER_ID        INTEGER    	NOT NULL REFERENCES USERS,
     TRANSACTIONDATE TIMESTAMP  NOT NULL DEFAULT CURRENT_DATE,
     NOTES          TEXT    	NOT NULL,
     FILE			BYTEA		NOT NULL,
     FILENAME		TEXT        NOT NULL);

CREATE TABLE PROJECTMEMBERS 
    (ID SERIAL PRIMARY KEY,
     PROJECT_ID     INTEGER    	NOT NULL REFERENCES PROJECTS,
     USER_ID        INTEGER    	NOT NULL REFERENCES USERS,
     USERROLE_ID  	INTEGER 	NOT NULL REFERENCES USERROLES,
     NOTES          TEXT    	NULL,
     REGISTEREDDT   TIMESTAMP	NOT NULL DEFAULT CURRENT_DATE,
     LASTVISITDT    TIMESTAMP	NOT NULL DEFAULT CURRENT_DATE);

CREATE TABLE ROWTYPES 
    (ID SERIAL PRIMARY KEY,
     CODE        	TEXT    	NOT NULL,
     NAME        	TEXT    	NOT NULL,
     SHOWORDER      INTEGER    	NOT NULL,
     NOTES          TEXT    	NULL,
     PROJECT_ID   	INTEGER     NOT NULL REFERENCES PROJECTS,
     REGISTEREDDT   TIMESTAMP	NOT NULL DEFAULT CURRENT_DATE,
     LASTVISITDT    TIMESTAMP	NOT NULL DEFAULT CURRENT_DATE,
     UNIQUE (CODE, PROJECT_ID));
INSERT INTO ROWTYPES (CODE, NAME, SHOWORDER, PROJECT_ID) VALUES ('SOURCE', 'Source', 1, 1);
INSERT INTO ROWTYPES (CODE, NAME, SHOWORDER, PROJECT_ID) VALUES ('CASRN', 'CASR Number', 2, 1);
INSERT INTO ROWTYPES (CODE, NAME, SHOWORDER, PROJECT_ID) VALUES ('CHEMICAL', 'Chemical', 3, 1);


CREATE TABLE ROWHEADERS
    (ID SERIAL PRIMARY KEY,
     CODE        	TEXT    	NOT NULL,
     NAME        	TEXT    	NOT NULL,
     NOTES          TEXT    	NULL,
     COLOR          INTEGER    	NULL,
     ROWTYPE_ID     INTEGER    	NOT NULL REFERENCES ROWTYPES,
     REGISTEREDDT   TIMESTAMP	NOT NULL DEFAULT CURRENT_DATE,
     LASTVISITDT    TIMESTAMP	NOT NULL DEFAULT CURRENT_DATE,
     UNIQUE (CODE, ROWTYPE_ID));
     
CREATE TABLE COLUMNTYPES 
    (ID SERIAL PRIMARY KEY,
     CODE        	TEXT    	NOT NULL,
     NAME        	TEXT    	NOT NULL,
     NOTES          TEXT    	NULL,
     PARENT_ID   	INTEGER     NULL REFERENCES COLUMNTYPES,
     PROJECT_ID   	INTEGER     NOT NULL REFERENCES PROJECTS,
     REGISTEREDDT   TIMESTAMP	NOT NULL DEFAULT CURRENT_DATE,
     LASTVISITDT    TIMESTAMP	NOT NULL DEFAULT CURRENT_DATE,
     UNIQUE (CODE, PROJECT_ID));
INSERT INTO COLUMNTYPES (CODE, NAME, PARENT_ID, PROJECT_ID) VALUES ('WEIGHT', 'Weight', null, 1);
INSERT INTO COLUMNTYPES (CODE, NAME, PARENT_ID, PROJECT_ID) VALUES ('GROUP', 'Group', 1, 1);
INSERT INTO COLUMNTYPES (CODE, NAME, PARENT_ID, PROJECT_ID) VALUES ('TYPE', 'Type', 2, 1);

CREATE TABLE COLUMNHEADERS
    (ID SERIAL PRIMARY KEY,
     CODE        	TEXT    	NOT NULL,
     NAME        	TEXT    	NOT NULL,
     NOTES          TEXT    	NULL,
     COLOR          INTEGER    	NULL,
     PARENT_ID  	INTEGER    	NOT NULL REFERENCES COLUMNHEADERS,
     COLUMNTYPE_ID  INTEGER    	NOT NULL REFERENCES COLUMNTYPES,
     REGISTEREDDT   TIMESTAMP	NOT NULL DEFAULT CURRENT_DATE,
     LASTVISITDT    TIMESTAMP	NOT NULL DEFAULT CURRENT_DATE,
     UNIQUE (CODE, COLUMNTYPE_ID));

CREATE TABLE VIEWTEMPLATES 
    (ID SERIAL PRIMARY KEY,
     CODE           TEXT    	UNIQUE NOT NULL,
     NAME           TEXT    	NOT NULL,
     OBJECTXML      XML         NULL,
     USER_ID        INTEGER     NOT NULL REFERENCES USERS,
     UPDATEDBY      INTEGER     NOT NULL REFERENCES USERS,
     UPDATEDDT      TIMESTAMP	NOT NULL DEFAULT CURRENT_DATE);    
     
CREATE TABLE NOTES 
    (ID SERIAL PRIMARY KEY,
     CODE           TEXT        UNIQUE NOT NULL,
     NOTE           TEXT        NULL,
     OWNER_ID       INTEGER     NOT NULL,
     OWNERTYPE      CHAR[1]     NOT NULL,
     VISIBLE        BOOLEAN     NOT NULL DEFAULT TRUE,
     UPDATEDBY      INTEGER     NOT NULL REFERENCES USERS,
     UPDATEDDT      TIMESTAMP	NOT NULL DEFAULT CURRENT_DATE);    

CREATE TABLE UNITS 
    (ID SERIAL PRIMARY KEY,
     CODE           TEXT    	UNIQUE NOT NULL,
     NAME           TEXT    	NULL,
     RELATEDUNIT	INTEGER     NULL REFERENCES UNITS,
     VOLUMEOF		DECIMAL     NULL,
     UPDATEDBY      INTEGER     NOT NULL REFERENCES USERS,
     UPDATEDDT      TIMESTAMP	NOT NULL DEFAULT CURRENT_DATE);
INSERT INTO UNITS (CODE, NAME, RELATEDUNIT, VOLUMEOF, UPDATEDBY, UPDATEDDT) VALUES ('STRING', 'String', NULL, NULL, 1, CURRENT_DATE);

CREATE TABLE COMPONENTS
    (ID SERIAL PRIMARY KEY,
     CODE           TEXT    	UNIQUE NOT NULL,
     NAME           TEXT    	NOT NULL,
     NOTES          TEXT    	NULL,
     COLOR          INTEGER    	NULL,
     PROJECT_ID   	INTEGER     NOT NULL REFERENCES PROJECTS,
     COLUMNHEADER_ID INTEGER	NULL REFERENCES COLUMNHEADERS,
     UNIT			INTEGER     NOT NULL REFERENCES UNITS,
     UPDATEDBY      INTEGER     NOT NULL REFERENCES USERS,
     UPDATEDDT      TIMESTAMP	NOT NULL DEFAULT CURRENT_DATE,
     UNIQUE (CODE, PROJECT_ID));
INSERT INTO COMPONENTS (CODE, NAME, NOTES, COLOR, PROJECT_ID, UNIT, UPDATEDBY) VALUES ('DEFAULT', 'Default', 'Default', NULL, 1, 1, 1);
     
CREATE TABLE RESULTS 
    (ID SERIAL PRIMARY KEY,
     COMPONENT_ID   INTEGER     NOT NULL REFERENCES COMPONENTS,
     PROJECT_ID   	INTEGER     NOT NULL REFERENCES PROJECTS,
     STRRESULT      TEXT     	NULL,
     UPDATEDBY      INTEGER     NOT NULL REFERENCES USERS,
     UPDATEDDT      TIMESTAMP	NOT NULL DEFAULT CURRENT_DATE);

CREATE TABLE ORDERS 
    (ID SERIAL PRIMARY KEY,
     ROWHEADER_ID	INTEGER		NULL REFERENCES ROWHEADERS,
     RESULT_ID		INTEGER		NULL REFERENCES RESULTS);
     
CREATE TABLE RESULTSHISTORY 
    (ID SERIAL PRIMARY KEY,
     RESULTS        INTEGER     NOT NULL REFERENCES RESULTS,
     OLDSTRRESULT   TEXT     	NULL,
     NEWSTRRESULT   TEXT     	NULL,
     UPDATEDBY      INTEGER     NOT NULL REFERENCES USERS,
     UPDATEDDT      TIMESTAMP	NOT NULL DEFAULT CURRENT_DATE);
     
CREATE OR REPLACE FUNCTION RESULT_CHANGES_HISTORY() RETURNS TRIGGER AS
$BODY$
BEGIN
    IF  TG_OP = 'INSERT' THEN
        INSERT INTO RESULTSHISTORY(RESULTS, OLDSTRRESULT, NEWSTRRESULT, UPDATEDBY)
        values (NEW.ID, null, NEW.STRRESULT, 1);
        RETURN NEW;
    ELSIF TG_OP = 'UPDATE' THEN
        INSERT INTO RESULTSHISTORY(RESULTS, OLDSTRRESULT, NEWSTRRESULT, UPDATEDBY)
        values (NEW.ID, OLD.STRRESULT, NEW.STRRESULT, 1);
        RETURN NEW;
    ELSIF TG_OP = 'DELETE' THEN
        RETURN OLD;
    END IF;
END;
$BODY$ LANGUAGE plpgsql;

CREATE TRIGGER T_RESULTS AFTER INSERT OR UPDATE OR DELETE ON RESULTS FOR EACH ROW EXECUTE PROCEDURE RESULT_CHANGES_HISTORY();