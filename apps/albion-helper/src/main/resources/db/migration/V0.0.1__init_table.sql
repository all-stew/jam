create table `items`
(
    `id`           bigint auto_increment,
    `unique_name`  varchar(255)           not null,
    `name`         varchar(255)           not null,
    `description`  varchar(255)           not null,
    `created_by`   bigint       default 0 not null,
    `created_time` int unsigned default 0 not null,
    `updated_by`   bigint       default 0 not null,
    `updated_time` int unsigned default 0 not null,
    primary key (`id`),
    unique key (`unique_name`)
)
    ENGINE = innoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;
