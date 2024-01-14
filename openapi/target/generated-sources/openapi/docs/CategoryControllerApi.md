# CategoryControllerApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addCategory**](CategoryControllerApi.md#addCategory) | **POST** /category/ | Add a new category |
| [**deleteCategory**](CategoryControllerApi.md#deleteCategory) | **DELETE** /category/{id} | Delete a category by ID |
| [**getAllCategories**](CategoryControllerApi.md#getAllCategories) | **GET** /category/all | Get all categories |
| [**getCategory**](CategoryControllerApi.md#getCategory) | **GET** /category/{id} | Get a category by ID |


<a id="addCategory"></a>
# **addCategory**
> Category addCategory(category)

Add a new category

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CategoryControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    CategoryControllerApi apiInstance = new CategoryControllerApi(defaultClient);
    Category category = new Category(); // Category | 
    try {
      Category result = apiInstance.addCategory(category);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CategoryControllerApi#addCategory");
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
| **category** | [**Category**](Category.md)|  | |

### Return type

[**Category**](Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="deleteCategory"></a>
# **deleteCategory**
> String deleteCategory(id)

Delete a category by ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CategoryControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    CategoryControllerApi apiInstance = new CategoryControllerApi(defaultClient);
    Integer id = 56; // Integer | ID of the category to delete
    try {
      String result = apiInstance.deleteCategory(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CategoryControllerApi#deleteCategory");
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
| **id** | **Integer**| ID of the category to delete | |

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

<a id="getAllCategories"></a>
# **getAllCategories**
> Set&lt;Category&gt; getAllCategories()

Get all categories

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CategoryControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    CategoryControllerApi apiInstance = new CategoryControllerApi(defaultClient);
    try {
      Set<Category> result = apiInstance.getAllCategories();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CategoryControllerApi#getAllCategories");
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

[**Set&lt;Category&gt;**](Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="getCategory"></a>
# **getCategory**
> Category getCategory(id)

Get a category by ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CategoryControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    CategoryControllerApi apiInstance = new CategoryControllerApi(defaultClient);
    Integer id = 56; // Integer | ID of the category to retrieve
    try {
      Category result = apiInstance.getCategory(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CategoryControllerApi#getCategory");
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
| **id** | **Integer**| ID of the category to retrieve | |

### Return type

[**Category**](Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

