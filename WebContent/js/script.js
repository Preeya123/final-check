function validation() {
	var a=document.forms["Form"]["Title"].value;
		if(a==""){
			alert("Title is Required");
			return false;
		}
		if(a.length < 2 ||a.length > 100) {
	       alert("Title should have 2 to 100 characters");
		   return false;
		}
	var b=document.forms["Form"]["Gross"].value;
		if(b=="") {
			alert("price is Required");
			return false;
		}
	     r=/[^0-9]/;
		if(r.test(b)) {
			alert("Box Office has to be a number");
			return false;
		}
	var c=document.forms["Form"]["txt"].value;
		if(c=="") {
			alert("Date of launch is Required");
			return false;
		}
	
}