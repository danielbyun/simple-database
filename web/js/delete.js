// delete form
let deleteForm = document.getElementById("deleteForm");

// error message
let errorMessage = document.getElementById("errorMsg");

// delete btn
let deleteBtn = document.getElementById("deleteBtn");
deleteBtn.addEventListener("click", deleteOk);

function deleteOk() {
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
        errorMessage.innerHTML = "please put in your password";

        userPw.focus();
        return false;
    }

    // fetch data
    let data = `userId=${encodeURIComponent(userId.value)}&userPW=${encodeURIComponent(userPw.value)}`;
    let url = "deleteProfile.mo";

    fetch (`${url}?${data}`)
        .then((resp) => resp.text())
        .then((data) => {
            // successful
            if (data == 1) {
                location.href = "/profileDeleted.do";
            } else {
                location.href = "/profile.do";
            }
        })
}

