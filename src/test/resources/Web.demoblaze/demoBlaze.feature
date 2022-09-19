@DEMOBLAZE
Feature: Validacion de compra en DEMOBLAZE
        yo como usuario necesito realizar una compra de una laptop modelo MAC

  Background:
    Given Cargar la pagina de demoBlaze

  @BLAZE1
  Scenario Outline: Accediendo al Home de DEMOBLAZE para dar de alta un usuario
    When Dar de alta un usuario dar clic en Sign up ingresar "<sCorreo>" y "<sClave>"
    Then Validar que estamos en la cuenta del usuario

    Examples:
      | sCorreo     | sClave    |
      | Argelio_01  | Peru456+  |

  @BLAZE2
  Scenario Outline: Accediendo al Home de DEMOBLAZE comprar con usuario nuevo
    When Ingresamos a la cuenta del usuario clic en Log in
    And luego ingresar el correo "<sCorreo>" y la clave "<sClave>"
    And validar que ingresamos al perfil del usuario "<sMensajeBienvenida>"
    And dar clic en Laptop
    And Luego seleccionamos la laptop Mac
    And Luego damos clic en el boton Agregar al carrito
    Then Validar que el producto se haya añadido con exito

    Examples:
      | sCorreo     | sClave    | sMensajeBienvenida   |
      | Argelio_01  | Peru456+  | Welcome Argelio_01   |
