INSERT INTO mydb.users (firstname, lastname, login, password, zipcode) 
VALUES
('Tim', 'Cook', 'standard_user', 'secret_sauce', 30123),
('Jeff', 'Bezos', 'standard_user', 'secret_sauce', 14678),
('Elon', 'Musk', 'standard_user', 'secret_sauce', 10009),
('Bill', 'Gates', 'locked_out_user', 'secret_sauce', 20200);

INSERT INTO mydb.orders (product, user_id) 
VALUES 
('Sauce Labs Backpack', 1),
('Sauce Labs Bike Light', 2),
('Sauce Labs Fleece Jacket', 3),
('Sauce Labs Bike Light', 3);