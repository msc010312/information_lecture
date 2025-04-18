const replyAdd = document.querySelector(".reply-add");
const itemsEl = document.querySelector(".items");
// const path = '${paceContext.request.contextPath}'

replyAdd.addEventListener('click',()=>{
	axios
		.get(`${path}/book/reply/create`)
		.then((resp)=>{console.log(resp);})
		.catch((error)=>{console.log(resp);})
	
	//createReplyItem();
});

function createReplyItem(){
	//item
	const itemEl = document.createElement('div');
	itemEl.className = 'item';
	
	// left
	const leftEl = document.createElement('div');
	leftEl.className = 'left';
	const profileEl = document.createElement('div');
	profileEl.className = 'profile';
	profileEl.innerHTML = 'profile';
	const usernameEl = document.createElement('div');
	usernameEl.className = 'username';
	usernameEl.innerHTML = 'username';
	
	//right
	const rightEl = document.createElement('div');
	rightEl.className = 'right';
	const dateEl = document.createElement('div');
	dateEl.className = 'date';
	dateEl.innerHTML = '2025-01-01';
	const contentEl = document.createElement('div');
	contentEl.className = 'content'; 
	const textAreaEl = document.createElement('textarea'); 
	const buttonGroupEl = document.createElement('div');
	buttonGroupEl.className = 'buttonGroup';
	
	itemEl.appendChild(leftEl);
	itemEl.appendChild(rightEl);
	
	leftEl.appendChild(profileEl);
	leftEl.appendChild(usernameEl);
	
	rightEl.appendChild(dateEl);
	rightEl.appendChild(contentEl);
	
	contentEl.appendChild(textAreaEl);
	
	rightEl.appendChild(buttonGroupEl);
	
	itemsEl.appendChild(itemEl);
};