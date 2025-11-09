<%@ page isELIgnored="false" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login | TechRoute</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

    <style>
        /* ===== Global Theme ===== */
        body {
          background: #0f172a; /* deep navy */
          color: #e2e8f0;
          height: 100vh;
          display: flex;
          justify-content: center;
          align-items: center;
          font-family: 'Poppins', sans-serif;
        }

        /* ===== Card Styling ===== */
        .login-card {
          width: 400px;
          max-width: 90%;
          border-radius: 15px;
          background: #1e293b; /* dark slate */
          border: 1px solid rgba(56, 189, 248, 0.2);
          color: #e2e8f0;
        }

        .card-header {
          background: #0f172a;
          border-bottom: 1px solid rgba(56, 189, 248, 0.3);
          color: #38bdf8;
          font-weight: 600;
          font-size: 1.2rem;
        }

        /* ===== Form Controls ===== */
        .form-label {
          color: #cbd5e1;
          font-weight: 500;
        }

        .input-group-text {
          background: #1e293b;
          border: 1px solid rgba(56, 189, 248, 0.3);
          color: #38bdf8;
        }

        .form-control {
          background: #0f172a;
          border: 1px solid rgba(56, 189, 248, 0.3);
          color: #e2e8f0;
        }

       .form-control {
  background: #0f172a;
  border: 1px solid rgba(56, 189, 248, 0.3);
  color: #e2e8f0;
}

.form-control::placeholder {
  color: #94a3b8;  /* visible placeholder */
  opacity: 1;
}
        .form-control:focus {
          box-shadow: 0 0 6px rgba(56, 189, 248, 0.4);
          border-color: #38bdf8;
          background: #0f172a;
          color: #e2e8f0;
        }

        /* ===== Links ===== */
        a {
          color: #38bdf8;
          transition: color 0.3s ease;
        }

        a:hover {
          color: #7dd3fc;
        }

        /* ===== Button ===== */
        .btn-primary {
          background: #38bdf8;
          border: none;
          font-weight: 600;
          transition: all 0.3s ease;
          color: #0f172a;
        }

        .btn-primary:hover {
          background: #0ea5e9;
          color: #fff;
        }

        /* ===== Error Text ===== */
        .text-danger {
          font-size: 0.9rem;
        }
    </style>
</head>

<body>

<!-- Login Form (Card) -->
<div class="card login-card shadow-lg">
    <div class="card-header text-center">
        <i class="fas fa-user-circle me-2"></i> Login
    </div>
    <div class="card-body p-4">
        <form action="login" method="POST">
            <span class="text-danger">${error}</span>

            <!-- Identifier -->
            <div class="mb-3">
                <label for="identifier" class="form-label">Email or Phone</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-envelope"></i></span>
                    <input type="text" class="form-control" id="identifier" name="identifier"
                           value="${identifier}" onchange="validateIdentifier()"
                           placeholder="Enter email or phone" required>
                </div>
                <span id="identifierError" class="text-danger"></span>
            </div>

            <!-- Password -->
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <span class="text-danger">${passwordError}</span>
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-lock"></i></span>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>
            </div>

            <!-- Forgot Password -->
            <div class="d-flex justify-content-between align-items-center mb-3">
                <a href="forgotPassword" class="small text-decoration-none">Forgot Password?</a>
            </div>

            <!-- Submit -->
            <button type="submit" class="btn btn-primary w-100" id="submitBtn">Login</button>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="js/LoginPageValidation.js"></script>
</body>
</html>