<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <style>
        /* ===== Global Theme ===== */
        body {
          background: #0f172a;
          color: #e2e8f0;
          height: 100vh;
          margin: 0;
          display: flex;
          flex-direction: column;
          font-family: 'Poppins', sans-serif;
        }
        h1 {
          font-weight: 700;
          color: #38bdf8;
        }

        p {
          color: #cbd5e1;
        }

        /* ===== Navbar ===== */
        .navbar {
          background: rgba(15, 23, 42, 0.95);
          border-bottom: 1px solid rgba(56, 189, 248, 0.2);
        }

        .navbar-brand strong {
          font-size: 1.4rem;
          color: #38bdf8;
        }

        .navbar-brand img {
          height: 40px;
          margin-right: 8px;
          border-radius: 6px;
        }

        .nav-link {
          color: #e2e8f0 !important;
          transition: color 0.3s ease;
        }

        .nav-link:hover {
          color: #38bdf8 !important;
        }

        /* ===== Admin Badge / Dropdown ===== */
        .admin-badge {
          color: #38bdf8;
          font-weight: 600;
          margin-left: auto;
          margin-right: 1rem;
          display: flex;
          align-items: center;
        }

        .admin-badge i {
          margin-right: 6px;
        }
        /* ===== Content ===== */
        .content {
          flex: 1;
          display: flex;
          align-items: center;
          justify-content: center;
          text-align: center;
          padding: 60px 20px;
        }
        /* ===== Pagination Wrapper ===== */
.pagination-wrapper {
  background-color: #1e293b;
  padding: 1rem;
  border: 1px solid rgba(56, 189, 248, 0.2);
  border-radius: 8px;
  box-shadow: 0 0 8px rgba(56, 189, 248, 0.1);
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 0.5rem;
}

/* ===== Pagination Info Text ===== */
.pagination-info {
  color: #94a3b8;
  font-size: 0.95rem;
  font-weight: 500;
}

/* ===== Custom Pagination Controls ===== */
.custom-pagination {
  list-style: none;
  display: flex;
  gap: 0.5rem;
  padding: 0;
  margin: 0;
}

.custom-pagination li {
  display: inline-block;
}

.custom-pagination a,
.custom-pagination .current {
  display: inline-block;
  padding: 6px 12px;
  border-radius: 6px;
  font-weight: 500;
  text-decoration: none;
  transition: all 0.3s ease;
}

/* Active Page */
.custom-pagination .current {
  background-color: #38bdf8;
  color: #0f172a;
  border: none;
}

/* Normal Page Links */
.custom-pagination a {
  background-color: #0f172a;
  color: #38bdf8;
  border: 1px solid #334155;
}

.custom-pagination a:hover {
  background-color: #38bdf8;
  color: #0f172a;
  border: none;
}

/* Arrows */
.custom-pagination .prev,
.custom-pagination .next {
  font-weight: bold;
}
        /* ===== Customer Cards ===== */
.card {
  background-color: #1e293b;
  color: #e2e8f0;
  border: 1px solid #334155;
  border-radius: 10px;
  transition: transform 0.3s ease, box-shadow 0.3s ease;
  cursor: pointer;
}

.card:hover {
  transform: translateY(-4px);
  box-shadow: 0 0 12px rgba(56, 189, 248, 0.3);
}

/* ===== Card Title ===== */
.card-title {
  color: #38bdf8;
  font-weight: 600;
  font-size: 1.2rem;
  margin-bottom: 0.5rem;
}

/* ===== Card Text ===== */
.card-text {
  font-size: 0.95rem;
  color: #cbd5e1;
  line-height: 1.5;
}

/* ===== Card Footer ===== */
.card-footer {
  background-color: transparent;
  border-top: 1px solid rgba(56, 189, 248, 0.2);
  font-size: 0.85rem;
  color: #94a3b8;
  text-align: end;
}

/* ===== Buttons Inside Cards ===== */
.card-footer .btn {
  font-size: 0.75rem;
  padding: 4px 10px;
  border-radius: 6px;
}

.btn-outline-warning {
  border-color: #facc15;
  color: #facc15;
}

.btn-outline-warning:hover {
  background-color: #facc15;
  color: #0f172a;
}

.btn-outline-danger {
  border-color: #f87171;
  color: #f87171;
}

.btn-outline-danger:hover {
  background-color: #f87171;
  color: #0f172a;
}
    </style>

