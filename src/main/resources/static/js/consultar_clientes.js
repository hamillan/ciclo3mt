function consultar_clientes(){
    $.ajax({
        url: "http://129.159.57.91:8080/api/Client/all",
        type: 'GET',
        dataType: 'json',
        success: function(respuesta){
            console.log(respuesta);
            mostrarRespuestacli(respuesta);
        },
        error: function (xhr, status) {
            alert('ha sucedido un problema');
        }
    });
}

function mostrarRespuestacli(respuesta){
    var tabla_client = `<table border="1">
                  <tr>
                    <th>ID</th>
                    <th>EMAIL</th>
                    <th>CONTRASEÑA</th>
                    <th>NOMBRE</th>
                    <th>EDAD</th>
                  </tr>`;
    
    for(i=0;i<respuesta.length;i++){
                    tabla_client+="<tr>";
                    tabla_client+="<td>"+respuesta[i].idClient+"</td>";
                    tabla_client+="<td>"+respuesta[i].email+"</td>";
                    tabla_client+="<td>"+respuesta[i].password+"</td>";
                    tabla_client+="<td>"+respuesta[i].name+"</td>";
                    tabla_client+="<td>"+respuesta[i].age+"</td>";
                    tabla_client+="<td> <button onclick='borrarClientes("+respuesta[i].idClient+")'>Eliminar</button>";
                    tabla_client+="<td> <button onclick='actualizarClientes("+respuesta[i].idClient+")'>Actualizar</button>";        
                    tabla_client+="</tr>";
                }    
    tabla_client +=`</table>`;
    $("#tabla_clientes").html(tabla_client);
}