<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>simple database</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/join.css">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <main>
            <section>
                <form action="join.mo" method="post" name="joinForm" id="joinForm">
                    <span id="errorMsg">error</span>
                    <ul>
                        <li>
                            <input type="text" name="userId" id="userId" placeholder="your id">
                            <input type="hidden" name="idCheckOk" id="idCheckOk" value="idNotChecked">
                            <input type="button" value="check id" id="checkId">
                        </li>
                        <li>
                            <input type="password" name="userPw" id="userPw" placeholder="*****" onkeyup="checkPwFunc()">
                            <input type="password" name="userPwCheck" id="userPwCheck" placeholder="*****" onkeyup="checkPwFunc()">
                        </li>
                        <li>
                            <input type="email" name="userEmail" id="userEmail" placeholder="your email">
                        </li>
                        <li>
                            <input type="button" value="join" id="joinBtn">
                        </li>
                    </ul>
                </form>
            </section>
        </main>
        <jsp:include page="footer.jsp"/>
        <script src="js/join.js"></script>
    </body>
</html>
