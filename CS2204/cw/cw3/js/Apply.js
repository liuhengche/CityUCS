var eng = document.getElementById("engineering");
var sci = document.getElementById("science");
var int = document.getElementById("interdis");

var engHead = document.getElementById("Eng");
var sciHead = document.getElementById("Sci");
var intHead = document.getElementById("Inter");

const majors = ["BSc in Computer Science and Technology", "BEng in Electronic Information", 
"BEng in Materials Science and Engineering", "MBEng in Materials and Chemicals", 
"BSc in Electronic Science and Technology", "BSc in Physics", "BSc in Chemistry", 
"BSc in Biology", "BSc in Cognitive Science", "BEng in Biomedical Engineering", "BSc in Biology and Medicine"];


window.onload = function() { 
    eng.style.display = "block";
    engHead.style.backgroundColor = "white";
};

engHead.onclick = function() { 
    eng.style.display = "block";
    sci.style.display = "none";
    int.style.display = "none";
    engHead.style.backgroundColor = "white";
    sciHead.style.backgroundColor = "lightgrey";
    intHead.style.backgroundColor = "lightgrey";
};

sciHead.onclick = function() { 
    eng.style.display = "none";
    sci.style.display = "block";
    int.style.display = "none";
    engHead.style.backgroundColor = "lightgrey";
    sciHead.style.backgroundColor = "white";
    intHead.style.backgroundColor = "lightgrey";
};

intHead.onclick = function() { 
    eng.style.display = "none";
    sci.style.display = "none";
    int.style.display = "block";
    engHead.style.backgroundColor = "lightgrey";
    sciHead.style.backgroundColor = "lightgrey";
    intHead.style.backgroundColor = "white";
};

var buttons = document.getElementsByClassName("roc");
var ranks = document.getElementsByClassName("rank");
var tds = document.querySelectorAll("td");



for (let i = 0; i < buttons.length; i++) {
    var button = buttons[i];
    //let rank = ranks[i]; // why do we have to use let here?
    button.onclick = function() { 
        console.log(i);
        var rank = ranks[i];
        var rankVal = rank.value;
        if(rankVal.trim() == '' || Number.isInteger(Number(rankVal)) == false) {
            alert("Please enter the rank of chosen major");
        }
        else {
            if(Number(rankVal) >10 || Number(rankVal) < 1) {
                alert("Please enter the rank of chose major between 1 and 10");
            }
            else {
                if(checkDuplicateMajor(i) == false && checkDuplicateRank(Number(rankVal)) == false) {
                    writeTable(i, Number(rankVal));
                    showContent(i, Number(rankVal));
                }
            }
        }
    }
}

function checkDuplicateMajor(i) {
    for(let j = 0; j < 10; j++) {
        if(tds[3*j+1].innerHTML == majors[i]) {
            alert("You have already chosen this major");
            return true;
        }
    }
    return false;
}

function checkDuplicateRank(rankVal) {
    if(tds[3*rankVal-3].innerHTML != "") {
        alert("You have already chosen this rank");
        return true;
    }
    return false;
}

function showContent(i,rankVal) {   
    var colMes;
    var majMes;
    var ranMes;
    if(i <= 4) {
        colMes = "College of Engineering";
        switch(i) {
            case 0:
                majMes = "BSc in Computer Science and Technology";
                break;
            case 1:
                majMes = "BEng in Electronic Information";
                break;
            case 2:
                majMes = "BEng in Materials Science and Engineering";
                break;
            case 3:
                majMes = "MBEng in Materials and Chemicals";
                break;
            case 4:
                majMes = "BSc in Electronic Science and Technology";
                break;
        }
    }
    else if(i <= 7) {
        colMes = "College of Science";
        switch(i) {
            case 5:
                majMes = "BSc in Physics";
                break;
            case 6:
                majMes = "BSc in Chemistry";
                break;
            case 7:
                majMes = "BSc in Biology";
                break;
        }
    }
    else if(i <= 10) {
        colMes = "College of Interdisciplinary Studies";
        switch(i) {
            case 8:
                majMes = "BSc in Cognitive Science";
                break;
            case 9:
                majMes = "BEng in Biomedical Engineering";
                break;
            case 10:
                majMes = "BSc in Biology and Medicine";
                break;
        }
    }
    switch(rankVal) { 
        case 1:
            ranMes = "1st";
            break;
        case 2:
            ranMes = "2nd";
            break;
        case 3:
            ranMes = "3rd";
            break;
        default:
            ranMes = rankVal + "th";
            break;
    }
    alert("You have chosen " + majMes  + " as your " + ranMes + " chosen major in " + colMes + " successfully");
}

