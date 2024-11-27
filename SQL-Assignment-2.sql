-- 1. Find out the number of documentaries with deleted scenes.
SELECT COUNT(f.film_id) AS documentary_with_deleted_scenes_count
FROM film f
JOIN film_text ft ON f.film_id = ft.film_id
WHERE f.special_features LIKE '%Deleted Scenes%' AND f.category_id = (
    SELECT category_id FROM category WHERE name = 'Documentary'
);


-- 2. Find out the number of sci-fi movies rented by the store managed by Jon Stephens.
SELECT COUNT(r.rental_id) AS sci_fi_rented_count
FROM rental r
JOIN inventory i ON r.inventory_id = i.inventory_id
JOIN film f ON i.film_id = f.film_id
JOIN store s ON i.store_id = s.store_id
JOIN staff st ON s.manager_staff_id = st.staff_id
JOIN film_category fc ON f.film_id = fc.film_id
JOIN category c ON fc.category_id = c.category_id
WHERE st.first_name = 'Jon' AND st.last_name = 'Stephens' AND c.name = 'Sci-Fi';


-- 	3. Find out the total sales from Animation movies.
SELECT SUM(p.amount) AS total_sales_from_animation
FROM payment p
JOIN rental r ON p.rental_id = r.rental_id
JOIN inventory i ON r.inventory_id = i.inventory_id
JOIN film_category fc ON i.film_id = fc.film_id
JOIN category c ON fc.category_id = c.category_id
WHERE c.name = 'Animation';

-- 4. Find out the top 3 rented categories of movies by “PATRICIA JOHNSON”.
SELECT c.name AS category_name, COUNT(r.rental_id) AS rental_count
FROM customer cu
JOIN rental r ON cu.customer_id = r.customer_id
JOIN inventory i ON r.inventory_id = i.inventory_id
JOIN film_category fc ON i.film_id = fc.film_id
JOIN category c ON fc.category_id = c.category_id
WHERE cu.first_name = 'PATRICIA' AND cu.last_name = 'JOHNSON'
GROUP BY c.name
ORDER BY rental_count DESC
LIMIT 3;


-- 5. Find out the number of R-rated movies rented by “SUSAN WILSON”.
SELECT COUNT(r.rental_id) AS r_rated_rentals
FROM customer cu
JOIN rental r ON cu.customer_id = r.customer_id
JOIN inventory i ON r.inventory_id = i.inventory_id
JOIN film f ON i.film_id = f.film_id
WHERE cu.first_name = 'SUSAN' AND cu.last_name = 'WILSON' AND f.rating = 'R';
