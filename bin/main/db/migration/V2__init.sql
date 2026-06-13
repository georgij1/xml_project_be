create table if not exists xml_project.company
(
    id serial primary key,
    name_company text unique,
    password_company text,
    desc_company text,
    owner_company text
);