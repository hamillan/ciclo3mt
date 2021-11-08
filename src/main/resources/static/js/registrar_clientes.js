function registrar_clientes(){
    console.log("ejecutando funcion para registrar nuevos Clientes");

    let clientes = {
        email:$("#client_email").val(),
        password:$("#client_password").val(),
        name:$("#client_name").val(),
        age:$("#client_age").val(),
        description:$("#prot_description").val()
        };
      
        $.ajax({
        type:'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: JSON.stringify(clientes),
        url:"http://129.159.57.91:8080/api/Client/save",

        success:function(response) {
            console.log(response);
            console.log("Se guardó correctamente");
            alert("Cliente guardado correctamente");
            consultar_clientes()    
        },        
        error: function(jqXHR, textStatus, errorThrown) {
              window.location.reload()
            alert("No se guardó correctamente");
        }
        });
}