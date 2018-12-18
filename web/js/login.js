// error message
let errorMessage = document.getElementById("errorMsg");

// login Btn
let loginBtn = document.getElementById("loginBtn");
loginBtn.addEventListener("click", loginOk);

function loginOk() {
    let userId = document.getElementById("userId");
    let userPw = document.getElementById("userPw");

    if (userId.value === null || userId.value.trim() === "") {
        errorMessage.style.display = "flex";
        errorMessage.innerHTML = "please put in your id";

        userId.focus();
        return false;
    }
    if (userPw.value === null || userPw.value.trim() === "") {
        errorMessage.style.display = "flex";
        errorMessage.innerHTML = "please put in your pw";

        userPw.focus();

        return false;
    }

    // ajax (fetch API)
    let data = `userId=${encodeURIComponent(userId.value)}&userPw=${encodeURIComponent(userPw.value)}`;
    let url = "login.mo";

    fetch(`${url}?${data}`)
        .then((resp) => resp.text())
        .then((data) => {
            // successful
            if (data == 1) {
                location.href = "boardList.bo";
            } else {
                errorMessage.style.display = "flex";
                errorMessage.innerHTML = "something went wrong, please try again";
                userId.focus();
            }
        })
}

