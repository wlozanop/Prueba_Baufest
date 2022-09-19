package com.bdd.page;

import com.bdd.path.pathDemoBlaze;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://www.demoblaze.com/index.html")
public class DemoBlazePage extends PageObject {


    pathDemoBlaze PathDemoBlaze = new pathDemoBlaze();

    public void darAltaUsuario(String user,String clave) throws InterruptedException {
        WebElement clickSignUp = getDriver().findElement(By.xpath(PathDemoBlaze.btnSignUp));
        clickSignUp.click();
        Thread.sleep(2000);
        System.out.println("Ingresar Correo");
        WebElement IngresarCorreo = getDriver().findElement(By.xpath(PathDemoBlaze.ingresarCorreoUser));
        IngresarCorreo.click();
        IngresarCorreo.sendKeys(user);
        Thread.sleep(2000);
        System.out.println("Ingresar Clave");
        WebElement IngresarClave = getDriver().findElement(By.xpath(PathDemoBlaze.IngresarClave));
        IngresarClave.click();
        IngresarClave.sendKeys(clave);
        Thread.sleep(2000);
        System.out.println("Clic en registrar");
        WebElement clickRegistrar = getDriver().findElement(By.xpath(PathDemoBlaze.btnRegistrar));
        clickRegistrar.click();
        Thread.sleep(2000);
    }

    public void clicLogin() throws InterruptedException {
        WebElement clickLogIn = getDriver().findElement(By.xpath(PathDemoBlaze.btnLogin));
        clickLogIn.click();
        Thread.sleep(2000);
    }

    public void IngresarUsuarioClave(String sUsuario, String sClave) throws InterruptedException {
        System.out.println("Ingresamos a Login");
        WebElement IngresarUsuario = getDriver().findElement(By.xpath(PathDemoBlaze.ingresarCorreoLogin));
        IngresarUsuario.click();
        IngresarUsuario.sendKeys(sUsuario);
        Thread.sleep(1000);
        WebElement IngresarClave = getDriver().findElement(By.xpath(PathDemoBlaze.ingresarPassLogin));
        IngresarClave.click();
        IngresarClave.sendKeys(sClave);
        Thread.sleep(1000);
        WebElement DarClicLog_In = getDriver().findElement(By.xpath(PathDemoBlaze.btnLog_In));
        DarClicLog_In.click();
        Thread.sleep(2000);
    }

    public void ValidarPerfil(String bienvenidoPerfil) throws InterruptedException {
        System.out.println("Ingresamos a Login");
        WebElement validarPerfil = getDriver().findElement(By.xpath(PathDemoBlaze.validarPerfil));
        if(bienvenidoPerfil.equals(getTextFrontElement(validarPerfil))){
            System.out.println("Ingreso al perfil correcto");
        }else System.out.println("No ingreso al perfil");
        Thread.sleep(1000);
    }

    private String getTextFrontElement(WebElement element) {
        return element.getText();
    }

    public void darClicLaptop() throws InterruptedException {
        WebElement clickLaptop= getDriver().findElement(By.xpath(PathDemoBlaze.darClicLaptops));
        clickLaptop.click();
        Thread.sleep(2000);
    }

    public void SeleccionMac() throws InterruptedException {
        WebElement SeleccionarMac= getDriver().findElement(By.xpath(PathDemoBlaze.seleccionarMac));
        SeleccionarMac.click();
        Thread.sleep(2000);
    }

    public void ClicBtnAgregarCarrito() throws InterruptedException {
        WebElement AgregarAlCarrito= getDriver().findElement(By.xpath(PathDemoBlaze.btnClicAgregarACarrito));
        AgregarAlCarrito.click();
        Thread.sleep(2000);
    }

    public void validarProductoEnCarrito() throws InterruptedException {
        Thread.sleep(3000);
        WebElement darClicCart= getDriver().findElement(By.xpath(PathDemoBlaze.btnCart));
        darClicCart.click();
        Thread.sleep(1000);
        WebElement ValidarProducto= getDriver().findElement(By.xpath(PathDemoBlaze.validarProductoAgregado));
        ValidarProducto.isEnabled();
        Thread.sleep(2000);
    }

}
