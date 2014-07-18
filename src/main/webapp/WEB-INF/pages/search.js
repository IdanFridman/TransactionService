function handleClick() {
    var inputParam = document.querySelector("#myinput").value;
    /* alert(inputParam);

     var xhr = new XMLHttpRequest();
     xhr.open("GET", "/searchTerm/ajaxcall?termToSearch=" + inputParam,true);
     xhr.setRequestHeader("Content-type", "application/json");

     xhr.onreadystatechange = function () {
     if (xhr.readyState == 4) {
     var status = xhr.status;
     var text = xhr.responseText;
     alert(text);
     // do something based on status and text...
     }
     };



     xhr.send();
     */
    $.get('/search/searchTerm?termToSearch=' + inputParam, function (responseText) {
        console.log(responseText);
        $("#resultlist").empty().append(prettyPrint(responseText));


    });

    return false;

}
