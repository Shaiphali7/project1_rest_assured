package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductsExtractionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);

    }
    @Test
    public void test021()
    {
        int limit = response.extract().path("limit");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");

    }
//    21. Extract the limit

//22. Extract the total

    @Test
    public void test002() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of total is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }
//23. Extract the name of 5th product
@Test
public void test003() {
    String productName = response.extract().path("data[4].name");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The name of 5th product is : " + productName);
    System.out.println("------------------End of Test---------------------------");
}
//24. Extract the names of all the products
@Test
public void test004() {
    List<String> productName = response.extract().path("data.name");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The list of all the products are : " + productName);
    System.out.println("------------------End of Test---------------------------");
}
//25. Extract the productId of all the products
@Test
public void test005() {
    List<Integer> productId = response.extract().path("data.id");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The list of all the products Id are : " + productId);
    System.out.println("------------------End of Test---------------------------");
}
//26. Print the size of the data list
@Test
public void test006() {
    List<Integer> productId = response.extract().path("data.id");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The size of data list is : " + productId.size());
    System.out.println("------------------End of Test---------------------------");
}
//27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-
//                                                                                        Pack)
@Test
public void test007() {
    List<HashMap<String,?>> values = response.extract().path("data.findAll{it.name=='Energizer - MAX Batteries AA (4-Pack)'}");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("All values for product name are : " + values);
    System.out.println("------------------End of Test---------------------------");
}
//28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-
//
@Test
public void test008() {
   List<String>  modelName=response.extract().path("data.findAll{it.name=='Energizer - N Cell E90 Batteries (2-Pack)'}.model");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The model name is : " + modelName);
    System.out.println("------------------End of Test---------------------------");
}
//29. Get all the categories of 8th products
    @Test
    public void test009()
    {
        List<HashMap<String,?>> categories=response.extract().path("data[7].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All the categories are : " + categories);
        System.out.println("------------------End of Test---------------------------");
    }
//30. Get categories of the store where product id = 150115
@Test
public void test010()
{
    List<HashMap<String,?>> categories=response.extract().path("data.findAll{it.id==150115}.categories");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("All the categories are : " + categories);
    System.out.println("------------------End of Test---------------------------");
}
//31. Get all the descriptions of all the products
@Test
public void test011()
{
    List<String> description=response.extract().path("data.description");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("All the description are : " + description);
    System.out.println("------------------End of Test---------------------------");
}
//32. Get id of all the all categories of all the products
@Test
public void test0012() {
    List<Integer> categoriesId = response.extract().path("data.categories.id");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The list of all the categories Id are : " + categoriesId);
    System.out.println("------------------End of Test---------------------------");
}

//33. Find the product names Where type = HardGood
    @Test
    public void test013()
    {
        List<String> productName=response.extract().path("data.findAll{it.type=='HardGood'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The product name is : " + productName);
        System.out.println("------------------End of Test---------------------------");
    }
//34. Find the Total number of categories for the product where product name = Duracell - AA
//1.5V CopperTop Batteries (4-Pack)
@Test
public void test014()
{
    List<HashMap<String,?>> category=response.extract().path("data.findAll{it.name=='Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The number of categories are  : " + category.size());
    System.out.println("------------------End of Test---------------------------");
}
//35. Find the createdAt for all products whose price < 5.49
@Test
public void test015()
{
    List<String> createdAt=response.extract().path("data.findAll{it.price < 5.49 }.categories.createdAt");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The createdAt for all products are  : " + createdAt);
    System.out.println("------------------End of Test---------------------------");
}
//            36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-
//                                                                                              Pack)”
@Test
public void test016()
{
    List<String> categoryName=response.extract().path("data.findAll{it.name=='Energizer - MAX Batteries AA (4-Pack)'}.categories.name");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The createdAt for all products are  : " + categoryName);
    System.out.println("------------------End of Test---------------------------");
}
    //            37. Find the manufacturer of all the products
    @Test
    public void test0017() {
        List<String>  manufacturerName=response.extract().path("data.manufacturer");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The manufacturer name are : " + manufacturerName);
        System.out.println("------------------End of Test---------------------------");
    }

//38. Find the imge of products whose manufacturer is = Energizer
@Test
public void test019()
{
    List<String> image=response.extract().path("data.findAll{it.manufacturer== 'Energizer'}.image");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The image for  products are  : " + image);
    System.out.println("------------------End of Test---------------------------");
}

//39. Find the createdAt for all categories products whose price > 5.99
@Test
public void test020()
{
    List<String> createdAt=response.extract().path("data.findAll{it.price > 5.99 }.categories.createdAt");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The createdAt for all products are  : " + createdAt);
    System.out.println("------------------End of Test---------------------------");
}
//            40. Find the uri of all the product
@Test
public void test0021() {
    List<String>  urlName=response.extract().path("data.url");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The URL are : " + urlName);
    System.out.println("------------------End of Test---------------------------");
}
}
