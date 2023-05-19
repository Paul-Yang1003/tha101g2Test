(() => {
	const btn1 = document.querySelector('#btn1');
	const msg = document.querySelector('#msg');
	const clinicName = document.querySelector('#clinicName');
	const clinicPrincipal = document.querySelector('#clinicPrincipal');
	const clinicEmail = document.querySelector('#clinicEmail');
	const clinicPassword = document.querySelector('#clinicPassword');
	const clinicPhone = document.querySelector('#clinicPhone');
	const clinicAddress = document.querySelector('#clinicAddress');
	const clinicService = document.querySelector('#clinicService');
	
	
	const inputs = document.querySelectorAll('input');
	btn1.addEventListener('click', () => {
	
		fetch('http://localhost:8080/tha101g2Test/index.html', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify({
				clinicName: clinicName.value,
				
			}),
		})
			.then(resp => resp.json())
			.then(body => {
				const { successful } = body;
				if (successful) {
					for (let input of inputs) {
						input.disabled = true;
					}
					btn1.disabled = true;
					msg.className = 'info';
					msg.textContent = '註冊成功';
				} else {
					msg.className = 'error';
					msg.textContent = '註冊失敗';
				}
			});
	});

})();