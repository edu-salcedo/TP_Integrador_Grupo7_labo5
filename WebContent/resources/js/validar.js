
 	(()=>{
 		  const forms = document.querySelectorAll('.needs-validation')

		Array.prototype.slice.call(forms).forEach(form=>{
		    form.addEventListener('click',event=> {
		      if (!form.checkValidity()) 
		      {
		        event.preventDefault()
		        event.stopPropagation()
		      }
		      form.classList.add('was-validated')
		    }, false)
		})
 	})()
 	
 	document.getElementById("alert").addEventListener('click', function (event)
 	{
 		$(".alert").alert('close');
 	})
 	
 	function form_submit() 
 	  {
 	    document.getElementById("form").submit();
 	   }    

 