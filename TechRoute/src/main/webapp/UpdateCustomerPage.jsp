<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Customer | TechRoute</title>

    <!-- Bootstrap & Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

    <!-- Axios -->
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

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
<nav class="navbar navbar-expand-lg shadow-sm">
    <div class="container">
        <a class="navbar-brand d-flex align-items-center" href="#">
            <img src="images/techroute-logo.png" alt="Logo">
            <strong>TechRoute</strong>
        </a>
        <div class="dropdown ms-auto me-3">
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
                <li>
                    <a class="dropdown-item text-light" href="viewCustomerPage">
                        <i class="fa fa-users me-2 text-info"></i> View Customers
                    </a>
                </li>
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

<div class="container py-5">
    <h2 class="text-info mb-4">Update Customer</h2>
    <form action="UpdateCustomer" method="post">

        <div class="row g-3">
            <span class="text-danger">${error}</span>
            <!-- Customer Name -->
            <div class="col-md-6">
                <label for="customerName" class="form-label">Customer Name</label>
                <input type="text" class="form-control" name="customerName" id="customerName" value="${dto.customerName}" placeholder="Enter full name" required onchange="validateName()">
                <span id="nameError" class="text-danger"></span>
            </div>

            <!-- Customer Type -->
            <div class="col-md-6">
                <label for="customerType" class="form-label">Customer Type</label>
                <select class="form-select" name="customerType" id="customerType" required>
                    <option disabled <c:if test="${empty dto.customerType}">selected</c:if>>Select type</option>
                    <option value="Creditors" <c:if test="${dto.customerType == 'Creditors'}"> selected </c:if>> Creditor </option>
                    <option value="Debitors" <c:if test="${dto.customerType == 'Debitors'}">selected</c:if>>Debitor</option>
                </select>
            </div>

            <!-- Email -->
            <div class="col-md-6">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" name="email" id="email" value="${dto.email}" placeholder="example@domain.com" required onchange="validateEmail()">
                <span id="emailError" class="text-danger"></span>
            </div>

            <div class="col-md-6">
                <label for="contact" class="form-label">Contact Number</label>
                <input type="tel" class="form-control" name="contact" id="contact" value="${dto.contact}" placeholder="+91 9876543210" required onchange="validateContact()">
                <span id="contactError" class="text-danger"></span>
            </div>

            <div class="col-md-6">
                <label for="gst" class="form-label">GST Number</label>
                <input type="text" class="form-control" name="gst" id="gst" value="${dto.gst}" placeholder="Enter GSTIN" onchange="validateGST()">
                <span id="gstError" class="text-danger"></span>
            </div>

            <div class="col-md-6">
                <label for="country" class="form-label">Country</label>
                <input type="text" class="form-control"  name="country" id="country" value="India" readonly>
            </div>


            <div class="col-md-6">
                <label for="pinCode" class="form-label">PinCode</label>
                <input type="text" class="form-control" name="pinCode" value="${dto.pinCode}" id="pinCode" placeholder="Enter pincode" onchange="checkPinCode()">
                <span id="pinCodeError" class="text-danger"></span>
            </div>

            <div class="col-md-6">
                <label for="state" class="form-label">State</label>
                <select class="form-select" name="state" id="state">
                    <option value="${dto.state}" selected> ${dto.state}</option>
                </select>
            </div>

            <!-- City -->
            <div class="col-md-6">
                <label for="city" class="form-label">City</label>
                <input type="text" class="form-control" name="city" id="city" value="${dto.city}" placeholder="Enter city">
            </div>


            <!-- Address -->
            <div class="col-md-6">
                <label for="address" class="form-label">Address</label>
                <input class="form-control" id="address" name="address" value="${dto.address}"  placeholder="Street, locality..."/>
            </div>

            <!-- Billing Address -->
            <div class="col-md-6">
                <label for="billingAddress" class="form-label">Billing Address</label>
                <input class="form-control" id="billingAddress" name="billingAddress" value="${dto.billingAddress}" placeholder="Billing details..." ></input>
            </div>

<!--            <div class="col-12">-->
<!--                <div class="form-check">-->
<!--                    <input class="form-check-input" type="checkbox" id="sameAddress" onclick="copyBillingAddress()" >-->
<!--                    <label class="form-check-label" for="sameAddress">-->
<!--                        Shipping address same as billing-->
<!--                    </label>-->
<!--                </div>-->
<!--            </div>-->

            <!-- Shipping Address -->
            <div class="col-md-12">
                <label for="shippingAddress" class="form-label">Shipping Address</label>
                <input class="form-control" id="shippingAddress" name="shippingAddress" value="${dto.shippingAddress}" placeholder="Shipping details..." >
            </div>



            <!-- Payment Mode -->
            <div class="col-md-12">
                <label class="form-label d-block mb-2">Payment Mode</label>

                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="paymentMode" id="online" value="Online"
                    <c:if test="${dto.paymentMode == 'Online'}">checked</c:if>>
                    <label class="form-check-label" for="online">Online</label>
                </div>

                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="paymentMode" id="cash" value="Cash"
                    <c:if test="${dto.paymentMode == 'Cash'}">checked</c:if>>
                    <label class="form-check-label" for="cash">Cash</label>
                </div>

                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="paymentMode" id="cheque" value="Cheque"
                    <c:if test="${dto.paymentMode == 'Cheque'}">checked</c:if>>
                    <label class="form-check-label" for="cheque">Cheque</label>
                </div>
            </div>
            <!-- Submit Button -->
            <div class="col-12 text-end mt-4">
                <button type="submit" class="btn btn-outline-primary">Update Customer</button>
            </div>
        </div>
    </form>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="js/AddCustomer.js"></script>
</body>

</html>