const selector = document.getElementById("formSelector");
const purchaseForm = document.getElementById("purchaseFormSection");
const salesForm = document.getElementById("salesFormSection");

// Toggle between purchase and sales form
selector.addEventListener("change", function () {
  if (this.value === "purchase") {
    purchaseForm.style.display = "block";
    salesForm.style.display = "none";
  } else {
    purchaseForm.style.display = "none";
    salesForm.style.display = "block";
  }
});

document.addEventListener("DOMContentLoaded", function () {
  // ✅ Load product groups
  axios("http://localhost:8080/TechRoute/fetch-products")
    .then(function (response) {
      const dropdown = document.getElementById("productGroupDropdown");
      dropdown.innerHTML = "<option value=''>Select a product group</option>";
      response.data.forEach(function (groupName) {
        const option = document.createElement("option");
        option.value = groupName;
        option.textContent = groupName;
        dropdown.appendChild(option);
      });
    })
    .catch(function (error) {
      console.error("Failed to load product groups:", error);
    });

  // ✅ Load customers
  axios("http://localhost:8080/TechRoute/fetch-debitors")
    .then(function (response) {
      const dropdown = document.getElementById("customerNameDropdown");
      dropdown.innerHTML = "<option value=''>Select a customer</option>";
      response.data.forEach(function (customer) {
        const option = document.createElement("option");
        option.value = customer;
        option.textContent = customer;
        dropdown.appendChild(option);
      });
    })
    .catch(function (error) {
      console.error("Failed to load customer names:", error);
    });
});

document.getElementById("productGroupDropdown").addEventListener("change", function () {
alert("Product group changed");
  const groupName = this.value;
  if (!groupName) return;
  axios("http://localhost:8080/TechRoute/fetch-allProductInGroupName?productGroupName=" + groupName )
    .then(function (response) {
    console.log("Products in group:", response.data);
      const productDropdown = document.getElementById("productNameDropdown");
      productDropdown.innerHTML = "<option value=''>Select a product</option>";

      response.data.forEach(function (product) {
        const option = document.createElement("option");
        option.value = product.productCode; // or productId if you prefer
        option.textContent = product.productName;
        option.dataset.product = JSON.stringify(product); // store full DTO for later use
        productDropdown.appendChild(option);
      });
    })
    .catch(function (error) {
      console.error("Failed to load products:", error);
    });
});

// ✅ When product selected → auto-fill fields
document.getElementById("productNameDropdown").addEventListener("change", function () {
  const selectedOption = this.options[this.selectedIndex];
  if (!selectedOption || !selectedOption.dataset.product) return;

  const product = JSON.parse(selectedOption.dataset.product);

  // Fill product details
  document.getElementById("companyName").value = product.companyName;
  document.getElementById("model").value = product.model;
  document.getElementById("productCode").value = product.productCode;

  // Fill stock details (first stock record)
  if (product.stocks && product.stocks.length > 0) {
    const stock = product.stocks[0];
    document.getElementById("openingValue").value = stock.openingValue;
    document.getElementById("purchasePrice").value = stock.purchasePrice;
    document.getElementById("quantity").value = stock.quantity;
    document.getElementById("stockInHand").value = stock.quantity;
  }
});

document.addEventListener("DOMContentLoaded", function () {
  // ✅ Load customers (creditors who buy from you)
  axios("http://localhost:8080/TechRoute/fetch-creditors")
    .then(function (response) {
      const dropdown = document.getElementById("salesCustomerDropdown");
      dropdown.innerHTML = "<option value=''>Select a customer</option>";
      response.data.forEach(function (creditor) {
        const option = document.createElement("option");
        option.value = creditor;
        option.textContent = creditor;
        dropdown.appendChild(option);
      });
    })
    .catch(function (error) {
      console.error("Failed to load customers:", error);
    });

  // ✅ Load product groups
  axios("http://localhost:8080/TechRoute/fetch-products")
    .then(function (response) {
      const dropdown = document.getElementById("salesProductGroupDropdown");
      dropdown.innerHTML = "<option value=''>Select a product group</option>";
      response.data.forEach(function (groupName) {
        const option = document.createElement("option");
        option.value = groupName;
        option.textContent = groupName;
        dropdown.appendChild(option);
      });
    })
    .catch(function (error) {
      console.error("Failed to load product groups:", error);
    });
});

// ✅ When group selected → load products
document.getElementById("salesProductGroupDropdown").addEventListener("change", function () {
  const groupName = this.value;
  if (!groupName) return;

  axios(`http://localhost:8080/TechRoute/fetch-allProductInGroupName?productGroupName=${groupName}`)
    .then(function (response) {
      const productDropdown = document.getElementById("salesProductNameDropdown");
      productDropdown.innerHTML = "<option value=''>Select a product</option>";

      response.data.forEach(function (product) {
        const option = document.createElement("option");
        option.value = product.productCode;
        option.textContent = product.productName;
        option.dataset.product = JSON.stringify(product); // store full DTO
        productDropdown.appendChild(option);
      });
    })
    .catch(function (error) {
      console.error("Failed to load products:", error);
    });
});

// ✅ When product selected → auto-fill fields
document.getElementById("salesProductNameDropdown").addEventListener("change", function () {
  const selectedOption = this.options[this.selectedIndex];
  if (!selectedOption || !selectedOption.dataset.product) return;

  const product = JSON.parse(selectedOption.dataset.product);

  // Fill product details
  document.getElementById("salesCompanyName").value = product.companyName;
  document.getElementById("salesModel").value = product.model;
  document.getElementById("salesProductCode").value = product.productCode;

  // Fill stock details (first stock record)
  if (product.stocks && product.stocks.length > 0) {
    const stock = product.stocks[0];
    document.getElementById("salesAvailableStock").value = stock.quantity;
    document.getElementById("salesPrice").value = product.defaultSalePrice;
  }
});

// ✅ Validate sale quantity against available stock
document.getElementById("salesQuantity").addEventListener("input", function () {
  const available = parseInt(document.getElementById("salesAvailableStock").value, 10);
  const entered = parseInt(this.value, 10);

  if (entered > available) {
    alert("Sale quantity cannot exceed available stock!");
    this.value = available; // reset to max available
  }
});
