# Music Store API 🎵

This is a **Spring Boot REST API** for managing a music store's catalog, user information, and image storage. It provides endpoints to create, read, update, and delete (CRUD) resources like `Music`, `Genres`, `Users`, and `Pictures`. The API is connected to a **MongoDB** database for image storage and **MySQL** for music and user data.

---

## Technologies Used
- **Spring Boot** - Application framework
- **Spring Data JPA** - Database interaction for MySQL
- **Spring Data MongoDB** - Database interaction for MongoDB
- **Spring Web** - RESTful web service
- **Maven** - Dependency management
- **Eclipse IDE** - Development environment
- **MongoDB** - NoSQL database for images
- **MySQL** - Relational database for user and music data

---

## Project Structure
```
MusicStoreAPI-master/
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── restlabpackage/
    │   │   │       ├── Driver.java
    │   │   │       ├── Genre.java
    │   │   │       ├── GenreRestController.java
    │   │   │       ├── Music.java
    │   │   │       ├── MusicRestController.java
    │   │   │       ├── Picture.java
    │   │   │       ├── PictureRestController.java
    │   │   │       ├── User.java
    │   │   │       ├── UserRestController.java
    │   │   │       └── repos/
    │   │   │           ├── GenreJpaRepository.java
    │   │   │           ├── MusicJpaRepository.java
    │   │   │           ├── PictureMongoRepository.java
    │   │   │           └── UserJpaRepository.java
    │   │   └── resources/
    │   │       ├── application.properties
    │   │       ├── 7qi7CDFh_400x400.jpg
    │   │       └── download.jpg
    └── pom.xml
```

---

## Installation & Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/YourUsername/MusicStoreAPI.git
   ```
2. Navigate to the project directory:
   ```bash
   cd MusicStoreAPI
   ```
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

---

## API Endpoints
### Genres
- `GET /api/genres` - Get all genres
- `POST /api/genres` - Create a new genre
- `PUT /api/genres/{id}` - Update a genre
- `DELETE /api/genres/{id}` - Delete a genre

### Music
- `GET /api/music` - Get all music
- `POST /api/music` - Create a new music entry
- `PUT /api/music/{id}` - Update music details
- `DELETE /api/music/{id}` - Delete a music entry

### Pictures
- `GET /api/pictures` - Get all pictures
- `POST /api/pictures` - Upload a new picture
- `DELETE /api/pictures/{id}` - Delete a picture

### Users
- `GET /api/users` - Get all users
- `POST /api/users` - Create a new user
- `PUT /api/users/{id}` - Update user details
- `DELETE /api/users/{id}` - Delete a user

---

## License
This project is licensed under the MIT License.
