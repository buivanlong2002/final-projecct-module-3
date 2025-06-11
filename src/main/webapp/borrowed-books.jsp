<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Danh sách sách đang mượn</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">

<h2 class="mb-4">Danh sách sách đang được mượn</h2>

<table class="table table-bordered">
  <thead>
  <tr>
    <th>Mã phiếu</th>
    <th>Tên sách</th>
    <th>Tác giả</th>
    <th>Học sinh</th>
    <th>Lớp</th>
    <th>Ngày mượn</th>
    <th>Ngày trả dự kiến</th>
    <th>Thao tác</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="card" items="${borrowCards}">
    <tr>
      <td>${card.id}</td>
      <td>${card.book.title}</td>
      <td>${card.book.author}</td>
      <td>${card.student.name}</td>
      <td>${card.student.studentClass}</td>
      <td>${card.borrowDate}</td>
      <td>${card.returnDate}</td>
      <td>
        <form method="post" action="return" onsubmit="return confirm('Xác nhận học sinh ${card.student.name} trả sách ${card.book.title}?')">
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
