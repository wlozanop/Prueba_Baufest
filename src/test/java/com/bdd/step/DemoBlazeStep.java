package com.bdd.step;

import com.bdd.page.DemoBlazePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class DemoBlazeStep extends ScenarioSteps {

    private DemoBlazePage demoBlazePage;

    @Step
    public void cargarPaginaDemoBlaze() {
        demoBlazePage.open();
        getDriver().manage().window().maximize();
    }

    @Step
    public void darAltaUsuario(String user,String clave) throws InterruptedException {
        demoBlazePage.darAltaUsuario(user,clave);
    }

    @Step
    public void darClicLogin() throws InterruptedException {
        demoBlazePage.clicLogin();
    }

    @Step
    public void IngresarUserPass(String usuario, String clave) throws InterruptedException {
        demoBlazePage.IngresarUsuarioClave(usuario,clave);
    }

    @Step
    public void validarPerfilUsuario(String bienvenidoPerfil) throws InterruptedException {
        demoBlazePage.ValidarPerfil(bienvenidoPerfil);
    }

    @Step
    public void clicLaptops() throws InterruptedException {
        demoBlazePage.darClicLaptop();
    }

    @Step
    public void SeleccionLaptop() throws InterruptedException {
        demoBlazePage.SeleccionMac();
    }

    @Step
    public void AgregarCarrito() throws InterruptedException {
        demoBlazePage.ClicBtnAgregarCarrito();
    }

    @Step
    public void ValidarProductoCarrito() throws InterruptedException {
        demoBlazePage.validarProductoEnCarrito();
    }


}
