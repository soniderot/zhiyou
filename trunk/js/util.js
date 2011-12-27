$(function(){
  $("input").each(function(){
  	if($(this).attr("tipstype")!=undefined) {
    	$(this).attr("tooltip", "tooltip");
    }
  });
  $("select").each(function(){
  	if($(this).attr("tipstype")!=undefined) {
    	$(this).attr("tooltip", "tooltip");
    }
  });
});
 
jQuery.fn.maxlength = function(){
    $("textarea[maxlength]").keypress(function(event){
        var key = event.which;
        //all keys including return.
        if(key >= 33 || key == 13) {
            var maxLength = $(this).attr("maxlength");
            var length = this.value.length;

            if(length >= maxLength) {
                event.preventDefault();
            }
        }
    });
    
	$("textarea[maxlength]").blur(function(event){
		var maxLength = $(this).attr("maxlength");
        var length = this.value.length;
        if(length >= maxLength) {
        	var maxText = $(this).val().substring(0,maxLength);
        	$(this).val(maxText);
        }
    });
}

String.prototype.replaceAll  = function(s1,s2){
	return this.replace(new RegExp(s1,"gm"),s2);
}

String.prototype.length = function(){
	return this.replace(/[^\x00-\xff]/g, "**").length;
}

$(document).ready(function(){
	initDocumentReady();
});

function initDocumentReady() {
	$.ajaxSetup({cache: false});
	$(document).ajaxSuccess(function(evt, request, settings){
		try {
			if(request.responseText.indexOf("css_login")>0) {
				location.href = '/login.jhtml';
			}
		} catch (e) {}
	});
	
	initTextlength();
	initDefaultText();
	
	$("a[rel='facebox']").facebox();
	
	$(document).bind('reveal.facebox', function() {
		if( !$("#facebox .content #siteLogoFacebox").length  ) {
			var siteLogoImg = $("#m-header-logo-img").attr("src");
			$('#facebox .content').css({
				"background" : "#fff url("+siteLogoImg+") no-repeat 5px bottom"
			}).append("<div style='padding-bottom:55px'>&nbsp;</div>");
		}
	});
	
	$(document).bind('afterClose.facebox', function() {
		$('#facebox .content').css("height","");
		validate_hide();
	});

	$("[checkall]").click(function() {
		var objName = $(this).attr("checkall");
		$("input:checkbox[name='"+objName+"']").attr("checked", $(this).is(":checked"));
	});
	
	$("[js='showonload']").each(function() {
		$(this).removeClass("dn");
	});	
	
	
	if ( $("#generalMsg").length ) {
		$.facebox({div: "#generalMsg"});
	}
	
	$("[delayhide]").each(function() {
		var obj = $(this);
		setTimeout(function() {
			$(obj).fadeOut();
		},$(this).attr("delayhide"));
	});
	
	$(".alert > .close").each(function() {
		$(this).click(function() {
			$(this).parent(".alert").fadeOut();
		});
	});
}

function initSidebarHeight() {
	if ($("#m-sidebar")) {
		$("#m-sidebar").height( $("#content").height() + 80 );
	}
}

function initTextlength(selector) {
	selector = selector==null||selector=="" ? "" : selector+" ";
	$(selector+"[textlength]").each(function() {
		var thisElem = $(this);
		if (thisElem.data("textlengthinited")!=1) {
			var length = $(this).attr("textlength");
			var showtips = length.indexOf("+")>=0;
			length = showtips ? length.replace("+",""): length;
			var otext = $.trim($(this).html());
			var ctext = textlength(otext, length);
			if (ctext!=otext) {
				$(this).html(ctext+"...");
				thisElem.data("textlengthinited", 1);
				if (showtips) {
					$(this).attr("tooltip",otext);
					initTooltip(selector);
				}
			}
			$(this).show();
		}
	});
	
	function textlength(s, n) {
	    var s2 = s.slice(0, n),
	        i = s2.replace(/[^\x00-\xff]/g, "**").length;
	    if (i <= n) return s2;
	    i -= s2.length;
	    switch (i) {
	        case 0: return s2;
	        case n: return s.slice(0, n>>1);
	        default:
	            var k = n - i,
	                s3 = s.slice(k, n),
	                j = s3.replace(/[\x00-\xff]/g, "").length;
	            return j ? s.slice(0, k) + textlength(s3, j) : s.slice(0, k);
	    }
	};
}

