package com.bdd.path;

public class pathDemoBlaze {

    public String btnSignUp = "//a[@id='signin2']";
    public String validarPerfilUsuario = "//a[@id='nameofuser' and text()='Welcome User Prueba']";
    public String ingresarCorreoUser = "//input[@id='sign-username']";
    public String IngresarClave = "//input[@id='sign-password']";
    public String btnRegistrar = "//button[@onclick='register()']";

    //Login a la cuenta del Usuario
    public String btnLogin = "//a[@id='login2']";
    public String ingresarCorreoLogin = "//input[@id='loginusername']";
    public String ingresarPassLogin = "//input[@id='loginpassword']";
    public String btnLog_In = "//button[@onclick='logIn()']";

    public String validarPerfil = "//a[@id='nameofuser']";

    public String darClicLaptops = "//a[@id='itemc' and text()='Laptops']";
    public String seleccionarMac = "//a[@class='hrefch' and text()='MacBook air']";
    public String btnClicAgregarACarrito = "//a[@onclick='addToCart(11)']";

    public String btnCart = "//a[@id='cartur']";
    public String validarProductoAgregado = "//tbody[@id='tbodyid']/tr";

}
