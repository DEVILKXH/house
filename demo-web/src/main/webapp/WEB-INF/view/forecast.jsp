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
</head>
	<body>	
	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
        <div class="text">
            <span class="text-liner"><a href="${contextPath}/house/index.do">厦门市房价分析</a></span>
        </div>
        <div class="container">
        	<div style="border: royalblue; border-style:dotted solid dotted; margin: 0 auto">
	        	<select class="city">
	        		<option value="">==请选择==</option>
	        		<option value="同安">同安</option>
	        		<option value="思明">思明</option>
	        		<option value="海沧">海沧</option>
	        		<option value="湖里">湖里</option>
	        		<option value="翔安">翔安</option>
	        		<option value="集美">集美</option>
	        	</select>
	        	<select class="brand">
	        		<option value="">==请选择==</option>
	        	</select>
	        	<input type = "text" value="" placeholder="请输入平房" class="myArea">
	        	<input type = "text" value="" readonly placeholder="房价预测数据" class="forecast">
        	</div>
        </div>
        <div class="container">
	        <div class="outside" style="border: royalblue; border-style:dotted solid dotted; margin: 0 auto">
		    	<div id="main" style="width: 1024px;height:400px;"></div>
	    	</div>
    	</div>
	</body>
	<script>
		var a = 0;
		var b = 0;
		var cityBrands = {
			"同安":["同安北","同集北路","城东","城北","城南","城西","环东海域"],
			"思明":["东浦路","中山路","会展中心","前埔","厦大","思北","文园路","曾厝垵","松柏","槟榔","湖滨北路","火车站","瑞景","禾祥东路","禾祥西路","莲前东","莲前西路","莲坂","莲花","观音山","鼓浪屿","龙山"],
			"海沧":["海沧区政府","海沧生活区","滨海社区","自贸区","马青路"],
			"湖里":["SM城市广场","东渡","五缘湾北区","五缘湾南区","南山","县后","后埔","大唐","悦华路","机场","枋湖","殿前","江头","湖边水库","湖里万达","祥店","金尚","金山","马垅","高新科技园"],
			"翔安":["大嶝","新圩","新店","翔安新城","马巷"],
			"集美":["华侨大学","厦门北站","同集南路","杏东路","杏北","杏滨路","杏西路","灌口","集美大学","集美新城"]
		}
		
		var lineChart = echarts.init(document.getElementById('main'),'dark');
		optionLine = {
		    tooltip: {
		        trigger: 'axis'
		    },
		    legend: {
		       data: []
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    xAxis: {
		        type: 'category',
		        boundaryGap: false,
		        data: []
		    },
		    yAxis: {
		        type: 'value'
		    },
		    series: []
		};
		
		$(".city").change(function(){
			var value = this.value;
			var brand = cityBrands[value];
			var html = "<option value=''>==请选择==</option>"
			for(var attr in brand){
				html += ("<option value='"+ brand[attr] +"'>"+ brand[attr] +"</option>");
			}
			$(".brand").html(html);
		});
		
		$(".brand").change(function(){
			var city = $(".city").val();
			var brand = this.value;
			$.ajax({
				url: '/demo-web/house/getForecast.do?city=' + city + '&brand=' + brand,
				async: true,
				success:function(res){
					optionLine.legend.data = res.result.legendData;
					optionLine.xAxis.data = res.result.axisData;
					optionLine.series = res.result.series;
					a = res.a;
					b = res.b;
					lineChart.clear();
					lineChart.setOption(optionLine);
				}
			});
		});
		
		$(".myArea").on('input',function(){
			var value = this.value;
			var values = parseFloat(b * value) + parseFloat(a);
			$(".forecast").val(values.toFixed(0))
		});
	</script>
</html>