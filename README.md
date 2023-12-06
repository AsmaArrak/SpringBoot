# Catalog Management Application

This is a simple web application built using Spring Boot for managing a catalog of products. The application includes user and admin authentication using Spring Security, pagination for browsing through products, and the ability to add images to the products.

## Features

- **User Authentication:** The application provides secure user authentication with Spring Security. Users can register for an account, log in, and log out.

- **Admin Panel:** Administrators have additional privileges to manage products, users, and other settings through the admin panel.

- **Product Management:**
  - **Add Product:** Admins can add new products to the catalog, including uploading product images.
  - **View Products:** Users can browse through the catalog with pagination to view all available products.

- **Image Upload:** Products can have images associated with them. Admins can upload and manage product images.

## Technologies Used

- Spring Boot
- Spring Security
- Thymeleaf (or your preferred templating engine)
- Hibernate (or any JPA provider)
- MySQL (or any preferred database)
- Bootstrap (or any preferred front-end framework)

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven
- MySQL database

### Configuration

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/catalog-management.git
