let mGroup = document.getElementsByClassName("mGroup");
let mGroupArr = [];

// retrieve each mGroup number from each board
for (let i = 0; i < mGroup.length; i++) {
    mGroupArr.push(`${mGroup[i].value}`);
}

let url = "boardCommentCount.bo";
let data = `mGroupArr=${mGroupArr}`;
// console.log(data);

// jquery scroll detection v2
$(window).scroll(function () {
    // let scroll = $(window).scrollTop();
    // alert("yo");

    // if ((window.innerHeight + Math.ceil(window.pageYOffset + 1)) >= document.body.offsetHeight) {
    //     console.log("second version");
    //     alert("second version");
    // }

    // if ($(window).scrollTop() + $(window).height() > $(document).height() - 100) {
    //     alert("bottom");
    // }

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

            replyShowing = true;
        }
    });

    // textarea should disappear when the user clicks 'cancel'
    cancelBtn[j].addEventListener("click", function () {
        if (replyShowing) {
            replyArea[j].style.display = "none";

            replyShowing = false;
        }
    });

    cancelBtnEdit[j].addEventListener("click", function () {
        if (editShowing) {
            editArea[j].style.display = "none";

            editShowing = false;
        }
    });
}

// get it to work on the correct post (had to take it out of the for loop bc it keeps ending it

// editBtn[j].addEventListener("click", function () {
//     if (!editShowing) {
//         editArea[j].style.display = "flex";
//         replyArea[j].style.display = "none";
//
//         editShowing = true;
//     } else if (editShowing) {
//         editArea[j].style.display = "none";
//
//         editShowing = false;
//     }
// });

