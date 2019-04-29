// gather the ToDo data from and validating then send to the todo service via Ajax call
$("#add").click(function(){
	validate($("form").serializeArray());
	servicefunc("POST", $('form').attr("action"), $('form').serialize());
});