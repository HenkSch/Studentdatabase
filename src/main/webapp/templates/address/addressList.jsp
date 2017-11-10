<%--
  Created by IntelliJ IDEA.
  User: U555987
  Date: 024, 24.10.2017
  Time: 13:45
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="address.caption"/></h1>
<s:if test="hasActionErrors()">
    <div class="errors">
        <s:actionerror/>
    </div>
    <s:form action="addressList">
        <s:submit key="button.back"/>
    </s:form>
</s:if>
<s:else>
    <s:form action="addressAdd">
        <s:submit key="button.add"/>
    </s:form>
    <table border="1">
        <tr>
            <th><s:text name="address.id"/></th>
            <th><s:text name="address.street"/></th>
            <th><s:text name="address.houseNumber"/></th>
            <th><s:text name="address.zipCode"/></th>
            <th><s:text name="address.location"/></th>
            <th><s:text name="address.addition"/></th>
            <th><s:text name="list.options"/></th>
        </tr>
        <s:iterator value="addressList">
            <tr>
                <td><s:property value="id"/></td>
                <td><s:property value="street"/></td>
                <td><s:property value="houseNumber"/></td>
                <td><s:property value="zipCode"/></td>
                <td><s:property value="location"/></td>
                <td><s:property value="addition"/></td>
                <td><!--
                Author: Meyyappan Muthuraman
                Source: https://dzone.com/tutorials/java/struts-2/struts-2-example/struts-2-crud-example-1.html
                -->
                    <s:url var="editUrl" action="addressEdit">
                        <s:param name="id" value="%{id}"></s:param>
                    </s:url>
                    <s:url var="deleteUrl" action="deleteAddress">
                        <s:param name="id" value="%{id}"></s:param>
                    </s:url>
                    <!--
                    Author: Roman C
                    Source: https://stackoverflow.com/questions/17477252/passing-values-in-button-instead-of-href-link
                    -->
                    <input type="button" value="<s:text name="button.edit"/>"
                           onclick="window.location='<s:property value="%{#editUrl}"/>';">
                    <input type="button" value="<s:text name="button.delete"/>"
                           onclick="window.location='<s:property value="%{#deleteUrl}"/>';">
                </td>
            </tr>
        </s:iterator>
    </table>
</s:else>