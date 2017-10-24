<%--
  Created by IntelliJ IDEA.
  User: U555987
  Date: 024, 24.10.2017
  Time: 13:45
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="address.title"/></h1>
<s:form action="updateAddress" method="POST">
    <s:textfield name="address.id" label="Id" readonly="true"/>
    <s:textfield name="address.street" label="Street"/>
    <s:textfield name="address.houseNumber" label="House number"/>
    <s:textfield name="address.zipCode" label="ZIP code"/>
    <s:textfield name="address.location" label="Location"/>
    <s:textfield name="address.addition" label="Addition"/>
    <s:submit value="Send"/>
</s:form>
