function actualizarCategorias(identificador){
    let valor={
        id:identificador,
        name:$("#categ_name").val(),
        description:$("#categ_description").val()
    };
    console.log(valor);
    let data=JSON.stringify(valor);
    $.ajax({
        url:"http://129.159.57.91:8080/api/Category/update",
        type:"PUT",
        data:data,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();   
            $("#id").val("");
            $("#categ_name").val("");
            $("#categ_description").val("");
            alert("Se ha Actualizado la Categoría.")
            consultar_categoria()
        }
    });

}