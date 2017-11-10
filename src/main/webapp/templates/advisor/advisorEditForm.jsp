<%--
  Created by IntelliJ IDEA.
  User: Henk Schuhmann
  Date: 024, 24.10.2017
  Time: 14:24
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="advisor.caption"/></h1>
<s:form action="updateAdvisor" method="POST">
    <s:textfield name="advisor.id" key="advisor.idEdit" readonly="true"/>
    <s:textfield name="advisor.name" key="advisor.nameEdit"/>
    <s:textfield name="advisor.givenName" key="advisor.givenNameEdit"/>
    <s:select name="advisor.contactData.id" key="advisor.contactDataEdit" list="contactDataList"/>
    <s:hidden name="id" value="%{id}"/>
    <s:submit key="button.save"/>
</s:form>
<s:form action="advisorList">
    <s:submit key="button.cancel"/>
</s:form>
<s:text name="required.caption"/>
