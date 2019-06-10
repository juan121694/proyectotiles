
function cargaInversion() {
	$("#concepto").focus();
}

$(document).ready(function(){
	$(".campofecha").calendarioDW();
});

function consultaData() {
	actualizaData('showInversion.jr', 'id', 0, 850, 350);
}