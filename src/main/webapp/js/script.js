function getTableRow(item) {
	if (!item) {
		return;
	}
	return 	'<tr>' +
			'  <td><input type="checkbox" name="' + item.idtasks + '"> </td>'+
			'  <td>' + item.header + '</td>' +
			'  <td>' + item.description + '</td>' +
			'  <td>' + item.dateCreate + '</td>' +
			'  <td>' + item.dateModified + '</td>' +
			'  <td>' + item.report + '</td>' +
			'  <td><input class="file-'+ item.idtasks +'" type = "file" name = "file"></td>' +
			'  <td><input type="button" class="upload-file-button" data-task-id="' + item.idtasks + '"> </td>' +
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
		.then((res) => res.json())
		.then((data) => loadToTemplate(tasksNode, data))
		.then(() => {
			const uploadButtons = [...document.querySelectorAll('.upload-file-button')];
			uploadButtons.forEach(button => {
				button.addEventListener('click', event => uploadFile(event.target.dataset.taskId));
			});
		});
}

function deleteTasks(getIdTask){
	return fetch('DeleteTasks', { 
			method: 'POST',
			body: JSON.stringify(getIdTask)
		})
		.then(function(response) {
			console.log("Delete");
			//return response.getIdTasks;
		});
}

function deleteTasksInDb(getIdTask){
	return fetch('DeletTaskinDataBase', { 
			method: 'POST',
			body: JSON.stringify(getIdTask)
		})
		.then(function(response) {
			console.log("Delete");
			//return response.getIdTasks;
		});
}

function executedTasks(getIdTask){
	return fetch('ExecutedTasks', { 
			method: 'POST',
			body: JSON.stringify(getIdTask)
		})
		.then(function(response) {
			console.log("excuted");
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
const excuted = document.getElementById('excuted');
const delInDB = document.getElementById('delInDB');

const uploadButtons = [...document.querySelectorAll('.upload-file-button')];

console.log(uploadButtons);

//document.addEventListener('click', function(){
//	setUploadFile();
//});

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
excuted.addEventListener('click', function() {
	executedTasks(getTasksIds());
});

delInDB.addEventListener('click', function () {
	deleteTasksInDb(getTasksIds());	
});


function getTasksIds(){
	const items = [...document.querySelectorAll('input[type="checkbox"]')]
		.filter((elem = {}) => elem.checked)
		.map((elem = {}) => elem.name);
	console.log(JSON.stringify(items))
	return items;
}

function uploadFile(taskId){
	const input = document.querySelector('.file-' + taskId);
	if (!input) {
		return;
	}	
	const data = new FormData();
	
	data.append('file', input.files[0])
	data.append('taskId', taskId)
	
	return fetch('FileUploadServlet',{
		method: 'POST',
		body: data
	})
	.then((res) => res.json())
	.then(data => {
		console.log(data);
	});
}

