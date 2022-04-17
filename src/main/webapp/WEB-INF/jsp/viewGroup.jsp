<%@ include file="/WEB-INF/jsp/header.jsp" %>


<c:url var="home" value="/"/>
<a href="${home}">Home</a>

<div class="container">
    <h1>Group View with key <c:out value="${key}"/></h1>
    <c:forEach items="${groupList}" var="group">
        <div>
            <c:out value="${group.name}"/>
            <div>
                    <%--            <c:forEach items="${group.persons}" var="person">--%>
                    <%--                test--%>
                    <%--                <c:out value="${person.LastName}"/>--%>
                    <%--            </c:forEach>--%>
            </div>
        </div>
    </c:forEach>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
