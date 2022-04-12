<%@ include file="/WEB-INF/jsp/header.jsp" %>

<div class="container">
    <p>the counter is at <c:out value="${sessionScope.counter}" default="None"/></p>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>
