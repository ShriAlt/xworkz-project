<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Customer | TechRoute</title>

    <!-- Bootstrap & Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

    <!-- Axios -->
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

    <style>
        body {
          background-color: #0f172a;
          color: #e2e8f0;
          font-family: 'Poppins', sans-serif;
        }

        h2 {
          color: #38bdf8;
          font-weight: 700;
          text-shadow: 0 0 6px rgba(56, 189, 248, 0.4);
        }

        label {
          font-weight: 500;
          color: #e2e8f0;
        }

        .form-control,
        .form-select,
        textarea {
          background-color: #1e293b;
          color: #e2e8f0;
          border: 1px solid #334155;
          transition: border-color 0.3s ease;
        }

        .form-control:focus,
        .form-select:focus,
        textarea:focus {
          border-color: #38bdf8;
          box-shadow: 0 0 0 0.2rem rgba(56, 189, 248, 0.25);
        }

        .form-check-label {
          color: #cbd5e1;
        }

        .btn-outline-primary {
          border-color: #38bdf8;
          color: #38bdf8;
          transition: all 0.3s ease;
        }

        .btn-outline-primary:hover {
          background-color: #38bdf8;
          color: #0f172a;
          border: none;
        }

        textarea {
          resize: vertical;
        }
    </style>
</head>

<body>

<div class="container py-5">
    <h2 class="text-info mb-4">Add Customer</h2>
    <form>
        <div class="row g-3">
            <!-- Customer Name -->
            <div class="col-md-6">
                <label for="customerName" class="form-label">Customer Name</label>
                <input type="text" class="form-control" name="customerName" id="customerName" placeholder="Enter full name">
            </div>

            <!-- Customer Type -->
            <div class="col-md-6">
                <label for="customerType" class="form-label">Customer Type</label>
                <select class="form-select" name="customerType" id="customerType">
                    <option selected disabled>Select type</option>
                    <option value="creditor">Creditor</option>
                    <option value="debitor">Debitor</option>
                </select>
            </div>

            <!-- Email -->
            <div class="col-md-6">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" name="email" id="email" placeholder="example@domain.com">
            </div>

            <!-- Contact Number -->
            <div class="col-md-6">
                <label for="contact" class="form-label">Contact Number</label>
                <input type="tel" class="form-control" name="contact" id="contact" placeholder="+91 9876543210">
            </div>

            <!-- GST Number -->
            <div class="col-md-6">
                <label for="gst" class="form-label">GST Number</label>
                <input type="text" class="form-control" name="gst" id="gst" placeholder="Enter GSTIN">
            </div>

            <!-- Country (Read-only) -->
            <div class="col-md-6">
                <label for="country" class="form-label">Country</label>
                <input type="text" class="form-control"  name="country" id="country" value="India" readonly>
            </div>

            <!-- State (API-driven) -->
            <div class="col-md-6">
                <label for="state" class="form-label">State</label>
                <select class="form-select" name="state" id="state">
                    <option selected disabled>Loading states...</option>
                </select>
            </div>

            <!-- City -->
            <div class="col-md-6">
                <label for="city" class="form-label">City</label>
                <input type="text" class="form-control" name="city" id="city" placeholder="Enter city">
            </div>

            <!-- Pincode -->
            <div class="col-md-6">
                <label for="pincode" class="form-label">Pincode</label>
                <input type="text" class="form-control" name="pincode" id="pincode" placeholder="Enter pincode">
            </div>

            <!-- Address -->
            <div class="col-md-6">
                <label for="address" class="form-label">Address</label>
                <textarea class="form-control" id="address" name="address" rows="2" placeholder="Street, locality..."></textarea>
            </div>

            <!-- Billing Address -->
            <div class="col-md-6">
                <label for="billingAddress" class="form-label">Billing Address</label>
                <textarea class="form-control" id="billingAddress" name="billingAddress" rows="2" placeholder="Billing details..."></textarea>
            </div>

            <!-- Same as Billing Checkbox -->
            <div class="col-12">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="sameAddress">
                    <label class="form-check-label" for="sameAddress">
                        Shipping address same as billing
                    </label>
                </div>
            </div>

            <!-- Shipping Address -->
            <div class="col-md-12">
                <label for="shippingAddress" class="form-label">Shipping Address</label>
                <textarea class="form-control" id="shippingAddress" name="shippingAddress" rows="2" placeholder="Shipping details..."></textarea>
            </div>

            <!-- Payment Mode -->
            <div class="col-md-12">
                <label class="form-label d-block mb-2">Payment Mode</label>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="paymentMode" id="online" value="online">
                    <label class="form-check-label" for="online">Online</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="paymentMode" id="cash" value="cash">
                    <label class="form-check-label" for="cash">Cash</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="paymentMode" id="cheque" value="cheque">
                    <label class="form-check-label" for="cheque">Cheque</label>
                </div>
            </div>

            <!-- Submit Button -->
            <div class="col-12 text-end mt-4">
                <button type="submit" class="btn btn-outline-primary">Add Customer</button>
            </div>
        </div>
    </form>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- State API + Address Sync -->
<!--<script>-->
<!--    // Load Indian states from API-->
<!--    axios.get("https://cdn-api.co-vin.in/api/v2/admin/location/states")-->
<!--      .then(response => {-->
<!--        const stateSelect = document.getElementById("state");-->
<!--        stateSelect.innerHTML = '<option selected disabled>Select state</option>';-->
<!--        response.data.states.forEach(state => {-->
<!--          const option = document.createElement("option");-->
<!--          option.value = state.state_name;-->
<!--          option.textContent = state.state_name;-->
<!--          stateSelect.appendChild(option);-->
<!--        });-->
<!--      })-->
<!--      .catch(error => {-->
<!--        console.error("Error loading states:", error);-->
<!--      });-->

<!--    // Sync billing and shipping address-->
<!--    document.getElementById("sameAddress").addEventListener("change", function () {-->
<!--      const billing = document.getElementById("billingAddress").value;-->
<!--      const shipping = document.getElementById("shippingAddress");-->
<!--      if (this.checked) {-->
<!--        shipping.value = billing;-->
<!--        shipping.setAttribute("readonly", true);-->
<!--      } else {-->
<!--        shipping.removeAttribute("readonly");-->
<!--        shipping.value = "";-->
<!--      }-->
<!--    });-->
<!--</script>-->
</body>

</html>