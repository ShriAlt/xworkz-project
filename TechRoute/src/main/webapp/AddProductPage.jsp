<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Product</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow-sm">
        <div class="card-header bg-info text-white">
            <h4 class="mb-0">Add Product</h4>
        </div>
        <div class="card-body">
            <form id="addProductForm" action="addProduct" method="post">
                <div class="row g-3">

                    <!-- Product Code -->
                    <div class="col-md-6">
                        <label class="form-label">Product Code</label>
                        <input type="text" class="form-control" name="productCode" maxlength="30" required>
                    </div>

                    <!-- Product Name -->
                    <div class="col-md-6">
                        <label class="form-label">Product Name</label>
                        <input type="text" class="form-control" name="productName" maxlength="100" required>
                    </div>

                    <!-- Product Group -->
                    <div class="col-md-6">
                        <label class="form-label">Product Group Name</label>
                        <select class="form-control" name="productGroupName" id="productGroupDropdown" required>
                            <option value="">Select a product group</option>
                        </select>
                    </div>

                    <!-- Model -->
                    <div class="col-md-6">
                        <label class="form-label">Model</label>
                        <input type="text" class="form-control" name="model" maxlength="50">
                    </div>

                    <!-- Company Name -->
                    <div class="col-md-6">
                        <label class="form-label">Company Name</label>
                        <input type="text" class="form-control" name="companyName" maxlength="50">
                    </div>

                    <!-- Variant / Attributes -->
                    <div class="col-md-6">
                        <label class="form-label">Variant / Attributes</label>
                        <input type="text" class="form-control" name="variantAttributes" maxlength="100">
                    </div>

                    <!-- Purchase Price -->
                    <div class="col-md-6">
                        <label class="form-label">Default Purchase Price</label>
                        <input type="number" class="form-control" name="defaultPurchasePrice" step="0.01" min="0">
                    </div>

                    <!-- Sale Price -->
                    <div class="col-md-6">
                        <label class="form-label">Default Sale Price</label>
                        <input type="number" class="form-control" name="defaultSalePrice" step="0.01" min="0">
                    </div>

                    <!-- Purchased From -->
                    <div class="col-md-6">
                        <label class="form-label">Purchased From</label>
                        <input type="text" class="form-control" name="purchasedFrom" maxlength="100">
                    </div>

                    <!-- Status -->
                    <div class="col-md-6">
                        <label class="form-label">Status</label>
                        <select class="form-select" name="status" required>
                            <option value="ACTIVE" selected>Active</option>
                            <option value="INACTIVE">Inactive</option>
                        </select>
                    </div>

                    <!-- Submit -->
                    <div class="col-12 text-end mt-4">
                        <button type="submit" class="btn btn-success">Add Product</button>
                        <button type="reset" class="btn btn-secondary">Reset</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
    document.addEventListener("DOMContentLoaded", function () {
   axios("http://localhost:8080/TechRoute/fetch-products")
     .then(function (response) {
       const dropdown = document.getElementById("productGroupDropdown");
       response.data.forEach(function (debitor) {
         const option = document.createElement("option");
         option.value = debitor;
         option.textContent = debitor;
         dropdown.appendChild(option);
       });
     })
     .catch(function (error) {
       console.error("Failed to load debitors:", error);
     });
 });
</script>
</body>
</html>
