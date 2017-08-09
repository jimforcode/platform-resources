<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/2 0002
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>demo</title>
    <script
            src="https://code.jquery.com/jquery-3.2.1.js"
            integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
            crossorigin="anonymous"></script>
</head>

<body>


<form class="form-inline">
    <div class="form-group">
        <label for="exampleInputName2">Name</label>
        <input type="text" class="form-control" id="exampleInputName2" placeholder="Jane Doe">
    </div>
    <div class="form-group">
        <label for="exampleInputEmail2">Email</label>
        <input type="text" class="form-control" id="exampleInputEmail2" placeholder="1">
    </div>
    <button type="button" onclick="submitFm()" class="btn btn-default">Send invitation</button>
</form>



</body>
</html>
<a href="${path}/sys/demo">sys/demo</a>





<script>

    function submitFm() {

        var num = $("#exampleInputEmail2").val();
        $.ajax({
            url: "/test/batchAdd",
            data: {
                num:num
            },
            datatype: "json",
            success: function( result ) {

                var data= JSON.parse(result) ;
                var data= result ;
                console.log(data);
                if(data.status=='ok'){
                    alert(data.data)
                }else {
                    alert(data.msg);
                }
            }
        });

    }



</script>