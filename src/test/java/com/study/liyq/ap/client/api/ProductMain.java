package com.study.liyq.ap.client.api;

import com.study.liyq.ap.client.ApiClient;
import com.study.liyq.ap.client.ApiException;
import com.study.liyq.ap.client.model.Partner;
import com.study.liyq.ap.client.model.Product;
import com.study.liyq.ap.client.model.ProductRequest;

public class ProductMain {

    public static void main(String[] args)
    {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath("http://localhost:8080/");

        ProductApi productApi = new ProductApi(apiClient);

        ProductRequest product = new ProductRequest()
                .productId(1)
                .productName("forbidenCity")
                .partner(Partner.CTRIP)
                .price(40.0)
                .addCancellationPoliciesItem("100% within 2 days")
                ;
        try {
            System.out.println(productApi.createProduct(product));
        } catch (ApiException e) {
            e.printStackTrace();
        }

    }
}
