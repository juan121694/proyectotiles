<%
String context = request.getContextPath();
%>
<script type="text/javascript">
YAHOO.util.Event.onDOMReady(function () {
	var clickSubmenu = function () {
	    opcion = this.id;
            if(opcion == "home") {
	    	window.location.replace("<%= context %>/home.jr");
	    	return;
	    }
	    if(opcion == "salir") {
	    	window.location.replace("<%= context %>/redirect.jsp");
	    	return;
	    }
	    if(opcion == "clientes") {
	    	window.location.replace("<%= context %>/catalogos/clientes/consultaClientes.jr");
	    	return;
	    }
            if(opcion == "movimientos") {
	    	window.location.replace("<%= context %>/catalogos/movimientos/consultaMovimientos.jr");
	    	return;
	    }
            if(opcion == "inversiones") {
	    	window.location.replace("<%= context %>/catalogos/inversiones/consultaInversiones.jr");
	    	return;
	    }
            if(opcion == "pago") {
	    	window.location.replace("<%= context %>/catalogos/clientes/consultaPago.jr");
	    	return;
	    }
	    if(opcion == "usuarios") {
	    	window.location.replace("<%= context %>/catalogos/usuarios/consultaUsuarios.jr");
	    	return;
	    }
            if(opcion == "obtener") {
	    	window.location.replace("<%= context %>/catalogos/clientes/obtenerCredito.jr");
	    	return;
	    }
	};
	var aItemData = null;
	aItemData = [
        {
	   	text: "Inicio", onclick: {fn: clickSubmenu}, id: "home"
	},
        {
            text: "Movimientos", onclick: {fn: clickSubmenu}, id: "movimientos"
        },
        {
            text: "Inversiones", onclick: {fn: clickSubmenu}, id: "inversiones"
        },
        {
	    text: "Pago Credito", onclick: {fn: clickSubmenu}, id: "pago"
	},
        {
	    text: "Obtener credito", onclick: {fn: clickSubmenu}, id: "obtener"
	},
	{
	   	text: "Salir", onclick: {fn: clickSubmenu}, id: "salir"
	}];
	var oMenuBar = new YAHOO.widget.MenuBar("mymenubar", {
	    lazyload: true,
	    itemdata: aItemData
	});
	oMenuBar.render(document.getElementById("menu_jr"));
});
</script>
<div id="menu_jr">
</div>
