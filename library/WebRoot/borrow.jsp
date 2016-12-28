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
    <s:if test="#request.status==1">
    	<style type="text/css">
    		#borrown_readerinfo{
    				display:block;
    			}
    	</style>
    </s:if>
    <s:if test="#request.status==2">
    	<style type="text/css">
    		#borrown_bookinfo{
    				display:block;
    			}
    	</style>
    </s:if>
    <s:if test="#request.status==3">
    	<style type="text/css">
    		#borrown_bookResult{
    				display:block;
    			}
    	</style>
    </s:if>
    <s:if test="#request.lendBookResult==1">
    	<style type="text/css">
    		#lendBookResult{
    				display:block;
    			}
    	</style>
    </s:if>
    <s:if test="#request.continueResult!=null">
    	<style type="text/css">
    		#continueResultDiv{
    				display:block;
    			}
    	</style>
    </s:if>
    <s:if test="#request.punishMoney!=null">
    	<style type="text/css">
    		#punishResultDiv{
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
                        <c:if test="${empty sessionScope.borrowAdmin}">
                            <td class="login"><a href="javascript:void(0)" onclick="login()">登入</a></td>
                        </c:if>
                        <c:if test="${!empty sessionScope.borrowAdmin}">
                            <td class="login">您好！${sessionScope.borrowAdmin.name }</td>
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
                    <input type="button" name="" value="读者查询" class="borrow_function" id="borrown_readercheckbtn">
                </a>
                <a href="#" title="">
                    <input type="button" name="" value="图书查询" class="borrow_function" id="borrown_bookcheckbtn">
                </a>
                <a href="#" title="">
                    <input type="button" name="" value="续借/归还" class="borrow_function" id="borrown_bookContinue">
                </a>
            </div>
            <!--读者查询-->
            <div id="borrown_readercheck" class="handleID">
                <form action="${pageContext.request.contextPath }/borrow_checkreader.action" method="post" accept-charset="utf-8">
                    <p> 借&nbsp;书&nbsp;证&nbsp;名&nbsp;：
                        <input type="text" name="readID">
                    </p>
                    <p>
                        <input type="submit" name="" value="查找" class="sbtn" id="">
                    </p>
                </form>
            </div>
            <!--图书查询-->
            <div id="borrown_bookcheck" class="handleID">
                <form action="${pageContext.request.contextPath }/borrow_checkbook.action" method="post" accept-charset="utf-8">
                    <p> &nbsp;&nbsp;书&nbsp;号&nbsp;：
                        <input type="text" name="bkID">
                    </p>
                    <p>
                        <input type="submit" name="" value="查找" class="sbtn" id="bookmodifybtn">
                    </p>
                </form>
            </div>
            <!-- <-相关图书图书信息 -->
            <div id="borrown_bookinfo" class="handleID">
             <s:if test="#request.bookInfo==null">
            		<center><h3>哎呀，您输入的书号未查找到结果呀。。。。</h3></center>
              </s:if>
              <s:else>
               <s:iterator var="entry" value="#request.bookInfo">
               <form action="${pageContext.request.contextPath }/borrow_lendBook.action" method="post" accept-charset="utf-8">
                <p> &nbsp;&nbsp;书&nbsp;名&nbsp;：
                    <s:property value="#entry.bkName" />
                </p>
                <p> &nbsp;&nbsp;作&nbsp;者&nbsp;：
                    <s:property value="#entry.bkAuthor" />
                </p>
                <p> &nbsp;出版社：
                    <s:property value="#entry.bkPress" />
                </p>
                <p> 出版日期：
                    <s:property value="#entry.bkDatePress" />
                </p>
                <p> &nbsp;页&nbsp;数：
                    <s:property value="#entry.bkPages" />
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
                    <s:property value="#entry.bkPrice" />
                </p>
                <p> ISBN：
                    <s:property value="#entry.bkISBN" />
                </p>
                <p>图书编号：
                    <s:property value="#entry.bkID" />
                </p>
                
                <div id="showbrief">
                    简介：<s:property value='#entry.bkBrief' />
                     </div>
               
                <p>状态：
                	
                    <s:property value='#entry.bkStatus' />
                   
                </p>
                <input type="hidden" value="<s:property value='#entry.bkID' />"  name="bkID"/>
                <p>读者证ID：
                     <input type="text" name="readID"  id="">
                </p>
                <p>借书操作员：
                     <input type="text" name="OperatorLend"  id="">
                </p>
                <p>
                    <input type="submit" name="" value="借书" class="sbtn" id="">
                </p>
                </form>
                </s:iterator>
               </s:else>
            </div>
            <!--查找到的读者信息-->
            <div id="borrown_readerinfo" class="handleID">
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
                <p> 借书证状态：
                	<label>
                		<s:if test="#entry.rdStatus==1">有效</s:if>
                		<s:if test="#entry.rdStatus==0">挂失</s:if>
                    </label>
                </p>
                <p>借书数量是否超期：
                	<label><s:property value="#request.rd_bkQty"/></label>
                </p>
                <p> 欠款：
                	<label>
                		<s:if test="#request.borrow_money==0.0">没有欠款</s:if>
                		<s:else><s:property value="#request.borrow_money"/></s:else>
                    </label>
                </p>
                <s:if test="#request.borrow_money !=0.0">
					<p><a href="${pageContext.request.contextPath }/borrow_punishMoney.action?rdID=<s:property value='#entry.rdID'/>">
					 <input type="button" name="" value="缴费" class="sbtn" >
					</p></a>
				</s:if>
                </s:iterator>
               </s:else>
              </div>
              <div id="lendBookResult" class="handleID">
          		<center><h2><s:property value="#request.lenderName"/>已经借书成功！</h2></center>
          	  </div>
          	  <!-- （1） 续借/归还 输入图书书号 -->
            <div id="borrown_continue" class="handleID">
                <form action="${pageContext.request.contextPath }/borrow_findByBk.action" method="post" accept-charset="utf-8">
                    <center><h3>请输入续借和归还的图书</h3></center>
                    <p>图书书号：
                        <input type="text" name="bkID" value="" placeholder="">
                    </p>
                    <p><input type="submit" name="" value="确定" class="sbtn"></p>
                </form>
            </div>
            <!-- (2) 系统查询并获取图书对象、未归还状态的借阅记录对象、及其读者对象，并进行显示。 -->
            <div id="borrown_bookResult" class="handleID">
                <table id="resultTable" style="border: 1px solid black">
                    <caption><h2>借阅情况</h2></caption>
                    <thead  border="1" align="center">
                        <tr>
                        	<th>序号</th>
                            <th>书名</th>
                            <th>读者</th>
                            <th>还书日期</th>
                            <th>已借次数</th>
                            <th>可借次数</th>
                            <th>续借</th>
                            <th>归还</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<s:iterator var="vr" value="#request.list" status="st">
                    		<s:if test="#vr.IsHasReturn==false">
		                        <tr>	
		                            <td><s:property value="#st.getCount()" /></td>
		                            <td><s:property value="#vr.bkName" /></td>
		                            <td><s:property value="#vr.rdName" /></td>
		                            <td>20<s:property value="#vr.IdDateRetPlan" /></td>
		                            <td><s:property value="#vr.IdContinueTimes" /></td>
		                            <td><s:property value="#vr.CanContinueTimes" /></td>
		                            <td>
		                            	<s:if test="#vr.IdContinueTimes<#vr.CanContinueTimes">
			                            	<a href="${pageContext.request.contextPath }/borrow_continueLend.action?bkID=<s:property value='#vr.bkID'/>&rdID=<s:property value='#vr.rdID'/>">续借</a>
		                            	</s:if>
		                            	<s:else>
		                            		不可续借
		                            	</s:else>
		                            	
		                            </td>
		                            <td>
		                            	<a href="${pageContext.request.contextPath }/borrow_returnBook.action?bkID=<s:property value='#vr.bkID'/>&rdID=<s:property value='#vr.rdID'/>">归还</a>
		                            </td>
		                        </tr>
	                        </s:if>
                        </s:iterator>
                    </tbody>
                </table>
            </div>
            <div id="continueResultDiv"  class="handleID" >
            	<center><h2><s:property value="#request.continueResult"/></h2></center>
            </div>
            <div id="returnResultDiv"  class="handleID" >
            	<center><h2><s:property value="#request.returnBookResult"/></h2></center>
            </div>
            <div id="punishResultDiv"  class="handleID" >
            	<center><h2>缴费成功！</h2></center>
            </div>
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
    $('#borrown_readercheckbtn').click(function() {
        console.log('test');
        $('#borrown_readercheck').css('display', 'block');
        $('#borrown_bookcheck').css('display', 'none');
        $('#borrown_bookinfo').css('display', 'none');
        $('#borrown_readerinfo').css('display', 'none');
         $('#borrown_continue').css('display', 'none');
          $('#borrown_bookResult').css('display', 'none');continueResultDiv
        $('#continueResultDiv').css('display', 'none');
        $('#returnResultDiv').css('display', 'none');
        $('#punishResultDiv').css('display', 'none');
        $('#lendBookResult').css('display', 'none');
    });
    $('#borrown_bookcheckbtn').click(function() {
        $('#borrown_bookcheck').css('display', 'block');
        $('#borrown_readercheck').css('display', 'none');
        $('#borrown_bookinfo').css('display', 'none');
        $('#borrown_readerinfo').css('display', 'none');
        $('#borrown_continue').css('display', 'none');
        $('#borrown_bookResult').css('display', 'none');
        $('#borrown_bookResult').css('display', 'none');
        $('#continueResultDiv').css('display', 'none');
        $('#returnResultDiv').css('display', 'none');
        $('#punishResultDiv').css('display', 'none');
        $('#lendBookResult').css('display', 'none');
    });
    $('#borrown_bookContinue').click(function() {
        $('#borrown_continue').css('display', 'block');
        $('#borrown_bookcheck').css('display', 'none');
        $('#borrown_readercheck').css('display', 'none');
        $('#borrown_bookinfo').css('display', 'none');
        $('#borrown_readerinfo').css('display', 'none');
        $('#borrown_bookResult').css('display', 'none');
        $('#continueResultDiv').css('display', 'none');
        $('#returnResultDiv').css('display', 'none');
        $('#punishResultDiv').css('display', 'none');
        $('#lendBookResult').css('display', 'none');
    });
    </script>
</body>

</html>
