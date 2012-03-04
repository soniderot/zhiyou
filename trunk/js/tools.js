function validateSignUp() {
	var result = true;
	result = checkUsername($("#register_username"))&&result;
	result = checkEmail($("#register_email"))&&result;
	result = checkPassword($("#register_password"))&&result;
	result = checkPassword2($("#register_confirmpassword"), $("#register_password"))&&result;
	result = checkGender($("#register_gender"))&&result;
	result = checkBirth($("#register_year"), $("#register_month"), $("#register_day"))&&result;
	return result;
}

function validateCreateEvent(form) {
	var result = true;
	result = checkEventName($("input[name='eventname']"))&&result;
	result = checkEventType($("select[name='eventCategory']"))&&result;
	result = checkEventDistrict($("select[name='districtid']"))&&result;
	return result;
}

function validateUpdateContact(form) {
	var result = true;
	result = checkMobile($("input[name='profileform.mobile']"))&&result;
	result = checkQQ($("input[name='profileform.qq']"))&&result;
	return result;
}

function checkUsername(obj) {
	$(obj).tipsy("hide");
	var fieldVal = $(obj).val();
	var regexp = new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5]+$");
	var tmpStr = fieldVal.replace(/[^x00-xff]/g, "aa");
	var len = tmpStr.length;
	var placeHolder = $(obj).attr("placeholder");
	if (!fieldVal.match(regexp) || fieldVal == placeHolder || len < 3 || len > 20) {
		$(obj).attr("tooltip", "您的用户名必须是汉字、字母或数字，字数在3-20之间。");
		$(obj).tipsy("show");
		setFocus(obj);
		return false;
	}
	return true;
}

function checkEmail(obj) {
	$(obj).tipsy("hide");
	var fieldVal = $(obj).val();
	if (!isEmailFormatValid(fieldVal)) {
		$(obj).attr("tooltip", "请输入您正确格式的电邮地址。如：bill@gmail.com");
		$(obj).tipsy("show");
		$(obj).focus();
		return false;
	}
	var result = true;
	$.ajax({
	    url: 'usr/validate!checkEmailAjax.jhtml',
	    type: 'GET',
	    dataType: 'text',
	    async: false,
	    data: "email="+fieldVal,
	    success: function (data) {
	    	if (data=='true') {
				$(obj).attr("tooltip","邮件地址已经被注册，请直接登录。");
				$(obj).tipsy("show");
				setFocus(obj);
				result = false;
	    	}
	    }
	});
	return result;
}

function checkOldPassword(obj) {
	var fieldVal = $(obj).val();
	var result = true;
	$.ajax({
	    url: 'usr/validate!checkPasswordAjax.jhtml',
	    type: 'GET',
	    dataType: 'text',
	    async: false,
	    data: "password="+fieldVal,
	    success: function (data) {
	    	if (data=='false') {
				$(obj).attr("tooltip","输入密码有误，请重新输入。");
				$(obj).tipsy("show");
				setFocus(obj);
				result = false;
	    	}
	    }
	});
	return result;
}

function checkPassword(obj) {
	$(obj).tipsy("hide");
	var fieldVal = $(obj).val();
	var regexp = new RegExp("^\\w{6,20}$");
	if (!fieldVal.match(regexp)) {
		$(obj).attr("tooltip","请输入您的密码，必须是字母或数字，字数在6-20之间。");
		$(obj).tipsy("show");
		setFocus(obj);
		return false;
	}
	return true;
}

function checkPassword2(obj, obj1) {
	$(obj).tipsy("hide");
	var fieldVal = $(obj).val();
	var regexp = new RegExp("^\\w{6,20}$");
	if (!fieldVal.match(regexp)) {
		$(obj).attr("tooltip","请输入您的密码，必须是字母或数字，字数在6-20之间。");
		$(obj).tipsy("show");
		setFocus(obj);
		return false;
	}
	var pwd = $(obj1).val();
	if (fieldVal != pwd) {
		$(obj).attr("tooltip", "两次输入的密码不一致，请重新输入。");
		$(obj).tipsy("show");
		setFocus(obj);
		return false;
	}
	return true;
}

function checkGender(obj) {
	$(obj).tipsy("hide");
	var gender = $(obj).val();
	if (gender < 0) {
		$(obj).attr("tooltip", "请您选择性别。");
		$(obj).tipsy("show");
		setFocus(obj);
		return false;
	}
	return true;
}

function checkBirth(yearObj, monthObj, dayObj) {
	$(dayObj).tipsy("hide");
	var year = $(yearObj).val();
	var month = $(monthObj).val();
	var day = $(dayObj).val();
	if (year < 0 || month < 0 || day < 0) {
		$(dayObj).attr("tooltip", "请您输入完整的日期。");
		$(dayObj).tipsy("show");
		setFocus(dayObj);
		return false;
	}
	return true;
}

function checkEventName(obj) {
	$(obj).tipsy("hide");
	var fieldVal = $(obj).val();
	var regexp = new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5]+$");
	var tmpStr = fieldVal.replace(/[^x00-xff]/g, "aa");
	var len = tmpStr.length;
	var placeHolder = $(obj).attr("placeholder");
	if (!fieldVal.match(regexp) || fieldVal == placeHolder || len < 6 || len > 100) {
		$(obj).attr("tooltip", "活动名称必须是汉字、字母或数字，字数在3-50之间。");
		$(obj).tipsy("show");
		setFocus(obj);
		return false;
	}
	return true;
}

function checkEventType(obj) {
	$(obj).tipsy("hide");
	var type = $(obj).val();
	if (type < 0) {
		$(obj).attr("tooltip", "请您选择活动类别。");
		$(obj).tipsy("show");
		setFocus(obj);
		return false;
	}
	return true;
}

function checkEventDistrict(obj) {
	$(obj).tipsy("hide");
	var district = $(obj).val();
	if (district < 0) {
		$(obj).attr("tooltip", "请您选择区域。");
		$(obj).tipsy("show");
		setFocus(obj);
		return false;
	}
	return true;
}

function checkMobile(obj) {
	$(obj).tipsy("hide");
	var fieldVal = $(obj).val();
	
	var regexp = new RegExp("^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\\d{8}$");
	if (fieldVal!=="" && !fieldVal.match(regexp)) {
		$(obj).attr("tooltip","请输入11位手机号码。");
		$(obj).tipsy("show");
		setFocus(obj);
		return false;
	}
	return true;
}
function checkQQ(obj) {
	$(obj).tipsy("hide");
	var fieldVal = $(obj).val();
	var regexp = new RegExp("^\\d{5,20}$");
	if (fieldVal!== "" && !fieldVal.match(regexp)) {
		$(obj).attr("tooltip","请输入5位以上QQ号码。");
		$(obj).tipsy("show");
		setFocus(obj);
		return false;
	}
	return true;
}