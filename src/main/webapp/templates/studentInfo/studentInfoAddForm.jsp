<%--
  Created by IntelliJ IDEA.
  User: Henk Schuhmann, Sarah Bruhn
  Date: 025, 25.10.2017
  Time: 10:48
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="studentInfo.caption"/></h1>
<s:form action="createStudentInfo" method="POST">
    <s:textfield name="studentInfo.userNumber" key="studentInfo.userNumberEdit"/>
    <s:select list="centuryList" name="studentInfo.century.id" key="studentInfo.centuryEdit" headerKey=""
              headerValue="Please select a century"/>
    <s:select list="advisorList" name="studentInfo.advisor.id" key="studentInfo.advisorEdit" headerKey=""
              headerValue="Please select an advisor"/>
    <s:select list="companyList" name="studentInfo.company.id" key="studentInfo.companyEdit" headerKey=""
              headerValue="Please select a company"/>
    <s:submit key="button.save"/>
</s:form>
<s:form action="studentInfoList">
    <s:submit key="button.cancel"/>
</s:form>
<s:text name="required.caption"/>