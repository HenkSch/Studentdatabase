<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="navbar-header">
        <h1><s:text name="title"/></h1>
    </div>
    <div class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
            <s:url var="student_url" action="studentList"/>
            <li><s:a href="%{student_url}">Students</s:a></li>

            <s:url var="studentInfo_url" action="studentList"/>
            <li class="active"><s:a href="%{studentInfo_url}">Student informations</s:a></li>

            <s:url var="century_url" action="studentList"/>
            <li><s:a href="%{century_url}">Centuries</s:a></li>

            <s:url var="company_url" action="studentList"/>
            <li><s:a href="%{company_url}">Companies</s:a></li>

            <s:url var="address_url" action="studentList"/>
            <li><s:a href="%{address_url}">Addresses</s:a></li>

            <s:url var="contactData_url" action="contactDataList"/>
            <li><s:a href="%{contactData_url}">Contact data</s:a></li>

            <s:url var="advisor_url" action="studentList"/>
            <li><s:a href="%{advisor_url}">Advisors</s:a></li>

        </ul>
    </div>
</nav>
