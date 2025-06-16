-- Sample data.sql for library project

-- Insert sample authors
INSERT INTO authors (name) VALUES ('John Doe');
INSERT INTO authors (name) VALUES ('Jane Smith');

-- Insert sample categories
INSERT INTO categories (name) VALUES ('Programming');
INSERT INTO categories (name) VALUES ('Web Development');

-- Insert sample books
INSERT INTO books (title, author_id, category_id, isbn) VALUES ('Spring Boot in Action', 1, 1, '9781617292545');
INSERT INTO books (title, author_id, category_id, isbn) VALUES ('Java Programming', 1, 1, '9780135166307');
INSERT INTO books (title, author_id, category_id, isbn) VALUES ('Web Development Basics', 2, 2, '9781492056260');