drop table if exists cats;
drop table if exists breeds;
drop table if exists cats_breeds;

create table IF NOT exists roles(
    id INT not null auto_increment,
    name varchar(255),
primary key (id)) engine=InnoDB;

create table IF NOT exists users (
    id INT not null auto_increment,
    username varchar(100),
    password VARCHAR(100) NOT NULL,
    enabled boolean,
primary key (id)) engine=InnoDB;

create table IF NOT exists cats(
    id int not null auto_increment,
    id_cat varchar(255) not null unique,
    url varchar(255),
    width INT,
    height INT,
primary key (id)) engine=InnoDB;

create table IF NOT exists breeds(
    id int not null auto_increment,
    id_breed varchar(255) not null unique,
    name varchar(255),
    lifespan varchar(255),
    origin varchar(255),
    country_code varchar(255),
    wikipedia_url varchar(255),
primary key (id)) engine=InnoDB;

create table if not exists cats_breeds(
    id int not null auto_increment,
    breeds_id int not null,
    cats_id int not null,
    primary key(id),
    foreign key (breeds_id) references Breeds(id),
    foreign key (cats_id) references Cats(id)
)engine=InnoDB;

# On Utilise toujours des liste de roles, pour permettre l ajout de nouveaux roles a un utilisateur
CREATE TABLE IF NOT exists users_roles (
    users_id INT,
    roles_id INT,
    FOREIGN KEY (users_id) REFERENCES users(id),
    FOREIGN KEY (roles_id) REFERENCES roles(id),
    PRIMARY KEY (users_id, roles_id)
);

# Le nom des roles doit commencer par ROLE_ en spring security
INSERT INTO roles (name) VALUES
('ROLE_CRUD'),
('ROLE_BOING'),
('ROLE_SCRAPPER')
;