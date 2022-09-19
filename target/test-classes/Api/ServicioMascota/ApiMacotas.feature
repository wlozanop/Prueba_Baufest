#language:es
  @PETSTORE
  Característica: Se desea ejecutar el Servicio API PetStore

    @PetStore_Server_01
    Escenario: Vamos a crear una mascota
      Dado que configuro las cabeceras
           | cabeceras    | valor            |
           | Content-type | application/json |
         Y que configuro el body del servicio: "agregarMascota"
           | key           | valor      |
           | id            | 400        |
           | name          | Boby       |
           | status        | disponible |
           | category.name | string     |
           | tags[0].name  | string     |
       Cuando ejecuto el api
         | dominio                     | urlbase | metodo |
         | https://petstore.swagger.io | /pet    | post   |
      Entonces valido que el codigo de respuesta sea "200"
      Y valido los siguientes resultados en el json de respuesta
        | nodo   | valor      |
        | id     | 400        |
        | name   | Boby       |
        | status | disponible |

    @PetStore_Server_02
    Escenario: Vamos a obtener los datos de una mascota existente
      Dado que configuro las cabeceras
        | cabeceras    | valor            |
        | Content-type | application/json |
      Cuando ejecuto el api
        | dominio                     | urlbase  | metodo |
        | https://petstore.swagger.io | /pet/400 | get   |
      Entonces valido que el codigo de respuesta sea "200"
      Y valido los siguientes resultados en el json de respuesta
        | nodo   | valor      |
        | id     | 400        |

    @PetStore_Server_03
    Escenario: Vamos a validar el control del exception de un ID nulo
      Dado que configuro las cabeceras
        | cabeceras    | valor            |
        | Content-type | application/json |
      Cuando ejecuto el api
        | dominio                     | urlbase  | metodo |
        | https://petstore.swagger.io | /pet/ | get   |
      Entonces valido que el codigo de respuesta sea "405"

    @PetStore_Server_04
    Escenario: Vamos a validar el Id que no existe
      Dado que configuro las cabeceras
        | cabeceras    | valor            |
        | Content-type | application/json |
      Cuando ejecuto el api
        | dominio                     | urlbase  | metodo |
        | https://petstore.swagger.io | /pet/405 | get   |
      Entonces valido que el codigo de respuesta sea "404"

    @PetStore_Server_05
    Escenario: Vamos a modificar los datos de una mascota
      Dado que configuro las cabeceras
        | cabeceras    | valor            |
        | Content-Type | application/json |
      Y que configuro el body del servicio: "modificarMascota"
        | key           | valor      |
        | id            | 400        |
        | name          | Boby_Shell |
        | status        | disponible |
        | category.name | string     |
        | tags[0].name  | string     |
      Cuando ejecuto el api
        | dominio                     | urlbase | metodo |
        | https://petstore.swagger.io | /pet    | put    |
      Entonces valido que el codigo de respuesta sea "200"
      Y valido los siguientes resultados en el json de respuesta
        | nodo   | valor      |
        | id     | 400        |



