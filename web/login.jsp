<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/login.css">
        <link rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="css/footer.css">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <main>
            <section>
                <form action="login.mo" method="post" name="loginForm" id="loginForm">
                    <span id="errorMsg">error</span>
                    <ul>
                        <li><h1>login</h1></li>
                        <li><input type="text" name="userId" id="userId" placeholder="your id"></li>
                        <li><input type="password" name="userPw" id="userPw" placeholder="*****"></li>
                        <li><input type="button" value="login" id="loginBtn"></li>
                    </ul>
                </form>
            </section>
        </main>
        <jsp:include page="footer.jsp"/>
        <script src="js/login.js"></script>
    </body>
</html>