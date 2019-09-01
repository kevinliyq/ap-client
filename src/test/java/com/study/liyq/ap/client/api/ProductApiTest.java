package com.study.liyq.ap.client.api;

import com.study.liyq.ap.client.ApiClient;
import com.study.liyq.ap.client.ApiException;
import com.study.liyq.ap.client.model.Partner;
import com.study.liyq.ap.client.model.ProductRequest;
import com.study.liyq.ap.client.model.ProductResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Need to start ap-service-start firstly
 */
public class ProductApiTest {

    private ProductApi api;

    private ApiClient apiClient;

    @Before
    public void setUp() throws Exception
    {
        apiClient = new ApiClient();
        apiClient.setBasePath("http://localhost:8080/");
        api = new ProductApi(apiClient);
    }

    @After
    public void tearDown() throws Exception
    {
        api = null;
    }

    @Test
    public void createProductTest() throws ApiException {
        ProductRequest product = new ProductRequest()
                .productId(1)
                .productName("forbidenCity")
                .partner(Partner.CTRIP)
                .price(40.0)
                .addCancellationPoliciesItem("100% within 2 days")
                ;

        ProductResponse response = api.createProduct(product);
        Assert.assertNotNull(response);
        Assert.assertEquals("forbidenCity", response.getData().getProductName());


    }

    @Test
    public void getProductTest() throws ApiException {
        ProductResponse getResponse = api.getProduct(1);
        Assert.assertNotNull(getResponse);
        Assert.assertEquals(Partner.CTRIP, getResponse.getData().getPartner());

    }
    
}
