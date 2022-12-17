 let curI = 0;
    let head = document.querySelector(".item");
    let content = document.querySelector(".content");
    let logContent = document.querySelector(".login");
    let regContent = document.querySelector(".register");
    head.addEventListener("click", (e) => {
      let activeI = Number(e.target.getAttribute("index"));
      if(curI == activeI) return;
      curI = activeI;	
      head.children[0].classList.toggle("active");
      head.children[1].classList.toggle("active");
      logContent.classList.toggle("active");
      regContent.classList.toggle("active");
    });
    let logForm =  document.querySelector("#logForm");
	const logSubmit = ()=>{
		const uname = logForm[0].value;
		const pwd = logForm[1].value;
		if(uname == "" || pwd == ""){
			alert("请检查输入");
			return;
		} 
		logForm.submit();
	}
	let regForm =  document.querySelector("#regForm");
	const regSubmit = ()=>{
		const uname = regForm[0].value;
		const name = regForm[1].value;
		const pwd =document.querySelector('#regPwd').value;
		const conPwd =document.querySelector('#regPwdConfirm').value;
		if(uname == "" || pwd == "" || conPwd == "" || name == ""){
			alert("请检查输入");
			return;
		}
		if(pwd !== conPwd){
			alert("两次密码不一致");
			return;
		}
		regForm.submit();
}