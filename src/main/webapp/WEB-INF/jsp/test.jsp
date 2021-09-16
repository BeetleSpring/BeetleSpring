<%--
  Created by IntelliJ IDEA.
  User: 11977
  Date: 2021/8/31
  Time: 3:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>

    <style>

        .select-shadow:hover {
            -webkit-box-shadow: 2px 2px 8px 1px rgba(20, 20, 20, 0.15);
            -moz-box-shadow: 2px 2px 8px 1px rgba(20, 20, 20, 0.15);
            box-shadow: 2px 2px 8px 1px rgba(20, 20, 20, 0.15);
            cursor: pointer;
            color: red;
        }




        .footer-link a {
            margin: 0 10px;
            font-size: 14px;
            color: #99a1a6;
            text-decoration: none;
        }
    </style>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <title>在线视频学习网站</title>
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="#">甲壳虫视频</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">首页 <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">课程</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">会员</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">工具</a>
                </li>

            </ul>
            <a href="#" data-toggle="modal" data-target="#loginModal" data-whatever="@fat" class="mr-1">登录</a> /
            <a href="#" data-toggle="modal" data-target="#registModal" data-whatever="@mdo" class="mr-1 ml-1">注册</a>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="搜索课程" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
            </form>
        </div>
    </div>
</nav>





<!-- 登录对话框 -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form>
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">登录</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">


                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="validationServer01">邮箱</label>
                            <!-- is-valid is-invalid-->
                            <input type="text" class="form-control " id="validationServer01" required>
                            <div class="valid-feedback">
                                Looks good!
                            </div>
                        </div>

                    </div>
                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="validationServer03">密码</label>
                            <input type="password" class="form-control " id="validationServer03" required>
                            <div class="invalid-feedback">
                                Please provide a valid city.
                            </div>
                        </div>


                    </div>
                    <div class="form-group">
                        <div class="form-check">
                            <input class="form-check-input " type="checkbox" value="" id="invalidCheck3">
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
<div class="modal fade" id="registModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form>
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">注册</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">


                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="validationServer01">邮箱</label>
                            <!-- is-valid is-invalid-->
                            <input type="text" class="form-control " id="validationServer01" required>
                            <div class="valid-feedback">
                                Looks good!
                            </div>
                        </div>

                    </div>
                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="validationServer03">手机</label>
                            <input type="password" class="form-control " id="validationServer03" required>
                            <div class="invalid-feedback">
                                Please provide a valid city.
                            </div>
                        </div>


                    </div>
                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="validationServer03">密码</label>
                            <input type="password" class="form-control " id="validationServer03" required>
                            <div class="invalid-feedback">
                                Please provide a valid city.
                            </div>
                        </div>


                    </div>
                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="validationServer01">验证码</label>
                            <!-- is-valid is-invalid-->
                            <div class="row">
                                <div class="col-md-7"><input type="text" class="form-control  " id="validationServer01"
                                                             required>
                                    <div class="valid-feedback">
                                        Looks good!
                                    </div>
                                </div>
                                <div class="col-md-5"><img src="vcode.png"></img></div>
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




<!-- Optional JavaScript; choose one of the two! -->

<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<!-- <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script> -->

<!-- Option 2: jQuery, Popper.js, and Bootstrap JS -->
<script src="../testJS/jquery-3.6.0.js"></script>
<!-- <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script> -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>


<!-- <%--轮播图--%> -->
<div class="container" style="margin-top: 30px">
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">

        <!-- <%--    轮播下划线--%> -->
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <!-- <%--轮播的内容--%> -->
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="/static/imgs/456.png" class="d-block w-100 rounded" alt="...">
            </div>
            <div class="carousel-item">
                <img src="/static/imgs/456.png" class="d-block w-100 rounded" alt="...">
            </div>
            <div class="carousel-item">
                <img src="/static/imgs/456.png" class="d-block w-100 rounded" alt="...">
            </div>
        </div>
        <!-- <%--  左箭头  --%> -->
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <!-- <%--    右箭头--%> -->
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>