function writeTable(i,rankVal) {
    if(i<=4) {
        tds[3*rankVal-3].innerHTML = "College of Engineering";
        switch(i) {
            case 0:
                tds[3*rankVal-2].innerHTML = "BSc in Computer Science and Technology";
                break;
            case 1:
                tds[3*rankVal-2].innerHTML = "BEng in Electronic Information";
                break;
            case 2:
                tds[3*rankVal-2].innerHTML = "BEng in Materials Science and Engineering";
                break;
            case 3:
                tds[3*rankVal-2].innerHTML = "MBEng in Materials and Chemicals";
                break;
            case 4:
                tds[3*rankVal-2].innerHTML = "BSc in Electronic Science and Technology";
                break;
        }
    }
    else if(i <= 7 ) {
        tds[3*rankVal-3].innerHTML = "College of Science";
        switch(i) {
            case 5:
                tds[3*rankVal-2].innerHTML = "BSc in Physics";
                break;
            case 6:
                tds[3*rankVal-2].innerHTML = "BSc in Chemistry";
                break;
            case 7:
                tds[3*rankVal-2].innerHTML = "BSc in Biology";
                break;
        }
    }
    else if(i <= 10) {
        tds[3*rankVal-3].innerHTML = "College of Interdisciplinary Studies";
        switch(i) {
            case 8:
                tds[3*rankVal-2].innerHTML = "BSc in Cognitive Science";
                break;
            case 9:
                tds[3*rankVal-2].innerHTML = "BEng in Biomedical Engineering";
                break;
            case 10:
                tds[3*rankVal-2].innerHTML = "BSc in Biology and Medicine";
                break;
        }
    }
}

var submit = document.getElementById("submit");
var clear = document.getElementById("clear");
var display = document.getElementById("display");
var total = document.getElementById("total");   
var time = document.getElementById("time");

submit.addEventListener("click", updateTable);

class DateTime {
    constructor() {
        const now = new Date();
        this.year = now.getFullYear();
        this.month = (now.getMonth() + 1).toString().padStart(2, "0");
        this.day = now.getDate().toString().padStart(2, "0");
        this.hour = now.getHours().toString().padStart(2, "0");
        this.minute = now.getMinutes().toString().padStart(2, "0");
        this.second = now.getSeconds().toString().padStart(2, "0");
      }
      generateFormattedDateTime() {
        return (
          this.year +
          "/" +
          this.month +
          "/" +
          this.day +
          " " +
          this.hour +
          ":" +
          this.minute +
          ":" +
          this.second
        );
      }
}

function updateTable() {
    clearMessage();
    if(checkEmpty() == false && checkGap() == false) {
        var count = countMajor();
        var now = new DateTime();
        var mes = "You have successfully submitted your application at time " + now.generateFormattedDateTime();
        display.innerHTML = mes;
        total.innerHTML = "Total Number of Major Applied: " + count;
        time.innerHTML = "Last change time: " + now.generateFormattedDateTime();
    }
}

function clearTable() { 
    clearMessage();
    for(let i = 0; i < 10; i++) {
        tds[3*i].innerHTML = "";
        tds[3*i+1].innerHTML = "";
    }
    var now = new DateTime();
    time.innerHTML = "Last change time: " + now.generateFormattedDateTime();
    total.innerHTML = "Total Number of Major Applied: 0";
}

function checkGap() {
    var gap = false;
    var gapIdx = [];
    var gapMes = [];
    var gapi = 0;
    while(gapi < 10) {
        for(let j = gapi+1; j<10; j++) {
            if(tds[3*gapi].innerHTML == "" && tds[3*j].innerHTML != "" && tds[3*(j-1)].innerHTML == "") {
                gap = true;
                for(let k = gapi; k < j; k++) {
                    gapIdx.push(k+1);
                }
                gapi = j-1;
                break;
            }
        }
        gapi++;
    }

    for(var i = 0; i<gapIdx.length; i++) {
        switch(gapIdx[i]) {
            case 1:
                gapMes.push("1st chosen major");
                break;
            case 2:
                gapMes.push("2nd chosen major");
                break;
            case 3:
                gapMes.push("3rd chosen major");
                break;
            default:
                gapMes.push(gapIdx[i] + "th chosen major");
                break;
        }

    }
    if (gap) {
        var mes = "You have not chosen your ";
        mes += gapMes.join(", and ");
        mes += ", you cannot leave any gap between your majors";
        display.innerHTML = mes;
        display.setAttribute("style", "color:red");
        display.setAttribute("style", "text-align:center");
    } 
    return gap;
}

function checkEmpty() {
    for(let i = 0; i < 10; i++) {
        if(tds[3*i].innerHTML != "") {
            return false;
        }

    }

    var emptyMes = "You have not chosen any major";
    display.innerHTML = emptyMes;
    display.setAttribute("style", "color:red");
    display.setAttribute("style", "text-align:center");
    return true;
}

function countMajor() {
    var count = 0;
    for(let i = 0; i < 10; i++) {
        if(tds[3*i].innerHTML != "") {
            count++;
        }
    }
    return count;
}

function clearMessage() {
    document.getElementById('display').innerHTML = '';
}










































