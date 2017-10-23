<%--
  Created by IntelliJ IDEA.
  User: U555987
  Date: 020, 20.10.2017
  Time: 13:40
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="contactData.title"/></h1>
<s:form action="updateContactData" method="POST">
    <s:textfield name="contactData.id" label="Id" readonly="true"/>
    <s:textfield name="contactData.email" label="Email"/>
    <s:textfield name="contactData.phoneNumber" label="Phone number"/>
    <s:textfield name="contactData.faxNumber" label="Fax number"/>
    <s:submit value="Send"/>
</s:form>
