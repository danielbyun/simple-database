<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>board list</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/boardList.css">
        <link rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="css/footer.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <main>
            <section class="boardList">
                <div class="boards">
                    <p style="color: white; text-align: center;">sorted by most clicked</p>
                    <c:forEach var="list" items="${lists}">
                        <c:choose>
                            <c:when test="${list.indent == 0}">
                                <div class="boardWrap">
                                    <input type="text" name="indent" id="indent" hidden value="${list.indent}">
                                    <input type="text" name="mGroup" class="mGroup" hidden value="${list.mGroup}">
                                    <input type="text" name="content" id="content" hidden value="${list.content}">
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
                                            <p class="content">
                                                    ${list.content}
                                            </p>
                                            <div class="social">
                                                <a href="#" class="replyBtn">
                                                    <i class="fas fa-comment-alt"></i>
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
                                                <a href="#" class="tweetBtn">
                                                    <i class="fab fa-twitter"></i>
                                                    tweet
                                                </a>
                                                <a href="" class="favoriteBtn">
                                                    <i class="fas fa-star"></i>
                                                    favorite
                                                </a>
                                                <c:if test="${sessionScope.sessionId.equals(list.userName)}">
                                                    <a href="#" class="editBtn">
                                                        <i class="fas fa-pen-square"></i>
                                                        edit
                                                    </a>
                                                </c:if>
                                            </div>
                                        </div>
                                        <div class="reply">
                                            <textarea name="replyBoard" id="replyBoard" cols="30" rows="10" placeholder="what are your thoughts?"></textarea>
                                            <input type="button" value="CANCEL" class="cancelBtn">
                                            <input type="button" value="REPLY" id="replySubmit">
                                        </div>
                                        <div class="editArea">
                                            <textarea name="editContent" id="editContent" cols="30" rows="10" placeholder="${list.content}"></textarea>
                                            <input type="button" value="CANCEL" class="cancelBtnEdit">
                                            <input type="button" value="EDIT" id="editSubmit">
                                        </div>
                                    </a>
                                </div>
                            </c:when>
                        </c:choose>
                    </c:forEach>
                </div>
                <div class="page-load-status">
                    <div class="loader-ellips infinite-scroll-request">
                        <span class="loader-ellips__dot"></span>
                        <span class="loader-ellips__dot"></span>
                        <span class="loader-ellips__dot"></span>
                        <span class="loader-ellips__dot"></span>
                    </div>
                    <p class="infinite-scroll-last">End of content</p>
                    <p class="infinite-scroll-error">No more pages to load</p>
                </div>
            </section>
        </main>
        <jsp:include page="footer.jsp"/>
        <script src="js/index.js"></script>
    </body>
</html>