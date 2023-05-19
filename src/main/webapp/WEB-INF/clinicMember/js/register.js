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

  fetch('http://localhost:8080/tha101g2Test/clinicMember/register.html', {
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
        // 註冊成功的處理邏輯
      } else {
        // 註冊失敗的處理邏輯
      }
    })
    .catch(error => {
      // 處理發生的錯誤
    });
});
