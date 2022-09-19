package com.bdd.Api.Step;

import com.bdd.utils.helpers;
//import com.jayway.jsonpath.JsonPath;
import cucumber.api.DataTable;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.util.*;
import org.json.JSONObject;

public class apiStep {

    private Headers $headers;
    private String $bodyRequest;
    private Response $response;

    public static Object getValueNodeResponseJson(String nodo, Response response) {
        return JsonPath.with(response.getBody().asString()).get(nodo);
    }

    @Step("Configurando las cabeceras")
    public void configuracionCabeceras(DataTable dataTable) {
        List<Header> headerList = new LinkedList();
        List<Map<String, String>> listCabeceras = dataTable.asMaps(String.class, String.class);
        Iterator items = listCabeceras.iterator();

        while (items.hasNext()) {
            Map<String, String> itemRow = (Map) items.next();
            Header header = new Header((String) itemRow.get("cabeceras"), (String) itemRow.get("valor"));
            headerList.add(header);
        }

        this.$headers = new Headers(headerList);
    }

    @Step("Configurando body del servicio")
    public void configuroBodyServicio(String servicio, DataTable dataTable) {
        String pathService =  helpers.DIR_REQUEST_JSON + servicio + ".json";

        File file = new File(pathService);
        String bodyRequest = "";

        try {
            String content = FileUtils.readFileToString(file, "utf-8");
            JSONObject jsonObject = new JSONObject(content);
            bodyRequest = jsonObject.toString();
            List<Map<String, String>> listBodyRequest = dataTable.asMaps(String.class, String.class);

            String newJson;
            for(Iterator item = listBodyRequest.iterator(); item.hasNext(); bodyRequest = newJson) {
                Map<String, String> stringMap = (Map)item.next();
                newJson = helpers.updateValueOfNodeInJson(bodyRequest,
                        (String)stringMap.get("key"),
                        ((String)stringMap.get("valor")));
            }
            this.$bodyRequest = bodyRequest;

        } catch (IOException err1) {
            System.out.printf("Error:", err1);
        }
    }


    @Step("Ejecutando el Servicio")
    public void ejecutamosApi(DataTable dataTable) {
        String dominio = helpers.getValueFromDataTable(dataTable, "dominio");
        String urlbase = helpers.getValueFromDataTable(dataTable, "urlbase");
        String metodo = helpers.getValueFromDataTable(dataTable, "metodo").toUpperCase();

        if ($headers == null) {
            $headers = new Headers();
        }
        RequestSpecification requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON).build();

        if (metodo.equals("GET")){
            $response = given()
                    .spec(requestSpecification)
                    .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                    .headers($headers)
                    .baseUri(dominio)
                    .basePath("/v2")
                    .get(urlbase)
                    .then()
                    .extract()
                    .response();
        }else if (metodo.equals("POST") || metodo.equals("PUT")){
            $response = given()
                    .spec(requestSpecification)
                    .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                    .headers($headers)
                    .baseUri(dominio)
                    .basePath("/v2")
                    .body($bodyRequest)
                    .post(urlbase)
                    .then()
                    .extract()
                    .response();
        }
    }

    @Step("Validando que el codigo de respuesta sea el adecuado")
    public boolean validarCodigo(int codigoRespuesta) {
        return $response.getStatusCode() == codigoRespuesta;
    }

    @Step("Valido que la respuesta del body sea el adecuado")
    public void validarRespuestaBody(DataTable dataTable) throws IOException {

        List<Map<String, String>> listValues = dataTable.asMaps(String.class, String.class);
        Map<String, Object> items = new HashMap();
        Iterator var4 = listValues.iterator();

        while (var4.hasNext()) {
            Map<String, String> stringMap = (Map) var4.next();

            String nodo = stringMap.get("nodo");
            String valor = stringMap.get("valor");
            String valueDato = String.valueOf(this.getValueNodeResponseJson(nodo, $response)).trim();

            Assert.assertThat(valueDato, CoreMatchers.containsString(valor));
        }

    }


}
