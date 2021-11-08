function consultar_mensajes(){
    $.ajax({
        url: "http://129.159.57.91:8080/api/Message/all",
        type: 'GET',
        dataType: 'json',
        success: function(respuesta){
            console.log(respuesta);
            mostrarRespuestamensj(respuesta);
        },
        error: function (xhr, status) {
            alert('ha sucedido un problema');
        }
    });
}

function mostrarRespuestamensj(respuesta){
    var tabla_mensj = `<table border="1">
                  <tr>
                    <th>ID</th>
                    <th>MENSAJE</th>
                  </tr>`;
    
    for(i=0;i<respuesta.length;i++){
                    tabla_mensj+="<tr>";
                    tabla_mensj+="<td>"+respuesta[i].idMessage+"</td>";
                    tabla_mensj+="<td>"+respuesta[i].messageText+"</td>";
                    tabla_mensj+="<td> <button onclick='borrarMensajes("+respuesta[i].idMessage+")'>Eliminar</button>";
                    tabla_mensj+="<td> <button onclick='actualizarMensajes("+respuesta[i].idMessage+")'>Actualizar</button>";        
                    tabla_mensj+="</tr>";
                }    
    tabla_mensj +=`</table>`;
    $("#tabla_mensajes").html(tabla_mensj);
}