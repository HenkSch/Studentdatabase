<%--
  Created by IntelliJ IDEA.
  User: U555987
  Date: 024, 24.10.2017
  Time: 15:38
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="company.caption"/></h1>
<s:form action="createCompany" method="POST">
    <s:textfield name="company.name" label="*Name"/>
    <s:textfield name="company.shortName" label="Short name"/>
    <s:select list="contactPersonList" name="company.contactPerson.id" label="*Contact person" headerKey=""
              headerValue="Please select a contact person"/>
    <s:select list="addressList" name="company.address.id" label="*Address" headerKey=""
              headerValue="Please select an address"/>
    <s:submit value="Save"/>
</s:form>
<s:form action="companyList">
    <s:submit value="Cancel"/>
</s:form>
<s:text name="required.caption"/>