**Project based on [Fernanda Kipper's tutorial](https://www.youtube.com/watch?v=QXunBiLq2SM&ab), with additional modifications by me using the latest version of the [challenge](https://github.com/PicPay/picpay-desafio-backend).**

# How to Access Swagger and Test the API
**Accessing Swagger UI**

You can access the documentation at 🔗[Swagger](https://springboot-picpay-production.up.railway.app/swagger-ui/index.html)

**Testing API Endpoints**

- Open Swagger UI in your browser.
- Select an endpoint (e.g., /users, /transfer).
- Click "Try it out" to enable editing.
- Fill in the required parameters.
- Click "Execute" to send the request.
- Check the response at the bottom of the page.

# Authentication API

This project is an API built using **Java, Java Spring, H2 as the database.** 

- [API Endpoints](#api-endpoints)

## API Endpoints
The API provides the following endpoints:

**GET USERS**
```markdown
GET /users - Retrieve a list of all users.
```
```json
[
    {
        "id": 1,
        "firstName": "Michael",
        "lastName": "de Santa",
        "document": "123456789",
        "email": "Michael@example.com",
        "password": "testPassword",
        "balance": 10.00,
        "userType": "COMMON"
    },
    {
        "id": 2,
        "firstName": "Franklin",
        "lastName": "Clinton",
        "document": "12345678910",
        "email": "Franklin@example.com",
        "password": "testPassword",
        "balance": 20.00,
        "userType": "COMMON"
    },
    {
        "id": 3,
        "firstName": "Trevor",
        "lastName": "Philips",
        "document": "1234567891011",
        "email": "Trevor@example.com",
        "password": "testPassword",
        "balance": 30.00,
        "userType": "MERCHANT"
    }
]
```

**GET USER**
```markdown
GET /users/{id} - Retrieves a user by the provided ID.
```
```json
    {
        "id": 1,
        "firstName": "Michael",
        "lastName": "de Santa",
        "document": "123456789",
        "email": "Michael@example.com",
        "password": "testPassword",
        "balance": 10.00,
        "userType": "COMMON"
    },
```

**POST USERS**
```markdown
POST /users - Register a new user into the App
```
```json
{
    "firstName": "TEST",
    "lastName": "USER",
    "password": "password",
    "document": "0123456789",
    "email": "testUser@example.com",
    "userType": "COMMON",
    "balance": 100
}
```

**POST TRANSACTIONS**
```markdown
POST /transfer - Register a new Transaction between users (COMMON to COMMON or COMMON to MERCHANT)
```

```json

{
  "senderId": 1,
  "receiverId": 2,
  "value": 10
}
```




