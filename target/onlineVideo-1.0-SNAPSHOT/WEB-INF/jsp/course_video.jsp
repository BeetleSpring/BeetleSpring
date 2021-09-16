<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>课程视频</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/static/css/beetle-video.css" crossorigin="anonymous">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/css/bootstrap.min.css" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/css/font-awesome.min.css">
</head>
<body>

    <jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>

    <%--首页内容区域--%>
    <div class="container">
<%--        视频播放窗口--%>
        <div class="card">
            <div class="embed-responsive embed-responsive-16by9">
<%--                ${videos.get(0).video.videoUrl1}--%>
<%--                //player.bilibili.com/player.html?aid=890357863&bvid=BV1XP4y1a7EP&cid=403875703&page=1--%>
                <iframe src="${currentVideoUrl}" scrolling="no" border="0" frameborder="no" framespacing="0" allowfullscreen="true"> </iframe>
            </div>
        </div>

    <%--    视频相关--%>
    <div class="row mt-2">
        <div class="col-md-9">
            <span class="font-weight">浏览次数：<b class="text-primary">${topic.courseViews}</b></span>
            <span class="font-weight ml-3">课时数：<b class="text-primary">${videos.size()}</b></span>
            <span class="text-weight ml-3">类别：<b class="text-success">
                <c:if test="${topic.vipFlag==0}">免费</c:if>
                <c:if test="${topic.vipFlag==1}">会员</c:if>
            </b></span>
            <i class="fa fa-share-alt text-secondary ml-3">&nbsp;<a href="#"
                                                                          class="alert-link text-secondary">分享</a></i>
            <i class="fa fa-star text-secondary ml-3">&nbsp;&nbsp;<a href="#"
                                                                     class="alert-link text-secondary">收藏</a></i>
        </div>

        <div class="col-md-3">
            <a class="btn btn-info text-white" href="#">资料下载</a>

            <a class="btn btn-info text-white ml-2" target="_blank">在线咨询</a>
        </div>
    </div>

    <div class="row mt-2">
        <div class="col-md-9">
            <div class="card">
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item" role="presentation">
                        <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">课程介绍</a>
                    </li>
                    <li class="nav-item" role="presentation">
                        <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">课程目录</a>
                    </li>

                </ul>
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        ${topic.courseIntro}
                    </div>
                    <div class="tab-pane fade " id="profile" role="tabpanel" aria-labelledby="profile-tab">
                        <c:forEach items="${videos}" var="video" varStatus="videoStatus">
                            <a href="/courseVideo/${topic.id}?videoId=${video.id}" class="list-group-item list-group-item-action list-group-item-light border-0 mb-2
                            <c:if test="${video.id==videoId}">active</c:if>">
                                <i class="fa fa-play-circle-o">&nbsp;&nbsp;第${videoStatus.index}讲<span class="ml-3">${video.videoName}</span>

                                    <c:if test="${topic.vipFlag==0}"><span class="ml-1 badge badge-pill badge-success  pt-1">免费</span></c:if>
                                    <c:if test="${topic.vipFlag==1}"><span class="ml-1 badge badge-pill badge-danger  pt-1">会员</span></c:if>
                            </i></a>
                        </c:forEach>

                    </div>



                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card">
                <div class="card-header">
                    渡一视频
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-md-4"><img src="/static/imgs/hicon.png" class="rounded-circle"
                                                   alt="Responsive image" style="height: 60px;width: 60px;">
                        </div>
                        <div class="col-md-8">程老师<br><span class="text-secondary"
                                                           style="font-size: 16px;">管理员</span>
                        </div>


                        <span class="text-secondary mt-2" style="font-size: 14px;">分布式微服务QQ交流群：123456789</span>

                        </blockquote>
                    </div>
                </div>
            </div>

        </div>
    </div>



    </div>



    <jsp:include page="/WEB-INF/jsp/common/tail.jsp"></jsp:include>


</body>
</html>
