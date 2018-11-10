<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="css/header.css">
<header>
    <section class="s1">
        <h1>reddit clone.. kinda</h1>
    </section>
    <nav>
        <ul>
            <li><a href="boardList.do">view posts</a></li>
            <%
                // logged in
                if (session.getAttribute("sessionId") != null) {
            %>
            <li><a href="boardWrite.bo">write a post</a></li>
            <li>
                <div class="dropdown">
                    <span><a href="memberView.do"> <%= session.getAttribute("sessionId") %></a></span>
                    <div class="dropdownContent">
                        <a href="profile.do">my profile</a>
                        <a href="logout.mo">logout</a>
                    </div>
                </div>
            </li>
            <%
                // not logged in
            } else {
            %>
            <li><a href="join.do">sign up</a></li>
            <li><a href="login.do">login</a></li>
            <%
                }
            %>
        </ul>
    </nav>
</header>