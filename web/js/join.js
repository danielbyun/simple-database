// form
let joinForm = document.getElementById("joinForm");

// check id button
let checkId = document.getElementById("checkId");

// whether the user checked the id or not
let checkIdConfirmation = document.getElementById("idCheckOk");

// error message span on top
let errorMessage = document.getElementById("errorMsg");

// user credentials
let userId = document.getElementById("userId");
let userPw = document.getElementById("userPw");
let userEmail = document.getElementById("userEmail");

// check the passwords
let checkPwCheck = document.getElementById("userPwCheck");

// submit button
let joinBtn = document.getElementById("joinBtn");

// event listeners
checkId.addEventListener("click", userIdCheck);
joinBtn.addEventListener("click", joinOk);

function isUserIdEmpty() {
    if (userId.value === null || userId.value.trim() === "") {
        errorMessage.style.display = "flex";
        errorMessage.innerHTML = "please put in your id to check!";

        userId.focus();

        return false;
    } else {
        return true;
    }
}

// created a function because it's used more than once.
function userIdCheck() {
    // if its not empty
    if (isUserIdEmpty() === true) {
        checkID();
    }
}

// check id in database if theres any duplicates
function checkID() {
    let userId = document.getElementById("userId");
    let userPw = document.getElementById("userPw");
    let data = `userId=${encodeURIComponent(userId.value)}`;
    let url = "idCheck.mo";

    fetch(`${url}?${data}`)
        .then((resp) => resp.text())
        .then((data) => {
            // this is where we retrieve the result
            if (data == 1) {
                errorMessage.style.display = "flex";
                errorMessage.innerHTML = "that id is taken, please try a different one!";

                userId.focus();
            } else {
                errorMessage.style.display = "flex";
                errorMessage.style.backgroundColor = "cadetblue";
                errorMessage.innerHTML = "good to go!";

                userPw.focus();
            }
        });

    // change the value to the 'checked'
    checkIdConfirmation.value = "checked";
}

// join method
function joinOk() {
    // userId field check
    if (isUserIdEmpty() === true) {
        // if userId have not been checked
        if (checkIdConfirmation.value !== "checked") {
            errorMessage.style.display = "flex";
            errorMessage.innerHTML = "please make sure you check the id";

            userId.focus();

            return false;
        }
        // if the userPw field is empty
        if (userPw.value === null || userPw.value.trim() === "") {
            errorMessage.style.display = "flex";
            errorMessage.innerHTML = "please put in your password";

            userPw.focus();

            return false;
        }
        // if the two password fields don't match
        if (userPw.value !== checkPwCheck.value) {
            errorMessage.style.display = "flex";
            errorMessage.innerHTML = "the passwords don't match, please try again";

            userPw.focus();

            return false;
        }
        // if the userEmail field is empty
        if (userEmail.value === null || userEmail.value.trim() === "") {
            errorMessage.style.display = "flex";
            errorMessage.innerHTML = "please put in your email";

            userEmail.focus();

            return false;
        }

        joinForm.submit();
    }
}
