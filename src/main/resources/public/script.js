const URL = 'http://localhost:8081';
let entries = [];
let mode = 'create';
let currentFahrrad;

// API Requests
const createFahrrad = (fahrrad) => {
    fetch(`${URL}/fahrrads`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(fahrrad)
    }).then((result) => {
        result.json().then((fahrrad) => {
            entries.push(fahrrad);
            renderEntries();
        });
    });
};

const indexFahrrads = () => {
    fetch(`${URL}/fahrrads`, {
        method: 'GET'
    }).then((result) => {
        result.json().then((result) => {
            fahrrads = result;
            renderFahrrads();
        });
    });
    renderFahrrads();
};

const deleteFahrrad = (id) => {
    fetch(`${URL}/fahrrads/${id}`, {
        method: 'DELETE'
    }).then((result) => {
        indexFahrrads();
    });
};

const updateFahrrad = (fahrrad) => {
    fetch(`${URL}/fahrrads/${fahrrad.id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(fahrrad)
    }).then((result) => {
        result.json().then((fahrrad) => {
            fahrrads = fahrrads.map((e) => e.id === fahrrad.id ? fahrrad : e);
            renderFahrrad();
        });
    });
}

// Rendering
const resetForm = () => {
    const fahrradForm = document.querySelector('#fahrradForm');
    fahrradForm.reset();
    mode = 'create';
    currentFahrrad = null;
}

const saveForm = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const fahrrad = {};
    fahrrad['fahrradType'] = formData.get("fahrradType");
    fahrrad['marke'] = formData.get("marke");

    if (mode === 'create') {
        createFahrrad(fahrrad);
    } else {
        fahrrad.id = currentFahrrad.id;
        updateFahrrad(fahrrad);
    }
    resetForm();
}

const editFahrrad = (fahrrad) => {
    mode = 'edit';
    currentFahrrad = fahrrad;

    const fahrradForm = document.querySelector('#fahrradForm');
    const checkFahrradTypeField = fahrradForm.querySelector('[name="fahrradType"]');
    checkFahrradTypeField.value = fahrrad.fahrradType;
    const checkMarke = fahrradForm.querySelector('[name="marke"]');
    checkMarke.value = fahrrad.marke;

};

const createCell = (text) => {
    const cell = document.createElement('td');
    cell.innerText = text;
    return cell;
};

const createActions = (fahrrad) => {
    const cell = document.createElement('td');

    const deleteButton = document.createElement('button');
    deleteButton.innerText = 'Delete';
    deleteButton.addEventListener('click', () => deleteFahrrad(fahrrad.id));
    cell.appendChild(deleteButton);

    const editButton = document.createElement('button');
    editButton.innerText = 'Edit';
    editButton.addEventListener('click', () => editFahrrad(fahrrad));
    cell.appendChild(editButton);

    return cell;
}

const renderFahrrads = () => {
    const display = document.querySelector('#fahrradDisplay');
    display.innerHTML = '';
    fahrrads.forEach((fahrrad) => {
        const row = document.createElement('tr');
        row.appendChild(createCell(fahrrad.id));
        row.appendChild(createCell(fahrrad.fahrradType.type));
        row.appendChild(createCell(fahrrad.marke.markenType));
        row.appendChild(createActions(fahrrad));
        display.appendChild(row);
    });
};

document.addEventListener('DOMContentLoaded', function(){
    const fahrradForm = document.querySelector('#fahrradForm');
    fahrradForm.addEventListener('submit', saveForm);
    fahrradForm.addEventListener('reset', resetForm);
    indexFahrrads();
});