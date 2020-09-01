function validatePwds(){
//		alert("Function Called")
		var newPassword = $('#newPassword').val();
		var confirmPassword = $('#confirmPassword').val();
		
		if(newPassword!=confirmPassword){
//			alert("In If")
			$('#errId').text('New Password and Confirm Password Should be Same');
			return false
		}
//		alert("Afert If")
		return true;
}
