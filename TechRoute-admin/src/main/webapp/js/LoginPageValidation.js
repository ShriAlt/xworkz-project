 async function validateIdentifier(){
  const identifier=document.getElementById("identifier").value;
   const submitBtn = document.getElementById("submitBtn");
  const errorSpan =  document.getElementById("identifierError");

 const isEmail = identifier.includes("@") && identifier.includes(".");
 const isPhone = /^[6-9]\d{9}$/.test(identifier);

 if (isEmail ) {
 const existEmail = await axios("http://localhost:8080/TechRoute/checkEmail?email="+identifier);
   if(existEmail.data === false){
     errorSpan.innerHTML="email is not registered , please use registered email"
     submitBtn.disabled = true;
     return false;
   }
   errorSpan.innerHTML = "";
   submitBtn.disabled = false;
   return true;
 }
 if(isPhone){
 const existPhone = await axios("http://localhost:8080/TechRoute/checkPhone?phone="+identifier);
    if(existPhone.data === false){
      errorSpan.innerHTML="phone number is not registered , please use registered phone number"
      submitBtn.disabled = true;
      return false;
    }
    errorSpan.innerHTML = "";
    submitBtn.disabled = false;
    return true;
 }
 else{
    errorSpan.innerHTML = "Login using a valid email or phone number";
 }
    return false;
}
