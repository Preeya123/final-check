-- Include table data insertion, updation, deletion and select scripts

-- -------------------------------------------------------------------
-- Adding Menu Items is MenuItem Table
-- --------------------------------------------------------------------
insert into movie
values
(1, 'Avatar', 2787965087, 'Yes','2017-03-15','Science Fiction','Yes'),
(2, 'Avengers', 1518812988, 'Yes','2017-12-23','SuperHero','No'),
(3, 'Titanic', 2187463944, 'Yes','2018-08-21','Romance','No'),
(4, 'Jurassic World', 1671713208, 'No','2017-07-02','Science Fiction','Yes'),
(5, 'Avengers:End Game', 2750760348, 'Yes','2022-11-02','SuperHero','Yes');

select
mo_id as "ID",
mo_title as "Title",
mo_box_Office as "Box Office",
mo_active as "Active",
mo_date_Of_launch as "Date Of Launch",
mo_genre as "Genre",
mo_has_Teaser as "Has Teaser"
from movie;
-- -------------------------------------------------------------------
-- Edit movie Item in Movie Crusier table 
-- -------------------------------------------------------------------
update movie 
set mo_title='Stree',mo_boxOffice='57375967963',mo_active='Yes',mo_date_Of_launch='2017-07-07',mo_genre='Haunted',mo_has_Teaser='Yes'
where mo_id='1';
-- -------------------------------------------------------------------
-- setting User Namr and Id
-- -------------------------------------------------------------------
insert into user(us_id,us_name)
values
(1,'The None'),(2,'GoodNews');
select 
us_id as "User ID",
us_name as "User Name"
from user;

-- -------------------------------------------------------------------
-- Displaying Customer Movie List in MovieItem table
-- -------------------------------------------------------------------
select 
mo_title as "Title",
mo_boxOffice as "Box Office",
mo_genre as "Genre",
mo_has_Teaser as "Has Teaser"
from movie
where mo_active='Yes'and mo_date_of_launch<curdate();
-- -------------------------------------------------------------------
-- Add to Favourite table
-- -------------------------------------------------------------------
insert into favorite(fv_id,fv_us_id,fv_pr_id)
values
(123,1,2),(124,1,1);
select 
fv_id as "Favourite ID",
fv_us_id as "Favourite User ID",
fv_pr_id as "Favourite Primary ID"
from favorite;

-- -------------------------------------------------------------------
-- Show Favourites Movie Item table
-- -------------------------------------------------------------------
select 
mo_title as "Title",
mo_boxOffice as "Box Office",
mo_genre as "Genre"
from movie
inner join favorite as favorite
on fv_pr_id=mo_id
where fv_us_id=1;
-- -------------------------------------------------------------------
-- Total Price of Favourite Movie Item
-- -------------------------------------------------------------------
select count(mo_boxOffice) as "no of favourite"
from movie
inner join favorite 
on fv_pr_id=mo_id
where fv_us_id=1;  
 -- -------------------------------------------------------
-- -------remove movie from favorite------------------
-- -------------------------------------------------------
 delete from favorite
 where  fv_us_id=1 
 and fv_pr_id=3;
  -- -------------------------------------------------------
-- -------after deleting movie from the favorite ------------------
-- -------------------------------------------------------
 
  select
fv_id as "Favorite ID",
fv_us_id as "Favorite User ID",
fv_pr_id as "Favorite Primary ID"
from favorite ;
 




