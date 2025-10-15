<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reset Password</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <style>
        body {
            background-color: #f8f9fa;
            height: 100vh;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .forgot-password-card {
            width: 400px;
            max-width: 90%;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card forgot-password-card">
                <div class="card-header text-center">
                    <h3>Reset your Password </h3>
                </div>
                <div class="card-body">
                    <form id="forgotPasswordForm" action="sendOtp" method="post">
                        <span>${locked}</span>
                        <div class="mb-3">
                            <label for="identifier" class="form-label">Email / phone  </label>
                            <span class="text-danger" id="identifierError"></span>
                            <input type="text"  class="form-control" id="identifier" value= "${identifier}" name="identifier" placeholder="Enter your email or phone number" onchange="validateIdentifier()" required>
                        </div>
                        <button type="submit" id="submitBtn" class="btn btn-primary w-100">Reset Password</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="js/LoginPageValidation.js"></script>
</body>
</html>
