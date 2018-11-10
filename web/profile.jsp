<%@ page import="org.web.memberDTO.MemberDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberDTO member = (MemberDTO)request.getAttribute("member");
%>
<html>
    <head>
        <title>view my profile</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equipv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/profile.css">
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <main>
            <section>
                <ul>
                    <li>
                        <input type="text" name="userId" id="userId" value="">
                    </li>
                    <li>
                        <input type="password" name="userPw" id="userPw" placeholder="*****">
                        <input type="password" name="userPwCheck" id="userPwCheck" placeholder="*****">
                    </li>
                    <li>
                        <input type="email" name="userEmail" id="userEmail">
                    </li>
                    <li><a href="updateProfile.mo">update</a></li>
                    <li><a href="deleteProfile.do">delete</a></li>
                </ul>
            </section>
        </main>
        <jsp:include page="footer.jsp" />
    </body>
</html>