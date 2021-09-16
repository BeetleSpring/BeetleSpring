<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>在线视频</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">



    <link rel="stylesheet" href="/static/css/beetle-video.css">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>

<%--    头部导航栏--%>
    <jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>

<%--首页内容区--%>

    <div class="container" style="margin-top: 30px">
        <%--轮播图--%>
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <%--    轮播下划线--%>
            <ol class="carousel-indicators">
                <c:forEach items="${bannerInfo.list}" var="banner" varStatus="bannerStatus">
                    <li data-target="#carouselExampleIndicators" data-slide-to="${bannerStatus.index}"
                        class="<c:if test="${bannerStatus.index==0}">active</c:if>"></li>
                </c:forEach>
            </ol>
            <%--轮播的内容--%>
            <div class="carousel-inner">
                <c:forEach items="${bannerInfo.list}" var="banner" varStatus="bannerStatus">
                    <div class="carousel-item <c:if test="${bannerStatus.index==0}">active</c:if>">
                        <a href="${banner.targetUrl}">
                            <img src="${banner.imgUrl}" class="d-block w-100 rounded h-50" alt="...">
                        </a>
                    </div>
                </c:forEach>

            </div>
            <%--  左箭头  --%>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <%--    右箭头--%>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>



        <!-- 最新课程类型-->
        <div class="border border-top-0 border-left-0 border-right-0  border-secondary">
            <a href="#" class="float-right">更多 ></a>
            <h4 class="text-center">最新课程</h4>
        </div>

        <div class="row row-cols-1 row-cols-md-4 mt-2">
            <c:forEach items="${newCourseTopicsInfo.list}" var="topic">
                <div class="col mb-3">
                    <a <c:if test="${topic.vipFlag==1&&login_user.vipFlag==1||topic.vipFlag==0}"> href="/courseVideo/${topic.id}"</c:if> target="_blank">
                        <div class="card select-shadow">
                            <img src="${topic.iconUrl}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <p class="card-text">${topic.title}</p>
                                <p class="card-text">${topic.courseViews}人学习</p>
                                <c:choose>
                                    <c:when test="${topic.vipFlag==0}">
                                        <span class="badge badge-pill badge-success ">免费</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="badge badge-pill badge-danger ">会员</span>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </a>
                </div>
            </c:forEach>

        </div>   <br>


        <%--常用框架--%>
        <div class="border border-top-0 border-left-0 border-right-0  border-secondary">
            <a href="#" class="float-right">更多 ></a>
            <h4 class="text-center">常用框架</h4>
        </div>

        <div class="row row-cols-1 row-cols-md-4 mt-2">
            <c:forEach items="${courseTopicsInfo.list}" var="topic">
                <div class="col mb-3">
                    <a <c:if test="${topic.vipFlag==1&&login_user.vipFlag==1||topic.vipFlag==0}"> href="/courseVideo/${topic.id}"</c:if> target="_blank">
                        <div class="card select-shadow">
                            <img src="${topic.iconUrl}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <p class="card-text">${topic.title}</p>
                                <p class="card-text">${topic.courseViews}人学习</p>
                                <c:choose>
                                    <c:when test="${topic.vipFlag==0}">
                                        <span class="badge badge-pill badge-success ">免费</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="badge badge-pill badge-danger ">会员</span>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>


    <jsp:include page="/WEB-INF/jsp/common/tail.jsp"></jsp:include>

</body>
</html>
