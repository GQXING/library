<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>图书管理员</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/lendIDAdminster.css">
    <script src="js/jquery-1.10.1.js" type="text/javascript"></script>
    <script src="js/bookAdmin.js" type="text/javascript" charset="utf-8" async defer></script>
    <s:if test="#request.bookStatus==1">
    	<style type="text/css">
    		#bookresultbtnDiv{
    				display:block;
    			}
    	</style>
    </s:if>
    <s:if test="#request.bookStatus==2">
    	<style type="text/css">
    		#bookmodifybtnDiv{
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
       
            <div id="checkpart">
                <a href="#" title="">
                    <input type="button" name="" value="图书查找" class="functionbtn" id="bookcheckbtn">
                </a>
                <a href="#" title="">
                    <input type="button" name="" value="图书入库" class="functionbtn" id="bookinsertbtn">
                </a>
                <a href="#" title="">
                    <input type="button" name="" value="图书销毁" class="functionbtn" id="bookdeletebtn">
                </a>
            </div>
            <!--查找图书-->
            <div id="findBookDiv" class="handleID">
                <form action="${pageContext.request.contextPath }/book_checkBook.action" method="post" accept-charset="utf-8">
                    <p> &nbsp;&nbsp;书&nbsp;名&nbsp;：
                        <input type="text" name="bookName">
                    </p>
                    <p> ISBN&nbsp;书号：
                        <input type="text" name="bookNo" />
                    </p>
                    <p>
                        <input type="submit" name="" value="查找" class="sbtn" id="bookmodifybtn">
                    </p>
                </form>
            </div>
            <!-- 添加入图书信息 -->
            <div id="bookinsertbtnDiv" class="handleID">
                <form action="${pageContext.request.contextPath }/book_insertBook.action" method="post" accept-charset="utf-8">
                    <p> &nbsp;&nbsp;书&nbsp;名&nbsp;：
                        <input type="text" name="book.bkName">
                    </p>
                    <p> &nbsp;&nbsp;作&nbsp;者&nbsp;：
                        <input type="text" name="book.bkAuthor"/>
                    </p>
                    <p> &nbsp;出版社：
                        <input type="text" name="book.bkPress">
                    </p>
                    <p> 出版日期：
                        <input type="text" name="book.bkDatePress" placeholder="2016-6-6">&nbsp;
                    </p>
                    
                    <p> &nbsp;页&nbsp;数：
                        <input type="text" name="book.bkPages" >
                    </p>
                    <p> &nbsp;语&nbsp;言：
                        <select id="selectId" onclick="choose(this)" name="book.bkLanguage" style=" BORDER-BOTTOM: #808080 1px solid; BORDER-RIGHT-WIDTH: 1px; WIDTH: 150px; BORDER-TOP-WIDTH: 1px; COLOR: #5d91c0; FONT-SIZE: 14pt; BORDER-LEFT-WIDTH: 1px">
                            <option value="0" selected="selected">中文</option>
                            <option value="1">英文</option>
                            <option value="2">日文</option>
                            <option value="3">俄文</option>
                            <option value="4">德文</option>
                            <option value="5">法文</option>
                        </select>
                    </p>
                    <p> &nbsp;单&nbsp;价：
                        <input type="text" name="book.bkPrice" >
                    </p>
                    <p> ISBN：
                        <input type="text" name="book.bkISBN" >
                    </p>
                    <p>简介：
                        <input type="textArea" name="book.bkBrief" >
                    </p>
                    <p>图书编号：
                        <input type="text" name="book.bkCode" >
                    </p>
                    <p> 状态：
                        <input type="radio" name="book.bkStatus" value="在馆">在馆&nbsp;
                        <input type="radio" name="book.bkStatus" value="借出">借出&nbsp;
                        <input type="radio" name="book.bkStatus" value="遗失">遗失&nbsp;
                        <input type="radio" name="book.bkStatus" value="变卖">变卖&nbsp;
                        <input type="radio" name="book.bkStatus" value="销毁">销毁&nbsp;
                    </p>
                    <p>
                        <input type="submit" name="" value="提交" class="sbtn" >
                    </p>
                </form>
            </div>
            <!-- 假设查询到的结果 -->
            <div id="bookresultbtnDiv" class="handleID">
              <s:if test="#request.book==null">
            		<center><h3>哎呀，未查找到结果呀。。。。</h3></center>
               </s:if>
               <s:else>
               <center style="margin-top: 10px;">
                    <h3>图书信息</h3></center>
               <s:iterator var="entry" value="#request.book">
                <p> &nbsp;&nbsp;书&nbsp;名&nbsp;：
                   <s:property value="#entry.bkName"/>
                </p>
                <p> &nbsp;&nbsp;作&nbsp;者&nbsp;：
                   <s:property value="#entry.bkAuthor"/>
                </p>
                <p> &nbsp;出版社：
                     <s:property value="#entry.bkPress"/>
                </p>
                <p> 出版日期：
                      <s:property value="#entry.bkDatePress"/>
                </p>
                <p> &nbsp;页&nbsp;数：
                    <s:property value="#entry.bkPages"/>
                </p>
                <p> &nbsp;语&nbsp;言：
                	<s:if test="#entry.bkLanguage==0">
                		中文
                	</s:if>
                	<s:if test="#entry.bkLanguage==1">
                		英文
                	</s:if>
                	<s:if test="#entry.bkLanguage==2">
                		日文
                	</s:if>
                	<s:if test="#entry.bkLanguage==3">
                		俄文
                	</s:if>
                	<s:if test="#entry.bkLanguage==4">
                		德文
                	</s:if>
                	<s:if test="#entry.bkLanguage==5">
                		法文
                	</s:if>
                </p>
                <p> &nbsp;单&nbsp;价：
                      <s:property value="#entry.bkPrice"/>
                </p>
                <p> ISBN：
                    <s:property value="#entry.bkISBN"/>
                </p>
                <p>图书编号：
                     <s:property value="#entry.bkID"/>
                </p>
                <p>简介：
                    <s:property value='#entry.bkBrief'/>
                </p>
                 <p>状态：
                    <s:property value='#entry.bkStatus'/>
                </p>
                <p>
                    <a href="${pageContext.request.contextPath }/book_findmodify.action?id=<s:property value='#entry.bkID'/>"><input type="button" name="" value="修改" class="sbtn" id="bookResult"></a>
                </p>
                </s:iterator>
               </s:else>
            </div>
            <!--销毁图书-->
            <div id="bookdeletebtnDiv" class="handleID">
                <form action="${pageContext.request.contextPath }/book_delete.action" method="post" accept-charset="utf-8">
                    <p> &nbsp;&nbsp;书&nbsp;名&nbsp;：
                        <input type="text" name="bookName">
                    </p>
                    <p> ISBN&nbsp;书号：
                        <input type="text" name="bookNo" />
                    </p>
                    <p>
                        <input type="submit" name="" value="删除" class="sbtn">
                    </p>
                </form>
            </div>
            <!-- 修改图书-->
            <div id="bookmodifybtnDiv" class="handleID">
              
                <center style="margin-top: 10px;">
                 	<h3>修改图书</h3></center> 
                 	
                <form action="${pageContext.request.contextPath }/book_modify.action"  method="post">
                 <s:iterator var="entry" value="#request.bookm">
                <p> &nbsp;&nbsp;书&nbsp;名&nbsp;：
                	
                    <input type="text" name="book.bkName" value="<s:property value='#entry.bkName'/>">
                </p>
                <p> &nbsp;&nbsp;作&nbsp;者&nbsp;：
                    <input type="text" name="book.bkAuthor" value="<s:property value='#entry.bkAuthor'/>"/>
                </p>
                <p> &nbsp;出版社：
                    <input type="text" name="book.bkPress" value="<s:property value='#entry.bkPress'/>">
                </p>
                <p> 出版日期：
                    <input type="text" name="book.bkDatePress"  value="<s:property value='#entry.bkDatePress'/>">
                </p>
                <p> &nbsp;页&nbsp;数：
                    <input type="text" name="book.bkPages" value="<s:property value='#entry.bkPages'/>">
                </p>
                <p> &nbsp;语&nbsp;言：
                    <select id="selectId" onclick="choose(this)" name="book.bkLanguage" style=" BORDER-BOTTOM: #808080 1px solid; BORDER-RIGHT-WIDTH: 1px; WIDTH: 150px; BORDER-TOP-WIDTH: 1px; COLOR: #5d91c0; FONT-SIZE: 14pt; BORDER-LEFT-WIDTH: 1px">
                        <option value="0" selected="selected">中文</option>
                        <option value="1">英文</option>
                        <option value="2">日文</option>
                        <option value="3">俄文</option>
                        <option value="4">德文</option>
                        <option value="5">法文</option>
                    </select>
                </p>
                <p> &nbsp;单&nbsp;价：
                    <input type="text" name="book.bkPrice" value="<s:property value='#entry.bkPrice'/>">
                </p>
                <p> ISBN：
                    <input type="text" name="book.bkISBN" value="<s:property value='#entry.bkISBN'/>">
                </p>
                <p>简介：
                    <input type="text" name="book.bkBrief" value="<s:property value='#entry.bkBrief'/>">
                </p>
                 <p>状态：
                    <input type="text" name="book.bkStatus" value="<s:property value='#entry.bkStatus'/>">
                </p>
                <input type="hidden" name="book.bkID" value="<s:property value='#entry.bkID'/>"/>
                </s:iterator>
                <p>
                    <input type="submit"  value="确定" class="sbtn">
                </p>
               </form>
            </div>
            <s:if test="#request.bookStatus==3">
    			<center class="message"><h3>修改成功啦</h3></center>
    	 	</s:if>
    	  	<s:if test="#request.bookStatus==4">
    			<center class="message"><h3>插入成功啦</h3></center>
    	 	</s:if>
    	 	<s:if test="#request.bookStatus==5">
    			<center class="message"><h3>删除成功啦</h3></center>
    		 </s:if>
        </div>
        <!-- 下角标部分 -->
        <div class="footer">
            <p><span><a href="#">copyright@郭庆兴</a></span></p>
            <p><a href="#">联系方式：135*********</a></p>
            <p><a href="#">官方微信：******</a></p>
        </div>
    </div>
    <script type="text/javascript">
    </script>
</body>

</html>
