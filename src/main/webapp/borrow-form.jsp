<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Phiếu mượn sách</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
<h2 class="mb-4">Phiếu mượn sách</h2>

<form method="post" action="borrow">
    <div class="mb-3">
        <label for="borrowId" class="form-label">Mã phiếu mượn</label>
        <input type="text" name="borrowId" id="borrowId" class="form-control" required placeholder="br001">
    </div>

    <div class="mb-3">
        <label class="form-label">Tên sách</label>
        <input type="text" class="form-control" value="${book.title}" readonly>
        <input type="hidden" name="bookId" value="${book.id}">
    </div>

    <div class="mb-3">
        <label class="form-label">Chọn học sinh</label>
        <select name="studentId" class="form-select" required>
            <c:forEach var="student" items="${students}">
                <option value="${student.id}">${student.name} - Lớp ${student.studentClass}</option>
            </c:forEach>
        </select>
    </div>

    <div class="mb-3">
        <label class="form-label">Ngày mượn</label>
        <input type="text" name="borrowDate" class="form-control" value="${currentDate}" readonly>
    </div>

    <div class="mb-3">
        <label class="form-label">Ngày trả dự kiến</label>
        <input type="date" name="returnDate" class="form-control" required>
    </div>

    <button type="submit" class="btn btn-success">Xác nhận mượn</button>
    <a href="books" class="btn btn-secondary">Trở về danh sách</a>
</form>

</body>
</html>
