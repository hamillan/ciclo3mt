function registrar_mensajes(){
    console.log("ejecutando funcion para registrar nuevos Mensajes");

    let mensaje = {
        messageText:$("#messag_text").val(),
        };
      
        $.ajax({
        type:'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: JSON.stringify(mensaje),
        url:"http://129.159.57.91:8080/api/Message/save",

        success:function(response) {
            console.log(response);
            console.log("Se guardo correctamente");
            alert("Mensage guardado correctamente");
            consultar_mensajes()    
        },        
        error: function(jqXHR, textStatus, errorThrown) {
              window.location.reload()
            alert("No se guardo correctamente");
        }
        });
}