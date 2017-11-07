<%--
  Created by IntelliJ IDEA.
  User: U555987
  Date: 025, 25.10.2017
  Time: 10:49
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="student.caption"/></h1>
<s:form action="updateStudent" method="POST">
    <s:textfield name="student.id" label="Id" readonly="true"/>
    <s:textfield name="student.name" label="*Name"/>
    <s:textfield name="student.givenName" label="*Given name"/>
    <s:textfield name="student.gender" label="*Gender"/>
    <s:textfield name="student.birthDate" label="*Birthdate"/>
    <s:textfield name="student.birthPlace" label="Birthplace"/>
    <s:select name="student.studentInfo.registrationNumber" label="Registration number" list="studentInfoList"
              emptyOption="true"/>
    <s:select name="student.address.id" label="*Address" list="addressList"/>
    <s:select name="student.contactData.id" label="*Contact data" list="contactDataList"/>
    <s:submit value="Send"/>
</s:form>
<s:text name="required.caption"/>
