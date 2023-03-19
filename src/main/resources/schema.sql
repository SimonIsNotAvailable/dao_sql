create table public.CUSTOMERS
(
    id             serial primary key not null,
    name           varchar(50) not null,
    surname        varchar(50) not null,
    age            smallint    not null,
    phone_number   varchar(15)
);

create table public.ORDERS
(
    id                  serial primary key not null,
    date                date not null,
    customer_id        integer not null,
    product_name       varchar(50) not null,
    amount            int  not null,
    constraint customers
        foreign key (customer_id)
            references customers(id)
)

INSERT INTO orders (
    date,
    customer_id,
    product_name,
    amount
)
VALUES(now(),1, 'margarita', 4),
      (now(),4, 'margarita', 1),
      (now(), 3, 'pepperoni', 2),
      (now(), 2, 'double_cheese', 1);


INSERT INTO CUSTOMERS (
    name,
    surname,
    age    )
VALUES('ALEX','SMITH', 55),
      ('DARIA','PAVLOVA', 15),
      ('SIMON','POLUSHKIN', 30),
      ('ALEXEY','POPOV', 21);
