// 给定年月获取当月天数 
function getMDay(y, m) {
    var mday = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
    if ((y % 40 == 0 && y % 100 != 0) || y % 400 == 0)//判断是否是闰月
        mday[1] = 29;
    return mday[m - 1];
}
 
// 获取星期数
function weekNumber(y, m, d) {
    var wk;
    if (m <= 12 && m >= 1) {
        for (var i = 1; i < m; ++i) {
            d += getMDay(y, i);
        }
    }
    /*根据日期计算星期的公式*/
    wk = (y - 1 + (y - 1) / 4 - (y - 1) / 100 + (y - 1) / 400 + d) % 7;
    //0对应星期天，1对应星期一
    return parseInt(wk);
}
 
function getCalendar(year, month, day) {
 
    var daynumber = getMDay(year, month); //当月天数
    var firstnumber = weekNumber(year, month, 1); //当月第一天星期
    var lastnumber = weekNumber(year, month, daynumber); //当月最后一天星期
    var weeknumber = (daynumber - (7 - firstnumber) - (lastnumber + 1)) / 7; //除去第一个星期和最后一个星期的周数
    var days = 1;
    var name;
    var calendar = "";
    calendar += "<tr>";
    var i = 0;
    for (i = 0; i < firstnumber; i++)//第一个星期
    {
        calendar += "<td></td>";
    }
    for (i = firstnumber; i < 7; i++) {
    	if (day == days) {
    		alendar += "<td class='dayCell selected'>" + days + "</td>";
    	} else {
        	calendar += "<td class='dayCell'>" + days + "</td>";
        }
        days++;
    }
    calendar += "</tr>";
    var number = 0;
    for (i = 0; i < weeknumber; i++)
    {
        calendar += "<tr>";
        for (var k = daynumber - (7 - firstnumber) - (weeknumber - 1) * 7; k < daynumber - (7 - firstnumber) - (weeknumber - 1) * 7 + 7; k++) {
            if (day == days) {
	    		calendar += "<td class='dayCell selected'>" + days + "</td>";
	    	} else {
	        	calendar += "<td class='dayCell'>" + days + "</td>";
	        }
            days++;
        }
        calendar += "</tr>";
        number++;
    }
    
    calendar += "<tr>";
    for (i = 0; i < lastnumber + 1; i++)//最后一个星期
    {
        if (day == days) {
    		calendar += "<td class='dayCell selected'>" + days + "</td>";
    	} else {
        	calendar += "<td class='dayCell'>" + days + "</td>";
        }
        days++;
    }
    for (i = lastnumber + 1; i < 7; i++) {
        calendar += "<td>";
        calendar += "</td>";
    }
    calendar += "</tr>";
    return calendar;
}

  var out = true;
  function showCalendar(obj) {
    var myDate = new Date();
    var year = myDate.getFullYear();
    var month = myDate.getMonth() + 1;
    var day = myDate.getDate();
    var calRoot = $(obj).parents(".uiDatepicker");
    calRoot.find(".monthTitle").html(month + "月 " + year);
    
    var calendar = getCalendar(year, month, day);
    calRoot.find(".dayTable").html(calendar);
    bindClick(year, month, calRoot);
    $("#contentCol").bind("click", function(evt){
	     var evtObj = evt.srcElement ? evt.srcElement : evt.target;
    	if(out && evtObj != obj) {
    		calRoot.removeClass("openToggler");
    	}
    });
    calRoot.addClass("openToggler");
 
    return false;
  }
  function lowerMonth(obj) {
    var monthYear = $(obj).parent().next().html();
    var index = monthYear.indexOf("月 ");
    var month = monthYear.substring(0, index);
    var year = monthYear.substr(index + 2, 4);
    var myDate = new Date();
    var day = myDate.getDate();
    month = month - 1;
   	if (month == 0) {
      month = 12;
      year = year - 1;
    }
    var calRoot = $(obj).parents(".uiDatepicker");
    calRoot.find(".monthTitle").html(month + "月 " + year);
    var calendar = getCalendar(year, month, day);
    calRoot.find(".dayTable").html(calendar);
    bindClick(year, month, calRoot);
    return false;
  }
  function highterMonth(obj) {
    var monthYear = $(obj).parent().prev().html();
    var index = monthYear.indexOf("月 ");
    var month = monthYear.substring(0, index);
    var year = monthYear.substr(index + 2, 4);
    var myDate = new Date();
    var day = myDate.getDate();
    month = parseInt(month) + 1;
   	if (month == 13) {
      month = 1;
      year = parseInt(year) + 1;
    }
    $(".monthTitle").html(month + "月 " + year);
    var calendar = getCalendar(year, month, day);
    $(".dayTable").html(calendar);
    bindClick(year, month, calRoot);
    return false;
  }
  
  function bindClick(year, month, calRoot) {
    calRoot.find(".dayCell").each(function(){
      $(this).bind("click", function (){
          var day = $(this).html();
          var date = month + "/" + day + "/" + year
          calRoot.removeClass("openToggler");
          calRoot.find("input[name$='Date']").val(date);
      });
    });
  }
  
  $(function(){
    $(".calendarWrapper").hover(
	  function () {
	    out = false;
	  },
	  function () {
	    out = true;
	  }
    );
  });
