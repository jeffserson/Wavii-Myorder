$(function() {
	$('.js-toggle').bind('click', function(event) {
		$('.js-sidebar, .js-content').toggleClass('is-toggled');
		event.preventDefault();
	});
});

jQuery(document).ready(function(jQuery){
	upperText();
});
function upperText(){
	jQuery(".up").bind('paste', function(e){
		var el = jQuery(this);
		setTimeout(function(){
			var text = jQuery(el).val();
			el.val(text.toUpperCase());
		},10);
		
	});
	jQuery(".up").keypress(function() {
		var el = jQuery(this);
		setTimeout(function() {
			var text = jQuery(el).val();
			el.val(text.toUpperCase());
			
		},10);
		
	});
	
	
}