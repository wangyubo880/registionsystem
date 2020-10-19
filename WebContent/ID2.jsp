<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://apps.bdimg.com/libs/jquery/1.8.3/jquery.min.js"></script>
</head>
<body>
输入身份证号码：
<input type="text" name="user_idnumber" id="user_idnumber" maxlength="18" />
<input class="birthday" id="birth" />
<script>
$(document).on("keyup blur","#user_idnumber",function(){
    var code=$(this).val();
    var len=code.length;
    //方法一
    if ($.trim($(this).val().length)>6)

    	$("#birth").attr("value",code.substr(6,4)+'-'+code.substr(10,2)+'-'+code.substr(12,2));
       // $(".birthday").value(code.substr(6,4)+'-'+code.substr(10,2)+'-'+code.substr(12,2));
    
    else
        $(".birthday").html("");
    //方法二(推荐)    
    /*if (len>6)
        $(".birthday").html(code.substr(6,4)+(len>10?'-':'')+code.substr(10,2)+(len>12?'-':'')+code.substr(12,2));
    else
        $(".birthday").html("");*/
});
</script>

</body>
</html>