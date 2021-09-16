<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


    <!-- Bootstrap CSS -->





<nav class="navbar navbar-expand-lg navbar-light bg-light shadow mb-10">

    <div class="container">

        <a class="navbar-brand" href="#">渡一视频</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link <c:if test="${focusFlag==0}">active</c:if>" href="/">首页 </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <c:if test="${focusFlag==1}">active</c:if>" href="/courseList/0">课程</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <c:if test="${focusFlag==2}">active</c:if>" href="/vip">会员</a>
                </li>
                </li>
                <li class="nav-item">
                    <a class="nav-link <c:if test="${focusFlag==3}">active</c:if>" href="/live">直播</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <c:if test="${focusFlag==4}">active</c:if>" href="/tools/0">工具</a>
                </li>

            </ul>
            <c:choose>
                <c:when test="${sessionScope.login_user!=null}">
                    <div class="btn-group mr-2">
                        <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false">
                            ${sessionScope.login_user.email}
                        </button>
                        <div class="dropdown-menu">
                            <button class="dropdown-item" type="button" onclick="loginOut()">退出</button>
                        </div>
                    </div>

                </c:when>

                <c:otherwise>
                    <a href="#" data-toggle="modal" data-target="#loginModal" data-whatever="@fat" class="mr-1">登录</a> /
                    <a href="#" data-toggle="modal" data-target="#registModal" data-whatever="@mdo" class="ml-1 mr-3">注册</a>
                </c:otherwise>
            </c:choose>


            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="搜索视频" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
            </form>
        </div>

    </div>
</nav>


<!-- 登录对话框 -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="/login" onsubmit="return loginSubmit()">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">登录</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">


                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="loginEmail">邮箱</label>
                            <!-- is-valid is-invalid-->
                            <input type="text" class="form-control" id="loginEmail" name="email" required>
                            <div class="valid-feedback">
                                Looks good!
                            </div>
                        </div>

                    </div>
                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="loginPassword">密码</label>
                            <input type="password" class="form-control " id="loginPassword" name="password" required>
                            <div class="valid-feedback" id="feedbackLoginPassword">
                                Please provide a valid city.
                            </div>
                        </div>


                    </div>
                    <div class="form-group">
                        <div class="form-check">
                            <input class="form-check-input " type="checkbox" value="1" id="autoLogin" name="autoLogin">
                            <label class="form-check-label">
                                自动登录
                            </label>

                            <a href="#" class="float-right">忘记密码</a>
                        </div>
                    </div>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">登录</button>
                </div>
                <div class="mb-3 ml-3">
                    <a href="#" data-toggle="modal" data-dismiss="modal" data-target="#registModal">还没有账号？点我注册</a>
                </div>

            </form>
        </div>


    </div>

</div>


<!-- 注册对话框 -->

<div class="modal fade" id="registModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="/regist" onsubmit="return registSubmit()">
                <div class="modal-header">
                    <h5 class="modal-title">注册</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">


                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="registerEmail">邮箱</label>
                            <!-- is-valid is-invalid-->
                            <input type="text" name="email" class="form-control" placeholder="请输入邮箱" onblur="checkEmail(this)" id="registerEmail"
                                   pattern="[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?" required>
                            <div class="valid-feedback" id="feedbackEmail">
                                Looks good!
                            </div>
                        </div>

                    </div>
                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="telephone">手机</label>
                            <!-- is-valid is-invalid-->
                            <input type="text" class="form-control"name="telephone" id="telephone"
                                   placeholder="请输入手机号" pattern="1[3456789]\d{9}$"required>
                            <div class="valid-feedback">
                                Looks good!
                            </div>
                        </div>

                    </div>
                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="registerPassword">密码</label>
                            <input type="password" class="form-control" id="registerPassword"
                                   name="password" placeholder="包含数字和字母且在6-20位之间"
                                   pattern="^(?![\d]+$)(?![a-zA-Z]+$)(?![^\da-zA-Z]+$).{6,20}$"required>
                            <div class="invalid-feedback">
                                Please provide a valid city.
                            </div>
                        </div>


                    </div>
                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="vcode">验证码</label>
                            <!-- is-valid is-invalid-->
                            <div class="row">
                                <div class="col-md-7"><input type="text" class="form-control" id="vcode"
                                                             placeholder="请输入验证码" name="vcode"
                                                             maxlength="4"
                                                             required>
                                    <div class="valid-feedback" id="feedbackVcode">
                                        Looks good!
                                    </div>
                                </div>
                                <div class="col-md-5"><img src="/vcode" onclick="imgChange(this)"></img></div>
                            </div>
                        </div>
                    </div>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">注册</button>
                </div>
                <div class="mb-3 ml-3">
                    <a href="#" data-toggle="modal" data-dismiss="modal" data-target="#loginModal">已有账号？点我登录</a>
                </div>

            </form>
        </div>


    </div>

