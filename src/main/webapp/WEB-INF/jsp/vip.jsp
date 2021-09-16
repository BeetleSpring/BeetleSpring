
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>会员</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/static/css/beetle-video.css" crossorigin="anonymous">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/css/bootstrap.min.css" crossorigin="anonymous">
</head>
<body>

<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>


<div class="container mt-4">
    <div class="card-deck mb-2 text-center">

        <div class="card mb-6 shadow-sm">
            <form method="POST" action="/vipPay">
                <div class="card-header">
                    <h4 class="my-0 font-weight-normal">包月</h4>
                </div>
                <div class="card-body">
                    <h1 class="card-title pricing-card-title">15￥ <small class="text-muted">/ 月</small></h1>

                    <input type="hidden" value="15" name="money">
                    <input type="hidden" value="包月会员" name="tradeName">

                    <button type="submit" class="btn btn-lg btn-block btn-primary">开通</button>
                </div>
            </form>
        </div>


        <div class="card mb-6 shadow-sm">
            <form method="POST" action="/vipPay">
                <div class="card-header">
                    <h4 class="my-0 font-weight-normal">包年</h4>
                </div>
                <div class="card-body">
                    <h1 class="card-title pricing-card-title">158￥ <small class="text-muted">/ 年</small></h1>
                    <input type="hidden" value="158" name="money">
                    <input type="hidden" value="包年会员" name="tradeName">

                    <button type="submit" class="btn btn-lg btn-block btn-primary">开通</button>
                </div>
            </form>
        </div>
    </div>


</div>

<jsp:include page="/WEB-INF/jsp/common/tail.jsp"></jsp:include>

</body>
</html>
