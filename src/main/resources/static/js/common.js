function showMsg(message, callback) {
	$('#msgBox').find('.weui-dialog__bd').html(message);
	$('#msgBox').fadeIn(200);
	$('.weui-dialog__btn_primary').unbind('click').click(function() {
		$('#msgBox').fadeOut(200);
		if (typeof (callback) == 'function') {
			callback();
		}
	});
}