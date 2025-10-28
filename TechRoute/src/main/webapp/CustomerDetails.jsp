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
        <c:forEach var="customer" items="${listOfCustomer}">
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
<!--                        <a href="viewCustomer?customerId={customer.id}" class="btn btn-outline-primary btn-sm">View</a>-->
                        <a href="updateCustomer?id=${customer.id}" class="btn btn-outline-warning btn-sm">Update</a>
                        <a href="deleteCustomer?id=${customer.id}" class="btn btn-outline-danger btn-sm"
                           onclick="return confirm('Are you sure you want to delete this customer?')">Delete</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <!-- Pagination Controls -->
    <nav class="mt-4">
        <div class="pagination-wrapper">

            <!-- Pagination Info -->
            <div class="pagination-info">
                Viewing ${startIndex}–${endIndex} of ${totalCustomers} customers
            </div>

            <!-- Pagination Controls -->
            <ul class="custom-pagination">
                <c:if test="${currentPage > 1}">
                    <li><a class="prev" href="viewCustomerPage?page=${currentPage - 1}&size=10">&laquo;</a></li>
                </c:if>

                <c:forEach var="i" begin="1" end="${totalPages}">
                    <c:choose>
                        <c:when test="${i == currentPage}">
                            <li><span class="current">${i}</span></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="viewCustomerPage?page=${i}&size=10">${i}</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:if test="${currentPage < totalPages}">
                    <li><a class="next" href="viewCustomerPage?page=${currentPage + 1}&size=10">&raquo;</a></li>
                </c:if>
            </ul>

            <div class="pagination-info">
                Page ${currentPage} of ${totalPages}
                </div>
        </div>
    </nav>
</div>
</body>
</html>