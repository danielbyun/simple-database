let memberId = document.getElementById("memberId");
let userId = document.getElementById("userId");
let userEmail = document.getElementById("userEmail");
let userPw = document.getElementById("userPw");
let userPwCheck = document.getElementById("userPwCheck");
let checkIdConfirmation = document.getElementById("idCheckOk");
let updateForm = document.getElementById("updateForm");

let deleteRedirect = document.getElementById("deleteRedirect");
deleteRedirect.addEventListener("click", redirect);

function redirect() {
    location.href = "deleteProfile.do";
}

let errorMsg = document.getElementById("errorMsg");
let updateBtn = document.getElementById("updateBtn");
updateBtn.addEventListener("click", updateFunc);

let checkId = document.getElementById("checkId");
checkId.addEventListener("click", userIdCheck);

function isUserIdEmpty() {
    if (userId.value === null || userId.value.trim() === "") {
        errorMsg.style.display = "flex";
        errorMsg.innerHTML = "please put in your id to check!";

        userId.focus();

        return false;
    } else {
        return true;
    }
}

function userIdCheck() {
    // if its not empty
    if (isUserIdEmpty() === true) {
        checkID();
    }
}

function updateFunc() {
    if (isUserIdEmpty() === true) {
        if (checkIdConfirmation.value !== "checked") {
            errorMsg.style.backgroundColor = "red";
            errorMsg.innerHTML = "please make sure you check the id";

            userId.focus();

            return false;
        }
        if (userId.value === null || userId.value.trim() === "") {
            errorMsg.style.display = "flex";
            errorMsg.innerHTML = "please put in your new id";

            userId.focus();

            return false;
        }
        if (userEmail.value === null || userEmail.value.trim() === "") {
            errorMsg.style.display = "flex";
            errorMsg.innerHTML = "please put in your new email address";

            userEmail.focus();

            return false;
        }
        if (userPw.value === null || userPw.value.trim() === "") {
            errorMsg.style.display = "flex";
            errorMsg.innerHTML = "please put in your new password";

            userPw.focus();

            return false;
        }

        // let url = "updateProfile.mo";
        // let data = `id=${encodeURIComponent(memberId.value)}&userId=${encodeURIComponent(userId.value)}&userEmail=${encodeURIComponent(userEmail.value)}&userPw=${encodeURIComponent(userPw.value)}`;
        //
        // fetch(`${url}?${data}`)
        //     .then((resp) => resp.text())
        //     .then((data) => {
        //         if (data == 1) {
        //             location.href = `viewProfile.mo?userId=${encodeURIComponent(userId.value)}`;
        //         } else {
        //             errorMsg.style.display = "flex";
        //             errorMsg.style.backgroundColor = "red";
        //             errorMsg.innerHTML = "something went wrong, try again.";
        //
        //             userId.focus();
        //         }
        //     })
        updateForm.submit();
    }
}

function checkID() {
    let data = `userId=${encodeURIComponent(userId.value)}`;
    let url = "idCheck.mo";

    fetch(`${url}?${data}`)
        .then((resp) => resp.text())
        .then((data) => {
            // this is where we retrieve the result
            if (data == 1) {
                errorMsg.style.display = "flex";
                errorMsg.innerHTML = "that id is taken, please try a different one!";

                userId.focus();
            } else {
                errorMsg.style.display = "flex";
                errorMsg.style.backgroundColor = "cadetblue";
                errorMsg.innerHTML = "good to go!";

                userEmail.focus();
            }
        });

    // change the value to the 'checked'
    checkIdConfirmation.value = "checked";
}

function checkPwFunc() {
    if (userPw.value !== userPwCheck.value) {
        errorMsg.style.backgroundColor = "red";
        errorMsg.innerHTML = "password doesn't match";
        return false;
    } else {
        errorMsg.innerHTML = "password matches!";
        errorMsg.style.backgroundColor = "cadetblue";
        return true;
    }
}