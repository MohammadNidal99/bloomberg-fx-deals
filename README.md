# Bloomberg-FX-Deals

## Spring boot service to store Exchange deals to Database

## Technologies Used in Service
	1- Spring boot
	2- JUnit
	3- MySQL
	
	
## Structure
	1- There is Controller called SubmitDataController it has an endpoint that accept request as JSON.
	2- The RequestValidator is used to validate the request before send the request to DealsService.
	3- DealsService used for saving the request to Database after it is validated.
	
## Validations
	1- Validate if this request was sent before 
	2- Validate if there is data in fields
	3- Validate contents if it is Matched with standards
	4 - Validate Currency code if Matched with ISO 4217 Codes

## Test Methods As Unit Test using JUnit 

## Request Structure

	{
    "fromCurrencyISO": "any Currency code that matches with ISO 4217",
    "toCurrencyISO": "any Currency code that matches with ISO 4217",
    "dealTimeStamp": "Follow this format: yyyy-MM-dd HH:mm:ss",
    "dealAmount": "any Double value greater than or equal to zero"
	}
	
## Request Example:

	{
    "fromCurrencyISO": "USD",
    "toCurrencyISO": "JOD",
    "dealTimeStamp": "2022-01-30 00:00:00",
    "dealAmount": "22.0"
	}
	



