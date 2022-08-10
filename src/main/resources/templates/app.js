async function getCount(id) {
    const res = await fetch(`http://localhost:8081/counter/asdasd`, {method: 'GET',
        headers: {'Content-Type' : 'application/json'}
    });
    const counter = await res.json();
    console.log(counter);
    res.forEach(counts => countToHtml(counts))
}

window.addEventListener('DOMContentLoaded', getCount);

function countToHtml({id, counterId, count}) {
    const countList = document.getElementById('counts');
    countList.insertAdjacentHTML('beforeend', `
        <div class='form-check' id="${id}">
            <label class="form-check-label">
                <input type="checkbox" class="form-check-input">
                <h1>${counterId}</h1>
                <h1>${count}</h1>
            </label>
        </div>
    `)
}