<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="login"  value="/user/login" />
<c:url var="logout" value="/user/logout" />
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:url var="show"   value="/user/show" />

<div class="container">
  <h1>User</h1>

  <p>
    name : <c:out value="${user.name}" default="no name"/> |
    <a href="${show}">Show</a> | <a href="${login}">Login</a> |
    <sec:authorize access="isAuthenticated()">
      <a href="${logout}">Logout</a>
    </sec:authorize>
  </p>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>