CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    nickname VARCHAR(100),
    profile_image VARCHAR(255),
    phone_number VARCHAR(20),
    gender ENUM('M', 'F', 'O'),
    birthdate DATE,
    address VARCHAR(255),
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_login TIMESTAMP,
    role ENUM('USER', 'ADMIN') DEFAULT 'USER',
    status ENUM('Y', 'N', 'B') DEFAULT 'Y',
    bio TEXT,
    consent_privacy ENUM('Y', 'N') DEFAULT 'N',
    consent_privacy_date TIMESTAMP NULL
);
