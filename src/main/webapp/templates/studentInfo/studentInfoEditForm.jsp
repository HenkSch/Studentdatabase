<%--
  Created by IntelliJ IDEA.
  User: U555987
  Date: 025, 25.10.2017
  Time: 10:48
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="studentInfo.caption"/></h1>
<s:form action="updateStudentInfo" method="POST">
    <s:textfield name="studentInfo.registrationNumber" label="Registration number" readonly="true"/>
    <s:textfield name="studentInfo.userNumber" label="*User number"/>
    <s:select list="centuryList" name="studentInfo.century.id" label="*Century"/>
    <s:select list="advisorList" name="studentInfo.advisor.id" label="Advisor" emptyOption="true"/>
    <s:select list="companyList" name="studentInfo.company.id" label="Company" emptyOption="true"/>
    <s:submit value="Send"/>
</s:form>
<s:text name="required.caption"/>