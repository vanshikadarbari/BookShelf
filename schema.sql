create schema Bookshelf;
set search_path to Bookshelf;

create table authors
(
name varchar(50) not null,
picture varchar(255),
dateofbirth date,
gender char(1),
about varchar(500),
createdate timestamp not null,
updatedate timestamp not null,
primary key(name)
);

create table users
(
username varchar(50) unique not null,
passwordhash varchar(50) not null,
dateofbirth date,
gender char(1),
sessiontoken varchar(255) not null,
profilepicture varchar(255),
firstname varchar(20) not null,
lastname varchar(20) not null,
email varchar(50) not null,
createdate timestamp not null,
updatedate timestamp not null,
primary key(username,email)
);

create table publishers
(
publisherid decimal(9,0) not null,
name varchar(30),
createdate timestamp not null,
updatedate timestamp not null,
primary key(publisherid)
);

create table books
(
title varchar(20) not null,
description varchar(200),
publisherid decimal(9,0),
publishdate date,
createdate timestamp not null,
updatedate timestamp not null,
foreign key(publisherid) references publishers(publisherid),
primary key(title)
);



create table genre
(
name varchar(20) not null,
createdate timestamp not null,
updatedate timestamp not null,
primary key(name)
);

create table book_genre
(
book_name varchar(20) not null,
genre_name varchar(20) not null,
createdate timestamp not null,
updatedate timestamp not null,
foreign key(book_name) references books(title),
foreign key(genre_name) references genre(name) 
);

create table author_genre
(
author varchar(20) not null,
genre_name varchar(20) not null,
createdate timestamp not null,
updatedate timestamp not null,
foreign key(author) references authors(name),
foreign key(genre_name) references genre(name) 
);


create table book_collections
(
book_name varchar(20) not null,
username varchar(50) not null,
createdate timestamp not null,
updatedate timestamp not null,
primary key(book_name,username),
foreign key(book_name) references books(title),
foreign key(username) references users(username)
);

create table book_authors
(
book_name varchar(20) not null,
author varchar(20) not null,
createdate timestamp not null,
updatedate timestamp not null,
primary key(author,book_name),
foreign key(book_name) references books(title),
foreign key(author) references authors(name)
);


create table comments
(
username varchar(50) not null,
commentid int not null,
parentcommentid int,
title varchar(20), 
body varchar(400),
createdate timestamp not null,
updatedate timestamp not null,
primary key(commentid,username),
foreign key(username) references users(username)
);

create table friend_list
(
username varchar(50) not null,
friendid varchar(50) not null,
createdate timestamp not null,
updatedate timestamp not null,
primary key(username,friendid,createdate,updatedate),
foreign key(username) references users(username),
foreign key(friendid) references users(username)
);

create table ratings
(
username varchar(50) not null,
book_name varchar(20) not null,
createdate timestamp not null,
updatedate timestamp not null,
rating int,
primary key(username, book_name),
foreign key(book_name) references books(title),
foreign key(username) references users(username)
);

create table reviews
(
username varchar(50) not null,
book_name varchar(20) not null,
title varchar(20),
body varchar(400),
createdate timestamp not null,
updatedate timestamp not null,
primary key(username,book_name),
foreign key(username) references users(username),
foreign key(book_name) references books(title)
);




