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
        <title> update profile</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/updateProfile.css">
        <link rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="css/footer.css">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <main>
            <section>
                <form action="updateProfile.mo" method="post">
                    <span id="errorMsg">error</span>
                    <ul>
                        <li>
                            <input type="text" name="userId" id="userId" placeholder="your new id">
                            <input type="hidden" name="" id=memberId" value="${member.memberId}">
                            <input type="hidden" name="" value="${member.userId}">
                            <input type="hidden" name="idCheckOk" id="idCheckOk" value="idNotChecked">
                            <input type="button" value="check id" id="checkId">
                        </li>
                        <li>
                            <input type="email" name="userEmail" id="userEmail" placeholder="your new email">
                        </li>
                        <li>
                            <input type="password" name="userPw" id="userPw" placeholder="*****" onkeyup="checkPwFunc()">
                            <input type="password" name="userPwCheck" id="userPwCheck" placeholder="*****" onkeyup="checkPwFunc()">
                        </li>
                        <li>
                            <input type="button" value="update" id="updateBtn">
                        </li>
                    </ul>
                </form>
            </section>
        </main>
        <script src="js/update.js"></script>
        <jsp:include page="footer.jsp"/>
    </body>
</html>