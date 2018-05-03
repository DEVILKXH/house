/**
 * 
 */
$(function(){
	var uri = "/demo-web"

// 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'),'dark');
        // 指定图表的配置项和数据 --- 柱状图
        var option = {
            tooltip: {},
            legend: {
                data:['平均房价']
            },
            xAxis: {
                data: ["集美区","同安区","思明区","湖里区","翔安区","海沧区"]
            },
            yAxis: {},
            series: [{
                name: '平均房价',
                type: 'bar',
                data: [5, 20, 36, 10, 10, 20]
            }]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        
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
		                {value:335, name:'集美区'},
		                {value:310, name:'同安区'},
		                {value:234, name:'翔安区'},
		                {value:135, name:'湖里区'},
		                {value:1548, name:'思明区'},
		                {value:456, name:'海沧区'}
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
		pieChart.setOption(optionPie);
		
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
		lineChart.setOption(optionLine);
		
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
		simingChart.setOption(optionSiming);
		
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
		huliChart.setOption(optionHuli);
		
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
		jimeiChart.setOption(optionJimei);
		
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
		tonganChart.setOption(optionTongan);
		
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
		xianganChart.setOption(optionXiangan);
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
		haicangChart.setOption(optionHaicang);
		
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
		
		
		
		//会员总数
		$(function () {
		    //模拟动态修改数据每5秒加5
		    setInterval(function () {
		        var oldVal = parseInt($("#member_count").attr("data-value"));
		        $("#member_count").attr("data-value", oldVal + 5);
		    }, 5000);
		    //模拟读取并修改显示
		    var _oldVal = $("#member_count").attr("data-value");
		    setInterval(function () {
		        var newVal = $("#member_count").attr("data-value"),
		            oStr = _oldVal.toString(),
		            nStr = newVal.toString();
		        if (_oldVal != newVal) {
		            _oldVal = newVal;
		            var oCharArr = oStr.split(""),
		                nCharArr = nStr.split("");
		            if (oStr.length == nStr.length) {
		                for (var i in oCharArr) {
		                    if (oCharArr[i] != nCharArr[i]) {
		                        var $img = $("#member_count").find(".no img:eq(" + i + ")"),
		                            src = $img.attr("src");
		                        $img.attr("src", src.replace(oCharArr[i] + ".png", nCharArr[i] + ".png")).addClass("animated flipInX").one('webkitAnimationEnd mozAnimationEnd animationend', function () {
		                            $(this).attr("class", "");
		                        });
		                    }
		                }
		            } else {
		                var imgGapNo = nStr.length - oStr.length;
		                var _img = $("#member_count").find(".no img:eq(0)"),
		                    _no = $("#member_count").find(".no");
		                for (var i = 0; i < imgGapNo; i++) {
		                    _no.append(_img.get(0).outerHTML);
		                }
		                for (var j in nCharArr) {
		                    var $img = $("#member_count").find(".no img:eq(" + j + ")"),
		                        src = $img.attr("src");
		                    $img.attr("src", src.replace(/\d{1}.png/, nCharArr[j] + ".png")).addClass("animated flipInX").one('webkitAnimationEnd mozAnimationEnd animationend', function () {
		                        $(this).attr("class", "");
		                    });
		                }
		            }
		        }
		    }, 5000);
		});
		
		//地图
		$(function(){
//	    var geoCoo
		var geoCoordMap = {
//		   '思明': [118.1689, 24.6478],
//		   '湖里': [118.1689, 24.6478],
		   '海沧': [
					[118.031256132813, 24.4693483710938],
					[118.036046171875, 24.4451174140626],
					[117.963170195313, 24.4596681953125],
					[117.957345, 24.4638430000001],
					[117.952877226563, 24.5031179023438],
					[117.93142703125, 24.5179274726563],
					[117.92326296875, 24.5297585273438],
					[117.91142703125, 24.5379274726563],
					[117.90326296875, 24.5697585273438],
					[117.887345, 24.593843],
					[117.890704375, 24.610483625],
					[117.913985625, 24.617202375],
					[117.925201445313, 24.6393727851563],
					[117.947345, 24.6438430000001],
					[117.95107546875, 24.592075421875],
					[117.987203398438, 24.5737966132812],
					[117.979244414063, 24.5574977851563],
					[117.997345, 24.553843],
					[118.001519804688, 24.5480178046875],
					[118.05091921875, 24.5289650703125],
					[118.063761015625, 24.508735578125],
					[118.031256132813, 24.4693483710938]
				]
//		   '同安': [118.1689, 24.6478],
//		   '翔安': [118.1689, 24.6478],
//		   '集美': [118.1689, 24.6478]
		};  
		  
		var convertData = function (data) {  
		    var res = [];  
		    for (var i = 0; i < data.length; i++) {  
		    	console.log(data);
		        var geoCoord = geoCoordMap[data[i].name];  
		        if (geoCoord) { 
		        	for(var attr in geoCoord){
		        		res.push(geoCoord[attr].concat(data[i].value))
		        	}
//		            res.push(geoCoord.concat(data[i].value));  
		        }  
		    } 
		    console.log(res)
		    return res;
		};  
		  
		$.get(uri + '/resources/js/xiamen.json', function (geoJson) {
			var dMapChart = echarts.init(document.getElementById('d_map'));
			echarts.registerMap('厦门', geoJson);
			dMapChart.setOption(optionChart);
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