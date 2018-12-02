/* general html elements */
let mId = document.getElementById("mId");
let mGroup = document.getElementById("mGroup");
let step = document.getElementById("step");
let indent = document.getElementById("indent");

// let userId = document.getElementById("userId");
let title = document.getElementById("title");
let content = document.getElementById("content");

/* REPLY SECTION */
// html elements
let replyText = document.getElementById("reply");
let replyBtn = document.getElementById("replyBtn");

// trigger ajax call when the button is clicked
replyBtn.addEventListener("click", reply);

// disable button until the textarea is filled
replyBtn.disabled = true;

replyText.addEventListener("keyup", function () {
    if (replyText.value === null || replyText.value.trim() === "") {
        replyBtn.disabled = true;
        replyBtn.style.cursor = "not-allowed";
        replyBtn.style.color = "rgb(215, 218, 220)";

        return false;
    }
    replyBtn.disabled = false;
    replyBtn.style.cursor = "pointer";
    replyBtn.style.color = "black";
});

// reply ajax call (using fetch) to controller
function reply() {
    let url = "boardReply.bo";
    let data = `mId=${mId.value}&mGroup=${mGroup.value}&step=${step.value}&indent=${indent.value}&userId=${userId.value}&title=${title.value}&content=${replyText.value}`;

    console.log(`${url}?${data}`);

    fetch(`${url}?${data}`)
        .then((resp) => resp.text())
        .then((data) => {
            if (data == 1) {
                alert("you will be redirected in 2 seconds");
                setTimeout(function () {
                    location.href = "boardList.bo";
                }, 2000);
            }
        })
}

/*====================================================================================================================*/

/* EDIT SECTION */
// edit button
let showEdit = document.getElementById("edit");
let cancelBtn = document.getElementById("cancelBtn");
let editContent = document.getElementById("editContent");

let editBtn = document.getElementById("editBtn");
editBtn.addEventListener("click", editContentFunc);

// disable edit button
editBtn.disabled = true;

// edit div
let editArea = document.getElementsByClassName("editArea");

// edit trigger
showEdit.addEventListener("click", editDisplay);
cancelBtn.addEventListener("click", cancelFunc);

// show edit section
function editDisplay() {
    editArea[0].style.display = "flex";
}

function cancelFunc() {
    editArea[0].style.display = "none";
    editContent.value = "";
}

// edit content
editContent.addEventListener("keyup", checkContent);

function checkContent() {
    if (editContent.value === null || editContent.value.trim() === "") {
        editBtn.disabled = true;
        editBtn.style.cursor = "not-allowed";
        editBtn.style.color = "rgb(215, 218, 220)";

        return false;
    }
    editBtn.disabled = false;
    editBtn.style.cursor = "pointer";
    editBtn.style.color = "black";
}

// edit function
// need mId, title (unchanged), content (new)
function editContentFunc() {
    let url = "boardUpdate.bo";
    let data = `mId=${mId.value}&title=${title.value}&content=${editContent.value}`;

    console.log(`${url}?${data}`);

    fetch(`${url}?${data}`)
        .then((resp) => resp.text())
        .then((data) => {
            if (data == 1) {
                location.href = `boardView.bo?mId=${mId.value}`;
            } else {
                alert("failed, try again");
            }
        })
}