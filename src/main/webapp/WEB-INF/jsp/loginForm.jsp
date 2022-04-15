<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="POST">
    <div class="form-group">
        <label>Name:</label>
        <form:input class="form-control" path="name" />
    </div>
    <div class="form-group">
        <label>Password:</label>
        <form:input class="form-control" path="password" />
    </div>
</form:form>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>
