<%--
  Created by IntelliJ IDEA.
  User: U555987
  Date: 023, 23.10.2017
  Time: 16:24
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="century.caption"/></h1>
<s:form action="updateCentury" method="POST">
    <s:textfield name="century.id" label="Id" readonly="true"/>
    <s:textfield name="century.studyProgram" label="Study program"/>
    <s:textfield name="century.year" label="Year"/>
    <s:textfield name="century.subGroup" label="Sub group"/>
    <s:submit value="Send"/>
</s:form>
