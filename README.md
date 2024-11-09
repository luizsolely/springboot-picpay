**Project based on [Fernanda Kipper's tutorial](https://youtu.be/T6ChO8LQxRE), with additional modifications by me.**

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
POST /transactions - Register a new Transaction between users (COMMON to COMMON or COMMON to MERCHANT)
```

```json

{
  "senderId": 1,
  "receiverId": 2,
  "value": 10
}
```




