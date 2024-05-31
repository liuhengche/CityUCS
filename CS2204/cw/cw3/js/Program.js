const prompt = [
    "<h2>Join Hong Kong Industrial University's College of Science for world-class education and research opportunities in science and technology! 20 QUOTAS LEFT!</h2>",
    "<h2>Join the future of engineering with Hong Kong Industrial University's College of Engineering, offering innovative programs and world-class faculty to prepare you for success in the field! 40 QUOTAS LEFT!</h2>",
    "<h2>Join the future of interdisciplinary studies with Hong Kong Industrial University's College of Interdisciplinary Studies, offering innovative programs and world-class faculty to prepare you for success in various fields! 30 QUOTAS LEFT!</h2>"
  ];

var curIdx = 0;

function displayPrompt() {
  document.getElementById("promptCon").innerHTML = prompt[curIdx];
  curIdx++;
  if (curIdx >= prompt.length) {
    curIdx = 0;
  }
  setTimeout(displayPrompt, 3000);
}

var firIdx = Math.floor(Math.random() * prompt.length);
curIdx = firIdx;

window.addEventListener('load', displayPrompt);

var firVid = document.getElementById('firVid');
var secVid = document.getElementById('secVid');

firVid.style.display = "none";

function switchVideos() {
  if (firVid.style.display == "none") {
    firVid.style.display = "block";
    secVid.style.display = "none";
    firVid.play();
  } else {
    firVid.style.display = "none";
    secVid.style.display = "block";
    secVid.play();
  }
}

firVid.addEventListener('ended', switchVideos);
secVid.addEventListener('ended', switchVideos);

