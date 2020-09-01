$(document).ready(function(event) {
	$("#countryId").change(function() {
		$("#stateId").find('option').remove();
		$('<option>').val('').text('---Select---').appendTo("#stateId");
		
		$("#cityId").find('option').remove();
		$('<option>').val('').text('---Select---').appendTo("#cityId");
		
		var countryId = $("#countryId").val();
		$.ajax({
			type : "GET",
			url : "getstates?cntryId=" + countryId,
			success : function(response){
//				alert(response); 
				$.each(response, function(stateId, stateName){
					$('<option>').val(stateId).text(stateName).appendTo("#stateId");
				});
			}
		});
	});
	
	$("#stateId").change(function(){
		$("#cityId").find('option').remove();
		$('<option>').val('').text('---Select---').appendTo("#cityId");
		
		var stateId = $("#stateId").val();
		$.ajax({
			type : "GET",
			url : "getcities?statId=" + stateId,
			success : function(data){
				$.each(data, function(cityId, cityName){
					$('<option>').val(cityId).text(cityName).appendTo("#cityId");
				});
			}
		});
	
	});
	
});