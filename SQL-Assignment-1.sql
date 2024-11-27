-- 1. Find out the PG-13 rated comedy movies. DO NOT use the film_list table.
SELECT f.title, f.rating
FROM film f
JOIN film_category fc ON f.film_id = fc.film_id
JOIN category c ON fc.category_id = c.category_id
WHERE f.rating = 'PG-13' AND c.name = 'Comedy';


-- 2.Find out the top 3 rented horror movies.
SELECT f.title, COUNT(r.rental_id) AS rental_count
FROM film f
JOIN film_category fc ON f.film_id = fc.film_id
JOIN category c ON fc.category_id = c.category_id
JOIN inventory i ON f.film_id = i.film_id
JOIN rental r ON i.inventory_id = r.inventory_id
WHERE c.name = 'Horror'
GROUP BY f.film_id
ORDER BY rental_count DESC
LIMIT 3;


-- 3.Find out the list of customers from India who have rented sports movies.
SELECT DISTINCT c.first_name, c.last_name, cu.email
FROM customer cu
JOIN address a ON cu.address_id = a.address_id
JOIN city ci ON a.city_id = ci.city_id
JOIN country co ON ci.country_id = co.country_id
JOIN rental r ON cu.customer_id = r.customer_id
JOIN inventory i ON r.inventory_id = i.inventory_id
JOIN film f ON i.film_id = f.film_id
JOIN film_category fc ON f.film_id = fc.film_id
JOIN category c ON fc.category_id = c.category_id
WHERE co.country = 'India' AND c.name = 'Sports';

-- 4. Find out the list of customers from Canada who have rented “NICK WAHLBERG” movies.
SELECT DISTINCT cu.first_name, cu.last_name, cu.email
FROM customer cu
JOIN address a ON cu.address_id = a.address_id
JOIN city ci ON a.city_id = ci.city_id
JOIN country co ON ci.country_id = co.country_id
JOIN rental r ON cu.customer_id = r.customer_id
JOIN inventory i ON r.inventory_id = i.inventory_id
JOIN film f ON i.film_id = f.film_id
JOIN film_actor fa ON f.film_id = fa.film_id
JOIN actor act ON fa.actor_id = act.actor_id
WHERE co.country = 'Canada' AND CONCAT(act.first_name, ' ', act.last_name) = 'NICK WAHLBERG';


-- 5. Find out the number of movies in which “SEAN WILLIAMS” acted.
SELECT COUNT(DISTINCT f.film_id) AS movie_count
FROM film f
JOIN film_actor fa ON f.film_id = fa.film_id
JOIN actor act ON fa.actor_id = act.actor_id
WHERE CONCAT(act.first_name, ' ', act.last_name) = 'SEAN WILLIAMS';

