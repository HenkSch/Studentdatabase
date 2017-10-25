<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Given name</th>
        <th>Gender</th>
        <th>Birthdate</th>
        <th>Birthplace</th>
        <th>Registration number</th>
        <th>Options</th>
    </tr>
    <s:iterator value="students">
        <tr>
            <td><s:property value="id"/></td>
            <td><s:property value="name"/></td>
            <td><s:property value="givenName"/></td>
            <td><s:property value="gender"/></td>
            <td><s:property value="birthDate"/></td>
            <td><s:property value="birthPlace"/></td>
            <td><s:property value="studentInfo.registrationNumber"/></td>
        </tr>
    </s:iterator>
</table>
