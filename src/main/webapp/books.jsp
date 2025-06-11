<%--
  Created by IntelliJ IDEA.
  User: LONGBV
  Date: 11/06/2025
  Time: 9:50 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Danh sách sách</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
<h2 class="mb-4">Danh sách sách trong thư viện</h2>

<table class="table table-bordered table-striped">
  <thead class="table-dark">
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
      <td>${book.title}</td>
      <td>${book.author}</td>
      <td>${book.quantity}</td>
      <td>${book.description}</td>
      <td>
        <form action="borrow" method="get">
          <input type="hidden" name="bookId" value="${book.id}" />
          <button type="submit" class="btn btn-primary btn-sm" ${book.quantity == 0 ? 'disabled' : ''}>Mượn</button>
        </form>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<a href="borrow-cards" class="btn btn-success mt-3">Xem danh sách phiếu mượn</a>

</body>
</html>

