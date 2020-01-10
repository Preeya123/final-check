-- Include table data insertion, updation, deletion and select scripts

insert into movie
values
(1, 'Avatar', 2787965087, 'Yes','2017-03-15','Science Fiction','Yes'),
(2, 'Avengers', 1518812988, 'Yes','2017-12-23','SuperHero','No'),
(3, 'Titanic', 2187463944, 'Yes','2018-08-21','Romance','No'),
(4, 'Jurassic World', 1671713208, 'No','2017-07-02','Science Fiction','Yes'),
(5, 'Avengers:End Game', 2750760348, 'Yes','2022-11-02','SuperHero','Yes');

select * from movie;
-- -------------------------------------------------------------------
-- Updating movie in movie_list Table
-- -------------------------------------------------------------------

select * from movie;
update movie 
set mo_title='Stree',mo_boxOffice='57375967963',mo_active='Yes',mo_date_of_launch='2017-07-07',mo_genre='Haunted',mo_has_Teaser='Yes'
where mo_id='1';
-- -------------------------------------------------------------------
-- Adding movie into movie_list Table
-- -------------------------------------------------------------------
insert into user(us_id,us_name)
values
(1,'The None'),(2,'GoodNews');
select * from user;
-- -------------------------------------------------------------------
-- Updating into Menu Items is MenuItem Table
-- -------------------------------------------------------------------
update user
set us_name='Pink'
where us_id=1;

-- -------------------------------------------------------------------
-- selecting menu item table
-- -------------------------------------------------------------------

select mo_id,mo_title,mo_boxOffice,mo_genre,mo_has_Teaser
from movie
where mo_active='Yes'and mo_date_of_launch<(select(current_date()));
-- -------------------------------------------------------------------
-- Add favourite into favourite table
-- -------------------------------------------------------------------
insert into favourite(fv_id,fv_us_id,fv_pr_id)
values
(123,1,2),(124,1,1);
select * from favourite;

-- -------------------------------------------------------------------
-- Editing List into movie favourite table
-- -------------------------------------------------------------------
select mo_title,mo_boxOffice,mo_active,mo_date_of_launch,mo_has_Teaser
from movie
inner join favourite as favourite
on fv_pr_id=mo_id
where fv_us_id=1;

select count(mo_boxOffice) as 'no of favourite'
from movie
inner join favourite as favourite
on fv_pr_id=mo_id
where fv_us_id=1;
-- -------------------------------------------------------------------
-- Remove items from the cart table
-- -------------------------------------------------------------------
delete from favourite
where fv_us_id=2 and fv_pr_id=4;
-- -------------------------------------------------------------------
-- Select list from favourite table
-- -------------------------------------------------------------------
select*from favourite;

