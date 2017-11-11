--@formatter:off
INSERT INTO CENTURY (ID, STUDYPROGRAM, YEAR, SUBGROUP) Values (hibernate_sequence.nextval, 'I', 14, 'a');
INSERT INTO CENTURY (ID, STUDYPROGRAM, YEAR, SUBGROUP) Values (hibernate_sequence.nextval, 'I', 14, 'b');
INSERT INTO CENTURY (ID, STUDYPROGRAM, YEAR, SUBGROUP) Values (hibernate_sequence.nextval, 'I', 14, 'c');
INSERT INTO CONTACTDATA (ID, EMAIL, PHONENUMBER, FAXNUMBER) Values (hibernate_sequence.nextval, 'astrid.meincke@lhind.dlh.de', '+49123456', '+49123123123');
INSERT INTO CONTACTPERSON (ID, NAME, GIVENNAME, CONTACTDATA_ID) Values (hibernate_sequence.nextval, 'Meincke', 'Astrid', 4 );
INSERT INTO ADDRESS (ID, STREET, HOUSENUMBER, ZIPCODE, LOCATION, ADDITION) Values (hibernate_sequence.nextval, 'Schuetzenwall', '1', 22844 , 'Norderstedt', 'Geb. 701');
INSERT INTO COMPANY (ID, NAME, SHORTNAME, CONTACTPERSON_ID, ADDRESS_ID) Values (hibernate_sequence.nextval, 'Lufthansa Industry Solutions', 'LHIND', 5, 6);
INSERT INTO CONTACTDATA (ID, EMAIL, PHONENUMBER, FAXNUMBER) Values (hibernate_sequence.nextval, 'frank.zimmermann@nordakademie.de', '+49123456', '');
INSERT INTO ADVISOR (ID, NAME, GIVENNAME, CONTACTDATA_ID) Values (hibernate_sequence.nextval, 'Zimmermann', 'Frank', 8 );
INSERT INTO STUDENTINFO (REGISTRATIONNUMBER, USERNUMBER, CENTURY_ID, ADVISOR_ID, COMPANY_ID) Values (hibernate_sequence.nextval, 14247, 3, 9, 7);
INSERT INTO ADDRESS (ID, STREET, HOUSENUMBER, ZIPCODE, LOCATION, ADDITION) Values (hibernate_sequence.nextval, 'Karoxbosteler Weg', '2b', 21218 , 'Seevetal', '');
INSERT INTO CONTACTDATA (ID, EMAIL, PHONENUMBER, FAXNUMBER) Values (hibernate_sequence.nextval, 'henk.schuhmann@lhind.dlh.de', '0123456', '+49123123123');
INSERT INTO STUDENT (ID, NAME, GIVENNAME, GENDER, BIRTHDATE, BIRTHPLACE, STUDENTINFO_REGISTRATIONNUMBER, ADDRESS_ID, CONTACTDATA_ID) Values (hibernate_sequence.nextval, 'Schuhmann', 'Henk', 'M', TO_DATE('07/10/1995', 'DD/MM/YYYY'), 'Hamburg', 10, 11, 12);
INSERT INTO ADDRESS (ID, STREET, HOUSENUMBER, ZIPCODE, LOCATION, ADDITION) Values (hibernate_sequence.nextval, 'Musterstrasse', '1', 12345 , 'Musterhausen', '');
INSERT INTO CONTACTDATA (ID, EMAIL, PHONENUMBER, FAXNUMBER) Values (hibernate_sequence.nextval, 'max.bewerbermann@muster.de', '+49123456', '+49123123123');
INSERT INTO STUDENT (ID, NAME, GIVENNAME, GENDER, BIRTHDATE, BIRTHPLACE, ADDRESS_ID, CONTACTDATA_ID) Values (hibernate_sequence.nextval, 'Bewerbermann', 'Max', 'M', TO_DATE('01/01/1995', 'DD/MM/YYYY'), 'Musterhausen',  14, 15);
INSERT INTO STUDENTINFO (REGISTRATIONNUMBER, USERNUMBER, CENTURY_ID, ADVISOR_ID, COMPANY_ID) Values (hibernate_sequence.nextval, 12345, 1, 9, 7);
INSERT INTO CONTACTDATA (ID, EMAIL, PHONENUMBER, FAXNUMBER) Values (hibernate_sequence.nextval, 'jan.meier@gmx.de', '+49123456', '+49123123123');
INSERT INTO CONTACTDATA (ID, EMAIL, PHONENUMBER, FAXNUMBER) Values (hibernate_sequence.nextval, 'benedikt.stemmildt@nordakademie.de', '+49123456', '');
INSERT INTO ADVISOR (ID, NAME, GIVENNAME, CONTACTDATA_ID) Values (hibernate_sequence.nextval, 'Stemmildt', 'Benedikt', 19 );
INSERT INTO CONTACTDATA (ID, EMAIL, PHONENUMBER, FAXNUMBER) Values (hibernate_sequence.nextval, 'alexander.birken@otto.de', '+49123456', '040123123123');
INSERT INTO CONTACTPERSON (ID, NAME, GIVENNAME, CONTACTDATA_ID) Values (hibernate_sequence.nextval, 'Birken', 'Alexander ', 21 );
INSERT INTO ADDRESS (ID, STREET, HOUSENUMBER, ZIPCODE, LOCATION) Values (hibernate_sequence.nextval, 'Wandsbeker Strasse', '3', 22172  , 'Hamburg');
INSERT INTO COMPANY (ID, NAME, SHORTNAME, CONTACTPERSON_ID, ADDRESS_ID) Values (hibernate_sequence.nextval, 'Otto (GmbH & Co KG)', 'Otto', 22, 23);
INSERT INTO STUDENTINFO (REGISTRATIONNUMBER, USERNUMBER, CENTURY_ID, ADVISOR_ID, COMPANY_ID) Values (hibernate_sequence.nextval, 23452, 3, 20, 24);
INSERT INTO CONTACTDATA (ID, EMAIL, PHONENUMBER, FAXNUMBER) Values (hibernate_sequence.nextval, 'georg.plate@nordakademie.de', '+49123456', '+49123123123');
INSERT INTO CONTACTDATA (ID, EMAIL, PHONENUMBER, FAXNUMBER) Values (hibernate_sequence.nextval, 'peter.schmidt@airbus.de', '040123456', '+49123123123');
INSERT INTO CONTACTPERSON (ID, NAME, GIVENNAME, CONTACTDATA_ID) Values (hibernate_sequence.nextval, 'Schmidt', 'Peter', 27 );
INSERT INTO CONTACTDATA (ID, EMAIL, PHONENUMBER, FAXNUMBER) Values (hibernate_sequence.nextval, 'heinz.bauer@aurubis.de', '040123456', '+49123123123');
INSERT INTO CONTACTPERSON (ID, NAME, GIVENNAME, CONTACTDATA_ID) Values (hibernate_sequence.nextval, 'Bauer', 'Heinz', 29 );
INSERT INTO STUDENTINFO (REGISTRATIONNUMBER, USERNUMBER, CENTURY_ID, ADVISOR_ID, COMPANY_ID) Values (hibernate_sequence.nextval, 64285, 3, 9, 24);
INSERT INTO CONTACTDATA (ID, EMAIL, PHONENUMBER, FAXNUMBER) Values (hibernate_sequence.nextval, 'philip.barwikowski@nordakademie.de', '+49123456', '+49123123123');
INSERT INTO STUDENT (ID, NAME, GIVENNAME, GENDER, BIRTHDATE, BIRTHPLACE, STUDENTINFO_REGISTRATIONNUMBER, ADDRESS_ID, CONTACTDATA_ID) Values (hibernate_sequence.nextval, 'Barwikowski', 'Philip', 'M', TO_DATE('01/02/1995', 'DD/MM/YYYY'), 'Hamburg', 31, 23, 32);














