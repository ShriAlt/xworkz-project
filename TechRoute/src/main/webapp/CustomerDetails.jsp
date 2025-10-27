<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Customer Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-4">Customer List</h2>
    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
        <c:forEach var="customer" items="${customerList}">
            <div class="col">
                <div class="card h-100 shadow-sm">
                    <div class="card-body">
                        <h5 class="card-title">${customer.customerName}</h5>
                        <p class="card-text">
                            <strong>Email:</strong> ${customer.email}<br>
                            <strong>Contact:</strong> ${customer.contact}
                        </p>
                    </div>
                    <div class="card-footer d-flex justify-content-between">
                        <a href="${pageContext.request.contextPath}/customer/view/${customer.id}" class="btn btn-outline-primary btn-sm">View</a>
                        <a href="${pageContext.request.contextPath}/customer/edit/${customer.id}" class="btn btn-outline-warning btn-sm">Update</a>
                        <a href="${pageContext.request.contextPath}/customer/delete/${customer.id}" class="btn btn-outline-danger btn-sm"
                           onclick="return confirm('Are you sure you want to delete this customer?')">Delete</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <!-- Pagination Controls -->
    <nav class="mt-4">
        <ul class="pagination justify-content-center">
            <c:if test="${currentPage > 0}">
                <li class="page-item">
                    <a class="page-link" href="?page=${currentPage - 1}">Previous</a>
                </li>
            </c:if>
            <c:forEach var="i" begin="0" end="${totalPages - 1}">
                <li class="page-item ${i == currentPage ? 'active' : ''}">
                    <a class="page-link" href="?page=${i}">${i + 1}</a>
                </li>
            </c:forEach>
            <c:if test="${currentPage < totalPages - 1}">
                <li class="page-item">
                    <a class="page-link" href="?page=${currentPage + 1}">Next</a>
                </li>
            </c:if>
        </ul>
    </nav>
</div>
</body>
</html>