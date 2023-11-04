create table if not exists Taco_Order (
          id int auto_increment primary key ,
          delivery_Name varchar(50) not null,
          delivery_Street varchar(50) not null,
          delivery_City varchar(50) not null,
          delivery_State varchar(30) not null,
          delivery_Zip varchar(10) not null,
          cc_number varchar(16) not null,
          cc_expiration varchar(5) not null,
          cc_cvv varchar(3) not null,
          placed_at timestamp not null
);

create table if not exists Taco (
            id int auto_increment primary key ,
            name varchar(50) not null,
            taco_order int not null,
            taco_order_key int not null,
            created_at timestamp not null,
            foreign key (taco_order) references Taco_Order(id)

);

CREATE TABLE IF NOT EXISTS Ingredient (
          id VARCHAR(4) NOT NULL PRIMARY KEY,
          name VARCHAR(25) NOT NULL,
          type VARCHAR(10) NOT NULL
);

create table if not exists Ingredient_Ref (
          ingredient varchar(4) not null,
          taco int not null,
          taco_key int not null,
          FOREIGN KEY (ingredient) REFERENCES Ingredient(id)
);

/*
 FOREIGN_KEY_CHECKS option specifies
 whether or not to check foreign key
 constraints for InnoDB tables.

 Do it before truncate tables
 */
SET FOREIGN_KEY_CHECKS = 0;

truncate table Ingredient_Ref;
truncate table Taco;
truncate table Taco_Order;
truncate table Ingredient;

SET FOREIGN_KEY_CHECKS = 1;


insert into Ingredient (id, name, type)
values ('FLTO', 'Flour Tortilla', 'WRAP');
insert into Ingredient (id, name, type)
values ('COTO', 'Corn Tortilla', 'WRAP');
insert into Ingredient (id, name, type)
values ('GRBF', 'Ground Beef', 'PROTEIN');
insert into Ingredient (id, name, type)
values ('CARN', 'Carnitas', 'PROTEIN');
insert into Ingredient (id, name, type)
values ('TMTO', 'Diced Tomatoes', 'VEGGIES');
insert into Ingredient (id, name, type)
values ('LETC', 'Lettuce', 'VEGGIES');
insert into Ingredient (id, name, type)
values ('CHED', 'Cheddar', 'CHEESE');
insert into Ingredient (id, name, type)
values ('JACK', 'Monterrey Jack', 'CHEESE');
insert into Ingredient (id, name, type)
values ('SLSA', 'Salsa', 'SAUCE');
insert into Ingredient (id, name, type)
values ('SRCR', 'Sour Cream', 'SAUCE');