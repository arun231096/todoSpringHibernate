// common array list validation to carry the validation
validate = function(arg){

	var arrayerror = []; // collection of errors stored by this variable

	$.each(arg, function(i, field){
	      if(field.value == "") {
	    	  arrayerror.push(field.name + " is empty");
	    	  $("#"+field.name).css("background-color", "red"); // validation error that fields are highlighted by red color 
	      }
    });

	if (arrayerror.length > 0) {
		window.alert("please fill all the fields");
		throw 500;
	}
}
