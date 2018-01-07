<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/dorm-staff.css">
    <title>宿舍管理</title>
</head>

<body>
    <div id="wrap">

        <!-- 左侧菜单栏目块 -->
        <div class="left-menu">
            <div class="logo-div">
                <p class="logo-p">
                    <img class="logo-img" src="../images/staff-logo.png" alt="宿舍管理">
                    <span>宿舍管理</span>
                </p>
            </div>

            <div class="person-info">
                <p id="userName"><c:out value="${staffDto.realName}"></c:out></p>
                <p>
                    <a href="#" class="logout">退出登录</a>
                </p>
            </div>
            <div class="menu-item" href="#announcements">
                <img src="../images/公告.png" alt="发布公告">发布公告
            </div>
            <div class="menu-item" href="#repair">
                <img src="../images/报修.png" alt="查看报修">查看报修
            </div>
            <div class="menu-item">
                <img src="../images/宿舍建设.png" alt="宿舍建设">宿舍建设
            </div>
            <ul class="menu-ul">
                <li class="menu-item-content" href="#hygiene">记录卫生检查结果</li>
                <li class="menu-item-content" href="#rewardAndPunishment">奖惩状况</li>
            </ul>
            <div class="menu-item">
                <img src="../images/出入登记.png" alt="出入登记">出入登记
            </div>
            <ul class="menu-ul">
                <li class="menu-item-content" href="#borrow">物品借还登记</li>
                <li class="menu-item-content" href="#holidaysLeave">假期离校情况</li>
            </ul>
            <div class="menu-item" href="#changePsw">
                <img src="../images/修改密码.png" alt="修改密码">修改密码
            </div>
        </div>

        <!-- 左侧具体内容栏目 -->
        <div class="right-content" id="rightContent">
            <div class="tab-content">

                <!-- 发布公告模块 -->
                <div class="tab-panel" id="announcements">
                    <div class="check-div">
                        <span>发布公告</span>
                    </div>
                    <div class="announcements-body">
                        <form action="/staffHome/doAddNotice" class="form-horizontal" method="post">
                            <p>发布公告</p>
                            <hr>
                            <input type="hidden" name="staffId" value="${staffDto.id}">
                            <textarea class="textarea" name="context" class="form-control add-notice-form" rows="7"
                                      placeholder="公告内容"></textarea>
                            <div class="col-xs-offset-3 col-xs-5">
                                <button type="reset" class="btn btn-xs btn-white" style="margin-left: 20px;">取 消</button>
                                <button type="submit" class="btn btn-xs btn-green add-notice-btn">保存</button>
                            </div>
                        </form>
                    </div>
                    <div class="notice-history">
                        <p>已发布公告</p>
                        <table class="table table-striped notice-table">
                            <thead>
                                <tr>
                                    <td>#</td>
                                    <td>公告内容</td>
                                    <td>发布时间</td>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="noticeHistory" items="${noticeDtoHistory}" varStatus="i">
                                    <tr>
                                        <td><c:out value="${i.count}"></c:out></td>
                                        <td><c:out value="${noticeHistory.context}"></c:out></td>
                                        <td><c:out value="${noticeHistory.time}"></c:out></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>


                <!-- 查看报修模块 -->
                <div class="tab-panel" id="repair">
                    <div class="check-div">报修情况</div>
                    <div class="repair-body">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>报修人学号</th>
                                    <th>报修寝室号</th>
                                    <th>报修内容</th>
                                    <th>报修时间</th>
                                    <th>修复情况</th>
                                    <th>标记修复</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="maintenanceHistory" items="${maintenanceDtoHistory}" varStatus="i">
                                <tr>
                                    <td><c:out value="${i.count}"></c:out></td>
                                    <td class="maintenance-id" hidden="hidden" name="${maintenanceHistory.id}"></td>
                                    <td><c:out value="${maintenanceHistory.stuId}"></c:out></td>
                                    <td><c:out value="${maintenanceHistory.dormName}"></c:out></td>
                                    <td><c:out value="${maintenanceHistory.description}"></c:out></td>
                                    <td><c:out value="${maintenanceHistory.time}"></c:out></td>
                                    <td class="state"><c:out value="${maintenanceHistory.state}"></c:out></td>
                                    <td class="do-repair" style="cursor: pointer;color:#529373">已修复</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                                <%--<tr>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>厕所的灯坏了</td>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td style="cursor: pointer;color:#529373">已修复</td>
                                </tr>
                                <tr>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>厕所的灯坏了</td>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td style="cursor: pointer;color:#529373">已修复</td>
                                </tr>
                                <tr>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>厕所的灯坏了</td>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td style="cursor: pointer;color:#529373">已修复</td>
                                </tr>
                                <tr>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>厕所的灯坏了</td>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td style="cursor: pointer;color:#529373">已修复</td>
                                </tr>
                            </tbody>--%>
                        </table>
                    </div>
                </div>

                <!-- 卫生检查记录模块 -->
                <div class="tab-panel" id="hygiene">
                    <div class="check-div">
                        <form action="/staff/chooseFloor" class="form-inline">
                            <span>记录卫生检查结果</span>
                            <label>请选择楼层：</label>
                            <select name="floor" class="form-control choose-flr">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                            <span class="now-time">现在是</span>
                            <a href="/staff/seeHygiene" class="see-hygiene" style="cursor: pointer">查看本月寝室卫生成绩单</a>
                        </form>

                    </div>
                    <div class="hygiene-body">
                        <form class="form-inline">
                            <c:forEach var="dorm" items="${dormList}" varStatus="i">
                                <c:if test="${i.count mod 10 eq 1}">
                                    <div class="col-sm-4" id="dorm-no">
                                </c:if>

                                <div class="form-group col-sm-7 hygiene-score">
                                    <%--<c:set var="no" value="寝室："></c:set>--%>
                                    <%--<c:set var="roomNo" value="${dorm.roomNo}${no}"></c:set>--%>
                                    <label><c:out value="${dorm.roomNo}"></c:out></label>
                                    <input type="text" class="form-control" placeholder="卫生检查分数">
                                </div>

                                <c:if test="${i.count mod 10 eq 0 || i.last}">
                                    </div>
                                </c:if>

                            </c:forEach>
                        </form>

                    </div>
                    <div id="hygiene-div">
                        <button type="button" class="btn btn-success hygiene-btn">保存</button>
                    </div>
                </div>

                <!-- 奖惩状况模块 -->
                <div class="tab-panel" id="rewardAndPunishment">
                    <div class="check-div">
                        <sapn class="col-sm-4">奖惩状况记录</sapn>
                        <div class="plus-rap col-sm-4" data-toggle="modal" data-target="#rapModal">
                            <div class="plus">+</div>
                            <span style="color:rgb(0, 179, 89);">添加奖惩记录</span>
                        </div>
                        <div class="col-sm-4 select-rap">
                            <form method="post" class="form-inline select-rap-form">
                                <div class="form-group">
                                    <label>寝室号：</label>
                                    <input type="text" id="roomNo" class="form-control" maxlength="3" onkeyup="value=value.replace(/[^\d]/g,'')">
                                </div>
                                <button type="submit" class="btn btn-success">查询</button>
                            </form>
                        </div>
                    </div>
                    <div class="rap-body">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <td>#</td>
                                    <td>奖惩状况</td>
                                    <td>寝室号</td>
                                    <td>学期</td>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="reward" varStatus="i" items="${rewardsList}">
                                <tr>
                                    <td><c:out value="${i.count}"></c:out></td>
                                    <td><c:out value="${reward.context}"></c:out></td>
                                    <td><c:out value="${reward.roomNo}"></c:out></td>
                                    <td><c:out value="${reward.term}"></c:out></td>
                                </tr>
                            </c:forEach>
                                <%--<tr>
                                    <td>2</td>
                                    <td>寝室有大功率电器</td>
                                    <td>303</td>
                                    <td>2017-2018上</td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>学期文明寝室</td>
                                    <td>415</td>
                                    <td>2017-2018上</td>
                                </tr>
                                <tr>
                                    <td>4</td>
                                    <td>党员寝室</td>
                                    <td>227</td>
                                    <td>2017-2018上</td>
                                </tr>--%>
                            </tbody>
                        </table>
                    </div>
                </div>

                <!-- 物品借还登记 -->
                <div class="tab-panel" id="borrow">
                    <div class="check-div">
                        <sapn class="col-sm-4">物品借还登记</sapn>
                        <div class="plus-rap col-sm-4" data-toggle="modal" data-target="#borrowModal">
                            <div class="plus">+</div>
                            <span style="color:rgb(0, 179, 89);">添加借物记录</span>
                        </div>
                    </div>
                    <div class="borrow-body">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>借物人学号</th>
                                    <th>寝室号</th>
                                    <th>物品</th>
                                    <th>借物时间</th>
                                    <th>归还情况/时间</th>
                                    <th>归还</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="equipment" items="${equipments}">
                                    <tr>
                                        <td class="equipment-id"><c:out value="${equipment.id}"></c:out></td>
                                        <td><c:out value="${equipment.stuId}"></c:out></td>
                                        <td><c:out value="${equipment.roomNo}"></c:out></td>
                                        <td><c:out value="${equipment.thingsName}"></c:out></td>
                                        <td><c:out value="${equipment.borrowTime}"></c:out></td>
                                        <td class="isReturned"><c:out value="${equipment.returnTime}"></c:out></td>
                                        <td class="returned" style="cursor: pointer;color:#529373">他已归还</td>
                                    </tr>
                                </c:forEach>
                                <%--<tr>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>打气筒</td>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td style="cursor: pointer;color:#529373">他已归还</td>
                                </tr>
                                <tr>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>打气筒</td>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td style="cursor: pointer;color:#529373">他已归还</td>
                                </tr>
                                <tr>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>打气筒</td>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td style="cursor: pointer;color:#529373">他已归还</td>
                                </tr>
                                <tr>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>打气筒</td>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td style="cursor: pointer;color:#529373">他已归还</td>
                                </tr>
                                <tr>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>打气筒</td>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td style="cursor: pointer;color:#529373">他已归还</td>
                                </tr>--%>
                            </tbody>
                        </table>
                    </div>
                    <%--分页--%>
                    <div class="page borrow-page">
                        <nav aria-label="Page navigation">
                            <ul class="pagination">
                                <c:forEach var="i" begin="1" end="${pageNumber}">
                                    <li><a href="#"><c:out value="${i}"></c:out></a></li>
                                </c:forEach>
                               <%-- <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li>--%>
                            </ul>
                        </nav>
                    </div>
                </div>

                <!-- 假期离校登记 -->
                <div class="tab-panel" id="holidaysLeave">
                    <div class="check-div">假期离校情况</div>
                    <div class="repair-body">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>学号</th>
                                    <th>寝室号</th>
                                    <th>离校时间</th>
                                    <th>目的地</th>
                                    <th>联系电话</th>
                                    <th>回校时间</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="leave" items="${leaveList}" varStatus="i">
                                    <tr>
                                        <td><c:out value="${i.count}"></c:out></td>
                                        <td><c:out value="${leave.stuId}"></c:out></td>
                                        <td><c:out value="${leave.roomNo}"></c:out></td>
                                        <td><c:out value="${leave.leavetime}"></c:out></td>
                                        <td><c:out value="${leave.destination}"></c:out></td>
                                        <td><c:out value="${leave.tel}"></c:out></td>
                                        <td class="return-time"><c:out value="${leave.returntime}"></c:out></td>
                                    </tr>
                                </c:forEach>
                                <%--<tr>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>2018-1-25</td>
                                    <td>义乌市</td>
                                    <td>10086</td>
                                    <td>2018-3-29</td>
                                </tr>
                                <tr>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>2018-1-25</td>
                                    <td>义乌市</td>
                                    <td>10086</td>
                                    <td>2018-3-29</td>
                                </tr>
                                <tr>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>2018-1-25</td>
                                    <td>义乌市</td>
                                    <td>10086</td>
                                    <td>2018-3-29</td>
                                </tr>
                                <tr>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>2018-1-25</td>
                                    <td>义乌市</td>
                                    <td>10086</td>
                                    <td>2018-3-29</td>
                                </tr>
                                <tr>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>xxx</td>
                                    <td>2018-1-25</td>
                                    <td>义乌市</td>
                                    <td>10086</td>
                                    <td>2018-3-29</td>
                                </tr>--%>
                            </tbody>
                        </table>
                    </div>
                    <div class="page leave-page">
                        <nav aria-label="Page navigation">
                            <ul class="pagination">
                                <c:forEach var="i" begin="1" end="${leavePageNumber}">
                                    <li><a href="#"><c:out value="${i}"></c:out></a></li>
                                </c:forEach>
                                <%-- <li><a href="#">2</a></li>
                                 <li><a href="#">3</a></li>
                                 <li><a href="#">4</a></li>
                                 <li><a href="#">5</a></li>--%>
                            </ul>
                        </nav>
                    </div>
                </div>

                <!-- 修改密码模块 -->
                <div class="tab-panel" id="changePsw">
                    <div class="check-div">
                        原始密码为666666
                    </div>
                    <div class="psw-body">
                        <form action="/staff/updatePassword" method="post" class="update-psw-form form-horizontal"
                              style="height: 200px">
                            <div class="form-group">
                                <label class="control-label col-xs-4">原密码：</label>
                                <div class="col-xs-5">
                                    <input name="previousPassword" type="password" class="form-control input-sm">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4">新密码：</label>
                                <div class="col-xs-5">
                                    <input name="newPassword" type="password" class="form-control input-sm"
                                           onkeyup="value=value.replace(/[^\d]/g,'')">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4">重复密码：</label>
                                <div class="col-xs-5">
                                    <input type="password" class="form-control input-sm">
                                </div>
                            </div>
                            <div class="col-xs-offset-4 col-xs-5">
                                <button type="reset" class="btn btn-xs btn-white">取 消</button>
                                <button type="button" class="update-psd-btn btn btn-xs btn-green">保存</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <!-- 添加奖惩状况模态框 -->
    <div class="modal fade" id="rapModal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">添加奖惩记录</h4>
                </div>
                <div class="modal-body">
                    <form action="/staff/addRewards" method="post" class="form-horizontal add-awards-form">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">奖惩状况：</label>
                            <div class="col-sm-8">
                                <input type="text" name="context" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">寝室号：</label>
                            <div class="col-sm-8">
                                <input type="text" name="roomNo" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">学期：</label>
                            <div class="col-sm-8">
                                <select name="term" class="form-control">
                                    <option>2017-2018上</option>
                                    <option>2017-2018下</option>
                                </select>
                            </div>
                            <input type="hidden" name="staffId" value="${staffDto.id}">
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary add-awards-btn">保存</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- 添加借还记录模态框 -->
    <div class="modal fade" id="borrowModal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">添加借物记录</h4>
                </div>
                <div class="modal-body">
                    <form action="/staff/borrow" method="post" class="form-horizontal borrow-form">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">借物人学号：</label>
                            <div class="col-sm-8">
                                <input type="text" name="stuId" class="form-control">
                            </div>
                        </div>
                        <%--<div class="form-group">
                            <label class="col-sm-3 control-label">寝室号：</label>
                            <div class="col-sm-8">
                                <input type="text" name="roomNo" class="form-control">
                            </div>
                        </div>--%>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">物品名称：</label>
                            <div class="col-sm-8">
                                <input type="text" name="thingsName" class="form-control">
                            </div>
                        </div>
                        <%--<input type="hidden" name="staffId" value="${staffDto.id}">--%>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary borrow-btn">保存</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->

<p class="select-error" hidden="hidden"><c:out value="${error}"></c:out></p>
<p class="borrow-msg" hidden="hidden"><c:out value="${message}"></c:out></p>
<p class="choose-flr-error" hidden="hidden"><c:out value="${chooseFlrNull}"></c:out></p>
<p class="current-flr" hidden="hidden"><c:out value="${floor}"></c:out></p>
<p class="update-psw-result" hidden="hidden"><c:out value="${requestScope.updatePasswordResult}"></c:out></p>
    <input type="hidden" id="refreshed" value="no">
</body>
<script src="../js/jquery-3.2.1.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery.cookie.js"></script>
<script src="../js/dorm-staff.js"></script>
</html>