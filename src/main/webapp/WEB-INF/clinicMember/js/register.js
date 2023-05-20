const btn1 = document.querySelector('#btn1');

btn1.addEventListener('click', () => {
  const clinicName = document.querySelector('#clinicName').value;
  const clinicPrincipal = document.querySelector('#clinicPrincipal').value;
  const clinicEmail = document.querySelector('#clinicEmail').value;
  const clinicPassword = document.querySelector('#clinicPassword').value;
  const clinicPhone = document.querySelector('#clinicPhone').value;
  const clinicAddress = document.querySelector('#clinicAddress').value;
  const clinicService = document.querySelector('#clinicService').value;

  const formData = {
    clinicName,
    clinicPrincipal,
    clinicEmail,
    clinicPassword,
    clinicPhone,
    clinicAddress,
    clinicService,
  };

  fetch('clinicMember/register', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(formData),
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