create table currency (
    id bigint not null auto_increment,
    currency_code varchar(255),
    exchange_date date,
    name varchar(255),
    rate double precision,
    reference INT,
    primary key (id)
);