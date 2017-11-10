<%--
  Created by IntelliJ IDEA.
  User: Henk Schuhmann
  Date: 020, 20.10.2017
  Time: 13:40
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="contactData.caption"/></h1>
<s:form action="createContactData" method="POST">
    <s:textfield name="contactData.email" key="contactData.emailEdit"/>
    <s:textfield name="contactData.phoneNumber" key="contactData.phoneNumberEdit"/>
    <s:textfield name="contactData.faxNumber" key="contactData.faxNumberEdit"/>
    <s:submit key="button.save"/>
</s:form>
<s:form action="contactDataList">
    <s:submit key="button.cancel"/>
</s:form>
<s:text name="required.caption"/>
