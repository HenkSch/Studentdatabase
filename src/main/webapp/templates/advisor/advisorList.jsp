<%--
  Created by IntelliJ IDEA.
  User: Henk Schuhmann
  Date: 024, 24.10.2017
  Time: 14:24
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="advisor.caption"/></h1>
<s:if test="hasActionErrors()">
    <div class="errors">
        <s:actionerror/>
    </div>
    <s:form action="advisorList">
        <s:submit key="button.back"/>
    </s:form>
</s:if>
<s:else>
    <s:form action="advisorAdd">
        <s:submit key="button.add"/>
    </s:form>
    <table border="1">
        <tr>
            <th><s:text name="advisor.id"/></th>
            <th><s:text name="advisor.name"/></th>
            <th><s:text name="advisor.givenName"/></th>
            <th><s:text name="advisor.email"/></th>
            <th><s:text name="advisor.phoneNumber"/></th>
            <th><s:text name="advisor.faxNumber"/></th>
            <th><s:text name="list.options"/></th>
        </tr>
        <s:iterator value="advisorList">
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
                    <s:url var="editUrl" action="advisorEdit">
                        <s:param name="id" value="%{id}"></s:param>
                    </s:url>
                    <s:url var="deleteUrl" action="deleteAdvisor">
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