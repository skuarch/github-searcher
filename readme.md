
start application

**mvn spring-boot:run**

how to get information about users?
with postman or another http client send a post request (application/json) to **http://localhost:8080/github/search**
the body of the message should be something like this :


[
  
  {
    "firstName": "Chunky",
    "lastName":  "Garg",
    "location":  "Gurgaon"
  },
  {
    "firstName": "Sharvi",
    "lastName":  "Verma",
    "location":  "India"
  },
  {
    "firstName": "Rahul",
    "lastName":  "Gaur",
    "location":  "India"
  },
  {
    "firstName": "Abhishek",
    "lastName":  "Parikh",
    "location":  ""
  },
  {
    "firstName": "Anubhav",
    "lastName":  "Saxena",
    "location":  ""
  },
  {
    "firstName": "Shiva",
    "lastName":  "Tiwari",
    "location":  "Bangalore"
  },
  {
    "firstName": "Sumit",
    "lastName":  "Yadav",
    "location":  "New Delhi"
  },
  {
    "firstName": "Varun",
    "lastName":  "Arora",
    "location":  "India"
  },
  {
    "firstName": "Anshika",
    "lastName":  "Singh",
    "location":  "India"
  },
  {
    "firstName": "Salman",
    "lastName":  "Kagzi",
    "location":  ""
  },
  {
    "firstName": "James",
    "lastName":  "Golick",
    "location":  "New York"
  },
  {
    "firstName": "Dave",
    "lastName":  "Fayram",
    "location":  "San Francisco, CA"
  },
  {
    "firstName": "Nishan",
    "lastName":  "Perera",
    "location":  "London"
  }
  
]


the easiest wey to test this api is with swagger
**http://localhost:8080/swagger-ui.html**



#user       https://api.github.com/search/users?q=Alfredo Bello
#profile    https://api.github.com/users/skuarch
#repos      https://api.github.com/users/skuarch/repos
            https://api.github.com/repos/skuarch/bulmaradio/branches
#commits    https://api.github.com/repos/skuarch/bulmaradio/commits

            https://github.com/search?q=fullname%3Alfredo+Bello&type=Users

------------------------------------------------------------------------------------------------
https://api.github.com/rate_limit


https://api.github.com/users/aregee/repos
https://api.github.com/repos/aregee/kibana/commits?per_page=100&page=64
https://api.github.com/search/users?q=fullname:James+Golick+location:New York&type=Users
https://api.github.com/search/users?q=James Golick

https://api.github.com/repos/skuarch/bulmaradio/contributors

