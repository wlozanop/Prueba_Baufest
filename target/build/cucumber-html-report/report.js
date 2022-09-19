$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Web.demoblaze/demoBlaze.feature");
formatter.feature({
  "name": "Validacion de compra en DEMOBLAZE",
  "description": "        yo como usuario necesito realizar una compra de una laptop modelo MAC",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@DEMOBLAZE"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Accediendo al Home de DEMOBLAZE comprar con usuario nuevo",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@BLAZE2"
    }
  ]
});
formatter.step({
  "name": "Ingresamos a la cuenta del usuario clic en Log in",
  "keyword": "When "
});
formatter.step({
  "name": "luego ingresar el correo \"\u003csCorreo\u003e\" y la clave \"\u003csClave\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "validar que ingresamos al perfil del usuario \"\u003csMensajeBienvenida\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "dar clic en Laptop",
  "keyword": "And "
});
formatter.step({
  "name": "Luego seleccionamos la laptop Mac",
  "keyword": "And "
});
formatter.step({
  "name": "Luego damos clic en el boton Agregar al carrito",
  "keyword": "And "
});
formatter.step({
  "name": "Validar que el producto se haya añadido con exito",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "sCorreo",
        "sClave",
        "sMensajeBienvenida"
      ]
    },
    {
      "cells": [
        "Argelio_01",
        "Peru456+",
        "Welcome Argelio_01"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Cargar la pagina de demoBlaze",
  "keyword": "Given "
});
formatter.match({
  "location": "DemoBlazeStepDefinition.Cargar_la_pagina_de_demoBlaze()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Accediendo al Home de DEMOBLAZE comprar con usuario nuevo",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@DEMOBLAZE"
    },
    {
      "name": "@BLAZE2"
    }
  ]
});
formatter.step({
  "name": "Ingresamos a la cuenta del usuario clic en Log in",
  "keyword": "When "
});
formatter.match({
  "location": "DemoBlazeStepDefinition.ingresamos_a_la_cuenta_del_usuario_clic_en_Log_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "luego ingresar el correo \"Argelio_01\" y la clave \"Peru456+\"",
  "keyword": "And "
});
formatter.match({
  "location": "DemoBlazeStepDefinition.luego_ingresar_el_correo_y_la_clave(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validar que ingresamos al perfil del usuario \"Welcome Argelio_01\"",
  "keyword": "And "
});
formatter.match({
  "location": "DemoBlazeStepDefinition.validar_que_ingresamos_al_perfil_del_usuario(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "dar clic en Laptop",
  "keyword": "And "
});
formatter.match({
  "location": "DemoBlazeStepDefinition.dar_clic_en_Laptop()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Luego seleccionamos la laptop Mac",
  "keyword": "And "
});
formatter.match({
  "location": "DemoBlazeStepDefinition.luego_seleccionamos_la_laptop_Mac()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Luego damos clic en el boton Agregar al carrito",
  "keyword": "And "
});
formatter.match({
  "location": "DemoBlazeStepDefinition.luego_damos_clic_en_el_boton_Agregar_al_carrito()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validar que el producto se haya añadido con exito",
  "keyword": "Then "
});
formatter.match({
  "location": "DemoBlazeStepDefinition.validar_que_el_producto_se_haya_añadido_con_exito()"
});
formatter.result({
  "status": "passed"
});
});