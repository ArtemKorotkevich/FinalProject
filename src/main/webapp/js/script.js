function getTableRow(item) {
	if (!item) {
		return;
	}
	return 	'<tr>' +
			'  <td><input type="checkbox" name="task-' + item.idtasks + '"> </td>'+
			'  <td>' + item.header + '</td>' +
			'  <td>' + item.description + '</td>' +
			'  <td>' + item.dateCreate + '</td>' +
			'  <td>' + item.dateModified + '</td>' +
			'  <td>' + item.report + '</td>' +
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

function deleteTasks(getIdTasks){
	return fetch('DeleteTasks', { 
			method: 'POST',
			body: JSON.stringify(getIdTasks)
		})
		.then(function(response) {
			console.log("Delete");
			//return response.getIdTasks;
		});
}

const tasksNode = document.getElementById('tasksBody');
const todayTasks = document.getElementById('todayTasks');
const tomorrowTasks = document.getElementById('tomorrowTasks');
const somedayTasks = document.getElementById('somedayTasks');
const fixedTasks = document.getElementById('fixedTasks');
const recycle_binTasks = document.getElementById('recycle_binTasks');
const del = document.getElementById('delete');


document.addEventListener('DOMContentLoaded', function() {
	loadData('tasks?section=alltask');		
});

todayTasks.addEventListener('click', function() {
	loadData('tasks?section=today');		
}); 

tomorrowTasks.addEventListener('click', function() {
	loadData('tasks?section=tomorrow');		
});

somedayTasks.addEventListener('click', function() {
	loadData('tasks?section=someday');		
});

fixedTasks.addEventListener('click', function() {
	loadData('tasks?section=fixed');		
});

recycle_binTasks.addEventListener('click', function() {
	loadData('tasks?section=recycle_bin');		
});

del.addEventListener('click', function() {
	deleteTasks(getTasksIds());
});


function getTasksIds(){
	const items =	[...document.querySelectorAll('input[name^="task-"][type="checkbox"]')]
		.filter((elem = {}) => elem.checked)
		.map((elem = {}) => elem.name);
	console.log(JSON.stringify(items))
	return items;
}

//body !!!
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
