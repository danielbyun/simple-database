<%@ page import="org.web.memberDTO.MemberDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberDTO member = (MemberDTO) request.getAttribute("member");
    if (session.getAttribute("sessionId") == null) {
%>
<script>
    alert("please log in to view this page!");
</script>
<%
    response.sendRedirect("boardList.do");
} else {
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
        <jsp:include page="header.jsp"/>
        <main>
            <section>
                <ul>
                    <h1>your profile</h1>
                    <li>
                        <input type="text" name="userId" id="userId" value="<%= member.getUserId() %>" disabled>
                    </li>
                    <li>
                        <input type="email" name="userEmail" id="userEmail" value="<%= member.getUserEmail() %>" disabled>
                    </li>
                    <li>
                        <input type="text" name="userPw" id="userPw" value="click here to reveal" readonly>
                    </li>
                    <li><a href="updateProfile.do">click here to update your profile</a></li>
                    <li><a href="deleteProfile.do">click here to delete your profile</a></li>
                </ul>
            </section>
        </main>
        <jsp:include page="footer.jsp"/>
        <script>
            let userPwToggle = document.getElementById("userPw");
            userPwToggle.addEventListener("click", showPassword);

            function showPassword() {
                if (userPwToggle.value = "click here to reveal") {
                    userPwToggle.value = <%= member.getUserPw() %>;
                } else {
                    userPwToggle.value = "click here to reveal";
                }
            }
        </script>
    </body>
</html>
<%
    }
%>