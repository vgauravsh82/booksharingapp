-- :name create-user! :! :n
-- :doc creates a new user record
INSERT INTO users
( first_name, last_name, email, pass)
VALUES ( :first_name, :last_name, :email, :pass)

-- :name update-user! :! :n
-- :doc update an existing user record
UPDATE users
SET first_name = :first_name, last_name = :last_name, email = :email
WHERE id = :id

-- :name get-user :? :1
-- :doc retrieve a user given the id.
SELECT * FROM users

-- :name delete-user! :! :n
-- :doc delete a user given the id
DELETE FROM users
WHERE id = :id


-- :name get-books :? :*
-- :doc retrieve all books
SELECT * FROM books

-- :name save-book! :! :n
-- :doc creates a new message using the book name, author, and timestamp keys
INSERT INTO books
(book_name, author, create_time)
VALUES (:book_name, :author, :create_time)

