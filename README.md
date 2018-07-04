# N26-Solution
This is the solution for N26 Backend Challenge

# EndPoints

POST : "/transactions"
Accepts : Json
Example :
{
  "timestamp" : 1530703865,
  "amount" : 20.0
}

Response :
201 - Created
If the addition of data is successful
204 - No Content
If the date belongs to time > 60 seconds

Build Process :
Import this Maven project into any IDE example STS/Eclipse.
Run as Maven Install to install all the dependencies.



