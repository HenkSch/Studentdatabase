<%--
  Created by IntelliJ IDEA.
  User: Henk Schuhmann, Sarah Bruhn
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><s:text name="title"/></title>
</head>
<body>
<div class="container">
    <tiles:insertAttribute name="header"/>
    <hr/>
    <tiles:insertAttribute name="content"/>
</div>
</body>
</html>
