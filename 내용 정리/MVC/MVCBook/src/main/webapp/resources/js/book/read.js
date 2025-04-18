const replyAdd = document.querySelector(".reply-add");
const itemsEl = document.querySelector(".items");
// const path = '${paceContext.request.contextPath}'

replyAdd.addEventListener('click',()=>{
	const content = document.querySelector('.reply-header textarea').value;
	axios
		.get(`${path}/book/reply/create?bookCode=${bookCode}&content=${content}`)
		.then((resp)=>{
			console.log(resp);
			document.querySelector('.reply-header textarea').value = '';
		})
		.catch((error)=>{console.log(error);})
	
	createReplyItem();
});

function receiveReplyData() {
	axios
		.get(`${path}/book/reply/list?bookCode=${bookCode}`)
		.then((resp)=>{
			// 기존 items의 노드 제거
			const itemsEl = document.querySelector('.reply-body .items')
			while(itemsEl.firstChild){
				itemsEl.removeChild(itemsEl.firstChild)
			}
			
			console.log(resp.data);
			const data = resp.data;
			const cnt = data.replyCnt;
			const items = data.replyList;
			items.forEach(item=>createReplyItem(item));
			const reCnt = document.querySelector('.reCnt');
			reCnt.innerHTML = cnt;
		})
		.catch((error)=>{console.log(error);})
}
receiveReplyData()

function createReplyItem(item){
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
	usernameEl.innerHTML = item.username;
	
	//right
	const rightEl = document.createElement('div');
	rightEl.className = 'right';
	const dateEl = document.createElement('div');
	dateEl.className = 'date';
	dateEl.innerHTML = item.createAt;
	const contentEl = document.createElement('div');
	contentEl.className = 'content'; 
	const textAreaEl = document.createElement('textarea'); 
	textAreaEl.value = item.content
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