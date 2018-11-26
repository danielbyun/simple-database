<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/core" %>

<link rel="stylesheet" href="css/footer.css">
<footer>
    <section>
        <jsp:useBean id="current" class="java.util.Date"/>
        <small>daniel byun &copy; ${(current.year) + 1900}</small>
    </section>
</footer>