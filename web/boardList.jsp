<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>board list</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/boardList.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    </head>
    <body>
        <script>
            window.onload = function () {
                /*    detect scroll    */
                window.onscroll = function (ev) {
                    if ((window.innerHeight + Math.ceil(window.pageYOffset + 1)) >= document.body.offsetHeight) {
                        alert("youre at the end bruh");
                    }
                };
            };
        </script>
        <jsp:include page="header.jsp"/>
        <main>
            <section class="boardList">
                <div class="boards">
                    <p style="color: white">sorted by original posts</p>
                    <c:forEach var="list" items="${lists}">
                        <c:choose>
                            <%-- just show original posts not the replies --%>
                            <c:when test="${list.indent == 0}">
                                <div class="boardWrap"><a href="<c:url value="boardView.bo?mId=${list.mId}"/>">
                                    <input type="text" name="indent" id="indent" hidden value="${list.indent}">
                                    <input type="text" name="mGroup" class="mGroup" hidden value="${list.mGroup}">
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
                                        <div class="social">
                                            <a href=""><i class="fas fa-comment-alt"></i>
                                                <c:choose>
                                                    <c:when test="${list.indent > 0}">
                                                        <c:choose>
                                                            <c:when test="${list.indent == 1}">
                                                                comment
                                                            </c:when>
                                                            <c:otherwise>
                                                                comments
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:when>
                                                    <c:otherwise>
                                                        comment
                                                    </c:otherwise>
                                                </c:choose>
                                            </a>
                                            <a href=""><i class="fab fa-twitter"></i>
                                                tweet
                                                <c:forEach begin="0" end="${list.mGroup-1}">
                                                </c:forEach>
                                            </a>
                                            <a href=""><i class="fas fa-star"></i>favorite</a>
                                            <c:if test="${sessionScope.sessionId.equals(list.userName)}">
                                                <a href="#" id="edit"><i class="fas fa-pen-square"></i>edit</a>
                                            </c:if>
                                        </div>
                                    </div>
                                </a>
                                </div>
                            </c:when>
                        </c:choose>
                    </c:forEach>
                </div>
            </section>
        </main>
        <jsp:include page="footer.jsp"/>
        <script src="js/index.js"></script>
    </body>
</html>