<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:choose>
    <c:when test="${sessionScope.sessionId == null}">
        <script>
            alert("please log in to view this page!");
        </script>
        <c:redirect url="index.jsp"/>
    </c:when>
</c:choose>
<html>
    <head>
        <title>delete page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/deleteProfile.css">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <main>
            <section>
                <form action="deleteProfile.mo" method="post" id="deleteForm">
                    <span id="errorMsg"></span>
                    <ul>
                        <h1>delete your profile</h1>
                        <li>
                            <input type="text" name="userId" id="userId" placeholder="your id">
                        </li>
                        <li>
                            <input type="password" name="userPw" id="userPw" placeholder="your password">
                        </li>
                        <li>
                            <input type="button" value="delete" id="deleteBtn">
                        </li>
                    </ul>
                </form>
            </section>
        </main>
        <jsp:include page="footer.jsp"/>
        <script src="js/delete.js"></script>
    </body>
</html>