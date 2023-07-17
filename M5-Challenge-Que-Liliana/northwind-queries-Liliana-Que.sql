use northwind;

-- What are the categories of products in the database?
select category
from products;

-- Answer: camera, laptop, phone, tablet

-- What products are made by Dell?
select product_name
from products
where product_name
like '%Dell%';

-- Answer: Dell Inspirion

-- List all orders shipped to Pennsylvania 
select *
from orders 
where ship_state = 'Pennsylvania';

-- 2

-- List the first name and last name of all employees with last names that start with the letter W
select first_name, last_name
from employees
where last_name 
like 'W%'
order by first_name, last_name;

-- Willie Willis

-- List all customers from zip codes that start with 55.
select *
from customers
where postal_code
like '55%';

-- List all customers from zip codes that end with 0.
select*
from customers
where postal_code
like '%0';

-- List the first name, last name, and email for all customers with a ".org" email address.
select first_name, last_name, email
from customers
where email
like '%.org';

-- List the first name, last name, and phone number for all customers from the 202 area code.
select first_name, last_name, phone
from customers
where phone
like '__(202)%';

-- List the first name, last name, and phone number for all customers from the 202 area code, ordered by last name, first name.
select last_name, first_name, phone
from customers
where phone
like '__(202)%'
order by last_name, first_name;