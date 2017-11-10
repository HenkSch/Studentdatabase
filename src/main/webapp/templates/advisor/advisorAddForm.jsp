<%--
  Created by IntelliJ IDEA.
  User: Henk Schuhmann
  Date: 024, 24.10.2017
  Time: 14:24
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="advisor.caption"/></h1>
<s:form action="createAdvisor" method="POST">
    <s:textfield name="advisor.name" key="advisor.nameEdit"/>
    <s:textfield name="advisor.givenName" key="advisor.givenNameEdit"/>
    <s:select name="advisor.contactData.id" key="advisor.contactDataEdit" list="contactDataList" headerKey=""
              headerValue="Please select a contact data"/>
    <s:submit key="button.save"/>
</s:form>
<s:form action="advisorList">
    <s:submit key="button.cancel"/>
</s:form>
<s:text name="required.caption"/>