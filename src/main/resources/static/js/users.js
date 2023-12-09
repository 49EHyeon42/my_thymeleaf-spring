function registerUser() {
    const name = document.getElementById('name').value;

    fetch('/api/users', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name }),
    })
        .then(response => {
            if (response.status == 200) {
                // 등록 후 알림
                alert('등록이 완료되었습니다.');

                // Modal 닫기
                document.getElementById('registerModal').classList.remove('show');
                document.body.classList.remove('modal-open');
                const backdrop = document.getElementsByClassName('modal-backdrop');
                if (backdrop[0]) {
                    backdrop[0].remove();
                }
            }

            findAll();
        })
        .catch(error => {
            console.error(error);
        });
}

function findAll() {
    const userTableBody = document.getElementById('userTableBody');

    fetch('/api/users')
        .then(response => response.json())
        .then(users => {
            // 테이블 초기화
            userTableBody.innerHTML = '';

            users.forEach(user => {
                const row = document.createElement('tr');

                const idCell = document.createElement('td');
                idCell.textContent = user.id;
                row.appendChild(idCell);

                const nameCell = document.createElement('td');
                nameCell.textContent = user.name;
                row.appendChild(nameCell);

                const createdDateCell = document.createElement('td');
                createdDateCell.textContent = user.createdDate;
                row.appendChild(createdDateCell);

                userTableBody.appendChild(row);
            });
        })
        .catch(error => {
            console.error(error);
        });
}