function initTooltip(selector) {
	selector = selector==null||selector=="" ? "" : selector+" ";
	$(selector+"[tooltip]").each(function() {
		$(this).attr("tooltip_", $(this).attr("tooltip"));
		var option = new Object();
		option.gravity = $.fn.tipsy.autoNS;
		option.html = true;
		option.title = "tooltip";
		option.tipstype = "tipsy_normal";
		
		if ($(this).attr("tipstype")) {
			option.tipstype = $(this).attr("tipstype");
			if ($(this).attr("tipstype")=='error') {
				option.tipstype = "tipsy_error";
            	option.gravity = 'w';
            	option.trigger = 'manual';
            	option.opacity = 1;
			}
		}
		
		if ($(this).attr("tipsoption")) {
			var tipsoption = $.parseJSON($(this).attr("tipsoption"));
			if (tipsoption.html) {
				option.html = tipsoption.html==='true';
			}
			if (tipsoption.gravity) {
				option.gravity = tipsoption.gravity;
			}
			if (tipsoption.opacity) {
				option.opacity = tipsoption.opacity;
			}
		}
		$(this).tipsy(option);
	});	
	
    $(selector+"[note]").each(function() {
    	var thisNote = $(this);
    	var content = $("#note"+thisNote.attr("note").split(",")[0]).html();
    	thisNote.attr("notetips", content)
    	var option = new Object();
    	option.tipstype = "tipsy_note";
    	option.title = "notetips";
    	option.trigger = 'manual';
		option.gravity = "w";
		option.html = true;
		
		if (thisNote.attr("tipsoption")) {
			var tipsoption = $.parseJSON($(this).attr("tipsoption"));
			if (tipsoption.gravity) {
				option.gravity = tipsoption.gravity;
			}
			if (tipsoption.trigger) {
				option.trigger = tipsoption.trigger;
			}
			if (tipsoption.opacity) {
				option.opacity = tipsoption.opacity; 
			}
		}

		thisNote.tipsy(option);
		
		if (option.trigger=="manual") {
			var noteId = thisNote.attr("note").split(",");
			$(noteId).each(function(i) {
				$("[id="+this+"]").each(function() {
				    $(this).bind("click mousedown", function() {
				    	validate_hide();
				    	thisNote.tipsy("show");
					}).bind("blur focusout", function() {
						thisNote.tipsy("hide");
					});					
				});
			});
		}
    });
}

function limitImageDimension(obj,h,w) {
	h = h==null ? 100 : h;
	w = w==null ? 100 : w;
	obj = obj==null ? $(".vcard-pic img") : obj;

	$(obj).one("load",function(){
		var o_h = $(this).height();
		var o_w = $(this).width();
		if ($(this).height() > h) {
			$(this).attr("height",h);
			$(this).removeAttr("width");
		}

		if ($(this).width() > w) {
			$(this).attr("width",w);
			$(this).removeAttr("height");
		}

		$(this).show();
	}).each(function() {
		$(this).hide();
		if(this.complete || (jQuery.browser.msie && parseInt(jQuery.browser.version) == 6)) {
			$(this).trigger("load");
		}
	});	
}

function enlarge(photoId, userId) {
	$.facebox({ ajax: '/member/browse.jhtml?action=photos&profileId='+userId+'&photoId='+photoId });
	return false;
}

function initDefaultText(selector) {
	selector = selector==null||selector=="" ? "" : selector+" ";
	$(selector+"[defaulttext]").each(function() {
		$(this).addClass("default");
		var defaulttext = $(this).attr("defaulttext");
		if ($(this).val().length==0 || $(this).val()==defaulttext) {
			$(this).val(defaulttext);
		} else {
			$(this).removeClass("default");
		}

		$(this).focus(function() {
			if ($(this).data("pwdtext")=="1") {
				$(this).prev("input:password").show().focus();				
				$(this).prev("input:password").attr("id",$(this).attr("id"));
				$(this).prev("input:password").attr("name",$(this).attr("name"));
				$(this).detach();
			} else {
				if ($(this).val() == defaulttext) {
					$(this).val("");
				}
				$(this).removeClass("default");
			}
		});
		
		$(this).blur(function() {
			if ($(this).val() == "") {
				if ($(this).data("pwdtext_")!=null) {
					var newx = $(this).data("pwdtext_");
					newx.insertAfter($(this));
					$(this).attr("id","pwdtext_"+$(this).attr("id"));
					$(this).attr("name","pwdtext_"+$(this).attr("name"));
					$(this).hide();
				} else {
					$(this).val(defaulttext);
					$(this).addClass("default");
				}
			}
		});

		if ($(this).attr("type")=="password" && $(this).data("pwdtext_")==null && $(this).data("pwdtext")==null) {
			var dummy = $("<input>");
			var $this = $(this);
			$.each($this.get(0).attributes, function(i) {
				var a = $this.get(0).attributes[i];
				var n = a.nodeName;
				var v = a.nodeValue;
				var s = a.specified;
				if (s) {
					var set = true;
					if (n=="type") {
						v = "text";
					} else if (n=="style") {
						v = $this.attr("style");
					} else if (n=="onclick") {
						dummy.bind("click",function() { eval(v) });
						set = false;
					} else if (n=="onfocus") {
						dummy.bind("focus",function() { eval(v) });
						set = false;
					} else if (n=="onblur") {
						dummy.bind("blur",function() { eval(v) });
						set = false;
					}
					
					if (n.indexOf("jQuery")!=0 && set) {
						dummy.attr(n,v);
					}
				}
			});
			var events = $this.data('events');
			for (var type in events) {
				$.each(events[type], function(index, handler) {
					dummy.bind(type, handler.handler);
				});
			}
			dummy.val($(this).val());
			dummy.data("pwdtext","1").insertAfter($(this));
			$this.attr("id","pwdtext_"+$this.attr("id"));
			$this.attr("name","pwdtext_"+$this.attr("name"));
			$this.data("pwdtext_",dummy);
			$this.hide();
		}
	});	
	
	initTooltip(selector);
	$().maxlength();
}

