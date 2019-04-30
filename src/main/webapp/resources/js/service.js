// service calls are achieved by Ajax call
this.servicefunc = function(type,url,params){
	$.ajax({
		type: type,
		url: url,   
		data: params,
		success: function (data){
			$("#content").html(data);
		}
	});
}
