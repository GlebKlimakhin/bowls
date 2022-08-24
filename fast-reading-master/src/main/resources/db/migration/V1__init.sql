create table exercises(
id bigserial not null unique,
data text not null,
type varchar(50) not null,
primary key (id)
);

create table users(
id bigserial not null primary key,
username varchar(55) not null unique,
password varchar(255) not null,
firstname varchar(55) not null,
lastname varchar(55) not null,
status varchar(55) default 'ACTIVE',
email varchar(55) unique,
role varchar(55) default 'USER',
rating int default 0
);

create table done_exercises(
user_id bigint not null,
exercise_id bigint not null,
score int,
done_at date,
type varchar(55),
primary key(user_id, exercise_id)
);

create table homeworks(
id bigserial not null,
description varchar(255),
primary key (id)
);

insert into exercises(data, type) VALUES
('this is test reading exercise1', 'READING_SPEED'),
('this is test reading exercise2', 'READING_SPEED'),
('this is test reading exercise3', 'READING_SPEED'),
('this is test reading exercise4', 'READING_SPEED'),
('this is test reading exercise5', 'READING_SPEED'),
('this is test reading exercise6', 'READING_SPEED'),
('this is test reading exercise7', 'READING_SPEED'),
('this is test reading exercise8', 'READING_SPEED'),
('this is test reading exercise9', 'READING_SPEED'),
('this is test reading exercise10', 'READING_SPEED');

create table groups(
    id bigserial not null,
    name varchar(255) not null,
    primary key (id)
);

create table users_groups(
    user_id bigint not null,
    group_id bigint not null,
    primary key (user_id, group_id),
    foreign key (user_id) references users(id),
    foreign key (group_id) references groups(id)
);

create table groups_homeworks(
    group_id bigint not null,
    homework_id bigint not null,
    primary key (group_id, homework_id),
    foreign key (group_id) references groups(id),
    foreign key (homework_id) references homeworks(id)
);

create table homeworks_exercises(
    homework_id bigint not null,
    exercise_id bigint not null,
    primary key (homework_id, exercise_id),
    foreign key (homework_id) references homeworks(id),
    foreign key (exercise_id) references exercises(id)
);

insert into users(username, password, firstname, lastname, email, role, status, rating) values
('user1', '$2a$12$4Vxok0Ubj8wUuDk8sUciFeBgCgfNy.4hIl9XmJDkRvkyQBWDxWiUe', 'user1', 'user1', 'user1@gmail.com', 'ADMIN', default, default),
('user2', '$2a$12$JS30AoZb3jwCFNhZ1.QtZeYAChznRsikM1GFPuATSDGlgLgD9Afyy', 'user2', 'user2', 'user2@gmail.com', 'USER', default, default);

insert into groups(name) values
('Bababa');

insert into users_groups(user_id, group_id) values
(1, 1),
(2, 1);

