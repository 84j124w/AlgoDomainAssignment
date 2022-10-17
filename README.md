# AlgoDomainAssignment

#Database MySQL
Required Tools
1) IntelliJIDEA Community latest
2) MySQL Workbench 8.0
3) JAVA 17

#Create Database algodomain

#Change below properties in 'application.properites' file
spring.datasource.username = your_db_username
spring.datasource.password = your_db_pass


1) Download the project
2) Extract the Project in Directory
3) Open the Project in IntelliJIDEA
4) 'ProductApiApplication' is the Starting point of aaplication so you can click on run button or goto 'ProductApiApplication' class
and run the application.
5) Do check in Run tab below in IntelliJIDEA it will show the logs!
7) and start testing in Postman


Open postman and perform CRUD using below URLs

1) For adding product
Method: POST
URL: http://localhost:8080/addProduct
Request Body for Product Data (raw and select json)

{
    "productID": 1003,
    "productName": "HP Pavilion 360",
    "productType": "Laptop",
    "productCategory": "Electronics",
    "productPrice": 60000
}
==========================================================================


2) For updating product
Method: PUT
URL: http://localhost:8080/updateProduct
Add Request Body Product Data (raw and select json)

{
    "productID": 1003,
    "productName": "HP Pavilion 360",
    "productType": "Laptop",
    "productCategory": "Electronics",
    "productPrice": 60000
}
==========================================================================


3) For getting list of all products
Method: GET
URL: http://localhost:8080/getProducts
==========================================================================


4) For getting one single Product
Method: GET
URL: http://localhost:8080/getProduct/product_id
eg: http://localhost:8080/getProduct/1006
=========================================================================


5) For Deleting Product
Method: DELETE
URL: http://localhost:8080/deleteProduct/product_id
eg: http://localhost:8080/deleteProduct/1006
===========================================================================
========================================================================

Links for Discount Taxes and Charges Entity

1) For adding DTC
Method: POST
URL: http://localhost:8080/addDTC
Request Body for DTC (raw and select json)

{
    "discount": 50.0,
    "gst": 330.0,
    "deliveryCharges": 800.0,
    "productCategory": "Home Appliances"
}
===================================================================================

2) For Updating DTC
Method: PUT
URL: http://localhost:8080/updateDTC
Request Body for DTC (raw and select json)

{
    "dtcid": 1,
    "discount": 50.0,
    "gst": 330.0,
    "deliveryCharges": 800.0,
    "productCategory": "Home Appliances"
}
===============================================================================

3) For Getting list of DTCs
Method: GET
URL: http://localhost:8080/getDTCs
==============================================================================

4) For Getting single DTC Object
Method: GET
URL: http://localhost:8080/getDTC/dtc_id
eg: http://localhost:8080/getDTC/2
==============================================================================

5) For Deleting DTC
Method: DELETE
URL: http://localhost:8080/deleteDTC/dtc_id
eg: http://localhost:8080/deleteDTC/2

