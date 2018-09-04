window.onload = function(){
	document.querySelector('#getTask').onclick = function(){
		getTask();
	}
	
}

function getTask(){
	request = new XMLHttpRequest();
	 request.onreadystatechange = function(){
		 if(request.readyState == 4 && request.status == 200){
			 var jsonData = JSON.parse(request.responseText);
			 for(var i =0; i < request.length; i++){
				 document.querySelector('#contentTask').innerHTML = jsonData[i];
			 }
			 if(jsonData == null){
				 alert("you do not have any assignments for today");
			 }
		 }
	 }
	 request.open('GET','tasks?section=today');
	 request.send();
}
