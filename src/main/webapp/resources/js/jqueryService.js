$(document).ready(function(){

	// setting the pagination limit as constant starting at 0
	const limit = 10;
	var start =0;
	var max = limit;

	// calling paginated index list
	dataList(start, max);

	$("#back").prop('disabled', true); // initially disable the back button 

	// loading the next limited list page from the service
    $("#next").click(function() {
	   start = max;
	   max = max + limit;
	   $("#back").prop('disabled', false);
	   dataList(start, max);
    });

    // loading the back of the list page from the service
    $("#back").click(function() {
 	   max = start;
 	   start = start - limit;
 	   $("#next").prop('disabled', false);
 	   if (start == 0 && max == limit) {
 		   $("#back").prop('disabled', true);
 	   }
 	   dataList(start, max);
    });

    // clear all the changes and sets the index page with initial setup
    $("#clear").click(function(){
 	   start = 0;
 	   max = limit;
 	   $("#title_search").val("");
 	   $("#next").prop('disabled', false);
 	   dataList(start, max);
    });

    // search the list of todo list based on the title
    $("#title_search").keydown(function(){
 	   var params  = { "title": $("#title_search").val() }
 	   servicefunc("GET", "search?", $.param(params)); // ajax call
    });

    // function returning the create view page for add Todo to user
    $("#addtodo").click(function(){
 	   var params  = {  }
 	   servicefunc("GET", "todo/create", $.param(params)); // ajax call
   });

});
