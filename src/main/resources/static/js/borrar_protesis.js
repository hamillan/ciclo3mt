function borrarProtesis(identificador){
    let valor={
        id:identificador
    };
    let data=JSON.stringify(valor);
    $.ajax({
        url:"http://129.159.57.91:8080/api/Ortopedic/"+identificador,
        type:"DELETE",
        data:data,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();            
            alert("Se ha Eliminado la Prótesis.")
            consultar_protesis()
        }
    });

}