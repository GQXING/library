<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>系统管理员</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/lendIDAdminster.css">
    <script src="js/jquery-1.10.1.js" type="text/javascript"></script>
    <script src="" type="text/javascript" charset="utf-8" async defer></script>
    <s:if test="#request.status==1">
    	<style type="text/css">
    		#readerinfo{
    				display:block;
    			}
    	</style>
    </s:if>
    <s:if test="#request.status==2">
    	<style type="text/css">
    		#setAdminResult{
    				display:block;
    			}
    	</style>
    </s:if>
    
</head>

<body>
    <div id="main">
        <!-- logo部分 -->
        <div id="header">
            <embed src="swf/logo.swf" width="100%" style="height: 152px;">
        </div>
        <!-- 菜单栏部分 -->
        <div id="menu">
            <ul id="alist">
                <a href="${pageContext.request.contextPath }/index.jsp">
                    <li class="ali">&nbsp;首&nbsp;页</li>
                </a>
                <a href="" title="">
                    <li class="ali">本馆概况</li>
                </a>
                <a href="" title="">
                    <li class="ali">学术资源</li>
                </a>
                <a href="" title="">
                    <li class="ali">馆长信箱</li>
                </a>
                <a href="" title="">
                    <li class="ali">书香长大</li>
                </a>
            </ul>
            <table align="right">
                <tbody>
                    <tr>
                        <!-- <c:if test="${empty sessionScope.user}">
                            <td class="login"><a href="javascript:void(0)" onclick="login()">登入</a></td>
                        </c:if>
                        <c:if test="${!empty sessionScope.user}">
                            <td class="login">您好！${sessionScope.user.name }</td>
                        </c:if>
                        <td class="search"> 
                            <a href="${pageContext.request.contextPath }/index.jsp">返回首页</a>
                        </td>-->
                        <td class="search">
                            <a href="${pageContext.request.contextPath }/loginAction_exit.action">注销</a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="mainBody">
            <div id="checkpart">
                <form action="${pageContext.request.contextPath }/admin_checkreader.action"  method="post" accept-charset="utf-8" id="menu_function">
                    借书证号：<input type="text" name="readerID" id="readerInfo_text" />
                    <input type="submit" name="" value="查询"  id="readerInfo_btn">
                </form>
            </div>
            <!--读者信息显示-->
            <div id="readerinfo" class="handleID">
            <form action="${pageContext.request.contextPath }/admin_setAdmin.action""  method="post" accept-charset="utf-8" id="menu_function">
               
               <s:if test="#request.readerInfo==null">
            		<center><h3>哎呀，您输入的读者证未查找到结果呀。。。。</h3></center>
               </s:if>
               <s:else>
               	<s:iterator var="entry" value="#request.readerInfo">
                <p> 借书证编号：
                    <label><s:property value="#entry.rdID"/></label>
                </p>
                <p> &nbsp;姓&nbsp;名：
                    <label><s:property value="#entry.rdName"/></label>
                </p>
                <p> 所在单位：
                    <label><s:property value="#entry.rdDept"/></label>
                </p>
                <p> 办证日期：
                   <label><s:property value="#entry.rdDateReg"/></label>
                </p>
                <input type="hidden" value="<s:property value='#entry.rdName'/>"  name="user.name"/>
                <input type="hidden" value="<s:property value='#entry.rdPwd'/>"  name="user.password"/>
				<p>设置类型：
                    <select name="user.userType" style=" BORDER-BOTTOM: #808080 1px solid; BORDER-RIGHT-WIDTH: 1px; WIDTH: 150px; BORDER-TOP-WIDTH: 1px; COLOR: #5d91c0; FONT-SIZE: 14pt; BORDER-LEFT-WIDTH: 1px">
                        <option value="2" selected="selected">借阅证管理员</option>
                        <option value="3">图书管理员</option>
                        <option value="4">借阅管理员</option>
                    </select>
                </p>
                <p>
                    <input type="submit" name="" value="确定" class="sbtn" />
                </p>
				
                </s:iterator>
                
               </s:else>
                
                </form>
            </div>
            <div id="setAdminResult"  class="handleID" >
            	<center><h2><s:property value="#request.statusName"/>的证件身份办理成功！</h2></center>
            </div>
        </div>
        <!-- 下角标部分 -->
        <div class="footer">
            <p><span><a href="#">copyright@郭庆兴</a></span></p>
            <p><a href="#">联系方式：135*********</a></p>
            <p><a href="#">官方微信：******</a></p>
        </div>
    </div>
    <script type="text/javascript">
    $('#readerInfo_btn').click(function() {
        $('#readerinfo').css('display', 'block');
    });
    
    </script>
</body>

</html>
