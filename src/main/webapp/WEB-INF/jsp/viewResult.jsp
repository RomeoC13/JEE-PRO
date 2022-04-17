<%@ include file="/WEB-INF/jsp/header.jsp" %>

<c:url var="home" value="/"/>
<a href="${home}">Home</a>

<div id="card-container" class="container">
    <h1>Group View with <c:out value="${key}"/></h1>
    <c:forEach items="${data}" var="person">
        <div class="person-card">
            <fmt:formatDate value="${person.birthDay}" var="birthday" type="date" pattern="MM-dd-yyyy"/>
            <p><c:out value="${person.firstName}"/></p>
            <p><c:out value="${person.lastName}"/></p>
            <p> &#127874; <c:out value="${birthday}"/></p>
            <p> &#128231; <c:out value="${person.emailAddress}"/></p>
            <p> site : <c:out value="${person.website}"/></p>
        </div>
    </c:forEach>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
