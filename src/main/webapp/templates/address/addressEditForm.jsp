<%--
  Created by IntelliJ IDEA.
  User: Henk Schuhmann
  Date: 024, 24.10.2017
  Time: 13:45
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="address.caption"/></h1>
<s:form action="updateAddress" method="POST">
    <s:textfield name="address.id" key="address.idEdit" readonly="true"/>
    <s:textfield name="address.street" key="address.streetEdit"/>
    <s:textfield name="address.houseNumber" key="address.houseNumberEdit"/>
    <s:textfield name="address.zipCode" key="address.zipCodeEdit"/>
    <s:textfield name="address.location" key="address.locationEdit"/>
    <s:textfield name="address.addition" key="address.additionEdit"/>
    <s:submit key="button.save"/>
</s:form>
<s:form action="addressList">
    <s:submit key="button.cancel"/>
</s:form>
<s:text name="required.caption"/>
