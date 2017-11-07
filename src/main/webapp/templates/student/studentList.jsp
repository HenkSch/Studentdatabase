<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="student.caption"/></h1>
<s:form action="studentAdd">
    <s:submit value="Add"/>
</s:form>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Given name</th>
        <th>Gender</th>
        <th>Birthdate</th>
        <th>Birthplace</th>
        <th>Registration number</th>
        <th>Century</th>
        <th>Address</th>
        <th>Contact data</th>
        <th>Options</th>
    </tr>
    <s:iterator value="studentList">
        <tr>
            <td><s:property value="id"/></td>
            <td><s:property value="name"/></td>
            <td><s:property value="givenName"/></td>
            <td><s:property value="gender"/></td>
            <td><s:date name="birthDate" format="dd.MM.yyyy"/></td>
            <td><s:property value="birthPlace"/></td>
            <td><s:property value="studentInfo.registrationNumber"/></td>
            <td>
                <s:property value="studentInfo.century.studyProgram"/><s:property
                    value="studentInfo.century.year"/><s:property value="studentInfo.century.subGroup"/>
            </td>
            <td>
                <s:property value="address.zipCode"/>
                <s:property value="address.location"/>
            </td>
            <td><s:property value="contactData.email"/></td>
            <td><!--
                Author: Meyyappan Muthuraman
                Source: https://dzone.com/tutorials/java/struts-2/struts-2-example/struts-2-crud-example-1.html
                -->
                <s:url var="editUrl" action="studentEdit">
                    <s:param name="id" value="%{id}"></s:param>
                </s:url>
                <s:url var="deleteUrl" action="deleteStudent">
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
