<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<h2>Com.Posting API</h2>

<form action="search">
    <div>
        <label for="searchTable">Choose a table to search:</label>
        <select name="tables" id="searchTable">
            <option value="period">Period</option>
            <option value="material">Material</option>
            <option value="service">Service</option>
            <option value="price">Price</option>
        </select>

        <label for="searchItem">Search Table:</label>
        <input type="text" id="searchItem" name="searchItem" >

    </div>
    <button type="submit" name="submit" value="search">Search</button>
    <button type="submit" name="submit" value="viewAll">View All</button>
</form>
<div id="resultsBox">
    <c:forEach var="result" items="results">
        <c:out value="${result.toString()}<br>"></c:out>
    </c:forEach>
</div>
</body>
</html>