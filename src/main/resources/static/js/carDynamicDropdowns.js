$(function(){
/*
$("#brand-choice").change(function() {

	var $dropdown = $(this);

	$.getJSON("/jsondata/brandsAndModels.json", function(data) {

		var key = $dropdown.val();
		var vals = [];

		switch(key) {
			case 'Mercedes-Benz':
				vals = data.mercedes-benz.split(",");
				break;
			case 'Audi':
				vals = data.audi.split(",");
				break;
			case 'BMW':
                vals = data.bmw.split(",");
                break;
            case 'Renault':
                vals = data.renault.split(",");
                break;
            case 'Peugeot':
                vals = data.peugeot.split(",");
                break;
            case 'Citroen':
                vals = data.citroen.split(",");
                break;
			case 'base':
				vals = ['Please choose from above'];
		}

		var $secondChoice = $("#model-choice");
		$secondChoice.empty();
		$.each(vals, function(index, value) {
			$secondChoice.append("<option>" + value + "</option>");
		});

	});
});
*/

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