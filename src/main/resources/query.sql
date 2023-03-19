select product_name
from
    orders join customers c on orders.customer_id = c.id
where  c.name LIKE :name GROUP BY product_name;