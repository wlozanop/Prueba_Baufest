package com.bdd.Api.StepDefinition;

import com.bdd.Api.Step.apiStep;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class apiStepDefinition {

    private Scenario scenario;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Steps
    private apiStep ApiStep;

    @Dado("^que configuro las cabeceras$")
    public void que_configuro_las_cabeceras(DataTable dataTable) throws Exception {
        ApiStep.configuracionCabeceras(dataTable);
    }

    @Dado("^que configuro el body del servicio: \"([^\"]*)\"$")
    public void que_configuro_el_body_del_servicio(String servicio, DataTable dataTable) throws Exception {
        ApiStep.configuroBodyServicio(servicio,dataTable);
    }

    @Cuando("^ejecuto el api$")
    public void ejecuto_el_api(DataTable dataTable) throws Exception {
        ApiStep.ejecutamosApi(dataTable);
    }


    @Entonces("^valido que el codigo de respuesta sea \"([^\"]*)\"$")
    public void valido_que_el_codigo_de_respuesta_sea(String codigo) {
        Assert.assertTrue("codigo de respuesta Incorrecto.", ApiStep.validarCodigo(Integer.parseInt(codigo)));
    }

    @Entonces("^valido los siguientes resultados en el json de respuesta$")
    public void valido_los_siguientes_resultados_en_el_json_de_respuesta(DataTable dataTable) throws Exception {
        ApiStep.validarRespuestaBody(dataTable);
    }

}
