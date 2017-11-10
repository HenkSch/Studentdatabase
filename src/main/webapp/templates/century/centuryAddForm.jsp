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
    <s:textfield name="century.studyProgram" key="century.studyProgramEdit"/>
    <s:textfield name="century.year" key="century.yearEdit"/>
    <s:textfield name="century.subGroup" key="century.subGroupEdit"/>
    <s:submit key="button.save"/>
</s:form>
<s:form action="centuryList">
    <s:submit key="button.cancel"/>
</s:form>
<s:text name="required.caption"/>
