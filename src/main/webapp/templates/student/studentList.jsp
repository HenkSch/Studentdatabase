<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1><s:text name="student.caption"/></h1>

<s:if test="hasActionErrors()">
    <div class="errors">
        <s:actionerror/>
    </div>
    <s:form action="studentList">
        <s:submit key="button.back"/>
    </s:form>
</s:if>
<s:else>
    <s:form action="studentList">
        <s:textfield name="searchValue" key="student.search"/>
        <s:submit key="student.searchGo"/>
    </s:form>
    <s:form action="studentList">
        <s:submit key="student.searchCancel"/>
    </s:form>
    <br/>
    <s:form action="studentAdd">
        <s:submit key="button.add"/>
    </s:form>

    <table border="1">
        <tr>
            <th><s:text name="student.id"/></th>
            <th><s:text name="student.name"/></th>
            <th><s:text name="student.givenName"/></th>
            <th><s:text name="student.gender"/></th>
            <th><s:text name="student.birthDate"/></th>
            <th><s:text name="student.birthPlace"/></th>
            <th><s:text name="student.registrationNumber"/></th>
            <th><s:text name="student.century"/></th>
            <th><s:text name="student.address"/></th>
            <th><s:text name="student.contactData"/></th>
            <th><s:text name="list.options"/></th>
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
                    <input type="button" value="<s:text name="button.edit"/>"
                           onclick="window.location='<s:property value="%{#editUrl}"/>';">
                    <input type="button" value="<s:text name="button.delete"/>"
                           onclick="window.location='<s:property value="%{#deleteUrl}"/>';">
                </td>
            </tr>
        </s:iterator>
    </table>
</s:else>