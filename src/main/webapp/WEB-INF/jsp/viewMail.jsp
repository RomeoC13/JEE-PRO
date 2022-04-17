
<%@ include file="/WEB-INF/jsp/header.jsp" %>

Group View with key <c:out value="${key}"/>

</br>

<c:forEach items="${mailList}" var="person">
    <div>
        <c:out value="${person.firstName}"/>
    </div>
</c:forEach>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
