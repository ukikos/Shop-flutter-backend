create table if not exists users (
    id serial not null,
    email varchar(255) not null unique,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    password varchar(255) not null,
    role varchar(255) not null check (role in ('ROLE_USER')),
    primary key (id)
);

create table if not exists categories (
    id serial not null,
    name varchar(255) not null,
    image_link varchar(255),
    parent_id integer,
    is_last integer check (is_last in (0,1)),
    primary key (id)
);

create table if not exists items (
    id serial not null,
    name varchar(255) not null,
    image_link varchar(255),
    price integer not null,
    category_id integer not null,
    primary key (id)
);

create table if not exists attributes (
    id serial not null,
    name varchar(255) not null,
    primary key (id)
);

create table if not exists item_attributes (
    id serial not null,
    item_id integer not null,
    attribute_id integer not null,
    value varchar(255) not null,
    primary key (id)
);


alter table if exists categories
    drop constraint if exists FKsaok720gsu4u2wrgbk10b5n8d;

alter table if exists item_attributes
    drop constraint if exists FK8g9dmvb3behtrnvosxhceg58q;

alter table if exists item_attributes
    drop constraint if exists FKmxoy1q79itj8wka1ir17t49qv;

alter table if exists items
    drop constraint if exists FKjcdcde7htb3tyjgouo4g9xbmr;


alter table if exists categories
    add constraint FKsaok720gsu4u2wrgbk10b5n8d
    foreign key (parent_id) references categories;

alter table if exists item_attributes
    add constraint FK8g9dmvb3behtrnvosxhceg58q
    foreign key (attribute_id) references attributes;

alter table if exists item_attributes
    add constraint FKmxoy1q79itj8wka1ir17t49qv
    foreign key (item_id) references items;

alter table if exists items
    add constraint FKjcdcde7htb3tyjgouo4g9xbmr
    foreign key (category_id) references categories;
