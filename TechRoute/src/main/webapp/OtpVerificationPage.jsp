<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OTP Verification</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            height: 100vh;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .otp-verification-card {
            width: 400px;
            max-width: 90%;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card otp-verification-card">
                <div class="card-header text-center">
                    <h3>OTP Verification</h3>
                    <p>Please enter the 6-digit OTP sent to your registered mail :  <span>${identifier}</span>.</p>
                </div>
                <div class="card-body">
                    <form id="otpForm" action="VerifyOtp" method="post">
                        <span>${error}</span>
                        <div class="mb-3">
                            <input type="text" value="${identifier}" name="identifier" hidden />
                            <label for="otp" class="form-label">One-Time Password (OTP)</label>
                            <input type="text" class="form-control" id="otp" name="otp" placeholder="Enter OTP"
                                   required pattern="[0-9]{6}" title="Please enter a 6-digit OTP">
                        </div>
                        <button type="submit" class="btn btn-primary w-100">Verify OTP</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
