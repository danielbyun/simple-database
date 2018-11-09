<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equipv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <main>
            <section>
                <form action="login.mo" method="post" name="loginForm" id="loginForm">
                    <ul>
                        <li><h1>login</h1></li>
                        <li><input type="text" name="userId" id="userId" placeholder="your id"></li>
                        <li><input type="text" name="userPw" id="userPw" placeholder="********"></li>
                        <li><input type="button" value="login" id="loginBtn"></li>
                    </ul>
                </form>
            </section>
        </main>
        <jsp:include page="footer.jsp"/>
    </body>
</html>