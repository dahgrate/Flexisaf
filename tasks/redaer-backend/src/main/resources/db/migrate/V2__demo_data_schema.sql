-- V2__demo_data_data.sql

INSERT INTO authors (name, bio)
VALUES ('Chinua Achebe', 'Author of Things Fall Apart'),
       ('Wole Soyinka', 'Nigerian playwright and poet');

INSERT INTO books (title, description, author_id)
VALUES ('Things Fall Apart', 'Classic African literature', 1),
       ('Death and the King’s Horseman', 'Drama by Soyinka', 2);

INSERT INTO users (username, email, password)
VALUES ('akpos', 'akpos@example.com', 'hashedpassword');

INSERT INTO library (user_id, book_id, favorite)
VALUES (1, 1, TRUE);
