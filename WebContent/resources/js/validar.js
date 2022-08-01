
 	(()=>{
      
 		  const forms = document.querySelectorAll('.needs-validation')
          const btn= document.querySelector('.btn1')
		   Array.prototype.slice.call(forms).forEach(form=>{
		    form.addEventListener('click',event=> {
		      if (!form.checkValidity()) 
		      {
		        event.preventDefault()
		        event.stopPropagation()
		      }
		      else{
		    	  btn.setAttribute("data-bs-target","#modalpopup");
	              btn.setAttribute("data-bs-toggle","modal");
	                
		      }
		      form.classList.add('was-validated')
		    }, false)
		})
 	})()
 	

 	
 	document.getElementById("alert").addEventListener('click', function (event)
 	{
 		$(".alert").alert('close');
 	})
 	