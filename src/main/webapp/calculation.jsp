<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculation</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/calc" method="post">
    <label>
        <input type="text" placeholder="Введите число а" name="a">
    </label>

    <label>
        <select name="title">
            <option value="add">+</option>
            <option value="sub">-</option>
            <option value="multi">*</option>
            <option value="div">:</option>
        </select>
    </label>

    <label>
        <input type="text" placeholder="Введите число b" name="b">
    </label>
    <button type="submit">Calculation</button>
</form>

<div>
    <p>
    <ul>
        <%
            List<String> history = (ArrayList<String>) request.getSession().getAttribute("history");
            for (String str: history)
                response.getWriter().println("<li>" + str + "</li>");
        %>
    </ul>
    </p>
</div>

</body>
</html>
