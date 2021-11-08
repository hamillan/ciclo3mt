function consultar_protesis(){
    $.ajax({
        url: "http://129.159.57.91:8080/api/Ortopedic/all",
        type: 'GET',
        dataType: 'json',
        success: function(respuesta){
            console.log(respuesta);
            mostrarRespuestapro(respuesta);
        },
        error: function (xhr, status) {
            alert('ha sucedido un problema');
        }
    });
}

var mostrarRespuestapro = function (items) {
    var tabla_pro = `<table class="table striped">
                  <tr>
                    <th>ID</th>
                    <th>NOMBRE</th>
                    <th>MARCA</th>
                    <th>AÑO</th>
                    <th>DESCRIPCION</th>  
                    <th>ACCIONES</th>
                  </tr>`;


    for (var i = 0; i < items.length; i++) {
        tabla_pro += `<tr>
                   <td>${items[i].id}</td>
                   <td>${items[i].name}</td>
                   <td>${items[i].brand}</td>
                   <td>${items[i].year}</td>
                   <td>${items[i].description}</td>
                   
                   <td style="margin:0">
                    <button type="button" class="btn btn-sm btn-primary" onclick="editar(${items[i].id}, '${items[i].name}', '${items[i].brand}', '${items[i].year}', '${items[i].description}')">
                        Editar
                    </button>
                    <button type="button" class="btn btn-sm btn-danger" onclick="eliminar(${items[i].id})">
                        Eliminar
                    </button>
                   </td>
                </tr>`;
    }
    tabla_pro += `</table>`;

    $("#tabla_protesis").html(tabla_pro);

}

$(document).ready(function () {
    console.log("document ready");
    consultar_protesis();
});