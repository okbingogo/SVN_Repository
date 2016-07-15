<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>评论</title>

<script type="text/javascript" src="${base }/js/WdatePicker.js"></script>

<link rel="stylesheet" type="text/css" href="${base }/css/frame.css">
<link rel="stylesheet" type="text/css" href="${base }/css/extra.css">
<link rel="Stylesheet" type="text/css" href="${base }/css/PCD_mplayer.css">
<link rel="Stylesheet" type="text/css" href="${base }/css/home_A.css">
<link rel="Stylesheet" type="text/css" href="${base }/css/skin.css">

</head>
<body class="FRAME_main B_index">
	<div class="WB_miniblog">
		<div class="WB_miniblog_fb">
			<div id="plc_top">
				<div class="WB_global_nav UI_top_hidden ">
					<div class="gn_header clearfix">
						<div class="gn_position">
							<div class="gn_nav">
								<ul class="gn_nav_list">
									<li>
										<a href="${base }/index.do" class="gn_name">
											<em class="W_ficon ficon_user S_ficon">首页</em>
										</a>
									</li>
									<li><span>&nbsp;</span></li>
									<#if username??>
									<li>
										<a  class="gn_name">
											<em class="W_ficon ficon_user S_ficon">${username }</em> 
										</a>
									</li>
									<li><span>&nbsp;</span></li>
									<li>
										<a href="${base }/logout.do" class="gn_name">
											<em class="W_ficon ficon_user S_ficon">注销</em>
										</a>
									</li>
									<#else>
									<li>
										<a href="${base }/toRegister.do" class="gn_name">
											<em class="W_ficon ficon_user S_ficon">注册</em>
										</a>
									</li>
									<li><span>&nbsp;</span></li>
									<li>
										<a href="${base }/toLogin.do" class="gn_name">
											<em class="W_ficon ficon_user S_ficon">登录</em>
										</a>
									</li>
									</#if>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="WB_main clearfix" id="plc_frame">
			<div class="WB_frame">
				<div id="plc_main">
					<div class="WB_main_c">
						<div id="v6_pl_content_publishertop">
							<!--主内容-->
							<div class="WB_feed_detail clearfix">
								<div class="WB_screen W_fr">
									<div class="screen_box">
										<a><i class="W_ficon ficon_arrow_down S_ficon">#${message.msgId}</i></a>
									</div>
								</div>
								<div class="WB_detail">
									<div class="WB_info">
										<a class="W_f14 W_fb S_txt1" >${message.fromName }</a>
									</div>
									<div class="WB_text W_f14">${message.msgContent }</div>
									<div class="WB_from S_txt2" style="text-align: right;">
										<a class="S_txt2"> 
											${(message.msgTime)?string("yyyy年MM月dd日    HH:mm:ss")}
										</a>
									</div>
								</div>
							</div>
							<!--/主内容-->
							<div class="send_weibo S_bg2 clearfix">
								<form action="${base }/comment.do" method="post">
									<div class="input">
										<textarea class="W_input " name="content" maxlength="200"></textarea>
									</div>
									<div class="func_area clearfix">
										<div class="func">
											<input type="hidden" name="msgId" value="${message.msgId}" />
											<input type="submit" class="W_btn_a btn_30px W_btn_a_disable" value="发布" />
										</div>
									</div>
								</form>
							</div>
						</div>
						<div id="v6_pl_content_homefeed">
							<div class="WB_feed WB_feed_v3 WB_feed_newuser">
								<#list commentList as comm>
								<div class="WB_cardwrap WB_feed_type S_bg2">
									<!--主内容-->
									<div class="WB_feed_detail clearfix">
										<div class="WB_screen W_fr">
											<div class="screen_box">
												<a ><i class="W_ficon ficon_arrow_down S_ficon">#${comm.commId}</i></a>
											</div>
										</div>
										<div class="WB_detail">
											<div class="WB_info">
												<a class="W_f14 W_fb S_txt1" >${comm.fromName }</a>
											</div>
										<div class="WB_text W_f14">${comm.commContent }</div>
											<div class="WB_from S_txt2" style="text-align: right;">
												<a class="S_txt2"> ${(comm.commTime)?string("yyyy年MM月dd日    HH:mm:ss")} </a>
											</div>
										</div>
									</div>
									<!--/主内容-->
								</div>
								</#list>
							</div>
							<!--主操作-->
							<div class="WB_feed_handle">
								<div class="WB_handle">
									<ul class="WB_row_line WB_row_r3 clearfix S_line2">
										<li style="width:120px;">
											<#if curPage == 1>	
											<a class="S_txt1" style="color: gray;">
											<#else>
											<a class="S_txt1" href="${base }/toComment.do?msgId=${message.msgId}&keyword=${keyword }&startTime=${startTime }&endTime=${endTime }&curPage=1">
											</#if> 
												<span class="pos"> 
													<span class="line S_line1">首页</span>
												</span> 
											</a>
										</li>
										<li style="width:120px;">
											<#if (curPage > 1)>
											<a class="S_txt1" href="${base }/toComment.do?msgId=${message.msgId}&keyword=${keyword }&startTime=${startTime }&endTime=${endTime }&curPage=${curPage - 1}">
											<#else>
											<a class="S_txt1" style="color: gray;">
											</#if> 
												<span class="pos"> 
													<span class="line S_line1">上一页</span>
												</span> 
											</a>
										</li>
										<li style="width:120px;">
											<#if (curPage < pageCount)>
											<a class="S_txt1" href="${base }/toComment.do?msgId=${message.msgId}&keyword=${keyword }&startTime=${startTime }&endTime=${endTime }&curPage=${curPage + 1}">
											<#else>
											<a class="S_txt1" style="color: gray;">
											</#if> 
												<span class="pos"> 
													<span class="line S_line1">下一页</span>
												</span> 
											</a>
										</li>
										<li style="width:120px;">
											<#if curPage == pageCount>
											<a class="S_txt1" style="color: gray;">
											<#else>
											<a class="S_txt1" href="${base }/toComment.do?msgId=${message.msgId}&keyword=${keyword }&startTime=${startTime }&endTime=${endTime }&curPage=${pageCount }">
											</#if> 
												<span class="pos"> 
													<span class="line S_line1">尾页</span>
												</span> 
											</a>
										</li>
										<li style="width:120px;">
											<span class="pos"> 
												<span class="line S_line1">第${curPage }页/共${pageCount }页</span> 
											</span>
										</li>
									</ul>
								</div>
							</div>
							<!--/主操作-->
						</div>
					</div>
					<div class="WB_main_r">
						<div class="nameBox">
							<form action="${base }/toComment.do">
								<label>搜索评论： </label><input name="keyword" type="text"><hr>
								<label for="start-datepicker">起始日期：</label> 
								<input type="text" id="temp" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd 00:00:00',maxDate:'%y-%M-%d'})" name="startTime" />
								<hr>
								<label for="end-datepicker">结束日期：</label> 
								<input type="text" id="temp" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd 23:59:59',maxDate:'%y-%M-%d'})" name="endTime" />
								<hr>
								<div style="text-align: right;">
									<input type="hidden" name="msgId" value="${message.msgId}" />
									<input type="submit" value="    搜索    " />
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
