
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<div class="container">
    <h1>Home of the application</h1>
    <form method="get" action="/viewMail">
        Look for an email
        <input type="text" name="key"/>
        <input type="submit"/>
    </form>
    <form method="get" action="/viewPeople">
        Look for someone
        <input type="text" name="key"/>
        <input type="submit"/>
    </form>
    <form method="get" action="/viewGroup">
        Look for an group
        <input type="text" name="key"/>
        <input type="submit"/>
    </form>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>
