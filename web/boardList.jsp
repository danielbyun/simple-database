<%@ page import="org.web.boardDTO.BoardDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<BoardDTO> lists = (ArrayList<BoardDTO>) request.getAttribute("lists");
%>
<html>
    <head>
        <title>board list</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equipv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/boardList.css">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <main>
            <section>
                <h1>yoyoyoy</h1><br><br><br><br><br><br>
                <h1>yoyoyoy</h1><br><br><br><br><br><br>
                <h1>yoyoyoy</h1><br><br><br><br><br><br>
                <h1>yoyoyoy</h1><br><br><br><br><br><br>
                <h1>yoyoyoy</h1><br><br><br><br><br><br>
                <h1>yoyoyoy</h1><br><br><br><br><br><br>
                <%
                    for (BoardDTO dto : lists) {
                %>
                <%=
                dto.getContent()
                %>
                <%
                    }
                %>
            </section>
        </main>
        <jsp:include page="footer.jsp"/>
    </body>
</html>