<!-- 最新课程类型-->
<div class="border border-top-0 border-left-0 border-right-0  border-secondary">
    <a href="#" class="float-right">更多 ></a>
    <h4 class="text-center">最新课程</h4>
</div>

<div class="row row-cols-1 row-cols-md-4 mt-2">
    <div class="col mb-3">
        <a href="#" target="_blank">
            <div class="card select-shadow">
                <img src="/static/imgs/555.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <p class="card-text">Springboot</p>
                    <p class="card-text">1000人学习</p>
                    <span class="badge badge-pill badge-success ">免费</span>
                </div>
            </div>
        </a>
    </div>
    <div class="col mb-3">
        <a href="#" target="_blank">
            <div class="card select-shadow">
                <img src="/static/imgs/555.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <p class="card-text">Springboot</p>
                    <p class="card-text">1000人学习</p>
                    <span class="badge badge-pill badge-success ">免费</span>
                </div>
            </div>
        </a>
    </div>
    <div class="col mb-3">
        <a href="#" target="_blank">
            <div class="card select-shadow">
                <img src="/static/imgs/555.png"class="card-img-top" alt="...">
                <div class="card-body">
                    <p class="card-text">Springboot</p>
                    <p class="card-text">1000人学习</p>
                    <span class="badge badge-pill badge-success ">免费</span>
                </div>
            </div>
        </a>
    </div>
    <div class="col mb-3">
        <a href="#" target="_blank">
            <div class="card select-shadow">
                <img src="/static/imgs/555.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <p class="card-text">Springboot</p>
                    <p class="card-text">1000人学习</p>
                    <span class="badge badge-pill badge-success ">免费</span>
                </div>
            </div>
        </a>
    </div>
</div>   <br>


<%--常用框架--%>
<div class="border border-top-0 border-left-0 border-right-0  border-secondary">
    <a href="#" class="float-right">更多 ></a>
    <h4 class="text-center">常用框架</h4>
</div>

<div class="row row-cols-1 row-cols-md-4 mt-2">
    <div class="col mb-3">
        <a href="#" target="_blank">
            <div class="card select-shadow">
                <img src="/static/imgs/555.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <p class="card-text">Springboot</p>
                    <p class="card-text">1000人学习</p>
                    <span class="badge badge-pill badge-success ">免费</span>
                </div>
            </div>
        </a>
    </div>
    <div class="col mb-3">
        <a href="#" target="_blank">
            <div class="card select-shadow">
                <img src="/static/imgs/555.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <p class="card-text">Springboot</p>
                    <p class="card-text">1000人学习</p>
                    <span class="badge badge-pill badge-success ">免费</span>
                </div>
            </div>
        </a>
    </div>
    <div class="col mb-3">
        <a href="#" target="_blank">
            <div class="card select-shadow">
                <img src="/static/imgs/555.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <p class="card-text">Springboot</p>
                    <p class="card-text">1000人学习</p>
                    <span class="badge badge-pill badge-success ">免费</span>
                </div>
            </div>
        </a>
    </div>
    <div class="col mb-3">
        <a href="#" target="_blank">
            <div class="card select-shadow">
                <img src="/static/imgs/555.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <p class="card-text">Springboot</p>
                    <p class="card-text">1000人学习</p>
                    <span class="badge badge-pill badge-success ">免费</span>
                </div>
            </div>
        </a>
    </div>
</div>



<div style="background-color: #f3f5f7;box-shadow:0px 0px 1px 1px #ccc;">
    <div class="container footer-link">
        <div class="row pt-5">
            <a href="#" target="_blank">帮助中心</a>
            <a href="#" target="_blank">联系我们</a>
            <a href="#" target="_blank">关于我们</a>
            <a href="#" target="_blank">客服QQ：12345</a>
            <a href="#" target="_blank">官方粉丝群：678910</a>
        </div>

        <div class="row pb-5 mt-2">
            <a href="#" target="_blank"> Copyright © 2019 上海XXXXXXX公司</a>
            <a href="#" target="_blank">Java课堂</a>
            <a href="#" target="_blank">沪ICP备xxxx</a>
        </div>
    </div>

</div>








</body>
</html>