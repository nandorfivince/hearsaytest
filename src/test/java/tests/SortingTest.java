package tests;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import org.json.JSONException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Messages;
import utils.RequestSpecificationHelper;

import java.io.IOException;

import static io.restassured.http.ContentType.JSON;
import static io.restassured.http.Method.POST;
import static utils.Config.getListUrl;
import static utils.Messages.*;
import static utils.TestDataProvider.*;

public class SortingTest {

    private RequestSpecificationHelper requestSpecificationHelper = new RequestSpecificationHelper();

    @DataProvider(name = "testData")
    public static Object[][] testDataTable() {
        return new Object[][]{
                {TC001, POST, JSON, getListUrl(), EXAMPLE_REQUEST_JSON, 200, null, null, null},
                {TC002, POST, JSON, getListUrl(), EXAMPLE_REQUEST_JSON, 200, EXAMPLE_RESPONSE_JSON, null, null},
                {TC003, POST, JSON, getListUrl(), EXAMPLE_REQUEST_JSON, 201, null, null, null},
                {TC004, POST, JSON, getListUrl(), EXAMPLE_REQUEST_JSON, 200, EXAMPLE_RESPONSE_JSON, "fruits", "[\"apple\",\"pineapple\",\"watermelon\"]"},
                {TC005, POST, JSON, getListUrl(), EXAMPLE_REQUEST_JSON, 200, EXAMPLE_RESPONSE_JSON, "fruits", "apple"},
                {TC006, POST, JSON, getListUrl(), EXAMPLE_REQUEST_JSON, 200, EXAMPLE_RESPONSE_JSON, "fruits", "pineapple"},
                {TC007, POST, JSON, getListUrl(), EXAMPLE_REQUEST_JSON, 200, EXAMPLE_RESPONSE_JSON, "fruits", "watermelon"},
                {TC008, POST, JSON, getListUrl(), EXAMPLE_REQUEST_JSON, 200, EXAMPLE_RESPONSE_JSON, "numbers", "[4,7,1333,2431]"},
                {TC009, POST, JSON, getListUrl(), EXAMPLE_REQUEST_JSON, 200, EXAMPLE_RESPONSE_JSON, "numbers", "4"},
                {TC010, POST, JSON, getListUrl(), EXAMPLE_REQUEST_JSON, 200, EXAMPLE_RESPONSE_JSON, "numbers", "7"},
                {TC011, POST, JSON, getListUrl(), EXAMPLE_REQUEST_JSON, 200, EXAMPLE_RESPONSE_JSON, "numbers", "1333"},
                {TC012, POST, JSON, getListUrl(), EXAMPLE_REQUEST_JSON, 200, EXAMPLE_RESPONSE_JSON, "numbers", "2431"},
                {TC013, POST, JSON, getListUrl(), EXAMPLE_REQUEST_JSON, 200, EXAMPLE_RESPONSE_JSON, "colors", "[\"green\",\"blue\",\"yellow\"]"},
                {TC014, POST, JSON, getListUrl(), EXAMPLE_REQUEST_JSON, 200, EXAMPLE_RESPONSE_JSON, "colors", "green"},
                {TC015, POST, JSON, getListUrl(), EXAMPLE_REQUEST_JSON, 200, EXAMPLE_RESPONSE_JSON, "colors", "blue"},
                {TC016, POST, JSON, getListUrl(), EXAMPLE_REQUEST_JSON, 200, EXAMPLE_RESPONSE_JSON, "colors", "yellow"},
                {TC017, POST, JSON, getListUrl(), null, 422, null, null, null},
                {TC018, POST, JSON, getListUrl(), BAD_SYNTAX_IN_THE_JSON, 422, null, "type", "value_error.jsondecode"},
                {TC019, POST, JSON, getListUrl(), CHECK_SECURITY_EXE, 422, null, "doc", DO_NOT_BE_AFRAID.toString()},
                {TC020, POST, JSON, getListUrl(), EMPTY_JSON, 422, null, "type", "value_error.missing"},
                {TC021, POST, JSON, getListUrl(), EMPTY_VALUE_AT_SORT_KEYS_JSON, 422, null, null, null},
                {TC022, POST, JSON, getListUrl(), EMPTY_VALUE_AT_FRUIT_KEYS_JSON, 200, null, "fruits", ""},
                {TC023, POST, JSON, getListUrl(), NUMBER_INSTEAD_OF_STRING_JSON, 422, null, null, null},
                {TC024, POST, JSON, getListUrl(), STRING_INSTEAD_OF_NUMBER_JSON, 422, null, null, null}
        };
    }

    @Test(dataProvider = "testData")
    public void testCaseExecutor(Messages testCaseID, Method requestMethod, ContentType contentType,
                                 String endpointPath, String requestBodyResourceName,
                                 int responseStatusCode, String responseBodyJsonResourceName,
                                 String jsonKey, String hasItems) throws IOException, JSONException, InterruptedException {
        requestSpecificationHelper.buildHttpRequest(
                testCaseID, requestMethod, contentType, endpointPath, requestBodyResourceName,
                responseStatusCode, responseBodyJsonResourceName, jsonKey, hasItems);
    }

}
