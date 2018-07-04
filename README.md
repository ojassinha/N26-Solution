# N26-Solution
This is the solution for N26 Backend Challenge

# Build Process :
Import this Maven project into any IDE example STS/Eclipse.<br />
Run as Maven Install to install all the dependencies.<br />

# EndPoints 

### Base Url : http://localhost:9180 <br /> ###


*POST : "/transactions"<br />
Accepts : Json<br />
Example :<br />
{<br/>
      "timestamp" : 1530703865,<br />
      "amount" : 20.0<br />
}

Response :<br />
201 - Created<br />
If the addition of data is successful<br />
204 - No Content<br />
If the date belongs to time > 60 seconds<br />
<br />


* GET : "/statistics"<br />
Accetps : N/A<br />

Response : 200 <br/> 

{<br/>
  "sum": 0,<br/>
  "avg": 0,<br/>
  "min": "Infinity",<br/>
  "max": "-Infinity",<br/>
  "count": 0<br/>
}<br/>

### Included Functionalities ###

* Code with full functionality.
* 3 test cases are written for now.
* Added comment wherever necessary.
* Use of Java 8 version Stream API for statistics calculation.

### Improvments Area : ###

* More test cases can be included for better efficiency.
* O(1) can be done for statistics service if allowed the uses of scheduler which will further degrade the API performance.
* If given more time, we can create an improved Prediction for Stream Collection and maybe create Custom Collectors.





