window.onload = function(){
	document.getElementById("select").onclick = function(){
//		var me =this;
		$.ajax({
			url:"http://localhost:8080/myweb/getData",
			dataType:"json",
			//data:,
			type:"get",
			success:function(e){
				alert("success");
			},
			error:function(e){
				alert("fail");
			}
		})
	}
}