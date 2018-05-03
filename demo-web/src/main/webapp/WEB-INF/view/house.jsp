<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>房价分析</title>
	<link href="//cdn.bootcss.com/animate.css/3.5.2/animate.min.css" rel="stylesheet">
	<link href="${resources }/css/house.css" rel="stylesheet">
	<!-- 引入 ECharts 文件 -->
	<script src="${resources }/js/echarts.min.js"></script>
	<script src="${resources }/js/dark.js"></script>
	<script src="${resources }/js/jquery.min.js"></script>
	<script src="${resources }/js/house.js" charset="GBK"></script>
</head>
	<body>	
	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
        <div class="text">
            <span class="text-liner">厦门市房价分析</span>
        </div>
        <div class="container">
        <div class="outside" style="width: 25%;border: royalblue; border-style:dotted solid dotted">
	    	<div id="main" style="width: 290px;height:200px;"></div>
	    	<div id="line" style="width: 290px;height:200px;"></div>
    	</div>
	    <div class="outside" style="width: 60%;margin: 20px;border: royalblue; border-style:dotted solid dotted">
	    	<div id="d_map"></div>
    	</div>
    	<div class="outside" style="width: 25%;border: royalblue; border-style:dotted solid dotted">
    		<div class="member_count" id="member_count" data-value="9999">
            <span class="tt"><img src="http://o9gzet7tk.bkt.clouddn.com/img/title_03_member_total.png"></span>
            <span class="no">
                <img src="http://o9gzet7tk.bkt.clouddn.com/img/9.png" class="">
                <img src="http://o9gzet7tk.bkt.clouddn.com/img/9.png" class="">
                <img src="http://o9gzet7tk.bkt.clouddn.com/img/9.png" class="">
                <img src="http://o9gzet7tk.bkt.clouddn.com/img/9.png" class="">
            </span>
	        </div>
	    	<div id="pie" style="width: 300px;height:200px;"></div>	
    	</div>
    	</div>
    	<div style="width: 100%; height:210px; clear: both; margin-top: 50px;border: royalblue; border-style:dotted solid dotted">
    		<div class="inside" id="simingpie" style="width:16.6666%;height:200px;"></div>	
    		<div class="inside" id="hulipie" style="width: 16.6666%;height:200px;"></div>	
    		<div class="inside" id="haicangpie" style="width: 16.6666%;height:200px;"></div>	
    		<div class="inside" id="tonganpie" style="width: 16.6666%;height:200px;"></div>	
    		<div class="inside" id="jimeipie" style="width: 16.6666%;height:200px;"></div>	
    		<div class="inside" id="xianganpie" style="width: 16.6666%;height:200px;"></div>
    	</div>
	</body>
</html>