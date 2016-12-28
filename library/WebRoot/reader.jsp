<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>借阅管理员</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/lendIDAdminster.css">
    <script src="js/jquery-1.10.1.js" type="text/javascript"></script>
    <script src="" type="text/javascript" charset="utf-8" async defer></script>
    <s:if test="#request.modifyResult !=null">
    	<style type="text/css">
    		#modifyResultDiv{
    				display:block;
    			}
    	</style>
    </s:if>
    <s:if test="#request.bookList !=null">
    	<style type="text/css">
    		#readerBook{
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
                <a href="#" title="">
                    <input type="button" name="" value="个人信息" class="borrow_function" id="readerInfo_btn">
                </a>
                <a href="${pageContext.request.contextPath }/reader_borrowBook.action" title="">
                    <input type="button" name="" value="已借图书" class="borrow_function" id="readerBook_btn">
                </a>
                <a href="#" title="">
                    <input type="button" name="" value="修改密码" class="borrow_function" id="modifyPwd_btn">
                </a>
            </div>
            <!--密码修改-->
            <div id="modifyPwd" class="handleID">
                <form action="${pageContext.request.contextPath }/reader_modifyPwd.action" method="post" accept-charset="utf-8">
                    <p> 原&nbsp;密&nbsp;码&nbsp;：
                        <input type="text" value="${reader.rdPwd }">
                    </p>
                    <p> 新&nbsp;密&nbsp;码&nbsp;：
                        <input type="text" name="password">
                    </p>
                    <p>
                        <input type="submit" name="" value="确定" class="sbtn" ></a>
                    </p>
                </form>
            </div>
            <!--读者信息显示-->
            <div id="readerinfo" class="handleID">
            		
	                <p> 借书证编号：
	                    <label>${reader.rdID }</label>
	                </p>
	                <p> &nbsp;姓&nbsp;名：
	                    <label>${reader.rdName }</label>
	                </p>
	                <p> &nbsp;性&nbsp;别：
	                    <label>${reader.rdSex }</label>
	                </p>
	                <p> 所在单位：
	                    <label>${reader.rdDept }</label>
	                </p>
	                <p> 办证日期：
	                    <label>${reader.rdDateReg }</label>
	                </p>
	                <p> 借书证状态：
	                 	
		                <label id="status">
			               
		                </label>
	                </p>
	                <p> 手机号码：
	                       <label>${reader.rdphone }</label>
	                   </p>
	                <p>照片：</p>
	                <div class='am-g'>
	                        	<img   src="${reader.rdPhoto }"  width="100" height="150">
	                        </div>
                
            </div>
           <!-- 已借图书 -->
            <div id="readerBook" class="handleID">
                <table id="resultTable" style="border: 1px solid black">
                    <caption><h2>借阅情况</h2></caption>
                    <thead  border="1" align="center">
                        <tr>
                            <th>序号</th>
                            <th>书名</th>
                            <th>出版社</th>
                            <th>作者</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<s:iterator var="vr" value="#request.bookList" status="st">
                        <tr>
                            <td><s:property value="#st.getCount()" /></td>
                            <td><s:property value="#vr.bkName" /></td>
                            <td><s:property value="#vr.bkPress" /></td>
                            <td><s:property value="#vr.bkAuthor" /></td>
                            
                        </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </div>
            <div id="modifyResultDiv" class="handleID">
            	<center><h2><s:property value="#request.modifyResult"/></h2></center>
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
        $('#readerBook').css('display', 'none');
        $('#modifyPwd').css('display', 'none');
        $('#modifyResultDiv').css('display', 'none');
    });
    $('#readerBook_btn').click(function() {
        $('#readerinfo').css('display', 'none');
        $('#readerBook').css('display', 'block');
        $('#modifyPwd').css('display', 'none');
        $('#modifyResultDiv').css('display', 'none');
    });
    $('#modifyPwd_btn').click(function() {
        $('#readerinfo').css('display', 'none');
        $('#readerBook').css('display', 'none');
        $('#modifyPwd').css('display', 'block');
        $('#modifyResultDiv').css('display', 'none');
    });
    if(parseInt(${reader.rdStatus })==1){
    	$('#status').html("有效");
    }else{
    	$('#status').html("挂失");
    }
    </script>
</body>

</html>
