async function resendOtp(event){
event.preventDefault();
const identifier = document.getElementById("identifier").value;
const errorId = document.getElementById("resendError");
const response = await  axios.post("http://localhost:8080/TechRoute/resendOtp?identifier="+identifier);
if(response.data === "sent"){
    errorId.innerHTML = "OTP sent successfully wait for 30 seconds to resend OTP";
}else{
    errorId.innerHTML = "Error in resending OTP, please try again later";
}
document.getElementById("resendOtpBtn").disabled = true;
setTimeout(() => {
    document.getElementById("resendOtpBtn").disabled = false;
}, 30000);
}