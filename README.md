# E-Commerce API Documentation

Welcome to the documentation for the E-Commerce API! This API allows users to create accounts, login, and manage their item wishlists. Users can perform operations such as creating, deleting, and getting their wishlists. Only authenticated users have access to manage their own wishlists.

## Table of Contents
1. [Introduction](#introduction)
2. [Technologies Used](#technologies-used)
3. [Getting Started](#getting-started)
4. [Endpoints](#endpoints)
    - [User](#user)
    - [Authentication](#authentication)
    - [Wishlist](#wishlist)
5. [Authentication](#authentication)
6. [Responses](#responses)
7. [Error Handling](#error-handling)
8. [Conclusion](#conclusion)

## Introduction

This API serves as the backend for an E-Commerce platform, providing functionality for user management and wishlist handling. Users can create accounts, log in securely, and manage their item wishlists.

## Technologies Used

- Spring Boot
- Spring Security
- JPA (Java Persistence API)
- MySQL Database
- Lombok
- DevTools

## Getting Started

To get started with the API, follow these steps:

1. Clone the repository to your local machine.
2. Set up your MySQL database and configure the database connection in the application properties.
3. Build and run the application.
4. Access the API endpoints using a tool like Postman or curl.

## Endpoints

### User

- **POST /api/users/signup**: Create a new user account.
- **POST /api/users/login**: Authenticate user login.

### Authentication

- **GET /api/auth/logout**: Logout the authenticated user.

### Wishlist

- **GET /api/wishlists**: Get the user's wishlist.
- **POST /api/wishlists**: Create a new wishlist item.
- **DELETE /api/wishlists/{wishlistId}**: Delete a wishlist item by ID.

## Authentication

Authentication is handled using Spring Security. Upon successful login, a JWT (JSON Web Token) is generated and used for subsequent authenticated requests. The token should be included in the Authorization header of the request.

## Responses

Responses from the API are in JSON format and include appropriate status codes. Successful responses will include the requested data, while error responses will include an error message.

## Error Handling

The API handles errors gracefully and returns appropriate error responses with corresponding HTTP status codes. Common errors include invalid requests, unauthorized access, and resource not found.

## Conclusion

This README provides a brief overview of the E-Commerce API and its functionality. For detailed information on each endpoint and request/response formats, please refer to the Postman documentation linked below.

[API Documentation on Postman](https://documenter.getpostman.com/view/20743504/2sA2rDy1nf)

Thank you for using the E-Commerce API! If you have any questions or issues, feel free to contact the development team.
