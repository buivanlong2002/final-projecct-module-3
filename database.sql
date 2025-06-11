create
database library;
use
library;
CREATE TABLE books
(
    id          VARCHAR(10) PRIMARY KEY,
    title       VARCHAR(100),
    author      VARCHAR(100),
    description TEXT,
    quantity    INT
);

CREATE TABLE students
(
    id    VARCHAR(10) PRIMARY KEY,
    name  VARCHAR(100),
    class VARCHAR(10)
);

CREATE TABLE borrow_cards
(
    id          VARCHAR(10) PRIMARY KEY,
    book_id     VARCHAR(10),
    student_id  VARCHAR(10),
    borrow_date DATE,
    return_date DATE,
    status      BOOLEAN,
    FOREIGN KEY (book_id) REFERENCES books (id),
    FOREIGN KEY (student_id) REFERENCES students (id)
);
