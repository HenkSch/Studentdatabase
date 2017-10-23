<%--
  Created by IntelliJ IDEA.
  User: U555987
  Date: 020, 20.10.2017
  Time: 13:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form action="contactDataAdd">
    <s:submit value="Add"/>
</s:form>
<table>
    <tr>
        <th>Id</th>
        <th>Email</th>
        <th>Phone number</th>
        <th>Fax number</th>
    </tr>
    <s:iterator value="contactDataList">
        <tr>
            <td><s:property value="id"/></td>
            <td><s:property value="email"/></td>
            <td><s:property value="phoneNumber"/></td>
            <td><s:property value="faxNumber"/></td>
            <td><!--
                Author: Meyyappan Muthuraman
                Source: https://dzone.com/tutorials/java/struts-2/struts-2-example/struts-2-crud-example-1.html
                -->
                <s:url var="editUrl" action="contactDataEdit">
                    <s:param name="id" value="%{id}"></s:param>
                </s:url>
                <!--
                Author: Roman C
                Source: https://stackoverflow.com/questions/17477252/passing-values-in-button-instead-of-href-link
                -->
                <input type="button" value="Edit"
                       onclick="window.location='<s:property value="%{#editUrl}"/>';">
            </td>
            <td><!--
                Author: Meyyappan Muthuraman
                Source: https://dzone.com/tutorials/java/struts-2/struts-2-example/struts-2-crud-example-1.html
                -->
                <s:url var="deleteUrl" action="deleteContactData">
                    <s:param name="id" value="%{id}"></s:param>
                </s:url>
                <!--
                Author: Roman C
                Source: https://stackoverflow.com/questions/17477252/passing-values-in-button-instead-of-href-link
                -->
                <input type="button" value="Delete"
                       onclick="window.location='<s:property value="%{#deleteUrl}"/>';">
            </td>
        </tr>
    </s:iterator>
</table>


