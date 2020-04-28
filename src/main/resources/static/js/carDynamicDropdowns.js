$(function(){
$("#brand-choice").change(function() {

	var $brandChoice = $(this);

	$.getJSON("/jsondata/brandsAndModels.json", function(data) {

		var key = $brandChoice.val();
		var vals = [];

		vals = data[key].split(",");

		var $modelChoice = $("#model-choice");
		$modelChoice.empty();
		$.each(vals, function(index, value) {
			$modelChoice.append("<option>" + value + "</option>");
		});

	});
});

});