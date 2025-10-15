<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TechRoute</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

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
            <img src="images/logo-hollowKnight.jpeg" alt="Logo">
            <strong>TechRoute</strong>
        </a>

        <!-- Admin Dropdown -->
        <div class="dropdown ms-auto me-3">
            <a class="dropdown-toggle text-decoration-none text-light fw-semibold" href="#" role="button" data-bs-toggle="dropdown"
               aria-expanded="false">
                <i class="fas fa-user-shield me-1 text-info"></i> User Panel
            </a>
            <ul class="dropdown-menu dropdown-menu-end bg-dark border-info">
                <li>
                    <a class="dropdown-item text-light" href="viewProfile">
                        <i class="fa fa-id-card me-2 text-info"></i> View Profile
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

<!-- Content Area -->
<div class="content">
    <div class="container">
        <h1>Welcome to TechRoute</h1>
        <p>This is where you'll find all the latest laptops and innovations on your journey through tech.</p>
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

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>