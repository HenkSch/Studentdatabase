<%--
  Created by IntelliJ IDEA.
  User: Henk Schuhmann
  Date: 025, 25.10.2017
  Time: 10:48
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="studentInfo.caption"/></h1>
<s:form action="updateStudentInfo" method="POST">
    <s:textfield name="studentInfo.registrationNumber" key="studentInfo.registrationNumberEdit" readonly="true"/>
    <s:textfield name="studentInfo.userNumber" key="studentInfo.userNumberEdit"/>
    <s:select list="centuryList" name="studentInfo.century.id" key="studentInfo.centuryEdit"/>
    <s:select list="advisorList" name="studentInfo.advisor.id" key="studentInfo.advisorEdit" emptyOption="true"/>
    <s:select list="companyList" name="studentInfo.company.id" key="studentInfo.companyEdit" emptyOption="true"/>
    <s:submit key="button.save"/>
</s:form>
<s:form action="studentInfoList">
    <s:submit key="button.cancel"/>
</s:form>
<s:text name="required.caption"/>