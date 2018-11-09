<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="css/header.css">
<header>
    <section>
        <h1>da most basic reddit clone ever</h1>
    </section>
    <nav>
        <ul>
            <li><a href="boardList.do">VIEW POSTS</a></li>
            <%
                // logged in
                if (session.getAttribute("sessionId") != null) {
            %>
            <li><a href="boardWrite.bo">WRITE</a></li>
            <li><a href="memberEdit.do"><%= session.getAttribute("sessionId") %></a></li>
            <%
                // not logged in
            } else {
            %>
            <li><a href="join.do">SIGN UP</a></li>
            <li><a href="login.do">LOGIN</a></li>
            <%
                }
            %>
        </ul>
    </nav>
</header>