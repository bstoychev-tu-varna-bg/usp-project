$(function(){
$("#brand-choice").change(function() {

	var $brandChoice = $(this);

	$.getJSON("/jsondata/brandsAndModels.json", function(data) {

		var brandVals = $brandChoice.val().split(":");
		var key = brandVals[1];
		var vals = [];

		vals = data[key].split(",");

		var $modelChoice = $("#model-choice");
		$modelChoice.empty();
		$.each(vals, function(index, value) {
			$modelChoice.append("<option>" + "model:" + value + "</option>");
		});

	});
});

$('#searchCar').submit(function() {
    var yearOfManufacture = $('#yearOfManufacture');
    yearOfManufacture.val("date:" + yearOfManufacture.val());
    var carDistanceTraveled = $('#carDistanceTraveled');
    carDistanceTraveled.val("distance_traveled:" + carDistanceTraveled.val());
    var carColor = $('#carColor');
    carColor.val("color:" + carColor.val());
    var carPrice = $('#carPrice');
    carPrice.val("price:" + carPrice.val());
});

});