<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="navbar-header">
        <h1><s:text name="header.title"/></h1>
    </div>
    <div class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
            <s:url var="student_url" action="studentList"/>
            <li>
                <s:a href="%{student_url}">
                    <s:text name="header.students"/>
                </s:a>
            </li>

            <s:url var="studentInfo_url" action="studentInfoList"/>
            <li class="active">
                <s:a href="%{studentInfo_url}">
                    <s:text name="header.studentsInformation"/>
                </s:a>
            </li>

            <s:url var="century_url" action="centuryList"/>
            <li>
                <s:a href="%{century_url}">
                    <s:text name="header.centuries"/>
                </s:a>
            </li>

            <s:url var="company_url" action="companyList"/>
            <li>
                <s:a href="%{company_url}">
                    <s:text name="header.companies"/>
                </s:a>
            </li>

            <s:url var="address_url" action="addressList"/>
            <li>
                <s:a href="%{address_url}">
                    <s:text name="header.addresses"/>
                </s:a>
            </li>

            <s:url var="contactData_url" action="contactDataList"/>
            <li>
                <s:a href="%{contactData_url}">
                    <s:text name="header.contactData"/>
                </s:a>
            </li>

            <s:url var="advisor_url" action="advisorList"/>
            <li>
                <s:a href="%{advisor_url}">
                    <s:text name="header.advisors"/>
                </s:a>
            </li>

        </ul>
    </div>
</nav>