</div>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<%--<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"--%>
<%--        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"--%>
<%--        crossorigin="anonymous"></script>--%>
<script src="/static/js/jquery-3.6.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>--%>
<script src="/static/js/bootstrap.min.js"></script>
<script>

    //登录表单提交的时候 验证一下账号密码是否正确
    function loginSubmit(){
        var result = checkUser();
        if(!result){       // 验证码不正确
            $("#loginPassword").removeClass("is-valid");
            $("#loginPassword").addClass("is-invalid");
            $("#feedbackLoginPassword").text("账号或密码填写错误");
            $("#feedbackLoginPassword").attr("class", "invalid-feedback");
            return false
        }
        return true;
    }

    function checkUser(){
        var flag = false;
        //点击验证码图片 更换新的验证码图片
        $.ajax({
            async:false,//表示是同步的 这个很重要  否则可能loginSubmit 接收到的值是undfined
            url:"/checkUser",
            data:{email:$("#loginEmail").val(),password:$("#loginPassword").val()},
            type: "POST",
            success(result){
                if(result==0){//表示密码正确
                    flag = true;
                }
            }
        })
        return flag;
    }


    function imgChange(imgNode) {
        imgNode.src="/vcode?ram="+new Date().getTime();
    }

    //检查email是否存在
    function checkEmail(emailNode){
        var strEmail = emailNode.value
        $.ajax({
            type:"POST",
            url:"/checkEmail?email="+strEmail,
            success:function (result){
                if(result.rcode==0){//表示可以注册
                    // 可以注册 valid-feedback invalid-feedback
                    $("#registerEmail").addClass("is-valid");
                    $("#registerEmail").removeClass("is-invalid");
                    $("#feedbackEmail").text("Email可以注册");
                    $("#feedbackEmail").attr("class", "valid-feedback");
                }else{
                    // 不可以注册
                    $("#registerEmail").addClass("is-invalid");
                    $("#registerEmail").removeClass("is-valid");
                    $("#feedbackEmail").text("Email不可以注册");
                    $("#feedbackEmail").attr("class", "invalid-feedback");
                }

            }
        })
    }


    //注册表单提交的时候 检查验证码是否正确
    function registSubmit(){
        var flag = checkVcode();
        if(!flag){       // 验证码不正确
            $("#vcode").removeClass("is-valid");
            $("#vcode").addClass("is-invalid");
            $("#feedbackVcode").text("验证码填写错误");
            $("#feedbackVcode").attr("class", "invalid-feedback");
            return false
        }
        return true;
    }

    //写一个函数验证一下验证码是否正确
    function checkVcode(){
        var vcode = $("#vcode").val()
        var flag =false;
        $.ajax({
            url:"/checkVcode?vcode="+vcode,
            success:function (result){
                console.log(result)
                if(result==0){//表示验证码正确
                    flag=true;
                }
            },
            // 同步请求
            async: false
        })
        return flag;

    }

    function loginOut(){
        window.location.href="/loginOut";
    }

</script>