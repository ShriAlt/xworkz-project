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
      stateSelect.innerHTML = `<option selected>${office.State}</option>`;
      cityInput.value = office.District;
    } else {
      errorId.innerHTML = "No data found for this pincode.";
    }
  } catch (error) {
    errorId.innerHTML = "Failed to fetch data. Try again later.";
  }
}
 function validateName(){
    const name = document.getElementById('customerName');
    const nameError = document.getElementById('nameError');
    const namePattern = /^[A-Za-z\s]+$/;

    nameError.innerHTML = '';
    if (!namePattern.test(name)) {
        nameError.innerHTML = "Name can only contain letters and spaces.";
    }
 }
 function validateEmail(){
    const email = document.getElementById('email');
    const emailError = document.getElementById('emailError');
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    emailError.innerHTML = '';
    if (!emailPattern.test(email)) {
        emailError.innerHTML = "Please enter a valid email address.";
    }
 }
  function  validateContact(){
    const contact = document.getElementById('contactNumber');
    const contactError = document.getElementById('contactError');
    const contactPattern = /^\d{10}$/;

    contactError.innerHTML = '';
    if (!contactPattern.test(contact)) {
        contactError.innerHTML = "Contact number must be a 10-digit number.";
    }
    }
 function validateGST(){
    const gst = document.getElementById('gstNumber');
    const gstError = document.getElementById('gstError');
    const gstPattern = /^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$/;

    gstError.innerHTML = '';
    if (!gstPattern.test(gst)) {
        gstError.innerHTML = "Please enter a valid GST number.";
    }
    }
function copyBillingAddress() {
    const copyAddressCheckbox = document.getElementById('sameAddress')
 const billingAddress = document.getElementById('billingAddress').value;
    const shippingAddress = document.getElementById('shippingAddress');

    if (copyAddressCheckbox.checked){
        shippingAddress.value = billingAddress;
    } else {
        shippingAddress.value = '';
}
