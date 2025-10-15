<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OTP Verification | TechRoute</title>
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
          justify-content: center;
          align-items: center;
          font-family: 'Poppins', sans-serif;
        }

        /* ===== Card Styling ===== */
        .otp-verification-card {
          width: 100%;
          max-width: 420px;
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
          text-align: center;
        }

        .card-header p {
          font-size: 0.9rem;
          color: #cbd5e1;
          margin-top: 8px;
        }

        /* ===== Form Controls ===== */
        .form-label {
          color: #cbd5e1;
          font-weight: 500;
        }

        .form-control {
          background: #0f172a;
          border: 1px solid rgba(56, 189, 248, 0.3);
          color: #e2e8f0;
        }

        .form-control:focus {
          box-shadow: 0 0 6px rgba(56, 189, 248, 0.4);
          border-color: #38bdf8;
          background: #0f172a;
          color: #e2e8f0;
        }

        /* Placeholder styling */
        .form-control::placeholder {
          color: #94a3b8;
          opacity: 1;
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

<!-- Centered Card -->
<div class="otp-verification-card shadow-lg p-4">
    <div class="card-header">
        <i class="fas fa-shield-alt me-2"></i> OTP Verification
        <p>Please enter the 6-digit OTP sent to your registered mail: <span>${identifier}</span></p>
    </div>
    <div class="card-body">
        <form id="otpForm" action="VerifyOtp" method="post">
            <span class="text-danger">${error}</span>
            <div class="mb-3">
                <input type="text" value="${identifier}" name="identifier" hidden />
                <label for="otp" class="form-label">One-Time Password (OTP)</label>
                <input type="text" class="form-control" id="otp" name="otp"
                       placeholder="Enter OTP"
                       required pattern="[0-9]{6}"
                       title="Please enter a 6-digit OTP">
            </div>
            <button type="submit" class="btn btn-primary w-100">Verify OTP</button>
        </form>

        <!-- Resend OTP Section -->
        <div class="text-center mt-3">
            <span>Didn't receive the OTP?</span>
            <form id="resendOtpForm" action="resendOtp" method="post" onsubmit="resendOtp(event)">
                <input type="text" value="${identifier}" id="identifier" name="identifier" hidden />
                <button type="submit" id="resendOtpBtn" class="btn btn-link" >Resend OTP</button>
                <span id="resendError" class="text-danger"></span>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="js/OtpPage.js"></script>
</body>
</html>