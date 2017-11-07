<%--
  Created by IntelliJ IDEA.
  User: U555987
  Date: 024, 24.10.2017
  Time: 14:24
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="advisor.caption"/></h1>
<s:form action="updateAdvisor" method="POST">
    <s:textfield name="advisor.id" label="Id" readonly="true"/>
    <s:textfield name="advisor.name" label="*Name"/>
    <s:textfield name="advisor.givenName" label="*Given name"/>
    <s:select name="advisor.contactData.id" label="*Contact data" list="contactDataList"/>
    <s:label key="*field required" value=""></s:label>
    <s:submit value="Send"/>
</s:form>
