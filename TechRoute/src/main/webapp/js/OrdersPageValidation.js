
    const selector = document.getElementById("formSelector");
    const purchaseForm = document.getElementById("purchaseFormSection");
    const salesForm = document.getElementById("salesFormSection");

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
      axios("http://localhost:8081/TechRoute-User/fetch-products")
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
    document.addEventListener("DOMContentLoaded", function () {
      axios("http://localhost:8081/TechRoute-User/fetch-debitors")
        .then(function (response) {
          const dropdown = document.getElementById("customerNameDropdown");
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
