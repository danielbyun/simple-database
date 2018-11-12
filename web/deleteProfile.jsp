<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // if no one is logged in
    if (session.getAttribute("sessionId") == null) {
%>
<script>
    alert("please log in to view this page!");
    location.href = "/index.jsp";
</script>
<%
} else {
%>
<html>
    <head>
        <title>delete page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equipv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/deleteProfile.css">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <main>
            <section>
                <form action="deleteProfile.mo" method="post" id="deleteForm">
                    <span id="errorMsg"></span>
                    <ul>
                        <h1>delete your profile</h1>
                        <li>
                            <input type="text" name="userId" id="userId" placeholder="your id">
                        </li>
                        <li>
                            <input type="password" name="userPw" id="userPw" placeholder="your password">
                        </li>
                        <li>
                            <input type="button" value="delete" id="deleteBtn">
                        </li>
                    </ul>
                </form>
            </section>
        </main>
        <jsp:include page="footer.jsp"/>
        <script src="js/delete.js"></script>
    </body>
</html>
<%
    }
%>