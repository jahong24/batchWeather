# batchWeather
Given a text file of cities, read file line by line and call OpenWeatherMap API to get current weather 

Sample Request File:

New York  
Boston  
Houston  
Miami  
Chicago  
Los Angeles  

Sample Response File:

{
  "city" : "New York",  
  "description" : "overcast clouds",  
  "current" : 46,  
  "high" : 47,  
  "low" : 45  
}{  
  "city" : "Boston",  
  "description" : "few clouds",  
  "current" : 41,  
  "high" : 44,  
  "low" : 35  
}{  
  "city" : "Houston",  
  "description" : "clear sky",  
  "current" : 61,  
  "high" : 63,  
  "low" : 60  
}{  
  "city" : "Miami",  
  "description" : "broken clouds",  
  "current" : 69,  
  "high" : 70,  
  "low" : 68  
}{  
  "city" : "Chicago",  
  "description" : "broken clouds",  
  "current" : 6,  
  "high" : 11,  
  "low" : 2  
}{  
  "city" : "Los Angeles",  
  "description" : "clear sky",  
  "current" : 67,  
  "high" : 70,  
  "low" : 63  
}
