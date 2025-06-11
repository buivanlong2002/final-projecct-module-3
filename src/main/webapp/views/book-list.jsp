<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách sách</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
<h2 class="mb-4">Danh sách sách trong thư viện</h2>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>Mã sách</th>
        <th>Tên sách</th>
        <th>Tác giả</th>
        <th>Số lượng</th>
        <th>Mô tả</th>
        <th>Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.quantity}</td>
            <td>${book.description}</td>
            <td>
                <a href="borrow?bookId=${book.id}" class="btn btn-primary btn-sm">Mượn</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="return" class="btn btn-success">Thống kê sách đang cho mượn</a>
</body>
</html>
