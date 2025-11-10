<%@ page isELIgnored="false" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OrdersPage</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <style>
        /* ===== Global Theme ===== */
        body {
          background: #0f172a; /* deep navy */
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

        /* ===== User Dropdown ===== */
        .user-dropdown .dropdown-toggle {
          color: #e2e8f0;
          font-weight: 500;
        }

        .user-dropdown .dropdown-toggle:hover {
          color: #38bdf8;
        }

        .dropdown-menu {
          background: #1e293b;
          border: 1px solid rgba(56, 189, 248, 0.2);
        }

        .dropdown-item {
          color: #e2e8f0;
        }

        .dropdown-item:hover {
          background: #0f172a;
          color: #38bdf8;
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
                                <li>
                                    <a class="dropdown-item text-light" href="userHomePage">
                                        <i class="fa fa-id-card me-2 text-info"></i> Home
                                    </a>
                                </li>
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
    <div class="mb-4">
        <label for="formSelector" class="form-label text-info mb-4">Change Form </label>
        <select class="form-select w-auto" id="formSelector">
            <option value="purchase">Purchase</option>
            <option value="sales">Sales</option>
        </select>
    </div>

    <!-- Purchase Form -->
    <div id="purchaseFormSection">
        <!-- Paste your full purchase form here -->
        <h4 class="text-info">Purchase Form</h4>
        <!-- Example field -->
        <span class="text-danger">${error}</span>
        <form id="purchaseForm" action="purchase" method="post">
            <div class="row g-3">
                <div class="col-md-6">
                    <label class="form-label">Customer Name</label>
                    <select class="form-control" name="customerName" id="customerNameDropdown" required>
                        <option value="">Select a customer</option>
                    </select>
                </div>

                <div class="col-md-6">
                    <label class="form-label">Product Group Name</label>
                    <select class="form-control" name="productGroupName" id="productGroupDropdown" required>
                        <option value="">Select a product group</option>
                    </select>
                </div>

                <div class="col-md-6">
                    <label class="form-label">Company Name</label>
                    <input type="text" class="form-control" name="companyName" maxlength="50" required>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Model</label>
                    <input type="text" class="form-control" name="model" maxlength="50" required>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Product Code</label>
                    <input type="text" class="form-control" name="productCode" maxlength="30" required>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Product Name</label>
                    <input type="text" class="form-control" name="productName" maxlength="100" required>
                </div>

                <!-- Numeric Fields -->
                <div class="col-md-6">
                    <label class="form-label">Opening Value</label>
                    <input type="number" class="form-control" name="openingValue" min="1" required>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Purchase Price</label>
                    <input type="number" class="form-control" name="purchasePrice" min="1" step="1" required>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Quantity</label>
                    <input type="number" class="form-control" name="quantity" min="1" required>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Stock In Hand</label>
                    <input type="number" class="form-control" name="stockInHand" min="0" required>
                </div>

                <!-- Date and Status -->
                <div class="col-md-6">
                    <label class="form-label">Order Due Date</label>
                    <input type="date" class="form-control" name="orderDueDate" required>
                </div>

                <div class="col-md-6">
                    <label class="form-label">Status</label>
                    <select class="form-select" name="status" required >
<!--                        <option selected disabled>Select status</option>-->
                        <option value="PENDING" selected>Pending</option>
<!--                        <option value="CONFIRMED">Confirmed</option>-->
<!--                        <option value="CANCELLED">Cancelled</option>-->
<!--                        <option value="SHIPPED">Shipped</option>-->
                    </select>
                </div>

                <div class="col-12 text-end mt-4">
                    <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#confirmModal">
                        Place Order
                    </button>
                </div>
            </div>
        </form>
    </div>

    <!-- Sales Form Placeholder -->
    <div id="salesFormSection" style="display: none;">
        <h4 class="text-info">Sales Form</h4>
        <p class="text-muted">Sales form coming soon...</p>
    </div>
</div>

<!-- Confirmation Modal -->
<div class="modal fade" id="confirmModal" tabindex="-1" aria-labelledby="confirmModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content bg-dark text-light border-info">
            <div class="modal-header">
                <h5 class="modal-title" id="confirmModalLabel">Confirm Order</h5>
                <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Are you sure you want to place this order?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">Cancel</button>
                <button type="submit" form="purchaseForm" class="btn btn-outline-info">Confirm & Submit</button>
            </div>
        </div>
    </div>
</div>


<!-- Footer -->
<footer class="py-3 my-4">
    <div class="container">
        <ul class="nav justify-content-center border-bottom pb-3 mb-3">
            <li class="nav-item"><a href="#" class="nav-link px-2">Home</a></li>
            <li class="nav-item"><a href="#" class="nav-link px-2">Features</a></li>
            <li class="nav-item"><a href="#" class="nav-link px-2">Pricing</a></li>
            <li class="nav-item"><a href="#" class="nav-link px-2">FAQs</a></li>
            <li class="nav-item"><a href="#" class="nav-link px-2">About</a></li>
        </ul>
        <p class="text-center">© 2025 Shriharsha | Where Code Meets Character</p>
    </div>
</footer>
<script src="../../../../TechRoute-admin/src/main/webapp/js/OrdersPageValidation.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>