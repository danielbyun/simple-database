<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="css/header.css">
<header>
    <nav>
        <ul>
            <!-- if else statement using JSTL -->
            <c:choose>
                <c:when test="${sessionScope.sessionId != null}">
                    <li><a href="boardList.bo"><img src="img/spongebob%20face.jpg" alt="logo"></a></li>
                    <li><a href="boardList.bo">view posts</a></li>
                    <li><a href="boardWrite.jsp">write a post</a></li>
                    <li>
                        <div class="dropdown">
                            <span><a>${sessionScope.member.userId}</a></span>
                            <div class="dropdownContent">
                                <a href="viewProfile.mo?memberId=${sessionScope.member.id}">my profile</a>
                                <input type="text" hidden value="${sessionScope.memberId}" id="memberIdHeader">
                                <a href="logout.mo">logout</a>
                            </div>
                        </div>
                    </li>
                </c:when>
                <c:otherwise>
                    <li><a href="boardList.bo"><img src="img/spongebob%20face.jpg" alt="logo"></a></li>
                    <li><a href="boardList.bo">view posts</a></li>
                    <li><a href="join.do">sign up</a></li>
                    <li><a href="login.do">login</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </nav>
</header>