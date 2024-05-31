const reservationDetails = new Map();

document.getElementById('reservForm').addEventListener('submit', function (event) { 
    var date = document.getElementById('ddate').value;
    var time = document.getElementById('ttime').value;
    var no = document.getElementById('vvisitors').value;

    clearErrorMessage();

    if (date.trim() === '' || time.trim() === '' || no.trim() === '') {
        event.preventDefault();
        reservationDetails.set('error', 'Data not completed, please re-enter.');
        // var errorMessageElement = document.getElementById('errorMess');
        // errorMessageElement.innerHTML = 'Data not completed, please re-enter.';
    }
    else {
        if (!validNumber(no)) {   
            event.preventDefault();
            reservationDetails.set('error', 'Please enter a valid number of people!');
            // var errorMessageElement = document.getElementById('errorMess');
            // errorMessageElement.innerHTML = 'Please enter a valid number of people!';
        }
        else {
            var result = reserve(date, time, no);
            displayReservationMessage(result);
            event.preventDefault(); // Prevent form submission
        }
    }
    const errorMessage = document.getElementById('errorMess');
    if (reservationDetails.has('error')) {
        errorMessage.innerHTML = reservationDetails.get('error');
    }
});

document.getElementById('reservForm').addEventListener('reset', function (event) { 
    clearErrorMessage();

    reservationDetails.clear();
});

function clearErrorMessage() {
    var errorMessageElement = document.getElementById('errorMess');
    errorMessageElement.innerHTML = '';

    if(reservationDetails.has('error')) {
        reservationDetails.delete('error');
    }
}

function validNumber(no) {
    no = Number(no);
    return Number.isInteger(no) && no > 0;
}

function displayReservationMessage(isSuccessful) {
    if (isSuccessful) {
        alert('Your reservation is successful!');
    } else {
        alert('Sorry, the reservation is full!');
    }
}

function reserve(date, time, no) {
    /*
    *data: the date of reservation
    *time: the time of reservation
    *no: the number of people, type: int
    */
    if (arguments.length != 3) {
        alert("incorrect arguments detected"); // this is not a good way to handle error, this alert should not be activated by your code
        return;
    }
    //an random int as the valid quota
    let valid_quota = Math.floor(Math.random() * 2.0 * no);
    if (no > valid_quota) return false // the quota is full
    else return true; // the quota is not full
}