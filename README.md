To Test With Postman:

1. Register a new user:

URL: POST http://localhost:8080/api/register
{
"username": "testuser",
"password": "password"
}

2. Login with registered user:
URL: POST http://localhost:8080/api/login
   {
   "username": "testuser",
   "password": "password"
   }
Copy token from response.

3. Access protected endpoint:

URL: GET http://localhost:8080/protected-endpoint

Authorization: Bearer <your-jwt-token>
