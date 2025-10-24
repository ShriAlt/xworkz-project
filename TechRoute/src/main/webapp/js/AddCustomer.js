    async function checkPincode() {
    const pinCode = document.getElementById('pinCode').value.trim();
          const errorId = document.getElementById('pincodeError');
//          if (pinCode.length !== 6 || isNaN(pinCode)) {
//            errorId.innerHTML = "Please enter a valid 6-digit pinCode.";
//          }
          try {
           const response = await axios(`https://api.postalpincode.in/pincode/${pincode}`);
           const data = response.data;
           if (data[0].Status === "Success" && data[0].PostOffice.length > 0) {
             const office = data[0].PostOffice[0];
            alert("yeahhhh");
           } else {
             resultDiv.innerHTML = `<p>No data found for this pincode.</p>`;
           }
          } catch (error) {
            console.error("Error:", error);
            resultDiv.innerHTML = "<p>Failed to fetch data. Try again later.</p>";
          }
    }
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