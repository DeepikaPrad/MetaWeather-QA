The below test cases have been written using RestAssured :
1. Verify that for valid city passed, application is reachable
2. Verify that for invalid city code passed, application does not crash but is still reachable
3. Verify JSON body when valid city is passed

While WireMock was being considered to mock the server requests and responses, using the below code snippet