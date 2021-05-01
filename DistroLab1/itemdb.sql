create database itemdb;

use itemdb;

create table fruit_table(
	fruit_id int auto_increment,
    name varchar(255) not null unique,
    description varchar(255) not null,
    primary key(fruit_id)
);

create table user_table(
	name varchar(255),
    password varchar(255) not null,	
    primary key(name)
);

create table cart_table(
	item_id int not null,
    quantity int default(1),
    username varchar(255) not null,
    foreign key(item_id) references fruit_table(fruit_id),
    foreign key(username) references user_table(name),
    primary key(item_id, username)
);

insert into fruit_table(
    name, description
    )Values('Äpple', "Mycket gott och bra för hälsan");

    insert into fruit_table(
    name, description
    )Values('Päron', "Grön och gott");

    insert into fruit_table(
    name, description
    )Values('Mandarin', "Smakfullt");


    insert into fruit_table(
    name, description
    )Values('Vattenmelon', "Gott på sommaren");

    insert into fruit_table(
    name, description
    )Values('Kiwi', "Bra för tacos och gott överlag");
    
    insert into fruit_table(
    name, description
    )Values('Banan', "Gott och bra");
    
    
    insert into fruit_table(
    name, description
    )Values('Apelsin', "Surt, men gott och bra för hälsan");

insert into user_table(
name, password
)values("Johan", "boi");

insert into user_table(
name, password
)values("Jesper", "123");


SET GLOBAL time_zone = '+8:00';

create user 'fruituser'@'%' identified by 'fruit123';
grant all on itemdb.* to 'fruituser'@'%';
