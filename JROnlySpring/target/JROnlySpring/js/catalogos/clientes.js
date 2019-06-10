
function cargaCliente() {
	$("#nombre").focus();
}

$(document).ready(function(){
	$(".campofecha").calendarioDW();
});

function consultaData() {
	actualizaData('showCliente.jr', 'id', 0, 850, 350);
}
