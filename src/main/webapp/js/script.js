window.onload = function(){
	//document.querySelector('#getTask').onclick = function(){
		fetch('tasks?section=today').then(res => res.json()).then((data)=>{console.log(data);})
//		fetch('tasks?section=today')
//		.then(function(response) {
//			return response.json();
//		})
//		.then(function(myJson){
//			console.log(JSON.stringify(myJson));
//		});
	//}	
};

//function showtask(){
//	window.onload() = function() {
//		var data = JSON.parse();
//	}
//}


function getTask(){
	request = new XMLHttpRequest();
	 request.onreadystatechange = function(){
		 if(request.readyState == 4 && request.status == 200){
			 var jsonData = JSON.parse(request.responseText);
			 for(i =0; i < jsonData.length; i ++){
				 document.querySelector('#contentTask').innerHTML = jsonData;
				 }
			 if(jsonData == null){
				 alert("you do not have any assignments for today");
			 }
		 }
	 }
	 console.warn(request.responseText);
	 request.open('GET','tasks?section=today');
	 request.send();
}
