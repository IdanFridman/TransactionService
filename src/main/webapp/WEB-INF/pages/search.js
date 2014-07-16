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
        var resultList = $("#resultlist");
        var jsonArr = [];
        jsonArr.push({
            "UmeIP": "192.168.21.118",
            "UmeSerialNumber": "5700122",
            "transaction": [
                { "UmeSerialNumber": "5700122",
                    "UmeApplicationVersion": "![CDATA[1.3.4190.22770 RadioShack]",
                    "TransactionTimeDate": "2011-06-30 11:03:20",
                    "TransactionStatus": "3",
                    "TransactionReadFailInfo": "1",
                    "TransactionWriteFailInfo": "0"
                }
            ]
        })
        jsonArr.push({
            "UmeIP": "192.168.21.118",
            "UmeSerialNumber": "5700122888",
            "transaction": [
                { "UmeSerialNumber": "5700122",
                    "UmeApplicationVersion": "![CDATA[1.3.4190.22770 RadioShack]",
                    "TransactionTimeDate": "2011-06-30 11:03:20",
                    "TransactionStatus": "3",
                    "TransactionReadFailInfo": "1",
                    "TransactionWriteFailInfo": "0"
                }
            ]
        })


        console.log(jsonArr);

        var tbl = prettyPrint(jsonArr);
        document.body.appendChild(tbl);


        //  var json = JSON.parse(JSON.stringify(jsonArr));
        //   console.log(json[0]);
        //    var node = JsonHuman.format(json[0])
        //    document.body.appendChild(node);

        /*     var node = JsonHuman.format(jsonArr);
         //     var tbl = prettyPrint(jsonArr);
         document.body.appendChild(node);

         //resultList.text(JSON.stringify(jsonArr));
         */

    });


    return false;

}
