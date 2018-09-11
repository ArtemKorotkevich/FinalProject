function getTableRow(item) {
	if (!item) {
		return;
	}
	return 	'<tr>' +
			'  <td>' + item.description + '</td>' +
			'  <td>' + item.dateCreate + '</td>' +
			'  <td>' + item.dateModified + '</td>' +
			'  <td><input name="report" type="checkbox" value="' + item.report + '"></td>' +
			'  <td><input name="taskId" type="hidden" value="' + item.idtasks + '"></td>' +
			'</tr>';
}

function loadToTemplate(node, data) {
	if (!Array.isArray(data) || !node) {
		return;
	}
	node.innerHTML = data.map(function(item) {
		return getTableRow(item);
	});
}

function loadData(url){
	return fetch(url)
		.then(function(res) {
			return res.json();
		})
		.then(function(data) {
			loadToTemplate(tasksNode, data);
		});
}

const tasksNode = document.getElementById('tasksBody');
const todayTasks = document.getElementById('todayTasks');
const tomorrowTasks = document.getElementById('tomorrowTasks');

document.addEventListener('DOMContentLoaded', function() {
	loadData('tasks?section=today');		
});

todayTasks.addEventListener('click', function() {
	loadData('tasks?section=today');		
});

tomorrowTasks.addEventListener('click', function() {
	loadData('tasks?section=tomorrow');		
});




//window.onload = function(){
//
//	document.querySelector('#getTask').onclick = function(){
//		//fetch('tasks?section=today').then(res => res.json()).then((data)=>{console.log(data);})
//		fetch('tasks?section=today')
//		.then(function(response) {
//			return response.json();
//		})
//		.then(function(myJson){
//			document.getElementById("tasks").innerHTML =(myJson);
//		});
//	}	
//};


//function getTask(){
//	request = new XMLHttpRequest();
//	 request.onreadystatechange = function(){
//		 if(request.readyState == 4 && request.status == 200){
//			 var jsonData = JSON.parse(request.responseText);
//			 for(i =0; i < jsonData.length; i ++){
//				 document.querySelector('#contentTask').innerHTML = jsonData;
//				 }
//			 if(jsonData == null){
//				 alert("you do not have any assignments for today");
//			 }
//		 }
//	 }
//	 console.warn(request.responseText);
//	 request.open('GET','tasks?section=today');
//	 request.send();
//}
