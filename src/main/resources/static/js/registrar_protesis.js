function registrar_protesis(){
    console.log("ejecutando funcion para registrar nuevas prótesis");

    let protesis = {
        name:$("#prot_name").val(),
        brand:$("#prot_brand").val(),
        year:$("#prot_year").val(),
        description:$("#prot_description").val()
        };
      
        $.ajax({
        type:'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: JSON.stringify(protesis),
        url:"http://129.159.57.91:8080/api/Ortopedic/save",

        success:function(response) {
            console.log(response);
            console.log("Se guardo correctamente");
            alert("Prótesis guardada correctamente");
            consultar_protesis()    
        },        
        error: function(jqXHR, textStatus, errorThrown) {
              window.location.reload()
            alert("No se guardo correctamente");
        }
        });
}