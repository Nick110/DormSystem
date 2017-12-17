<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="../css/dorm-admin.css">
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
                <p id="userName">杨少侠</p>
                <p>
                    <a href="#">退出登录</a>
                </p>
            </div>
            <div class="menu-item menu-item-active" href="#announcements">
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
                <div class="tab-panel active" id="announcements">
                    <div class="check-div">
                        <span>发布公告</span>
                    </div>
                    <div class="announcements-body">
                        <form action="/staffHome/doAddNotice" class="form-horizontal" method="post">
                            <p>发布公告</p>
                            <hr>
                            <input type="hidden" name="staffId" value="${staffDto.id}">
                            <textarea name="context" class="form-control" rows="7" placeholder="公告内容"></textarea>
                            <div class="col-xs-offset-3 col-xs-5">
                                <button type="reset" class="btn btn-xs btn-white" style="margin-left: 20px;">取 消</button>
                                <button type="submit" class="btn btn-xs btn-green">保存</button>
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
                            <c:forEach var="noticeHistory" items="${noticeDtoHistory}">
                                <tbody>
                                    <tr>
                                        <td><c:out value="${noticeHistory.id}"></c:out></td>
                                        <td><c:out value="${noticeHistory.context}"></c:out></td>
                                        <td><c:out value="${noticeHistory.time}"></c:out></td>
                                    </tr>
                                </tbody>
                            </c:forEach>
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
                                    <th>报修人</th>
                                    <th>报修寝室号</th>
                                    <th>报修内容</th>
                                    <th>报修时间</th>
                                    <th>修复情况</th>
                                    <th>标记修复</th>
                                </tr>
                            </thead>
                            <tbody>
                                
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
                            </tbody>
                        </table>
                    </div>
                </div>

                <!-- 卫生检查记录模块 -->
                <div class="tab-panel" id="hygiene">
                    <div class="check-div">
                        <form action="" class="form-inline">
                            <span>记录卫生检查结果</span>
                            <label>请选择楼层：</label>
                            <select class="form-control">
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                                <option>6</option>
                            </select>
                        </form>
                    </div>
                    <div class="hygiene-body">
                        <form class="form-inline">
                            <div class="form-group col-sm-7">
                                <label>卫生检查分数：</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group col-sm-5">
                                <label>寝室号：</label>
                                <select class="form-control">
                                    <option>201</option>
                                    <option>202</option>
                                    <option>203</option>
                                    <option>204</option>
                                    <option>205</option>
                                </select>
                            </div>
                            <div class="form-group col-sm-7">
                                <label>卫生检查分数：</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group col-sm-5">
                                <label>寝室号：</label>
                                <select class="form-control">
                                    <option>201</option>
                                    <option>202</option>
                                    <option>203</option>
                                    <option>204</option>
                                    <option>205</option>
                                </select>
                            </div>
                            <div class="form-group col-sm-7">
                                <label>卫生检查分数：</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group col-sm-5">
                                <label>寝室号：</label>
                                <select class="form-control">
                                    <option>201</option>
                                    <option>202</option>
                                    <option>203</option>
                                    <option>204</option>
                                    <option>205</option>
                                </select>
                            </div>
                            <div class="form-group col-sm-7">
                                <label>卫生检查分数：</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group col-sm-5">
                                <label>寝室号：</label>
                                <select class="form-control">
                                    <option>201</option>
                                    <option>202</option>
                                    <option>203</option>
                                    <option>204</option>
                                    <option>205</option>
                                </select>
                            </div>
                            <div class="form-group col-sm-7">
                                <label>卫生检查分数：</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group col-sm-5">
                                <label>寝室号：</label>
                                <select class="form-control">
                                    <option>201</option>
                                    <option>202</option>
                                    <option>203</option>
                                    <option>204</option>
                                    <option>205</option>
                                </select>
                            </div>
                            <div class="form-group col-sm-7">
                                <label>卫生检查分数：</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group col-sm-5">
                                <label>寝室号：</label>
                                <select class="form-control">
                                    <option>201</option>
                                    <option>202</option>
                                    <option>203</option>
                                    <option>204</option>
                                    <option>205</option>
                                </select>
                            </div>
                            <div class="form-group col-sm-7">
                                <label>卫生检查分数：</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group col-sm-5">
                                <label>寝室号：</label>
                                <select class="form-control">
                                    <option>201</option>
                                    <option>202</option>
                                    <option>203</option>
                                    <option>204</option>
                                    <option>205</option>
                                </select>
                            </div>
                            <div class="form-group col-sm-7">
                                <label>卫生检查分数：</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group col-sm-5">
                                <label>寝室号：</label>
                                <select class="form-control">
                                    <option>201</option>
                                    <option>202</option>
                                    <option>203</option>
                                    <option>204</option>
                                    <option>205</option>
                                </select>
                            </div>
                            <br>
                            <button type="submit" class="btn btn-default">保存</button>
                        </form>
                    </div>
                </div>

                <!-- 奖惩状况模块 -->
                <div class="tab-panel" id="rewardAndPunishment">
                    <div class="check-div" data-toggle="modal" data-target="#rapModal">
                        <sapn class="col-sm-4">奖惩状况记录</sapn>
                        <div class="plus-rap col-sm-4">
                            <div class="plus">+</div>
                            <span style="color:rgb(0, 179, 89);">添加奖惩记录</span>
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
                                <tr>
                                    <td>1</td>
                                    <td>学期文明寝室</td>
                                    <td>227</td>
                                    <td>2017-2018上</td>
                                </tr>
                                <tr>
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
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>

                <!-- 物品借还登记 -->
                <div class="tab-panel" id="borrow">
                    <div class="check-div" data-toggle="modal" data-target="#borrowModal">
                        <sapn class="col-sm-4">物品借还登记</sapn>
                        <div class="plus-rap col-sm-4">
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
                                    <th>借物寝室号</th>
                                    <th>物品</th>
                                    <th>借物时间</th>
                                    <th>归还情况/时间</th>
                                    <th>归还</th>
                                </tr>
                            </thead>
                            <tbody>
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
                            </tbody>
                        </table>
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
                            </tbody>
                        </table>
                    </div>
                </div>

                <!-- 修改密码模块 -->
                <div class="tab-panel" id="changePsw">
                    <div class="check-div">
                        原始密码为666666
                    </div>
                    <div class="psw-body">
                        <form action="" class="form-horizontal" style="height: 200px">
                            <div class="form-group">
                                <label class="control-label col-xs-4">原密码：</label>
                                <div class="col-xs-5">
                                    <input type="password" class="form-control input-sm">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4">新密码：</label>
                                <div class="col-xs-5">
                                    <input type="password" class="form-control input-sm">
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
                                <button type="submit" class="btn btn-xs btn-green">保存</button>
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
                    <form action="" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">奖惩状况：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">寝室号：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">学期：</label>
                            <div class="col-sm-8">
                                <select name="" class="form-control">
                                    <option>2017-2018上</option>
                                    <option>2017-2018下</option>
                                </select>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary">保存</button>
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
                    <form action="" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">借物人：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">寝室号：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">物品名称：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">借物日期：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary">保存</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->
</body>
<script src="../js/jquery-3.2.1.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/dorm-admin.js"></script>

</html>