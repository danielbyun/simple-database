// html elements
let userId = document.getElementById("userId");
let title = document.getElementById("title");
let content = document.getElementById("content");
let writeBtn = document.getElementById("writeBtn");

// trigger write ajax when button is clicked
writeBtn.addEventListener("click", write);

// disable button to start
writeBtn.disabled = true;

// condition to see if the user has filled in something (disables again if the user deletes the content)
[title, content].forEach(function (element) {
    element.addEventListener("keyup", function () {
        if (title.value === null || title.value.trim() === "") {
            writeBtn.disabled = true;
            writeBtn.style.cursor = "not-allowed";

            return false;
        }

        if (content.value === null || content.value.trim() === "") {
            writeBtn.disabled = true;
            writeBtn.style.cursor = "not-allowed";

            return false;
        }
        writeBtn.disabled = false;
        writeBtn.style.cursor = "pointer";
        writeBtn.style.color = "black";
    });
});

// write ajax call (using fetch) to controller
function write() {
    let url = "boardWrite.bo";
    let data = `userId=${encodeURIComponent(userId.value)}&title=${encodeURIComponent(title.value)}&content=${encodeURIComponent(content.value)}`;

    fetch(`${url}?${data}`)
        .then((resp) => resp.text())
        .then((data) => {
            if (data == 1) {
                location.href = "boardList.bo";
            } else {
                alert("something went wrong, try again");

                title.focus();
                return false;
            }
        })
}