package com.bdd.utils;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;
import com.jayway.jsonpath.spi.json.JsonOrgJsonProvider;
import com.jayway.jsonpath.spi.mapper.JsonOrgMappingProvider;
import cucumber.api.DataTable;

import java.util.List;
import java.util.Map;

public class helpers {
    public static final String DIR_REQUEST_JSON = System.getProperty("user.dir") + "/src/test/resources/request/json/";

    public static String getValueFromDataTable(DataTable dataTable, String key){
        List<Map<String, String>> item = dataTable.asMaps(String.class, String.class);
        return (String)((Map)item.get(0)).get(key);
    }

    public static String updateValueOfNodeInJson(String jsonString, String keyPath, String value) {
        Configuration configuration = Configuration.builder().jsonProvider(new JsonOrgJsonProvider()).mappingProvider(new JsonOrgMappingProvider()).build();

        return JsonPath.using(configuration).parse(jsonString).set("$." + keyPath, value, new Predicate[0]).jsonString();
    }
}
