
function cargaMovimiento() {
	$("#concepto").focus();
}

$(document).ready(function(){
	$(".campofecha").calendarioDW();
});

function consultaData() {
	actualizaData('showMovimiento.jr', 'id', 0, 850, 350);
}