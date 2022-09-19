package com.bdd.stepdefinition;

import com.bdd.step.DemoBlazeStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class DemoBlazeStepDefinition {


    @Steps
    private DemoBlazeStep demoBlazeStep;

    @Given("^Cargar la pagina de demoBlaze$")
    public void Cargar_la_pagina_de_demoBlaze() {
        demoBlazeStep.cargarPaginaDemoBlaze();
    }

    @When("^Dar de alta un usuario dar clic en Sign up ingresar \"([^\"]*)\" y \"([^\"]*)\"$")
    public void dar_de_alta_un_usuario_dar_clic_en_Sign_up_ingresar_y(String correo, String clave) throws Exception {
        demoBlazeStep.darAltaUsuario(correo,clave);
    }

    @Then("^Validar que estamos en la cuenta del usuario$")
    public void validar_que_estamos_en_la_cuenta_del_usuario() throws Exception {

    }

    //LOGIN A CUENTA DEL USUARIO

    @When("^Ingresamos a la cuenta del usuario clic en Log in$")
    public void ingresamos_a_la_cuenta_del_usuario_clic_en_Log_in() throws Exception {
        demoBlazeStep.darClicLogin();
    }

    @When("^luego ingresar el correo \"([^\"]*)\" y la clave \"([^\"]*)\"$")
    public void luego_ingresar_el_correo_y_la_clave(String usuario, String clave) throws Exception {
        demoBlazeStep.IngresarUserPass(usuario,clave);
    }

    @When("^validar que ingresamos al perfil del usuario \"([^\"]*)\"$")
    public void validar_que_ingresamos_al_perfil_del_usuario(String MensajeBienvenida) throws Exception {
        demoBlazeStep.validarPerfilUsuario(MensajeBienvenida);
    }

    @When("^dar clic en Laptop$")
    public void dar_clic_en_Laptop() throws Exception {
        demoBlazeStep.clicLaptops();
    }

    @When("^Luego seleccionamos la laptop Mac$")
    public void luego_seleccionamos_la_laptop_Mac() throws Exception {
        demoBlazeStep.SeleccionLaptop();
    }

    @When("^Luego damos clic en el boton Agregar al carrito$")
    public void luego_damos_clic_en_el_boton_Agregar_al_carrito() throws Exception {
        demoBlazeStep.AgregarCarrito();
    }

    @Then("^Validar que el producto se haya añadido con exito$")
    public void validar_que_el_producto_se_haya_añadido_con_exito() throws Exception {
        demoBlazeStep.ValidarProductoCarrito();
    }

}
