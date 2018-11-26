let userId = document.getElementById("userId");
let title = document.getElementById("title");
let content = document.getElementById("content");

let writeBtn = document.getElementById("writeBtn");
writeBtn.addEventListener("click", write);
writeBtn.disabled = true;

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
    });
});


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