function removeMailCookie() {
	$.cookie('mailSubject', null);
	$.cookie('mailBody', null);
}

function setMailSubjectCookie(profileId, content) {
	setMailCookie(profileId, content, "mailSubject");
}

function getMailSubjectCookie(profileId) {
	return getMailCookie(profileId, "mailSubject");
}

function setMailBodyCookie(profileId, content) {
	setMailCookie(profileId, content, "mailBody");
}

function getMailBodyCookie(profileId) {
	return getMailCookie(profileId, "mailBody");
}

function setMailCookie(profileId, content, cookieName) {
	content = profileId+cookieName+"|"+content;
	$.cookie(cookieName, content);
}

function getMailCookie(profileId, cookieName) {
	var mailCookie = $.cookie(cookieName);
	if (mailCookie != null) {
		var cookieProfileId = mailCookie.split(cookieName+"|")[0];
		var cookieContent =  mailCookie.split(cookieName+"|")[1];

		if (cookieProfileId!=profileId) {
			removeMailCookie();
			return "";
		} else {
			return cookieContent;
		}
	}

	return "";
}

function disabledButton(obj) {
	$(obj).attr("disabled", "disabled");
	$(obj).parent().addClass("disabled");
}

function enableButton(obj) {
	$(obj).removeAttr("disabled");
	$(obj).parent().removeClass("disabled");
}

function validate_hide() {
	$("div[id='tipsy_error']").each(function() {
		$(this).remove();
	});
	
	$("[note]").each(function() {
		$(this).tipsy("hide");
	});
}

function validate(obj, errObj) {
	validate_hide();

	var result = true;
	var type = $(obj).prop("type");
	var val = $.trim($(obj).val());
	if (type == 'text' || type == 'password' || type=='hidden') {
		result = val.length<=0 || val==$(obj).attr("defaulttext");
		if (type=='hidden') {
			result = val==0;
		}
	} else if (type == 'select-one') {
		result = $(obj).val()=='';
	} else if (type=='select-multiple') {
		result = $(obj+" option:selected").length == 0;
	} else if (type == 'checkbox') {
		result = !$(obj).is(":checked");
	} else if (type == 'radio') {
		result = $(obj).filter(":checked").val() ? false : true;		
	} else if (type == 'textarea') {
		result = val.length <= 0 || val==$(obj).attr("defaulttext");;
	} else if (type == 'file') {
		var fileName = val.toLowerCase();
		if (fileName.length>0) {
			var dotJpgIndex = fileName.lastIndexOf('.jpg');
			var dotPngIndex = fileName.lastIndexOf('.png');
			if ((dotJpgIndex>0 && (dotJpgIndex+4==fileName.length)) || (dotPngIndex>0 && (dotPngIndex+4==fileName.length))) {
				result = false;
			} else {
				result = true;
			}
		} else {
			result = true;
		}
	}

	if (result) {
		errObj = errObj==null ? obj : errObj;
		$(errObj).attr("tooltip", $(errObj).attr("tooltip_") );
		$(errObj).tipsy("show");
		setFocus($(obj));
	}
	
	return !result;
}

function setFocus(obj) {
	$(obj).focus();
	try {
		$(obj).select();
	} catch (e) {}
}

function isEmailFormatValid(fieldVal) {
	var regexp = new RegExp("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$");
	return fieldVal.match(regexp);
}

function text2Unicode(str) {
	var result = "";

	for(i = 0 ; i < str.length ; i++) {
		c = str.charAt(i);
		if((' ' <= c && c <= '~') || (c == '\r') || (c == '\n')) {
			if(c == '&') {
				cstr = "&amp;";
			} else if(c == '<') {
				cstr = "&lt;";
			} else if(c == '>') {
				cstr = "&gt;";
			} else {
				cstr = c.toString();
			}
		} else {
	    	cstr = "&#" + c.charCodeAt().toString() + ";";
	    }
		result = result + cstr;
	}

	return result;
}