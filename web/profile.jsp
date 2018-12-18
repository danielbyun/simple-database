<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${sessionScope.sessionId == null}">
    <script>
        alert("please log in to view this page!");
    </script>
    <c:redirect url="boardList.do"/>
</c:if>
<html>
    <head>
        <title>view my profile</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/profile.css">
        <link rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="css/footer.css">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <main>
            <section>
                <form action="updateProfile.mo" id="updateForm">
                    <span id="errorMsg">error</span>
                    <ul>
                        <li><h1>${member.userId}'s profile</h1></li>
                        <li>
                            <input type="hidden" name="memberId" id="memberId" value="${member.id}">
                            <input type="text" name="userId" id="userId" placeholder="${member.userId}">
                            <input type="button" value="check id" id="checkId">
                            <input type="hidden" name="idCheckOk" id="idCheckOk" value="idNotChecked">
                        </li>
                        <li>
                            <input type="email" name="userEmail" id="userEmail" placeholder="${member.userEmail}">
                        </li>
                        <li>
                            <input type="password" name="userPw" id="userPw" placeholder="********" onkeyup="checkPwFunc()">
                            <input type="password" name="userPwCheck" id="userPwCheck" placeholder="********" onkeyup="checkPwFunc()">
                        </li>
                        <li><input type="button" value="click here to update your profile" id="updateBtn"></li>
                        <li><input type="button" value="click here to delete your profile" id="deleteRedirect"></li>
                    </ul>
                </form>
            </section>
        </main>
        <jsp:include page="footer.jsp"/>
        <script src="js/update.js"></script>
    </body>
</html>