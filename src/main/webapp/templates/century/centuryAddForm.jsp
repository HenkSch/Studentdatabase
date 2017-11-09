<%--
  Created by IntelliJ IDEA.
  User: U555987
  Date: 023, 23.10.2017
  Time: 16:24
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="century.caption"/></h1>
<s:form action="createCentury" method="POST">
    <s:textfield name="century.studyProgram" label="*Study programm"/>
    <s:textfield name="century.year" label="*Year"/>
    <s:textfield name="century.subGroup" label="*Sub group"/>
    <s:submit value="Save"/>
</s:form>
<s:form action="centuryList">
    <s:submit value="Cancel"/>
</s:form>
<s:text name="required.caption"/>
