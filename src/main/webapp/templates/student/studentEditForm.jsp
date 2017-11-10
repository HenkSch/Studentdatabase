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
    <s:textfield name="student.id" key="student.idEdit" readonly="true"/>
    <s:textfield name="student.name" key="student.nameEdit"/>
    <s:textfield name="student.givenName" key="student.givenNameEdit"/>
    <s:select name="student.gender" key="student.genderEdit" list="genderList"/>
    <s:textfield name="student.birthDate" key="student.birthDateEdit"/>
    <s:textfield name="student.birthPlace" key="student.birthPlaceEdit"/>
    <s:select name="student.studentInfo.registrationNumber" key="student.registrationNumberEdit" list="studentInfoList"
              emptyOption="true"/>
    <s:select name="student.address.id" key="student.addressEdit" list="addressList"/>
    <s:select name="student.contactData.id" key="student.contactDataEdit" list="contactDataList"/>
    <s:hidden name="id" value="%{id}"/>
    <s:submit key="button.save"/>
</s:form>
<s:form action="studentList">
    <s:submit key="button.cancel"/>
</s:form>
<s:text name="required.caption"/>
