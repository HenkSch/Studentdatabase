<%--
  Created by IntelliJ IDEA.
  User: U555987
  Date: 025, 25.10.2017
  Time: 10:48
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="studentInfo.caption"/></h1>
<s:form action="createStudentInfo" method="POST">
    <s:textfield name="studentInfo.userNumber" label="*User number"/>
    <s:select list="centuryList" name="studentInfo.century.id" label="*Century"/>
    <s:select list="advisorList" name="studentInfo.advisor.id" label="Advisor" headerKey=""
              headerValue="Please select an advisor"/>
    <s:select list="companyList" name="studentInfo.company.id" label="Company" headerKey=""
              headerValue="Please select a company"/>
    <s:label key="*field required" value=""></s:label>
    <s:submit value="Send"/>
</s:form>