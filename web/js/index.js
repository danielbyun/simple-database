document.addEventListener("DOMContentLoaded", function () {
    let mGroup = document.getElementsByClassName("mGroup");
    let mGroupArr = [];

    // retrieve each mGroup number from each board
    for (let i = 0; i < mGroup.length; i++) {
        mGroupArr.push(`${mGroup[i].value}`);
    }

    let url = "boardCommentCount.bo";
    let data = `mGroupArr=${mGroupArr}`;
    console.log(data);

    // fetch(`${url}?${data}`)
    //     .then((resp) => resp.text())
    //     .then((data) => {
    //         if (data == 1) {
    //             alert("successful");
    //         } else {
    //             alert("failed");
    //         }
    //     })

});
