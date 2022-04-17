<%@ include file="/WEB-INF/jsp/header.jsp" %>

Group View with key <c:out value="${key}"/>

</br>

<c:forEach items="${groupList}" var="group">
    <div>
        <c:out value="${group.name}"/>
        <div>
            <c:forEach items="${groupList.persons}" var="person">
                <c:out value="${person.LastName}"/>
            </c:forEach>
        </div>
    </div>
</c:forEach>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
