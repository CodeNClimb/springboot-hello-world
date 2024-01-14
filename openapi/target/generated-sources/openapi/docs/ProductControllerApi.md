# ProductControllerApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addProduct**](ProductControllerApi.md#addProduct) | **POST** /product/add |  |
| [**deleteProduct**](ProductControllerApi.md#deleteProduct) | **DELETE** /product/{id} |  |
| [**getAllProducts**](ProductControllerApi.md#getAllProducts) | **GET** /product/all |  |
| [**getAllReviews**](ProductControllerApi.md#getAllReviews) | **GET** /product/{productId}/reviews/all |  |
| [**getProduct**](ProductControllerApi.md#getProduct) | **GET** /product/{id} |  |
| [**reviewProduct**](ProductControllerApi.md#reviewProduct) | **POST** /product/{productId}/{username}/review |  |


<a id="addProduct"></a>
# **addProduct**
> Product addProduct(product)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ProductControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ProductControllerApi apiInstance = new ProductControllerApi(defaultClient);
    Product product = new Product(); // Product | 
    try {
      Product result = apiInstance.addProduct(product);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductControllerApi#addProduct");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **product** | [**Product**](Product.md)|  | |

### Return type

[**Product**](Product.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="deleteProduct"></a>
# **deleteProduct**
> String deleteProduct(id)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ProductControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ProductControllerApi apiInstance = new ProductControllerApi(defaultClient);
    Integer id = 56; // Integer | 
    try {
      String result = apiInstance.deleteProduct(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductControllerApi#deleteProduct");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**|  | |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="getAllProducts"></a>
# **getAllProducts**
> List&lt;Product&gt; getAllProducts()



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ProductControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ProductControllerApi apiInstance = new ProductControllerApi(defaultClient);
    try {
      List<Product> result = apiInstance.getAllProducts();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductControllerApi#getAllProducts");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Product&gt;**](Product.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="getAllReviews"></a>
# **getAllReviews**
> List&lt;ReviewDTO&gt; getAllReviews(productId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ProductControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ProductControllerApi apiInstance = new ProductControllerApi(defaultClient);
    Integer productId = 56; // Integer | 
    try {
      List<ReviewDTO> result = apiInstance.getAllReviews(productId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductControllerApi#getAllReviews");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **productId** | **Integer**|  | |

### Return type

[**List&lt;ReviewDTO&gt;**](ReviewDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="getProduct"></a>
# **getProduct**
> Product getProduct(id)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ProductControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ProductControllerApi apiInstance = new ProductControllerApi(defaultClient);
    Integer id = 56; // Integer | 
    try {
      Product result = apiInstance.getProduct(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductControllerApi#getProduct");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**|  | |

### Return type

[**Product**](Product.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="reviewProduct"></a>
# **reviewProduct**
> ReviewDTO reviewProduct(productId, username, review)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ProductControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ProductControllerApi apiInstance = new ProductControllerApi(defaultClient);
    Integer productId = 56; // Integer | 
    String username = "username_example"; // String | 
    Review review = new Review(); // Review | 
    try {
      ReviewDTO result = apiInstance.reviewProduct(productId, username, review);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductControllerApi#reviewProduct");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **productId** | **Integer**|  | |
| **username** | **String**|  | |
| **review** | [**Review**](Review.md)|  | |

### Return type

[**ReviewDTO**](ReviewDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

