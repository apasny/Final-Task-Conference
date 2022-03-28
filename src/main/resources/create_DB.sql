use conferences;

CREATE TABLE IF NOT EXISTS user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(25) NOT NULL,
    surname VARCHAR(25) NOT NULL,
    login VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    is_admin TINYINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS conference (
    id INT AUTO_INCREMENT PRIMARY KEY,
    topic VARCHAR(50) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    place VARCHAR(50) NOT NULL,
    is_available TINYINT NOT NULL,
    is_deleted TINYINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS section (
    id INT AUTO_INCREMENT PRIMARY KEY,
    topic VARCHAR(50) NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    max_attendees INT NOT NULL,
    is_available TINYINT NOT NULL,
    is_deleted TINYINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    conference_id INT NOT NULL,
    FOREIGN KEY (conference_id) REFERENCES conference(id)
);

CREATE TABLE IF NOT EXISTS request (
    id INT AUTO_INCREMENT PRIMARY KEY,
    status ENUM("pending","accepted","canceled","declined"),
    user_id INT NOT NULL,
    section_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (section_id) REFERENCES section(id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);