create table if not exists xml_project.company
(
    id serial primary key,
    nameCompany text unique,
    passwordCompany text,
    descCompany text,
    ownerCompany text
);