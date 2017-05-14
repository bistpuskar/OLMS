$(document).ready(function() {
		$(document).ready(function() {

			$('#formregister').validate({
				rules : {

					bookname : {
						required : true,
						
					},
					
					authorname : {
						required : true,
						lettersonlys:true
						
					},
					isbn : {
						required : true
					},
					publicationname : {
						required : true,
						lettersonlys:true
						
						
					      
					},
					publicationyear : {
						required : true
					},
					purchasedate : {
						required : true
					},
					bookcategory : {
						required : true,
						lettersonlys:true
					},
					booknumber : {
						required : true,
						number:true
					},
					bookcost : {
						required : true,
						number:true
					},
					category : {
						required : true,
						lettersonlys:true
						
					
					},
					searchbook:{
						required:true
					}
					
				}

			});

		});

	});