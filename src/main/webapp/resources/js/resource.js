$(document).ready(function () {
	$('#request-link').click(function (e) {
		e.preventDefault();
		$.post("request", $("form").serialize(), function (data) {
			alert(data);
		});
		return false;
	});
});