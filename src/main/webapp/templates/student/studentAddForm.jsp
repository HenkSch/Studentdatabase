<%--
  Created by IntelliJ IDEA.
  User: U555987
  Date: 025, 25.10.2017
  Time: 10:49
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="student.caption"/></h1>
<s:form action="createStudent" method="POST">
    <s:textfield name="student.name" label="*Name"/>
    <s:textfield name="student.givenName" label="*Given name"/>
    <s:select name="student.gender" label="*Gender" list="genderList"
              headerKey="" headerValue="Please select a gender"/>
    <s:textfield name="student.birthDate" label="*Birthdate"/>
    <s:textfield name="student.birthPlace" label="Birthplace"/>
    <s:select name="student.studentInfo.registrationNumber" label="Registration number" list="studentInfoList"
              headerKey="" headerValue="Please select a registration number"/>
    <s:select name="student.address.id" label="*Address" list="addressList" headerKey=""
              headerValue="Please select an address"/>
    <s:select name="student.contactData.id" label="*Contact data" list="contactDataList" headerKey=""
              headerValue="Please select a contact data"/>
    <s:submit value="Send"/>
</s:form>
<s:text name="required.caption"/>