<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>board list</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/boardList.css">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <main>
            <section class="boardList">
                <div class="boards">
                    <c:forEach var="list" items="${lists}">
                        <a href="<c:url value="boardView.bo?mId=${list.mId}"/>">
                            <div class="board">
                                <jsp:useBean id="current" class="java.util.Date"/>
                                <small>
                                    posted by ${list.userName}
                                    on ${list.date.toLocaleString()}
                                </small>
                                <h1>
                                        ${list.title}
                                </h1>
                                <p>
                                        ${list.content}
                                </p>
                            </div>
                        </a>
                    </c:forEach>
                </div>
            </section>
        </main>
        <jsp:include page="footer.jsp"/>
    </body>
</html>