<!DOCTYPE html>
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
                    <a href="loginPage" class="btn btn-outline-primary nav-link">
                        <i class="fa fa-user"></i> Login
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>


<!-- Content Area -->
<div class="content">
    <div class="container-fluid text-center">
        <h1>Welcome to TechRoute</h1>
        <p>Your journey through the latest laptops starts here. Explore innovation, speed, and design all in one route.</p>
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