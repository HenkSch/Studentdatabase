<%--
  Created by IntelliJ IDEA.
  User: U555987
  Date: 024, 24.10.2017
  Time: 14:24
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="advisor.caption"/></h1>
<s:form action="createAdvisor" method="POST">
    <s:textfield name="advisor.name" label="*Name"/>
    <s:textfield name="advisor.givenName" label="*Given name"/>
    <s:select name="advisor.contactData.id" label="*Contact data" list="contactDataList" headerKey=""
              headerValue="Please select a contact data"/>
    <s:submit value="Save"/>
</s:form>
<s:form action="advisorList">
    <s:submit value="Cancel"/>
</s:form>
<s:text name="required.caption"/>