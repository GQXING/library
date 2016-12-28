<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>借书证管理员</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/lendIDAdminster.css">
    <script src="js/jquery-1.10.1.js" type="text/javascript"></script>
    <script src="js/most.js" type="text/javascript" charset="utf-8" async defer></script>
    <s:if test="#request.status==1">
    	<style type="text/css">
    		#result{
    				display:block;
    			}
    	</style>
    </s:if>
     <s:if test="#request.modify==1">
    	<style type="text/css">
    		#modifyID{
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
                       <c:if test="${empty sessionScope.user}">
                        <td class="login"><a href="javascript:void(0)" onclick="login()">登入</a></td>
                        </c:if>
                        <c:if test="${!empty sessionScope.user}">
                        	 <td class="login">您好！${sessionScope.user.name }</td>
                         </c:if>
                        <td class="search">
                            <a href="${pageContext.request.contextPath }/loginAction_exit.action">注销</a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="mainBody">
        	<!-- 查询功能 -->
            <div id="checkpart">
                <form action="${pageContext.request.contextPath }/check_checkName.action"  method="post" accept-charset="utf-8">
                    &nbsp;姓&nbsp;名：
                    <input type="text" name="userName"> 所在单位：
                    <input type="text" name="dept"> 类型：
                    <select name="userType" style=" BORDER-BOTTOM: #808080 1px solid; BORDER-RIGHT-WIDTH: 1px; WIDTH: 150px; BORDER-TOP-WIDTH: 1px; COLOR: #5d91c0; FONT-SIZE: 14pt; BORDER-LEFT-WIDTH: 1px">
                        <option value="2" selected="selected">本科生</option>
                        <option value="1">教师</option>
                         <option value="3" >专科生</option>
                        <option value="4">硕士研究生</option>
                         <option value="5" >博士研究生</option>
                    </select>
                    <input type="submit" name="" value="查询" class="subtn" id="checkbtn">
                    <input type="button" name="" value="注册" class="subtn" id="handbtn">
                </form>
            </div>
            <!-- 假设查询到的结果 -->
            <div id="result" class="handleID" >
            	<s:if test="#request.reader==null">
            		<center><h3>哎呀，未查找到结果呀。。。。</h3></center>
            	</s:if>
            	<s:else>
            		<s:iterator var="entry" value="#request.reader">
	            	 <p> 借书证编号：
	                       <label><s:property value="#entry.rdID"/></label>
	                    </p>
	            	 <p> &nbsp;姓&nbsp;名：
	                        <label><s:property value="#entry.rdName"/></label>
	                    </p>
	                    <p> &nbsp;性&nbsp;别：
	                         <label><s:property value="#entry.rdSex"/></label>
	                    </p>
	                    <p> 所在单位：
	                        <label><s:property value="#entry.rdDept"/></label>
	                    </p>
	                    <p> 办证日期：
	                        <label><s:property value="#request.rdDateReg"/></label>
	                    </p>
	                    <p> 手机号码：
	                        <label><s:property value="#request.rdphone"/></label>
	                    </p>
	
	                    <p> 借书证状态：<label>
								<s:if test="#entry.rdStatus==1">有效
									<a href="${pageContext.request.contextPath }/check_lost.action?id=<s:property value='#entry.rdID'/>"><input type="button" name="" value="挂失" id="islost"></a>
									<a href="${pageContext.request.contextPath }/check_logout.action?id=<s:property value='#entry.rdID'/>"><input type="button" name="" value="注销" id="islost"></a>
								</s:if>
								<s:if test="#entry.rdStatus==0">挂失
									<a href="${pageContext.request.contextPath }/check_logout.action?id=<s:property value='#entry.rdID'/>"><input type="button" name="" value="注销" id="islost"></a>
									<a href="${pageContext.request.contextPath }/check_reback.action?id=<s:property value='#entry.rdID'/>"><input type="button" name="" value="恢复" id="islost"></a>
								</s:if>
	                    </p>
	                    <p>照片：</p>
	                    
	                        <div class='am-g'>
	                        	<img   src="<s:property value='#request.rdPhoto'/>"  width="100" height="150">
	                        </div>
	                    <p>
							<a href="${pageContext.request.contextPath }/check_find.action?id=<s:property value='#entry.rdID'/>"><input type="button"  value="修改" class="sbtn" id="modifybtn"></a>
	                    </p>
	                    </s:iterator>
                    </s:else>
            </div>
            <!-- 办理借书证的div -->
            <div id="handleID" class="handleID">
                <form action="${pageContext.request.contextPath }/handleRd_Add.action" method="post"  enctype="multipart/form-data">
                    	<p> &nbsp;姓&nbsp;名：
                        	<input type="text" name="reader.rdName">
                      	</p>
                       <p>
                        	 &nbsp;密 &nbsp;码：
                        	 <input type="password" name="reader.rdPwd">
                    	</p>
                    	<p> &nbsp;性&nbsp;别：
                        	<input type="checkbox" name="reader.rdSex" value="男">男 &nbsp;&nbsp;&nbsp;&nbsp;
                        	<input type="checkbox" name="reader.rdSex" value="女">女
                    	</p>
                    	<p> &nbsp;手&nbsp;机：
                        	<input type="text"  name="reader.rdphone">
                    	</p>
                    	
                    	<p> 所在单位：
                        <input type="text"  name="reader.rdDept">
                     	</p>
                    	<p> 办证日期：
                        	<input type="text" name="reader.rdDateReg"  id="dateValue" >
                   		 </p>
                   		 <p>&nbsp;类&nbsp;型：
		                  		<select name="reader.rdType" style=" BORDER-BOTTOM: #808080 1px solid; BORDER-RIGHT-WIDTH: 1px; WIDTH: 150px; BORDER-TOP-WIDTH: 1px; COLOR: #5d91c0; FONT-SIZE: 14pt; BORDER-LEFT-WIDTH: 1px">
		                       		<option value="2" selected="selected">本科生</option>
		                       		<option value="1">教师</option>
		                        	<option value="3" >专科生</option>
		                       		<option value="4">硕士研究生</option>
		                        	<option value="5" >博士研究生</option>
		                   </select>
                    	</p>
                    	<div id="photo"> 照片：
                        <input type="file" placeholder="上传图片"  name="photo"  id="photobtn"> 
                        </div>
                    	<input type="hidden" value="1" name="reader.rdPhoto"/>
                        <div class='am-g'>
                        	<img id="preview" alt="" width="100" height="150">
                        </div>
                    
                    <p>
                        <input type="submit" name="" value="提交" class="sbtn">
                    </p>
                </form>
            </div>
        	<!-- 处理证件是否办理成功 -->
			<s:if test="#request.AddRessult!=null">
        		<center><h2><s:property value="#request.AddRessult"/></h2></center>
        	</s:if>
            
            <!-- 借书证修改的div -->
            <div id="modifyID" class="handleID">
                <form action="${pageContext.request.contextPath }/handleRd_modify.action" method="post" >
                    <s:iterator var="entry" value="#request.readerm">
                    	<input type="hidden" value="<s:property value='#entry.rdID'/>"  name="reader.rdID"/>
	            	 <p> &nbsp;姓&nbsp;名：
	                        <input type="text" value="<s:property value='#entry.rdName'/>"  name="reader.rdName"/>
	                    </p>
	                    <p> &nbsp;性&nbsp;别：
	                    	<input type="checkbox" name="reader.rdSex" value="男">男 &nbsp;&nbsp;&nbsp;&nbsp;
                        	<input type="checkbox" name="reader.rdSex" value="女">女
                    	</p>
                    	<p>
                        	 &nbsp;密 &nbsp;码：
                        	 <input type="password" name="reader.rdPwd" value="<s:property value='#entry.rdPwd'/>" />
                    	</p>
	                    <p> 所在单位：
	                        <input type="text" value="<s:property value='#entry.rdDept'/>"  name="reader.rdDept">
	                    </p>
	                     <p>&nbsp;类&nbsp;型：
		                  		<select name="reader.rdType" style=" BORDER-BOTTOM: #808080 1px solid; BORDER-RIGHT-WIDTH: 1px; WIDTH: 150px; BORDER-TOP-WIDTH: 1px; COLOR: #5d91c0; FONT-SIZE: 14pt; BORDER-LEFT-WIDTH: 1px">
		                       		<option value="2" selected="selected">本科生</option>
		                       		<option value="1">教师</option>
		                        	<option value="3" >专科生</option>
		                       		<option value="4">硕士研究生</option>
		                        	<option value="5" >博士研究生</option>
		                   </select>
                    	</p>
	                    <p> 手机号码：
	                        <input type="text" value="<s:property value='#request.rdphone'/>"  name="reader.rdphone"/>
	                    </p>
	                   </s:iterator>
	                  <p>
                        <input type="submit" name="" value="提交" class="sbtn">
                    </p>
                </form>
            </div>
            
        </div>
        <!-- 下角标部分 -->
        <div class="footer">
            <p><span><a href="#">copyright@郭庆兴</a></span></p>
            <p><a href="#">联系方式：135*********</a></p>
            <p><a href="#">官方微信：******</a></p>
        </div>
    </div>
    
</body>

</html>
