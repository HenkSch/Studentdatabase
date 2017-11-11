<%--
  Created by IntelliJ IDEA.
  User: Henk Schuhmann, Sarah Bruhn
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="attendanceList.caption"/></h1>
<h3><s:text name="attendanceList.course"/></h3>

<table border="1">
    <tr>
        <th><s:text name="attendanceList.name"/></th>
        <th><s:text name="attendanceList.week"/> 1</th>
        <th><s:text name="attendanceList.week"/> 2</th>
        <th><s:text name="attendanceList.week"/> 3</th>
        <th><s:text name="attendanceList.week"/> 4</th>
        <th><s:text name="attendanceList.week"/> 5</th>
        <th><s:text name="attendanceList.week"/> 6</th>
        <th><s:text name="attendanceList.week"/> 7</th>
        <th><s:text name="attendanceList.week"/> 8</th>
        <th><s:text name="attendanceList.week"/> 9</th>
        <th><s:text name="attendanceList.result"/></th>
    </tr>
    <s:iterator value="studentList">
        <tr>
            <td><s:property value="name"/>, <s:property value="givenName"/></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    </s:iterator>
</table>