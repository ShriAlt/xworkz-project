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
    <div class="container-fluid">
        <a class="navbar-brand d-flex align-items-center" href="#">
            <img src="images/techroute-logo.png" alt="TechRoute Logo" style="height: 45px; margin-right: 9px;">
            <strong class="text-info">TechRoute</strong>
        </a>

        <button class="navbar-toggler bg-light" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a href="adminHomePage" class="btn btn-outline-primary nav-link">
                        <i class="fa fa-user"></i> Home
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>


<!-- Content Area --><!-- Content Area -->
<div class="container py-5">
    <div class="card bg-dark text-light border-info shadow-lg mx-auto" style="max-width: 700px;">
        <div class="card-header text-center border-info">
            <h3 class="text-info mb-0"><i class="fas fa-box-open me-2"></i>Purchase Details</h3>
        </div>

        <div class="card-body">
            <p><i class="fas fa-user me-2 text-info"></i><strong>Customer Name:</strong> ${purchaseDto.customerName}</p>
            <p><i class="fas fa-layer-group me-2 text-info"></i><strong>Product Group:</strong> ${purchaseDto.productGroupName}</p>
            <p><i class="fas fa-building me-2 text-info"></i><strong>Company Name:</strong> ${purchaseDto.companyName}</p>
            <p><i class="fas fa-cogs me-2 text-info"></i><strong>Model:</strong> ${purchaseDto.model}</p>
            <p><i class="fas fa-barcode me-2 text-info"></i><strong>Product Code:</strong> ${purchaseDto.productCode}</p>
            <p><i class="fas fa-tag me-2 text-info"></i><strong>Product Name:</strong> ${purchaseDto.productName}</p>
            <p><i class="fas fa-wallet me-2 text-info"></i><strong>Opening Value:</strong> ₹${purchaseDto.openingValue}</p>
            <p><i class="fas fa-rupee-sign me-2 text-info"></i><strong>Purchase Price:</strong> ₹${purchaseDto.purchasePrice}</p>
            <p><i class="fas fa-sort-numeric-up me-2 text-info"></i><strong>Quantity:</strong> ${purchaseDto.quantity}</p>
            <p><i class="fas fa-boxes me-2 text-info"></i><strong>Stock In Hand:</strong> ${purchaseDto.stockInHand}</p>
            <p><i class="fas fa-calendar-alt me-2 text-info"></i><strong>Order Due Date:</strong> ${purchaseDto.orderDueDate}</p>
            <p><i class="fas fa-clipboard-check me-2 text-info"></i><strong>Status:</strong> ${purchaseDto.orderStatus}</p>
        </div>

        <div class="card-footer d-flex justify-content-between align-items-center border-info">
            <small class="text-muted"><i class="fas fa-route me-1"></i>TechRoute | Transaction Summary</small>
            <div>
                <form action="approvePurchase" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${purchaseDto.id}">
                    <button type="submit" class="btn btn-outline-success btn-sm"><i class="fas fa-check-circle me-1"></i>Approve
                    </button>
                </form>
                <form action="cancelPurchase" method="post" style="display:inline;" onsubmit="return confirm('Cancel this purchase?');">
                    <input type="hidden" name="id" value="${purchaseDto.id}">
                    <button type="submit" class="btn btn-outline-danger btn-sm"><i class="fas fa-times-circle me-1"></i>Cancel</button>
                </form>
            </div>
        </div>
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