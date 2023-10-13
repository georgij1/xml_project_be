create table files
(
    id_image text,
    image_name text,
    type text,
    data bytea,
    time_stamp text,
    sender_id integer references users(id),
    name_company text references company(name_company)
);