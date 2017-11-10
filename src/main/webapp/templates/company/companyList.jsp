<%--
  Created by IntelliJ IDEA.
  User: U555987
  Date: 024, 24.10.2017
  Time: 15:38
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="company.caption"/></h1>
<s:if test="hasActionErrors()">
    <div class="errors">
        <s:actionerror/>
    </div>
    <s:form action="companyList">
        <s:submit key="button.back"/>
    </s:form>
</s:if>
<s:else>
    <s:form action="companyAdd">
        <s:submit key="button.add"/>
    </s:form>
    <table border="1">
        <tr>
            <th><s:text name="company.id"/></th>
            <th><s:text name="company.name"/></th>
            <th><s:text name="company.shortName"/></th>
            <th><s:text name="company.contactPersonName"/></th>
            <th><s:text name="company.contactPersonGivenName"/></th>
            <th><s:text name="company.email"/></th>
            <th><s:text name="company.phoneNumber"/></th>
            <th><s:text name="company.faxNumber"/></th>
            <th><s:text name="company.street"/></th>
            <th><s:text name="company.houseNumber"/></th>
            <th><s:text name="company.zipCode"/></th>
            <th><s:text name="company.location"/></th>
            <th><s:text name="company.addition"/></th>
            <th><s:text name="list.options"/></th>
        </tr>
        <s:iterator value="companyList">
            <tr>
                <td><s:property value="id"/></td>
                <td><s:property value="name"/></td>
                <td><s:property value="shortName"/></td>
                <td><s:property value="contactPerson.name"/></td>
                <td><s:property value="contactPerson.givenName"/></td>
                <td><s:property value="contactPerson.contactData.email"/></td>
                <td><s:property value="contactPerson.contactData.phoneNumber"/></td>
                <td><s:property value="contactPerson.contactData.faxNumber"/></td>
                <td><s:property value="address.street"/></td>
                <td><s:property value="address.houseNumber"/></td>
                <td><s:property value="address.zipCode"/></td>
                <td><s:property value="address.location"/></td>
                <td><s:property value="address.addition"/></td>
                <td><!--
                Author: Meyyappan Muthuraman
                Source: https://dzone.com/tutorials/java/struts-2/struts-2-example/struts-2-crud-example-1.html
                -->
                    <s:url var="editUrl" action="companyEdit">
                        <s:param name="id" value="%{id}"></s:param>
                    </s:url>
                    <s:url var="deleteUrl" action="deleteCompany">
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