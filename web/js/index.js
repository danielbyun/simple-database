let mGroup = document.getElementsByClassName("mGroup");
let mGroupArr = [];
let replyBoard = document.getElementById("replyBoard");
let editContent = document.getElementById("editContent");

// retrieve each mGroup number from each board
for (let i = 0; i < mGroup.length; i++) {
    mGroupArr.push(`${mGroup[i].value}`);
}

let url = "boardCommentCount.bo";
let data = `mGroupArr=${mGroupArr}`;

// jquery scroll detection v2 (feature not implemented yet)
$(window).scroll(function () {
    if ($(window).scrollTop() + $(window).height() === getDocHeight()) {
        alert("bottom!");
    }

    // ajax call to retrieve more boards
    let url = "";
    let data = ``;

    fetch(`${url}?${data}`)
        .then((resp) => resp.text())
        .then(data => function () {
            if (data == 1) {
                console.log("successful");
            } else {
                console.log("failed");
            }
        })
});

// get document height for different browsers, different machines
function getDocHeight() {
    let D = document;

    return Math.max(
        D.body.scrollHeight, D.documentElement.scrollHeight,
        D.body.offsetHeight, D.documentElement.offsetHeight,
        D.body.clientHeight, D.documentElement.clientHeight
    );
}

// buttons
let tweetBtn = document.getElementsByClassName("tweetBtn");
let replyBtn = document.getElementsByClassName("replyBtn");
let editBtn = document.getElementsByClassName("editBtn");
let cancelBtn = document.getElementsByClassName("cancelBtn");
let cancelBtnEdit = document.getElementsByClassName("cancelBtnEdit");
let content = document.getElementsByClassName("content");
let editSubmit = document.getElementById("editSubmit");

// textareas
let replyArea = document.getElementsByClassName("reply");
let editArea = document.getElementsByClassName("editArea");

// reply board showing?
let replyShowing = false;
// edit textarea showing?
let editShowing = false;

let boardWrap = $(".boardWrap");

for (let j = 0; j <= boardWrap.length + 1; j++) {
    // tweet button click function
    tweetBtn[j].addEventListener("click", function () {
        window.open(`https://twitter.com/share?text=${content[j].textContent.trim()}`, "", "menubar=no, toolbar=no, resizable=yes, scrollbars=yes, height=550, width=420");
    });

    // toggle **cancel button should also do that
    replyBtn[j].addEventListener("click", function () {
        if (!replyShowing) {
            replyArea[j].style.display = "flex";
            editArea[j].style.display = "none";
        }
        replyShowing = true;
    });

    // textarea should disappear when the user clicks 'cancel'
    cancelBtn[j].addEventListener("click", function () {
        if (replyShowing) {
            replyArea[j].style.display = "none";
        }
        replyShowing = false;
    });

    cancelBtnEdit[j].addEventListener("click", function () {
        if (editShowing) {
            editArea[j].style.display = "none";
        }
        editContent.textContent = "";
        editShowing = false;
    });

    // get it to work on the correct post (had to take it out of the for loop bc it keeps ending it
    editBtn[j].addEventListener("click", function () {
        if (!editShowing) {
            editArea[j].style.display = "flex";
            replyArea[j].style.display = "none";

            editShowing = true;
        } else if (editShowing) {
            editArea[j].style.display = "none";

            editShowing = false;
        }
    });

    editContent[j].addEventListener("keyup", function () {
        if (editContent[j].value === null || editContent[j].value.trim() === "") {

            editSubmit[j].disabled = true;
            editSubmit[j].style.cursor = "not-allowed";

            return false;
        }

        editSubmit[j].disabled = false;
        editSubmit[j].style.cursor = "pointer";
        editSubmit[j].style.color = "black"
    });
}