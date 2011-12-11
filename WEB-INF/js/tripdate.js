function initTripDate() {
	var tripdateOption = new Object();
	tripdateOption["dateFormat"] = 'mm/dd/yy';
	tripdateOption["minDate"]= new Date();
	tripdateOption["onSelect"] = function(selectedDate) {
		var id = $(this).attr("id");
		
		$(this).removeClass("default");

		var tripId = id.substring(id.lastIndexOf("-")+1, id.length);
		if (id.indexOf("tripdate-from") >= 0) {
			$("#tripdate-to-"+tripId).datepicker("option", "defaultDate", selectedDate);
			$("#tripdate-to-"+tripId).datepicker("option", "minDate", selectedDate);
		}

		if (id.indexOf("tripdate-to") >= 0) {
			$("#tripdate-from-"+tripId).datepicker("option", "maxDate", selectedDate);
		}
	}

    $("[id^='tripdate']").each(function() {
    	$(this).datepicker(tripdateOption);
	});
}

//formats to a yyyy-mm-dd format
function formatDate(_date) {
    var fm = _date.getFullYear();
    fm+="-";
    fm+=(_date.getMonth()+1);
    fm+="-";
    fm+=_date.getDate();
    return fm;
}