function registrar_categorias(){
    console.log("ejecutando funcion para registrar nuevas categorías");

    let categoria = {
        name:$("#categ_name").val(),
        description:$("#categ_description").val()
        };
      
        $.ajax({
        type:'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: JSON.stringify(categoria),
        url:"http://129.159.57.91:8080/api/Category/save",

        success:function(response) {
            console.log(response);
            console.log("Se guardo correctamente");
            alert("Categoría guardada correctamente");
            consultar_categoria()    
        },        
        error: function(jqXHR, textStatus, errorThrown) {
              window.location.reload()
            alert("No se guardo correctamente");
        }
        });
}