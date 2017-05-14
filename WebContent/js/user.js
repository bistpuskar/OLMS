$(document).ready(function() {
	$(document).ready(function() {

		$('#userform').validate({
			rules : {

				username : {
					required : true
					

				},
				password : {
					required : true
				
				},
				fname : {
					required : true
					
				},
				lname : {
					required : true
				
				},
				email : {
					required : true,
					email : true
				},
				address : {
					required : true,
				
				},
				searchuser : {
					required : true

				},
				gender : {
					required : true

				},
				registerdate : {
					required : true

				},
				expiredate : {
					required : true

				}

			}

		});

	});

});