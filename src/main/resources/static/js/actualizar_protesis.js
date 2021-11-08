function actualizarProtesis(identificador){
    let valor={
        id:identificador,
        name:$("#prot_name").val(),
        brand:$("#prot_brand").val(),
        year:$("#prot_year").val(),
        description:$("#prot_description").val(),
    };
    console.log(valor);
    let data=JSON.stringify(valor);
    $.ajax({
        url:"http://129.159.57.91:8080/api/Ortopedic/update",
        type:"PUT",
        data:data,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();   
            $("#id").val("");
            $("#prot_name").val("");
            $("#prot_brand").val("");
            $("#prot_year").val("");
            $("#prot_description").val("");
            alert("Se ha Actualizado la Prótesis.")
            consultar_protesis()
        }
    });

}