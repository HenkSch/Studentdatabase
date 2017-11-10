<%--
  Created by IntelliJ IDEA.
  User: Henk Schuhmann
  Date: 024, 24.10.2017
  Time: 15:38
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="company.caption"/></h1>
<s:form action="createCompany" method="POST">
    <s:textfield name="company.name" key="company.nameEdit"/>
    <s:textfield name="company.shortName" key="company.shortNameEdit"/>
    <s:select list="contactPersonList" name="company.contactPerson.id" key="company.contactPersonEdit" headerKey=""
              headerValue="Please select a contact person"/>
    <s:select list="addressList" name="company.address.id" key="company.addressEdit" headerKey=""
              headerValue="Please select an address"/>
    <s:submit key="button.save"/>
</s:form>
<s:form action="companyList">
    <s:submit key="button.cancel"/>
</s:form>
<s:text name="required.caption"/>