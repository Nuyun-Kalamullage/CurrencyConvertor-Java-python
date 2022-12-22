Run this to build the client stub change the jdk path to your machine appropriately

>"C:\Users\HP\.jdks\corretto-1.8.0_352\bin\wsimport.exe" -keep -d ..\CurrencyConvertorClient\src\main\java\Stub -p edu.sltc.sa.client.stub http://localhost:8888/SoapWebService?wsdl

when adding to system path you can use like below:
>wsimport.exe -keep -d ..\CurrencyConvertorClient\src\main\java\Stub -p stub http://localhost:8888/SoapWebService?wsdl
