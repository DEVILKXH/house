/**
 * 
 */
var uri = "/demo-web"
$(function(){

// 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'),'dark');
        // 指定图表的配置项和数据 --- 柱状图
        var option = {
            tooltip: {},
            legend: {
                data:['平均房价']
            },
            xAxis: {
                data: ["同安区","思明区","海沧区","湖里区","翔安区","集美区"]
            },
            yAxis: {},
            series: [{
                name: '平均房价',
                type: 'bar',
                barWidth: 20,
                data: [24481,57674,36515,58903,27511,31038]
            }]
        };
        // 使用刚指定的配置项和数据显示图表。
        
        $.ajax({
			url: uri + '/house/getAvgPriceByCity.do?type=new',
			success:function(res){
				option.xAxis.data = res.axisData;
				option.series = res.series;
				myChart.setOption(option);
			}
		});
        
        //指定图表的配置项和数据 --- 饼图
        var pieChart = echarts.init(document.getElementById('pie'),'dark');
        var optionPie = {
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    series : [
		        {
		            name: '访问来源',
		            type: 'pie',
		            radius : '55%',
		            center: ['50%', '60%'],
		            data:[
		                {value:31038, name:'集美区'},
		                {value:24481, name:'同安区'},
		                {value:27511, name:'翔安区'},
		                {value:58903, name:'湖里区'},
		                {value:57674, name:'思明区'},
		                {value:36515, name:'海沧区'}
		            ],
		            itemStyle: {
		                emphasis: {
		                    shadowBlur: 10,
		                    shadowOffsetX: 0,
		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		                }
		            }
		        }
		    ]
		};
		$.ajax({
			url: uri + '/house/getAvgPriceByCityOld.do?type=old',
			success:function(res){
				optionPie.series[0].data = res.list;
				pieChart.setOption(optionPie);
			}
		});
		//折线图
		var lineChart = echarts.init(document.getElementById('line'),'dark');
		optionLine = {
		    tooltip: {
		        trigger: 'axis'
		    },
		    legend: {
		       data: ['集美区','同安区','翔安区','湖里区','思明区','海沧区']
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
		        data: ['一月','二月','三月','四月','五月']
		    },
		    yAxis: {
		        type: 'value'
		    },
		    series: [
		        {
		            name:'集美区',
		            type:'line',
		            stack: '总量',
		            data:[120, 132, 101, 134, 90]
		        },
		        {
		            name:'同安区',
		            type:'line',
		            stack: '总量',
		            data:[220, 182, 191, 234, 290]
		        },
		        {
		            name:'翔安区',
		            type:'line',
		            stack: '总量',
		            data:[150, 232, 201, 154, 190]
		        },
		        {
		            name:'湖里区',
		            type:'line',
		            stack: '总量',
		            data:[320, 332, 301, 334, 390]
		        },
		        {
		            name:'思明区',
		            type:'line',
		            stack: '总量',
		            data:[820, 932, 901, 934, 1290]
		        },
		        {
		            name:'海沧区',
		            type:'line',
		            stack: '总量',
		            data:[850, 1032, 1001, 434, 1090]
		        }
		    ]
		};
		
		$.ajax({
			url: uri + '/house2/getAvgPriceByCity.do',
			success:function(res){
				optionLine.legend.data = res.legendData;
				optionLine.xAxis.data = res.axisData;
				optionLine.series = res.series;
				lineChart.setOption(optionLine);
				console.log(res);
			}
		});
		
		function getOptions(echart,options,city){
			var url = uri + '/house2/getAvgPriceByMonth.do?area='+city;
			$.ajax({
				url: url,
				success:function(res){
					options.series[0].data = res.list;
					echart.setOption(options);
				}
			});
		}
		
		//思明
		var simingChart = echarts.init(document.getElementById('simingpie'),'dark');
		var optionSiming = {
	    	title : {
				text: '思明区',
				x:'center',
				bottom:'10px'
			},
		    tooltip: {
		        trigger: 'item',
		        formatter: "{a} <br/>{b}: {c} ({d}%)"
		    },
		    series: [
		        {
		            name:'访问来源',
		            type:'pie',
		            radius: ['50%', '60%'],
		            avoidLabelOverlap: false,
		            label: {
		                normal: {
		                    show: false,
		                    position: 'center'
		                },
		                emphasis: {
		                    show: true,
		                    textStyle: {
		                        fontSize: '30',
		                        fontWeight: 'bold'
		                    }
		                }
		            },
		            labelLine: {
		                normal: {
		                    show: false
		                }
		            },
		            data:[
		                {value:335, name:'一月'},
		                {value:310, name:'二月'},
		                {value:234, name:'三月'},
		                {value:135, name:'四月'},
		                {value:1548, name:'五月'}
		            ]
		        }
		    ]
		};
		
		//湖里
		var huliChart = echarts.init(document.getElementById('hulipie'),'dark');
		var optionHuli = {
			title : {
				text: '湖里区',
				x:'center',
				bottom:'10px'
			},
		    tooltip: {
		        trigger: 'item',
		        formatter: "{a} <br/>{b}: {c} ({d}%)"
		    },
		    series: [
		        {
		            name:'访问来源',
		            type:'pie',
		            radius: ['50%', '60%'],
		            avoidLabelOverlap: false,
		            label: {
		                normal: {
		                    show: false,
		                    position: 'center'
		                },
		                emphasis: {
		                    show: true,
		                    textStyle: {
		                        fontSize: '30',
		                        fontWeight: 'bold'
		                    }
		                }
		            },
		            labelLine: {
		                normal: {
		                    show: false
		                }
		            },
		            data:[
		                {value:335, name:'一月'},
		                {value:310, name:'二月'},
		                {value:234, name:'三月'},
		                {value:135, name:'四月'},
		                {value:1548, name:'五月'}
		            ]
		        }
		    ]
		};
		
		//集美
		var jimeiChart = echarts.init(document.getElementById('jimeipie'),'dark');
		var optionJimei = {
			title : {
				text: '集美区',
				x:'center',
				bottom:'10px'
			},
		    tooltip: {
		        trigger: 'item',
		        formatter: "{a} <br/>{b}: {c} ({d}%)"
		    },
		    series: [
		        {
		            name:'访问来源',
		            type:'pie',
		            radius: ['50%', '60%'],
		            avoidLabelOverlap: false,
		            label: {
		                normal: {
		                    show: false,
		                    position: 'center'
		                },
		                emphasis: {
		                    show: true,
		                    textStyle: {
		                        fontSize: '30',
		                        fontWeight: 'bold'
		                    }
		                }
		            },
		            labelLine: {
		                normal: {
		                    show: false
		                }
		            },
		            data:[
		                {value:335, name:'一月'},
		                {value:310, name:'二月'},
		                {value:234, name:'三月'},
		                {value:135, name:'四月'},
		                {value:1548, name:'五月'}
		            ]
		        }
		    ]
		};
		
		//同安
		var tonganChart = echarts.init(document.getElementById('tonganpie'),'dark');
		var optionTongan = {
			title : {
				text: '同安区',
				x:'center',
				bottom:'10px'
			},
		    tooltip: {
		        trigger: 'item',
		        formatter: "{a} <br/>{b}: {c} ({d}%)"
		    },
		    series: [
		        {
		            name:'访问来源',
		            type:'pie',
		            radius: ['50%', '60%'],
		            avoidLabelOverlap: false,
		            label: {
		                normal: {
		                    show: false,
		                    position: 'center'
		                },
		                emphasis: {
		                    show: true,
		                    textStyle: {
		                        fontSize: '30',
		                        fontWeight: 'bold'
		                    }
		                }
		            },
		            labelLine: {
		                normal: {
		                    show: false
		                }
		            },
		            data:[
		                {value:335, name:'一月'},
		                {value:310, name:'二月'},
		                {value:234, name:'三月'},
		                {value:135, name:'四月'},
		                {value:1548, name:'五月'}
		            ]
		        }
		    ]
		};
		
		//翔安
		var xianganChart = echarts.init(document.getElementById('xianganpie'),'dark');
		var optionXiangan = {
			title : {
				text: '翔安区',
				x:'center',
				bottom:'10px'
			},
		    tooltip: {
		        trigger: 'item',
		        formatter: "{a} <br/>{b}: {c} ({d}%)"
		    },
		    series: [
		        {
		            name:'访问来源',
		            type:'pie',
		            radius: ['50%', '60%'],
		            avoidLabelOverlap: false,
		            label: {
		                normal: {
		                    show: false,
		                    position: 'center'
		                },
		                emphasis: {
		                    show: true,
		                    textStyle: {
		                        fontSize: '30',
		                        fontWeight: 'bold'
		                    }
		                }
		            },
		            labelLine: {
		                normal: {
		                    show: false
		                }
		            },
		            data:[
		                {value:335, name:'一月'},
		                {value:310, name:'二月'},
		                {value:234, name:'三月'},
		                {value:135, name:'四月'},
		                {value:1548, name:'五月'}
		            ]
		        }
		    ]
		};
		//海沧
		var haicangChart = echarts.init(document.getElementById('haicangpie'),'dark');
		var optionHaicang = {
			title : {
				text: '海沧区',
				x:'center',
				bottom:'10px'
			},
		    tooltip: {
		        trigger: 'item',
		        formatter: "{a} <br/>{b}: {c} ({d}%)"
		    },
		    series: [
		        {
		            name:'访问来源',
		            type:'pie',
		            radius: ['50%', '60%'],
		            avoidLabelOverlap: false,
		            label: {
		                normal: {
		                    show: false,
		                    position: 'center'
		                },
		                emphasis: {
		                    show: true,
		                    textStyle: {
		                        fontSize: '30',
		                        fontWeight: 'bold'
		                    }
		                }
		            },
		            labelLine: {
		                normal: {
		                    show: false
		                }
		            },
		            data:[
		                {value:335, name:'一月'},
		                {value:310, name:'二月'},
		                {value:234, name:'三月'},
		                {value:135, name:'四月'},
		                {value:1548, name:'五月'}
		            ]
		        }
		    ]
		};
		
		getOptions(simingChart,optionSiming,'siming');
		getOptions(huliChart,optionHuli,'huli');
		getOptions(jimeiChart,optionJimei,'jimei');
		getOptions(xianganChart,optionXiangan,'xiangana');
		getOptions(tonganChart,optionTongan,'tongana');
		getOptions(haicangChart,optionHaicang,'haicang');
		
        //平均房价逻辑
        /*预加载图片*/
		function preLoadImages(urls) {//可以是String Array或者String
		    var argsLen = arguments.length,
		        loadImage = function (url) {
		            var img = new Image();
		            img.src = url;
		        };
		    if (argsLen == 1) {
		        if (typeof (urls) == "string" && (sLen = urls.length) > 1) {//预加载一个图片
		            loadImage(urls);
		        }
		        else if (Object.prototype.toString.call(arguments[0]) == "[object Array]" && urls.length > 0) {//预加载多个图片
		            for (var i = 0; i < urls.length; i++) {
		                loadImage(urls[i]);
		            }
		        }
		    }
		}
		var urlPrefix = 'http://o9gzet7tk.bkt.clouddn.com/img/',
				urls = [];
		for(var i = 0;i<10;i++){
			urls.push(urlPrefix + i + '.png');
		}
		preLoadImages(urls);
		
		//地图
		$(function(){
//	    var geoCoo
		var geoCoordMap = {
			'集美大学':[118.101299,24.588486],
			'集美新城':[118.062182,24.610049],
			'灌口':[117.998971,24.615116],
			'杏西路':[118.025266,24.571251],
			'杏滨路':[118.069796,24.575782],
			'杏北':[118.049613,24.575724],
			'杏东路':[118.054376,24.569727],
			'华侨大学':[118.079395,24.578547],
			'厦门北站':[118.079645,24.643368],
			'马巷':[118.257531,24.662825],
			'翔安新城':[118.245993,24.611148],
			'新店':[118.253699,24.614739],
			'新圩':[118.265528,24.739961],
			'大嶝':[118.338808,24.568567],
			'高新科技园':[118.168469,24.530683],
			'枋湖':[118.147393,24.518522],
			'金山':[118.163867,24.507337],
			'金尚':[118.157134,24.499217],
			'机场':[118.13862,24.540399],
			'湖里万达':[118.184016,24.51089],
			'五缘湾北区':[118.168824,24.528272],
			'SM城市广场':[118.133503,24.506661],
			'海沧区政府':[118.039547,24.490415],
			'海沧生活区':[118.040044,24.499406],
			'滨海社区':[118.02672,24.563255],
			'自贸区':[118.016718,24.4664],
			'马青路':[118.057579,24.520369],
			'鼓浪屿':[118.073167,24.450523],
			'观音山':[118.204635,24.501241],
			'莲坂':[118.12763,24.487841],
			'瑞景':[118.166143,24.48073],
			'曾厝垵':[118.133137,24.432679],
			'厦大':[118.111907,24.442647],
			'前埔':[118.186194,24.477463],
			'会展中心':[118.189308,24.473369],
			'中山路':[118.085588,24.460278],
			'城北':[118.14938,24.744403],
			'城南':[118.153562,24.721252],
			'城西':[118.152507,24.74005],
			'环东海域':[118.131887,24.706392]
		};  
		  
		var convertData = function (data) {  
		    var res = [];  
		    for (var i = 0; i < data.length; i++) {  
		    	console.log(data);
		        var geoCoord = geoCoordMap[data[i].name];  
		        if (geoCoord) { 
		            res.push(geoCoord.concat(data[i].value));  
		        }  
		    } 
		    return res;
		};  
		  
		$.get(uri + '/resources/js/xiamen.json', function (geoJson) {
			var dMapChart = echarts.init(document.getElementById('d_map'));
			echarts.registerMap('厦门', geoJson);
			$.ajax({
				url: uri + '/house/getAvgPriceByBrand.do',
				success:function(res){
					optionChart.series[0].data = convertData(res.list);
					dMapChart.setOption(optionChart);
				}
			});	
		});
		
		var optionChart = {  
		    visualMap: {  
		        min: 0,  
		        max: 80000,  
		        splitNumber: 8,  
		        inRange: {  
		            color: ['#d94e5d','#eac736','#50a3ba','#fe83e6','#0343a3','#759aa0'].reverse()  
		        },  
		        textStyle: {  
		            color: '#fff'  
		        }
		    },  
		    geo: {  
		        map: '厦门'  
		    },  
		    series: [{  
		        name: '房价分布',  
		        type: 'heatmap',  
		        coordinateSystem: 'geo',  
		        data: convertData([
		            {name: "思明", value: 75000},
		            {name: "海沧", value: 22000},
		            {name: "湖里", value: 61000},
		            {name: "同安", value: 26000},
		            {name: "集美", value: 15000},
		            {name: "翔安", value: 27000},
		        ])  
		    }]  
		};  
	// 使用刚指定的配置项和数据显示图表。
	});
});


function getNew(){
	var url = uri + "/python/getNew.do";
	getPython(url);
}

function getOld(){
	var url = uri + "/python/getOld.do";
	getPython(url);
}

function getHistory(){
	var url = uri + "/python/getHistory.do";
	getPython(url);
}

function getPython(url){
	$.ajax({
		url: url,
		success: function(){
			alert("获取成功")
		}
	})
}