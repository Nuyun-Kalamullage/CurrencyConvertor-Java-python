Run this to build the client stub
change the jdk path to your machine appropriately

"C:\Program Files\Java\jdk1.8.0_201\bin\wsimport.exe" -keep -d ..\DemoWebServiceClient\Stub -p com.sltc.soa.client.stub http://localhost:8888/DemoWebService?wsdl
wsimport.exe -keep -d ..\DemoWebServiceClient\src\com\sltc\soa\client -p stub http://localhost:8888/DemoWebService?wsdl



wsimport.exe -keep -d D:\IdeaProjects\CurenncyConvertorClient\Stub -p edu.sltc.curenncyconvertorclient.stub http://localhost:8888/DemoWebService?wsdl
wsimport.exe -keep -d D:\IdeaProjects\CurenncyConvertorClient\src\main\java\Stub -p stub http://localhost:8888/DemoWebService?wsdl
