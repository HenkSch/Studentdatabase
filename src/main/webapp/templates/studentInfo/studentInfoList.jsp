<%--
  Created by IntelliJ IDEA.
  User: U555987
  Date: 025, 25.10.2017
  Time: 10:48
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="studentInfo.caption"/></h1>
<s:if test="hasActionErrors()">
    <div class="errors">
        <s:actionerror/>
    </div>
    <s:form action="studentInfoList">
        <s:submit value="Ok. Back to List"/>
    </s:form>
</s:if>
<s:else>
    <s:form action="studentInfoAdd">
        <s:submit value="Add"/>
    </s:form>
    <table border="1">
        <tr>
            <th>Registration number</th>
            <th>Usernumber</th>

            <th>Century study program</th>
            <th>Century year</th>
            <th>Century sub group</th>

            <th>Advisor name</th>
            <th>Advisor given name</th>

            <th>Company name</th>
            <th>Company short name</th>
            <th>Company contact person name</th>
            <th>Company contact person given name</th>

            <th>Options</th>
        </tr>
        <s:iterator value="studentInfoList">
            <tr>
                <td><s:property value="registrationNumber"/></td>
                <td><s:property value="userNumber"/></td>

                <td><s:property value="century.studyProgram"/></td>
                <td><s:property value="century.year"/></td>
                <td><s:property value="century.subGroup"/></td>

                <td><s:property value="advisor.name"/></td>
                <td><s:property value="advisor.givenName"/></td>

                <td><s:property value="company.name"/></td>
                <td><s:property value="company.shortName"/></td>
                <td><s:property value="company.contactPerson.name"/></td>
                <td><s:property value="company.contactPerson.givenName"/></td>

                <td><!--
                Author: Meyyappan Muthuraman
                Source: https://dzone.com/tutorials/java/struts-2/struts-2-example/struts-2-crud-example-1.html
                -->
                    <s:url var="editUrl" action="studentInfoEdit">
                        <s:param name="id" value="%{registrationNumber}"></s:param>
                    </s:url>
                    <s:url var="deleteUrl" action="deleteStudentInfo">
                        <s:param name="id" value="%{registrationNumber}"></s:param>
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
</s:else>