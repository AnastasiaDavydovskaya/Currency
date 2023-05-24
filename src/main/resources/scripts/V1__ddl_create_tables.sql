create table if not exists rate
(
    id            bigint auto_increment primary key,
    abbreviation  varchar(255),
    calendar_date date,
    name          varchar(255),
    official_rate float
);
