create table users (
    id serial primary key,
    first_name text unique,
    last_name text unique,
    second_name text unique,
    login text unique,
    password text,
    email text unique,
    role text,
    state text,
    phone_number text
)