function validatePasswords(){
 const password = document.getElementById("password").value.trim();
  const confirmPassword = document.getElementById("confirmPassword").value.trim();
  const passwordError = document.getElementById("PasswordError");
  const confirmPasswordError = document.getElementById("confirmPasswordError");
   const submitBtn = document.getElementById("submitBtn");
  const strengthRegex = ^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$;

  if (!strengthRegex.test(password)) {
    passwordError.innerHTML = "Password must be at least 8 characters long and include letters and numbers";
    submitBtn.disabled = true;
    return false;
  }
  passwordError.innerHTML = "";
  if (password !== confirmPassword) {
    confirmPasswordError.innerHTML = "Passwords do not match";
    submitBtn.disabled = true;
    return false;
  }
  confirmPasswordError.innerHTML = "";
  submitBtn.disabled = false;
  return true;
}