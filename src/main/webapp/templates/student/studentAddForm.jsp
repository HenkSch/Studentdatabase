<%--
  Created by IntelliJ IDEA.
  User: Henk Schuhmann, Sarah Bruhn
  Date: 025, 25.10.2017
  Time: 10:49
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="student.caption"/></h1>

<s:form action="createStudent" method="POST">
    <s:textfield name="student.name" key="student.nameEdit"/>
    <s:textfield name="student.givenName" key="student.givenNameEdit"/>
    <s:select name="student.gender" key="student.genderEdit" list="genderList"
              headerKey="" headerValue="Please select a gender"/>
    <s:textfield name="student.birthDate" key="student.birthDateEdit"/>
    <s:textfield name="student.birthPlace" key="student.birthPlaceEdit"/>
    <s:select name="student.studentInfo.registrationNumber" key="student.registrationNumberEdit" list="studentInfoList"
              headerKey="" headerValue="Please select a registration number"/>
    <s:select name="student.address.id" key="student.addressEdit" list="addressList" headerKey=""
              headerValue="Please select an address"/>
    <s:select name="student.contactData.id" key="student.contactDataEdit" list="contactDataList" headerKey=""
              headerValue="Please select a contact data"/>
    <s:submit key="button.save"/>
</s:form>
<s:form action="studentList">
    <s:submit key="button.cancel"/>
</s:form>
<s:text name="required.caption"/>