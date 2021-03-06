<%--
  Created by IntelliJ IDEA.
  User: Henk Schuhmann, Sarah Bruhn
  Date: 020, 20.10.2017
  Time: 13:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="century.caption"/></h1>
<s:if test="hasActionErrors()">
    <div class="errors">
        <s:actionerror/>
    </div>
    <s:form action="centuryList">
        <s:submit key="button.back"/>
    </s:form>
</s:if>
<s:else>
    <s:form action="centuryAdd">
        <s:submit key="button.add"/>
    </s:form>
    <table border="1">
        <tr>
            <th><s:text name="century.id"/></th>
            <th><s:text name="century.studyProgram"/></th>
            <th><s:text name="century.year"/></th>
            <th><s:text name="century.subGroup"/></th>
            <th><s:text name="list.options"/></th>
        </tr>
        <s:iterator value="centuryList">
            <tr>
                <td><s:property value="id"/></td>
                <td><s:property value="studyProgram"/></td>
                <td><s:property value="year"/></td>
                <td><s:property value="subGroup"/></td>
                <td><!--
                Author: Meyyappan Muthuraman
                Source: https://dzone.com/tutorials/java/struts-2/struts-2-example/struts-2-crud-example-1.html
                -->
                    <s:url var="editUrl" action="centuryEdit">
                        <s:param name="id" value="%{id}"></s:param>
                    </s:url>
                    <s:url var="deleteUrl" action="deleteCentury">
                        <s:param name="id" value="%{id}"></s:param>
                    </s:url>
                    <s:url var="attendanceListUrl" action="studentAttendanceList">
                        <s:param name="centuryId" value="%{id}"></s:param>
                    </s:url>
                    <!--
                    Author: Roman C
                    Source: https://stackoverflow.com/questions/17477252/passing-values-in-button-instead-of-href-link
                    -->
                    <input type="button" value="<s:text name="button.edit"/>"
                           onclick="window.location='<s:property value="%{#editUrl}"/>';">
                    <input type="button" value="<s:text name="button.delete"/>"
                           onclick="window.location='<s:property value="%{#deleteUrl}"/>';">
                    <input type="button" value="<s:text name="button.attendanceList"/>"
                           onclick="window.location='<s:property value="%{#attendanceListUrl}"/>';">
                </td>
            </tr>
        </s:iterator>
    </table>
</s:else>

