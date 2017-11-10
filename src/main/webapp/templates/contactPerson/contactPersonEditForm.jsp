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
    <s:textfield name="contactPerson.id" key="contactPerson.idEdit" readonly="true"/>
    <s:textfield name="contactPerson.name" key="contactPerson.nameEdit"/>
    <s:textfield name="contactPerson.givenName" key="contactPerson.givenNameEdit"/>
    <s:select name="contactPerson.contactData.id" key="contactPerson.contactDataIdEdit" list="contactDataList"/>
    <s:hidden name="id" value="%{id}"/>
    <s:submit key="button.save"/>
</s:form>
<s:form action="contactPersonList">
    <s:submit key="button.cancel"/>
</s:form>
<s:text name="required.caption"/>