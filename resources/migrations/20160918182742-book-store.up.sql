CREATE TABLE books
(id INTEGER PRIMARY KEY AUTO_INCREMENT,
 book_name VARCHAR(100),
 isbn_no VARCHAR(30),
 author VARCHAR(30),
 is_available BOOLEAN,
 create_time TIMESTAMP);
