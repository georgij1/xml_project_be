create table if not exists xml_project.users (
    id serial primary key,
    username text unique,
    password text not null
)