create table if not exists climate_conditions_object_xml(
    climate_district_value text,
    geological_conditions_value text,
    wind_district_value text,
    snow_district_value text,
    seismic_activity_value text,
    name_company text,
    id_file int,
    id_transaction uuid
)