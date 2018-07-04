# N26-Solution
This is the solution for N26 Backend Challenge

# EndPoints 

## Base Url : http://localhost:9180 <br />

<br />
POST : "/transactions"<br />
Accepts : Json<br />
Example :<br />
```{
      "timestamp" : 1530703865,<br />
      "amount" : 20.0<br />
   }```

Response :<br />
201 - Created<br />
If the addition of data is successful<br />
204 - No Content<br />
If the date belongs to time > 60 seconds<br />
<br />
<br />
<br />

GET : "/statistics"<br />
Accetps : N/A<br />






# Build Process :
Import this Maven project into any IDE example STS/Eclipse.<br />
Run as Maven Install to install all the dependencies.<br />



