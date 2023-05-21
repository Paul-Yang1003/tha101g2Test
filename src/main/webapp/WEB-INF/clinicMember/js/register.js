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
            for (let Member of Member) {
                console.log(Member)
            }

        });
});
