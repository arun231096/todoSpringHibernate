(function ToDoList () {

	// getting the start and max value and load the list of toDo
	this.dataList = function(start, max) {
		var params  = { "start": start, "max": max}
		servicefunc("GET", "page?", $.param(params)); // ajax call
	}

	// read the specific data from the service using id
	this.readData = function(id) {
		var params  = { "id": id}
		servicefunc("GET", "read?", $.param(params)); // ajax call
	}

	// delete the specific data from the service using id
	this.deleteData = function(id) {
		var params  = { "id": id}
		servicefunc("GET", "delete?", $.param(params)); // ajax call
	}

}());

	