<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<div style="margin: auto; width: 80%;">
<h2 style="text-align: center;">Com.Posting API</h2>
<div style="margin: auto; width: 50%;">
<fieldset>
    <legend>Database Searches</legend>
<form action="${pageContext.request.contextPath}/search" method="get">
    <div>
        <input name="tables" id="searchTable" value="service" hidden>
        <label for="searchItem">Enter the ID to retrieve:</label>
        <input type="text" id="searchItem" name="searchItem" value="" pattern="^[0-9]*">
    </div>
    <button type="submit" name="submit" value="search">Search</button>
    <button type="submit" name="submit" value="viewAll">View All</button>
</form>
</fieldset>
</div>
<div style="margin: auto; width: 50%;">
    <c:if test="${sessionScope.processed}">
        <c:forEach var="result" items="${results}">
                <c:out value="${result.toString()}"></c:out><br>
        </c:forEach>
    </c:if>
</div>
<div style="margin: auto; width: 50%;">
<fieldset>
    <legend>API Calls</legend>
    <div>
        <p><a href="${pageContext.request.contextPath}/comPosting/servicesV1/"><button>All Services, GET request, plain text</button></a></p>
    </div>
</fieldset>
</div>
<c:set var="processed" value="false" scope="session"></c:set>
</div>
</body>
</html>