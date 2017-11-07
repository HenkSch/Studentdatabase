<%--
  Created by IntelliJ IDEA.
  User: U555987
  Date: 006, 06.11.2017
  Time: 12:24
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="contactPerson.caption"/></h1>
<s:form action="updateContactPerson" method="POST">
    <s:textfield name="contactPerson.id" label="Id" readonly="true"/>
    <s:textfield name="contactPerson.name" label="*Name"/>
    <s:textfield name="contactPerson.givenName" label="*Given name"/>
    <s:textfield name="contactPerson.contactData.id" label="*Contact data"/>
    <s:label key="*field required" value=""></s:label>
    <s:submit value="Send"/>
</s:form>
