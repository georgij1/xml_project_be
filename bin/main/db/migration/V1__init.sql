create table if not exists xml_project.users (
    id serial primary key,
    username text unique ,
    password_hash text not null,
    info_person text
)