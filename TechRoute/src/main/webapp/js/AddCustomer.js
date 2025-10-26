async function checkPinCode() {
  const pinCode = document.getElementById('pinCode').value.trim();
  const errorId = document.getElementById('pinCodeError');
  const stateSelect = document.getElementById('state');
  const cityInput = document.getElementById('city');
  // Clear previous errors and reset fields
  errorId.innerHTML = '';
  stateSelect.innerHTML = '<option selected disabled>Loading states...</option>';
  cityInput.value = '';

  if (pinCode.length !== 6 || isNaN(pinCode)) {
    errorId.innerHTML = "Please enter a valid 6-digit pinCode.";
    return;
  }

  try {
    const response = await axios.get(`https://api.postalpincode.in/pincode/${pinCode}`);
    const data = response.data;

    if (data[0].Status === "Success" && data[0].PostOffice.length > 0) {
      const office = data[0].PostOffice[0];

      // Populate state dropdown with the matched state
      stateSelect.innerHTML = `<option selected>${office.State}</option>`;

      // Populate city input with the district
      cityInput.value = office.District;
    } else {
      errorId.innerHTML = "No data found for this pincode.";
    }
  } catch (error) {
    console.error("Error:", error);
    errorId.innerHTML = "Failed to fetch data. Try again later.";
  }
}