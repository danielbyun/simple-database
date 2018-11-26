<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>board write</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/boardWrite.css">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <main>
            <section class="writeSection">
                <h1>
                    Create a post
                </h1>
                <form action="boardWrite.bo" method="post" id="writeForm">
                    <ul>
                        <li>
                            <span class="errorMsg"></span>
                        </li>
                        <li>
                            <input type="text" name="userId" id="userId" value="${sessionScope.member.userId}" hidden placeholder="${sessionScope.member.userId}">
                        </li>
                        <li>
                            <input type="text" name="title" id="title" placeholder="title">
                        </li>
                        <li>
                            <textarea name="content" id="content" cols="30" rows="9" placeholder="text"></textarea>
                        </li>
                        <li>
                            <input type="button" value="POST" id="writeBtn" disabled>
                        </li>
                    </ul>
                </form>
            </section>
        </main>
        <script src="js/boardWrite.js"></script>
        <jsp:include page="footer.jsp"/>
    </body>
</html>