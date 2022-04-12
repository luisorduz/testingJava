CREATE TABLE IF NOT EXISTS movies(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    minutes INT NOT NULL,
    genre VARCHAR(50) NOT NULL,
    director VARCHAR(100) NOT NULL
);

INSERT INTO movies (name, minutes, genre, director) VALUES
    ('Dark Knight', 152, 'ACTION','director1'),
    ('Memento', 113, 'THRILLER','director2'),
    ('Matrix', 136, 'ACTION','director3');