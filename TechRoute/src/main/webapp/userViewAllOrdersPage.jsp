<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TechRoute</title>
    <!-- Favicon -->
    <link rel="icon" type="image/png" href="images/techroute-logo.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

    <style>
        /* ===== Global Styles ===== */
        body {
          background: #0f172a; /* deep navy instead of heavy gradient */
          color: #e2e8f0;
          height: 100vh;
          margin: 0;
          display: flex;
          flex-direction: column;
          font-family: 'Poppins', sans-serif;
        }

        h1, h2, h3 {
          font-weight: 700;
          color: #38bdf8; /* softer cyan accent */
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

        .btn-outline-primary {
          border-color: #38bdf8;
          color: #38bdf8;
        }

        .btn-outline-primary:hover {
          background: #38bdf8;
          color: #0f172a;
          border: none;
        }

        /* ===== Hero Section ===== */
        .content {
          flex: 1;
          display: flex;
          align-items: center;
          justify-content: center;
          text-align: center;
          padding: 60px 20px;
        }

        .content h1 {
          font-size: 2.8rem;
          margin-bottom: 20px;
          text-shadow: 0 0 6px rgba(56, 189, 248, 0.4); /* subtle glow */
        }

        .content p {
          font-size: 1.1rem;
          max-width: 600px;
          margin: auto;
        }

.navbar-brand img:hover {
  filter: drop-shadow(0 0 4px #38bdf8);
}

        /* ===== Footer ===== */
        footer {
          background: #0f172a;
          color: #94a3b8;
          padding: 20px 0;
          border-top: 1px solid rgba(56, 189, 248, 0.2);
        }

        footer .nav-link {
          color: #94a3b8 !important;
        }

        footer .nav-link:hover {
          color: #38bdf8 !important;
        }

        footer p {
          margin: 0;
          font-size: 0.9rem;
        }
        .btn-outline-primary {
  border-color: #38bdf8;
  color: #38bdf8;
  transition: all 0.3s ease;
}

.btn-outline-primary:hover {
  background: #38bdf8;
  color: #0f172a !important; /* dark navy text on cyan background */
  border: none;
}

    </style>
</head>

<body>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg shadow-sm">
    <div class="container">
        <a class="navbar-brand d-flex align-items-center" href="#">
            <img src="images/techroute-logo.png" alt="Logo">
            <strong>TechRoute</strong>
        </a>

        <!-- Admin Dropdown -->
        <div class="dropdown ms-auto me-3">
            <a class="dropdown-toggle text-decoration-none text-light fw-semibold" href="#" role="button" data-bs-toggle="dropdown"
               aria-expanded="false">
                <i class="fas fa-user-shield me-1 text-info"></i> Orders
            </a>
            <ul class="dropdown-menu dropdown-menu-end bg-dark border-info">
                <!--                <li>-->
                <!--                    <a class="dropdown-item text-light" href="viewProfile">-->
                <!--                        <i class="fa fa-id-card me-2 text-info"></i> View Profile-->
                <!--                    </a>-->
                <!--                </li>-->
                <!--                <li>-->
                <!--                    <a class="dropdown-item text-light" href="salesPage">-->
                <!--                        <i class="fa fa-id-card me-2 text-info"></i> Sales-->
                <!--                    </a>-->
                <!--                </li>-->
                <li>
                    <a class="dropdown-item text-light" href="purchasePage">
                        <i class="fa fa-id-card me-2 text-info"></i> Order
                    </a>
                </li>
                <li>
                    <a class="dropdown-item text-light" href="viewAllOrders">
                        <i class="fa fa-id-card me-2 text-info"></i> View All Orders
                    </a>
                </li>
                <li><hr class="dropdown-divider border-info"></li>
                <li>
                    <a class="dropdown-item text-danger" href="logout">
                        <i class="fa fa-sign-out-alt me-2"></i> Logout
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>


<div class="container py-5">
    <h3 class="text-info mb-4"><i class="fas fa-clipboard-list me-2"></i>All Orders</h3>

    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
        <c:forEach var="order" items="${allOrders}">
            <div class="col">
                <!-- Card -->
                <div class="card bg-dark text-light border-info shadow-sm h-100">
                    <div class="card-body">
                        <h5 class="card-title text-info">
                            <i class="fas fa-box-open me-2"></i>${order.productName}
                        </h5>
                        <p class="card-text mb-1">
                            <i class="fas fa-user me-2 text-info"></i><strong>Customer:</strong> ${order.customerName}<br>
                            <i class="fas fa-calendar-alt me-2 text-info"></i><strong>Due Date:</strong> ${order.orderDueDate}<br>
                            <i class="fas fa-clipboard-check me-2 text-info"></i><strong>Status:</strong>
                            <span class="badge bg-info text-dark">${order.status}</span>
                        </p>
                    </div>
                    <div class="card-footer text-end border-info">
                        <button class="btn btn-outline-primary btn-sm" data-bs-toggle="modal" data-bs-target="#orderModal${order.id}">
                            <i class="fas fa-eye me-1"></i>View
                        </button>
                    </div>
                </div>

                <!-- Modal -->
                <div class="modal fade" id="orderModal${order.id}" tabindex="-1" aria-labelledby="orderModalLabel${order.id}" aria-hidden="true">
                    <div class="modal-dialog modal-lg modal-dialog-centered">
                        <div class="modal-content bg-dark text-light border-info">
                            <div class="modal-header">
                                <h5 class="modal-title text-info" id="orderModalLabel${order.id}">
                                    <i class="fas fa-box-open me-2"></i>Order Details
                                </h5>
                                <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <p><i class="fas fa-user me-2 text-info"></i><strong>Customer Name:</strong> ${order.customerName}</p>
                                <p><i class="fas fa-layer-group me-2 text-info"></i><strong>Product Group:</strong> ${order.productGroupName}</p>
                                <p><i class="fas fa-building me-2 text-info"></i><strong>Company Name:</strong> ${order.companyName}</p>
                                <p><i class="fas fa-cogs me-2 text-info"></i><strong>Model:</strong> ${order.model}</p>
                                <p><i class="fas fa-barcode me-2 text-info"></i><strong>Product Code:</strong> ${order.productCode}</p>
                                <p><i class="fas fa-tag me-2 text-info"></i><strong>Product Name:</strong> ${order.productName}</p>
                                <p><i class="fas fa-wallet me-2 text-info"></i><strong>Opening Value:</strong> ₹${order.openingValue}</p>
                                <p><i class="fas fa-rupee-sign me-2 text-info"></i><strong>Purchase Price:</strong> ₹${order.purchasePrice}</p>
                                <p><i class="fas fa-sort-numeric-up me-2 text-info"></i><strong>Quantity:</strong> ${order.quantity}</p>
                                <p><i class="fas fa-boxes me-2 text-info"></i><strong>Stock In Hand:</strong> ${order.stockInHand}</p>
                                <p><i class="fas fa-calendar-alt me-2 text-info"></i><strong>Order Due Date:</strong> ${order.orderDueDate}</p>
                                <p><i class="fas fa-clipboard-check me-2 text-info"></i><strong>Status:</strong> ${order.status}</p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-outline-info" data-bs-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>


<!-- Footer -->
<footer class="py-3 my-4">
    <div class="container-fluid">
        <ul class="nav justify-content-center border-bottom pb-3 mb-3 flex-wrap">
            <li class="nav-item"><a href="#" class="nav-link px-2">Home</a></li>
            <li class="nav-item"><a href="#" class="nav-link px-2">Features</a></li>
            <li class="nav-item"><a href="#" class="nav-link px-2">Pricing</a></li>
            <li class="nav-item"><a href="#" class="nav-link px-2">FAQs</a></li>
            <li class="nav-item"><a href="#" class="nav-link px-2">About</a></li>
        </ul>
        <p class="text-center"> © 2025 Shriharsha | Where Code Meets Character</p>
    </div>
</footer>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>