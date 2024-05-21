create table spaceship (
    id UUID primary key,
    name varchar(64) not null,
    supported_crew integer not null,
    cargo_limit integer not null,
    available boolean not null
);

create table cargo (
    id UUID primary key,
    engine_modules integer not null,
    power_cores integer not null,
    comm_arrays integer not null,
    hull_platings integer not null
);

create table debris_location (
    id UUID primary key,
    estimated_size integer not null,
    cleared boolean not null default false
);
