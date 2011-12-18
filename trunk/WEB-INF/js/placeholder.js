$(document).ready(  
   function() {  
     $("input[type='text']").each(function() {
     	 if ($(this).attr("placeholder") != undefined) {
     	 		$(this).val($(this).attr("placeholder"));
     	 }
   	 });
   	 $("textarea").each(function() {
     	 if ($(this).attr("placeholder") != undefined) {
     	 		$(this).val($(this).attr("placeholder"));
     	 }
   	 });
     make.placeholder("DOMControl_placeholder", "placeholder");  
   });  
   
 (function() {  
   var make = {  
     // placeholderClassName: class name that define the css to control the style  
     // attributeName: attribute name in the input field  
     placeholder : function(placeholderClassName, attributeName) {  
       $("input").each(function() {  
         var $this = $(this);  
         if ($this.attr(attributeName) != undefined) {  
           // deactivate placeholder  
           $this.focus(function() {
             if ($this.val() == $this.attr(attributeName)) {  
               $this.removeClass(placeholderClassName);  
               $this.val("");  
             }  
           });  
           // activate placeholder  
           $this.blur(function() {  
             if ($this.val() == "") {  
               $this.addClass(placeholderClassName);  
               $this.val($this.attr(attributeName));
             }  
           });  
           // initialize placeholder  
           $this.blur();  
         }  
       });  
     }  
   };  
   window.make = make;
 })(); 