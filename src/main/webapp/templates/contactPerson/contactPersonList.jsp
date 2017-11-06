<%--
  Created by IntelliJ IDEA.
  User: U555987
  Date: 006, 06.11.2017
  Time: 12:25
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="contactPerson.caption"/></h1>
<s:form action="contactPersonAdd">
    <s:submit value="Add"/>
</s:form>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Given name</th>
        <th>Email</th>
        <th>Phone number</th>
        <th>Fax number</th>
        <th>Options</th>
    </tr>
    <s:iterator value="contactPersonList">
        <tr>
            <td><s:property value="id"/></td>
            <td><s:property value="name"/></td>
            <td><s:property value="givenName"/></td>
            <td><s:property value="contactData.email"/></td>
            <td><s:property value="contactData.phoneNumber"/></td>
            <td><s:property value="contactData.faxNumber"/></td>
            <td><!--
                Author: Meyyappan Muthuraman
                Source: https://dzone.com/tutorials/java/struts-2/struts-2-example/struts-2-crud-example-1.html
                -->
                <s:url var="editUrl" action="contactPersonEdit">
                    <s:param name="id" value="%{id}"></s:param>
                </s:url>
                <s:url var="deleteUrl" action="deleteContactPerson">
                    <s:param name="id" value="%{id}"></s:param>
                </s:url>
                <!--
                Author: Roman C
                Source: https://stackoverflow.com/questions/17477252/passing-values-in-button-instead-of-href-link
                -->
                <input type="button" value="Edit"
                       onclick="window.location='<s:property value="%{#editUrl}"/>';">
                <input type="button" value="Delete"
                       onclick="window.location='<s:property value="%{#deleteUrl}"/>';">
            </td>
        </tr>
    </s:iterator>
</table>
