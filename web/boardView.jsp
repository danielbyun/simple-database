<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>board view</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/boardView.css">
        <link rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="css/footer.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <main>
            <section class="boardView">
                <div class="boards">
                    <div class="board" style="position: relative; left: ${list.indent}rem">
                        <jsp:useBean id="current" class="java.util.Date"/>
                        <div class="post">
                            <div class="attr">
                                <input type="text" name="mId" id="mId" hidden value="${list.mId}">
                                <input type="text" name="mGroup" id="mGroup" hidden value="${list.mGroup}">
                                <input type="text" name="step" id="step" hidden value="${list.step}">
                                <input type="text" name="indent" id="indent" hidden value="${list.indent}">
                                <input type="text" name="userId" id="userId" hidden value="${sessionScope.member.userId}">
                                <input type="text" name="title" id="title" hidden value="${list.title}">
                                <input type="text" name="content" id="content" hidden value="${list.content}">
                            </div>
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
                            <c:choose>
                                <c:when test="${list.indent > 0}">
                                    <c:choose>
                                        <c:when test="${list.indent == 1}">
                                            ${list.indent} comment
                                        </c:when>
                                        <c:otherwise>
                                            ${list.indent} comments
                                        </c:otherwise>
                                    </c:choose>
                                </c:when>
                            </c:choose>
                            <div class="editArea">
                                <textarea name="editContent" id="editContent" cols="30" rows="10" placeholder="${list.content}"></textarea>
                                <input type="button" value="CANCEL" id="cancelBtn">
                                <input type="button" value="EDIT" id="editBtn">
                            </div>
                        </div>
                        <c:choose>
                            <c:when test="${sessionScope.sessionId != null}">
                                <ul class="commentPrompt">
                                    <li>
                                        <a href=""><i class="fas fa-comment-alt"></i>comments</a>
                                        <a href=""><i class="fas fa-star"></i>favorite</a>
                                        <a href=""><i class="fab fa-twitter"></i>tweet</a>
                                        <c:if test="${sessionScope.sessionId.equals(list.userName)}">
                                            <a href="#" id="edit"><i class="fas fa-pen-square"></i>edit</a>
                                        </c:if>
                                    </li>
                                </ul>
                                <ul class="reply">
                                    <li>
                                        <textarea name="reply" class="reply" cols="30" rows="10" placeholder="what are your thoughts?"></textarea>
                                        <input type="button" value="COMMENT" class="replyBtn">
                                    </li>
                                </ul>
                            </c:when>
                            <c:otherwise>
                                <ul class="signUpPrompt">
                                    <li>
                                        <p>What are your thoughts? Log in or Sign up</p>
                                    </li>
                                    <li>
                                        <a href="login.do">LOG IN</a>
                                        <a href="join.do">SIGN UP</a>
                                    </li>
                                </ul>
                            </c:otherwise>
                        </c:choose>
                    </div>

                    <c:forEach var="lists" items="${lists}" varStatus="loop">
                        <c:if test="${list.mGroup == lists.mGroup && not loop.first && lists.step > 0}">
                            <section class="replyBoard" style="margin-left: ${lists.indent * 2}rem">
                                <div class="post">
                                    <small>
                                        posted by ${lists.userName}
                                        on ${lists.date.toLocaleString()}
                                    </small>
                                    <h1>
                                            ${lists.title}
                                    </h1>
                                    <p class="content">
                                            ${lists.content}
                                    </p>
                                </div>
                                <ul class="commentPrompt">
                                    <li>
                                        <a href=""><i class="fas fa-comment-alt"></i>reply</a>
                                        <c:if test="${sessionScope.sessionId.equals(list.userName)}">
                                            <a href="#" id="edit"><i class="fas fa-pen-square"></i>edit</a>
                                        </c:if>
                                    </li>
                                </ul>
                                <ul class="reply">
                                    <li>
                                        <textarea name="reply" class="reply" cols="30" rows="10" placeholder="what are your thoughts?"></textarea>
                                        <input type="button" value="COMMENT" class="replyBtn">
                                    </li>
                                </ul>
                            </section>
                        </c:if>
                    </c:forEach>
                </div>
            </section>
        </main>
        <jsp:include page="footer.jsp"/>
        <script src="js/boardReply.js"></script>
    </body>
</html>