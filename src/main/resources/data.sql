insert into user_details(id, name, birth_date)values(10001, 'Abhishek', current_date());
insert into user_details(id, name, birth_date)values(10002, 'Kumar', current_date());
insert into user_details(id, name, birth_date)values(10003, 'Raushan', current_date());

insert into post(id,description, user_id)values(11001,'Learning is easy', 10001);
insert into post(id,description, user_id)values(11002,'Learning Java is easy', 10002);
insert into post(id,description, user_id)values(11003,'Learning Python is easy', 10003);