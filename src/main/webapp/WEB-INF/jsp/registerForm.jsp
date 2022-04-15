<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="POST">
    <div class="form-group">
        <label>Name:*</label>
        <form:input class="form-control" path="name"/>
    </div>

    <div class="form-group">
        <label>FirstName:</label>
        <form:input class="form-control" path="firstname"/>
    </div>

    <div class="form-group">
        <label>Address:</label>
        <form:input class="form-control" path="address"/>
    </div>

    <div class="form-group">
        <label>website:</label>
        <form:input class="form-control" path="website"/>
    </div>

    <div class="form-group">
        <label>Birthday:</label>
        <form:input type="date" class="form-control" path="birthday"/>
    </div>

    <div class="form-group">
        <label>Password:*</label>
        <form:input type="password" class="form-control" path="password"/>
    </div>

    <div class="form-group">
        <input type="submit"/>
    </div>
</form:form>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>
