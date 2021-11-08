function borrarClientes(identificador){
    let valor={
        id:identificador
    };
    let data=JSON.stringify(valor);
    $.ajax({
        url:"http://129.159.57.91:8080/api/Client/"+identificador,
        type:"DELETE",
        data:data,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();            
            alert("Se ha Eliminado el Cliente.")
            consultar_clientes()
        }
    });

}