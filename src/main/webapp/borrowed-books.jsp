<%--
  Created by IntelliJ IDEA.
  User: LONGBV
  Date: 11/06/2025
  Time: 9:26 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Thống kê sách đang cho mượn</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
<h2 class="mb-4">Thống kê sách đang cho mượn</h2>

<form method="get" action="return" class="mb-4">
  <input type="text" name="keyword" class="form-control w-50 d-inline" placeholder="Tìm theo tên sách hoặc tên học sinh">
  <button type="submit" class="btn btn-primary">Tìm kiếm</button>
</form>

<table class="table table-bordered">
  <thead>
  <tr>
    <th>Mã mượn</th>
    <th>Tên sách</th>
    <th>Tác giả</th>
    <th>Học sinh</th>
    <th>Lớp</th>
    <th>Ngày mượn</th>
    <th>Ngày trả</th>
    <th>Thao tác</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="card" items="${cards}">
    <tr>
      <td>${card.id}</td>
      <td>${card.book.name}</td>
      <td>${card.book.author}</td>
      <td>${card.student.fullName}</td>
      <td>${card.student.className}</td>
      <td>${card.borrowDate}</td>
      <td>${card.returnDate}</td>
      <td>
        <form method="post" action="return" onsubmit="return confirm('Xác nhận học sinh ${card.student.fullName} trả sách ${card.book.name}?')">
          <input type="hidden" name="borrowId" value="${card.id}">
          <input type="hidden" name="bookId" value="${card.book.id}">
          <button type="submit" class="btn btn-danger btn-sm">Trả sách</button>
        </form>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<a href="books" class="btn btn-secondary">Trở về danh sách sách</a>
</body>
</html>

