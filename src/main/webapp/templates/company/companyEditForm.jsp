<%--
  Created by IntelliJ IDEA.
  User: U555987
  Date: 024, 24.10.2017
  Time: 15:38
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="company.caption"/></h1>
<s:form action="updateCompany" method="POST">
    <s:textfield name="company.id" label="Id" readonly="true"/>
    <s:textfield name="company.name" label="Name"/>
    <s:textfield name="company.shortName" label="Short name"/>
    <s:textfield name="company.contactPerson.id" label="Contact person"/>
    <s:textfield name="company.address.id" label="Address"/>
    <s:submit value="Send"/>
</s:form>
