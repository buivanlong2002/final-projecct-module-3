<%--
  Created by IntelliJ IDEA.
  User: LONGBV
  Date: 11/06/2025
  Time: 9:25 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Mượn sách</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
<h2 class="mb-4">Mượn sách</h2>
<form method="post" action="borrow">
    <div class="mb-3">
        <label for="borrowId" class="form-label">Mã mượn sách</label>
        <input type="text" name="borrowId" id="borrowId" class="form-control" required placeholder="MS-0001">
    </div>
    <div class="mb-3">
        <label class="form-label">Tên sách</label>
        <input type="text" class="form-control" value="${book.name}" readonly>
        <input type="hidden" name="bookId" value="${book.id}">
    </div>
    <div class="mb-3">
        <label class="form-label">Tên học sinh</label>
        <select name="studentId" class="form-select" required>
            <c:forEach var="student" items="${students}">
                <option value="${student.id}">${student.fullName} - ${student.className}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">Ngày mượn</label>
        <input type="text" name="borrowDate" class="form-control" value="${currentDate}" readonly>
    </div>
    <div class="mb-3">
        <label class="form-label">Ngày trả</label>
        <input type="text" name="returnDate" class="form-control" placeholder="dd/MM/yyyy" required>
    </div>
    <button type="submit" class="btn btn-success">Mượn sách</button>
    <a href="books" class="btn btn-secondary">Trở về danh sách</a>
</form>
</body>
</html>