</head>
<body>
<nav class="navbar navbar-expand-lg shadow-sm">
    <div class="container">
        <a class="navbar-brand d-flex align-items-center" href="#">
            <img src="images/techroute-logo.png" alt="Logo">
            <strong>TechRoute</strong>
        </a>
        <div class="dropdown ms-auto me-3">
            <span>${dto.firstName}</span>
            <a class="dropdown-toggle text-decoration-none text-light fw-semibold" href="#" role="button" data-bs-toggle="dropdown"
               aria-expanded="false">
                <i class="fas fa-user-shield me-1 text-info"></i> Admin Panel
            </a>
            <ul class="dropdown-menu dropdown-menu-end bg-dark border-info">
                <li>
                    <a class="dropdown-item text-danger" href="adminHome">
                        <i class="fa fa-sign-out-alt me-2"></i> Home
                    </a>
                </li>
                <li>
                    <a class="dropdown-item text-light" href="viewProfilePage">
                        <i class="fa fa-user-circle me-2 text-info"></i> View Profile
                    </a>
                </li>
                <li>
                    <a class="dropdown-item text-light" href="addCustomerPage">
                        <i class="fa fa-user-plus me-2 text-info"></i> Add Customer
                    </a>
                </li>
<!--                <li>-->
<!--                    <a class="dropdown-item text-light" href="viewCustomerPage">-->
<!--                        <i class="fa fa-users me-2 text-info"></i> View Customers-->
<!--                    </a>-->
<!--                </li>-->
                <li><hr class="dropdown-divider border-info"></li>
                <li>
                    <a class="dropdown-item text-danger" href="viewUsers">
                        <i class="fa fa-sign-out-alt me-2"></i> view Users
                    </a>
                </li>
                <li>
                    <a class="dropdown-item text-danger" href="logout">
                        <i class="fa fa-sign-out-alt me-2"></i> Logout
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-4">
    <h2 class="mb-4">Customer List</h2>
    <span class="text-danger">${error}</span>

    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
        <c:forEach var="customer" items="${listOfCustomer}">
            <div class="col">
                <!-- Card with modal trigger -->
                <div class="card h-100 shadow-sm bg-secondary text-light" data-bs-toggle="modal" data-bs-target="#customerModal${customer.id}" style="cursor:pointer;">
                    <div class="card-body">
                        <h5 class="card-title">${customer.customerName}</h5>
                        <p class="card-text">
                            <strong>Email:</strong> ${customer.email}<br>
                            <strong>Contact:</strong> ${customer.contact}<br>
                            <strong>Type:</strong> ${customer.customerType}
                        </p>
                    </div>
                    <div class="card-footer text-end">
                        <small class="text-info">Click for details</small>
                    </div>
                </div>

                <!-- Modal for customer details -->
                <div class="modal fade" id="customerModal${customer.id}" tabindex="-1" aria-labelledby="modalLabel${customer.id}" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-lg">
                        <div class="modal-content bg-dark text-light border-info">
                            <div class="modal-header">
                                <h5 class="modal-title" id="modalLabel${customer.id}">${customer.customerName}</h5>
                                <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <!-- Add your fields here -->
                                <p><strong>Email:</strong> ${customer.email}</p>
                                <p><strong>Contact:</strong> ${customer.contact}</p>
                                <p><strong>Customer Type:</strong> ${customer.customerType}</p>
                                <p><strong>Customer GST:</strong> ${customer.gst}</p>
                                <p><strong>Customer Country:</strong> ${customer.country}</p>
                                <p><strong>Customer State:</strong> ${customer.state}</p>
                                <p><strong>Customer city:</strong> ${customer.city}</p>
                                <p><strong>Customer pinCode:</strong> ${customer.pinCode}</p>
                                <p><strong>Customer address:</strong> ${customer.address}</p>
                                <p><strong>Customer billingAddress:</strong> ${customer.billingAddress}</p>
                                <p><strong>Customer shippingAddress:</strong> ${customer.shippingAddress}</p>
                                <p><strong>Customer paymentMode:</strong> ${customer.paymentMode}</p>
                            </div>
                            <div class="modal-footer">
                                <a href="updateCustomerPage?id=${customer.id}" class="btn btn-outline-warning btn-sm">Update</a>
                                <a href="deleteCustomer?id=${customer.id}" class="btn btn-outline-danger btn-sm"
                                   onclick="return confirm('Are you sure you want to delete this customer?')">Delete</a>
                                <button type="button" class="btn btn-outline-info" data-bs-dismiss="modal">Close</button>
                            </div>
                        </div>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>