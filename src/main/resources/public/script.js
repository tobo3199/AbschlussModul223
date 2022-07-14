const URL = 'http://localhost:8081';
let entries = [];
let mode = 'create';
let currentEntry;

const dateAndTimeToDate = (dateString, timeString) => {
    return new Date(`${dateString}T${timeString}`).toISOString();
};

// API Requests
const createEntry = (fahrrad) => {
    fetch(`${URL}/entries`, {
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

const indexEntries = () => {
    fetch(`${URL}/fahrrads`, {
        method: 'GET'
    }).then((result) => {
        result.json().then((result) => {
            entries = result;
            renderEntries();
        });
    });
    renderEntries();
};

const deleteEntry = (id) => {
    fetch(`${URL}/fahrrads/${id}`, {
        method: 'DELETE'
    }).then((result) => {
        indexEntries();
    });
};

const updateEntry = (fahrrad) => {
    fetch(`${URL}/fahrrads/${fahrrad.id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(fahrrad)
    }).then((result) => {
        result.json().then((fahrrad) => {
            fahrrads = fahrrads.map((e) => e.id === fahrrad.id ? fahrrad : e);
            renderEntries();
        });
    });
}

// Rendering
const resetForm = () => {
    const fahrradForm = document.querySelector('#fahrradForm');
    fahrrdForm.reset();
    mode = 'create';
    currentEntry = null;
}

const saveForm = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const fahrrad = {};
    fahrrad['checkIn'] = dateAndTimeToDate(formData.get('checkInDate'), formData.get('checkInTime'));
    fahrrad['checkOut'] = dateAndTimeToDate(formData.get('checkOutDate'), formData.get('checkOutTime'));

    if (mode === 'create') {
        createEntry(fahrrad);
    } else {
        fahrrad.id = currentEntry.id;
        updateEntry(fahrrad);
    }
    resetForm();
}

const editEntry = (fahrrad) => {
    mode = 'edit';
    currentEntry = fahrrad;

    const fahrradForm = document.querySelector('#fahrradForm');
    const checkInDateField = fahrradForm.querySelector('[name="fahrradType"]');
    const checkInTimeField = fahrradForm.querySelector('[name="marke"]');

}

const createCell = (text) => {
    const cell = document.createElement('td');
    cell.innerText = text;
    return cell;
};

const createActions = (fahrrad) => {
    const cell = document.createElement('td');

    const deleteButton = document.createElement('button');
    deleteButton.innerText = 'Delete';
    deleteButton.addEventListener('click', () => deleteEntry(fahrrad.id));
    cell.appendChild(deleteButton);

    const editButton = document.createElement('button');
    editButton.innerText = 'Edit';
    editButton.addEventListener('click', () => editEntry(fahrrad));
    cell.appendChild(editButton);

    return cell;
}

const renderEntries = () => {
    const display = document.querySelector('#fahrradDisplay');
    display.innerHTML = '';
    entries.forEach((fahrrad) => {
        const row = document.createElement('tr');
        row.appendChild(createCell(fahrrad.id));
        row.appendChild(createCell(new Date(fahrrad.checkIn).toLocaleString()));
        row.appendChild(createCell(new Date(fahrrad.checkOut).toLocaleString()));
        row.appendChild(createActions(fahrrad));
        display.appendChild(row);
    });
};

document.addEventListener('DOMContentLoaded', function(){
    const fahrradForm = document.querySelector('#fahrradForm');
    fahrradForm.addEventListener('submit', saveForm);
    fahrradForm.addEventListener('reset', resetForm);
    indexEntries();
});