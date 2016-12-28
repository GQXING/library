<%@page import="com.gqx.dao.impl.BookDaoImpl"%>
<%@page import="com.gqx.entity.Book"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>长江大学图书馆</title>
    <link rel="stylesheet" href="css/style.css">
    <script src="js/jquery-1.10.1.js" type="text/javascript"></script>
    <script src="js/most.js" type="text/javascript" charset="utf-8" async defer></script>
    <script src="js/head.js" type="text/javascript" charset="utf-8" async defer></script>
    <style type="text/css" media="screen">

    </style>
</head>

<body>
    <div id="main">
        <!-- logo部分 -->
        <div id="header">
            <embed src="swf/logo.swf" width="100%" height="160" style="height: 152px;">
        </div>
        <!-- 菜单栏部分 -->
        <div id="menu">
            <ul id="alist">
                <a href="" title="">
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
                    		<c:if test="${empty sessionScope.BookAdmin}">
                    			<c:if test="${empty sessionScope.borrowAdmin}">
                    				<c:if test="${empty sessionScope.reader}">
                    					<c:if test="${empty sessionScope.admin}">
                        					<td class="login"><a href="javascript:void(0)" onclick="login()">登入</a></td>
                        				</c:if>
                        			</c:if>
                        		</c:if>
                        	</c:if>
                        </c:if>
                        <c:if test="${!empty sessionScope.user}">
                        	 <td class="login">您好！${sessionScope.user.name }</td>
	                         <td><a href="${pageContext.request.contextPath }/lendIDAdminster.jsp">管理</a></td>
                         </c:if>
                         <c:if test="${!empty sessionScope.admin}">
                        	 <td class="login">您好！${sessionScope.admin.name }</td>
	                         <td><a href="${pageContext.request.contextPath }/admin.jsp">管理</a></td>
                         </c:if>
                         <c:if test="${!empty sessionScope.reader}">
                        	 <td class="login">您好！${sessionScope.reader.rdName }</td>
	                         <td><a href="${pageContext.request.contextPath }/reader.jsp">管理</a></td>
                         </c:if>
                         <c:if test="${!empty sessionScope.BookAdmin}">
                        	 <td class="login">您好！${sessionScope.BookAdmin.name }</td>
	                         <td><a href="${pageContext.request.contextPath }/bookAdmin.jsp">管理</a></td>
                         </c:if>
                         <c:if test="${!empty sessionScope.borrowAdmin}">
                        	 <td class="login">您好！${sessionScope.borrowAdmin.name }</td>
	                         <td><a href="${pageContext.request.contextPath }/borrow.jsp">管理</a></td>
                         </c:if>
                         
                        <td class="search">
                        			<form action="SqlWork" method="psot" accept-charset="utf-8">
		                                <label>站内搜索：</label>
		                                <input type="text" name="search">
		                                <input type="submit" name="" class="searchpic" value="">
		                            </form>
		                    </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <!-- 图片轮播部分 -->
        <div id="top">
            <div id="banner">
                <div id="banner_bg"></div>
                <!--标题背景-->
                <a href="#" id="banner_info"></a>
                <!--标题-->
                <ul id="list"></ul>
                <div id="banner_list">
                    <a href="#" target="_blank"><img src="img/banner-0.jpg" title="多彩校园" alt="多彩校园" style="width: 145%;height: 145%" /></a>
                    <a href="#" target="_blank"><img src="img/banner-1.png" title="图书性格" alt="图书性格" style="width: 130%;height: 130%" /></a>
                    <a href="#" target="_blank"><img src="img/banner-2.jpg" title="图书森林" alt="图书森林" style="width: 130%;height: 130%" /></a>
                    <a href="#" target="_blank"><img src="img/banner-3.png" title="岁月的总结" alt="岁月的总结" style="width: 130%;height: 130%" /></a>
                </div>
            </div>
        </div>
        <!-- 中部信息栏 -->
        <div id="middle">
            <div class="left">
                <ul id="blist">
                    <a>
                        <li class="active">通知公告</li>
                    </a>
                    <a>
                        <li>最新图书</li>
                    </a>
                    <a>
                        <li>图书分类</li>
                    </a>
                    <a>
                        <li>培训讲座</li>
                    </a>
                </ul>
            </div>
            <div class="right">
                <div id="div1">
                    <div>
                        <img src="img/inform.jpg" alt="" class="icon">
                        <h2>通知公告</h2>
                        <a href="#" title=""><span class="more">more</span></a>
                    </div>
                    <div class="content">
                        <ul>
                       
                            <a href="#" title="">
                                <li>关于使用管理电子公章的培训通知<span class="date">2016-12-26</span></li>
                            </a>
                            <a href="#" title="">
                                <li>关于收集各立档单位公章图案的通知<span class="date">2016-12-26</span></li>
                            </a>
                            <a href="#" title="">
                                <li>关于图书馆门禁系统试运行的通知<span class="date">2016-12-26</span></li>
                            </a>
                        </ul>
                    </div>
                </div>
                <div id="div2">
                    <div>
                        <img src="img/newbook.png" alt="" class="icon">
                        <h2>最新图书</h2>
                        <a href="#" title=""><span class="more">more</span></a>
                    </div>
                    <div class="content">
                        <ul>
                         <%
                        	BookDaoImpl bookDaoImpl=new BookDaoImpl();
                        	List<Book> list=bookDaoImpl.getBooks();
                        	pageContext.setAttribute("books", list);
                         %>
                         <c:forEach items="${books }" var="book">
                            <a href="#" title="">
                                <li>${book.bkName }<span class="date">${book.bkDatePress }</span></li>
                            </a>
                         </c:forEach>
                            
                        </ul>
                    </div>
                </div>
                <div id="div3">
                    <div>
                        <img src="img/classfy.png" alt="" class="icon">
                        <h2>图书分类</h2>
                    </div>
                    <div class="bookClassfy">
                        <div class="book">
                            <ul class="bookstyle">
                                <a href="" title="">
                                    <li>
                                        <div><img src="img/computer.png" alt=""></div>
                                        <div>计算科学类</div>
                                    </li>
                                </a>
                                <a href="" title="">
                                    <li>
                                        <div><img src="img/classic.png" alt=""></div>
                                        <div>经典著作</div>
                                    </li>
                                </a>
                                <a href="" title="">
                                    <li>
                                        <div><img src="img/nature.png" alt=""></div>
                                        <div>自然科学</div>
                                    </li>
                                </a>
                                <a href="" title="">
                                    <li>
                                        <div><img src="img/construction.png" alt=""></div>
                                        <div> 建筑工程 </div>
                                    </li>
                                </a>
                            </ul>
                        </div>
                        <div class="book">
                            <ul class="bookstyle">
                                <a href="" title="">
                                    <li>
                                        <div><img src="img/English.png" alt=""></div>
                                        <div> 外国文学 </div>
                                    </li>
                                </a>
                                <a href="" title="">
                                    <li>
                                        <div><img src="img/magazine.png" alt=""></div>
                                        <div>杂志期刊</div>
                                    </li>
                                </a>
                                <a href="" title="">
                                    <li>
                                        <div><img src="img/math.png" alt=""></div>
                                        <div>数理化学</div>
                                    </li>
                                </a>
                                <a href="" title="">
                                    <li>
                                        <div><img src="img/art.png" alt=""></div>
                                        <div> 美术雕塑 </div>
                                    </li>
                                </a>
                            </ul>
                        </div>
                        <div class="book">
                            <ul class="bookstyle">
                                <a href="" title="">
                                    <li>
                                        <div><img src="img/literature.png" alt=""></div>文学荟萃
                                        <div></div>
                                    </li>
                                </a>
                                <a href="" title="">
                                    <li>
                                        <div><img src="img/science.png" alt=""></div>
                                        <div>科学世界</div>
                                    </li>
                                </a>
                                <a href="" title="">
                                    <li>
                                        <div><img src="img/education.png" alt=""></div>
                                        <div>文化教育</div>
                                    </li>
                                </a>
                                <a href="" title="">
                                    <li>
                                        <div><img src="img/factory.png" alt=""></div>
                                        <div>工业技术</div>
                                    </li>
                                </a>
                            </ul>
                        </div>
                    </div>
                </div>
                <div id="div4">
                    <div>
                        <img src="img/teach.png" alt="" class="icon">
                        <h2>培训讲座</h2>
                        <a href="#" title=""><span class="more">more</span></a>
                    </div>
                    <div class="content">
                        <ul>
                            <a href="#" title="">
                                <li>关于使用管理电子公章的培训通知<span class="date">2016-12-26</span></li>
                            </a>
                            <a href="#" title="">
                                <li>关于收集各立档单位公章图案的通知<span class="date">2016-12-26</span></li>
                            </a>
                            <a href="#" title="">
                                <li>关于图书馆门禁系统试运行的通知<span class="date">2016-12-26</span></li>
                            </a>
                        </ul>
                    </div>
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
    <!-- 登入部分 -->
    <div id="light" class="white_content">
        <center>
            <form action="${pageContext.request.contextPath }/loginAction_login.action" method="post" >
                <p>用&nbsp;户&nbsp;名：
                    <input type="text" class="sword" name="user.name">
                </p>
                <p>&nbsp;&nbsp;密&nbsp;码;：
                    <input type="password" class="sword"  name="user.password">
                </p>
                <p>
                    类型：
                    <select  id="selectId" onclick="choose(this)"  style=" BORDER-BOTTOM: #808080 1px solid; BORDER-RIGHT-WIDTH: 1px; WIDTH: 150px; BORDER-TOP-WIDTH: 1px; COLOR: #5d91c0; FONT-SIZE: 14pt; BORDER-LEFT-WIDTH: 1px">
                        <option value="1" selected="selected">普通读者</option>
                        <option value="2">借书证管理员</option>
                        <option value="3">图书管理员</option>
                        <option value="4">借阅管理员</option>
                        <option value="5">系统管理员</option>
                    </select>
                    <input type="hidden" name="user.userType" value="1"  id="hivalue">
                </p>
                <p>
                    验证码：
                    <input type="text" name="code" id="code">&nbsp;<span id="checkcode"></span>
                    <br>
                    <img id="vimg" title="点击更换" onclick="changeCode();" src="/library/AuthImageServlet" style="margin-left: 45px;margin-top: 10px;">
                </p>
                <p>
                    <input type="submit" name="" value="登入" class="sobtn" id="btns">
                </p>
            </form>
            <p><a href="javascript:void(0)" onclick="closeIt()">Close</a></p>
        </center>
    </div>
    <div id="fade" class="black_overlay"> </div>
    <script type="text/javascript">
    window.onload = function() {
        //
        zone.scroll(4, "banner_list", "list", "banner_info");
    }
    </script>
</body>

</html>
