$(document).ready(function() {
		$(document).ready(function() {

			$('#settings').validate({
				rules : {

					finerate : {
						required : true,
							 number:true
							 
				},
				
					bookduration : {
						required : true,
							 number:true
							 
				}
				
				
				
				}

			});

		});

	});