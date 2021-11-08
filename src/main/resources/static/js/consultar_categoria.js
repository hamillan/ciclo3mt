function consultar_categoria(){
    $.ajax({
        url: "http://129.159.57.91:8080/api/Category/all",
        type: 'GET',
        dataType: 'json',
        success: function(respuesta){
            console.log(respuesta);
            mostrarRespuestacat(respuesta);
        },
        error: function (xhr, status) {
            alert('ha sucedido un problema');
        }
    });
}

function mostrarRespuestacat(respuesta){
    var tabla_categ = `<table border="1">
                  <tr>
                    <th>ID</th>
                    <th>NOMBRE</th>
                    <th>DESCRIPCION</th>
                  </tr>`;

    for(i=0;i<respuesta.length;i++){
        tabla_categ+="<tr>";
        tabla_categ+="<td>"+respuesta[i].id+"</td>";
        tabla_categ+="<td>"+respuesta[i].name+"</td>";
        tabla_categ+="<td>"+respuesta[i].description+"</td>";
        tabla_categ+="<td> <button onclick='borrarCategorias("+respuesta[i].id+")'>Eliminar</button>";
        tabla_categ+="<td> <button onclick='actualizarCategorias("+respuesta[i].id+")'>Actualizar</button>";        
        tabla_categ+="</tr>";
    }    
    tabla_categ +=`</table>`;
    $("#tabla_categorias").html(tabla_categ);
}

