--
-- JBoss, Home of Professional Open Source
-- Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
-- contributors by the @authors tag. See the copyright.txt in the
-- distribution for a full listing of individual contributors.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- http://www.apache.org/licenses/LICENSE-2.0
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

-- You can use this file to load seed data into the database using SQL statements
insert into Member (id, name, email, phone_number) values (0, 'John Smith', 'john.smith@mailinator.com', '2125551212');

DROP Table IF EXISTS REVIEW;
create table REVIEW (id bigint auto_increment, type varchar(255), reviewedMediaUrl varchar(255) , referenceUrl varchar(255) , reviewedtimes bigint, description varchar(255));

insert into REVIEW  (type , reviewedMediaUrl , referenceUrl , reviewedtimes, description) values ('POSITIVE', '65660684', 'http://dl.dropbox.com/u/65660684/640px-Carnival_Puppets.jpg' , FLOOR(RAND()  * 401) + 100, 'Description POSITIVE');
insert into REVIEW  (type , reviewedMediaUrl , referenceUrl , reviewedtimes, description) values ('POSITIVE', '65660684', 'http://dl.dropbox.com/u/65660684/640px-Carnival_Puppets.jpg' , FLOOR(RAND()  * 401) + 100, 'Description POSITIVE');
insert into REVIEW  (type , reviewedMediaUrl , referenceUrl , reviewedtimes, description) values ('POSITIVE', '65660684', 'http://dl.dropbox.com/u/65660684/640px-Carnival_Puppets.jpg' , FLOOR(RAND()  * 401) + 100, 'Description POSITIVE');


insert into REVIEW  (type , reviewedMediaUrl , referenceUrl , reviewedtimes, description) values ('NEGATIVE', '65660684', 'http://dl.dropbox.com/u/65660684/640px-Carnival_Puppets.jpg' , FLOOR(RAND()  * 401) + 100, 'Description NEGATIVE..');
insert into REVIEW  (type , reviewedMediaUrl , referenceUrl , reviewedtimes, description) values ('NEGATIVE', '65sdf0684', 'http://dl.dropbox.com/u/65660684/640px-Carnival_Puppets.jpg' , FLOOR(RAND()  * 401) + 100, 'Description NEGATIVE..');
insert into REVIEW  (type , reviewedMediaUrl , referenceUrl , reviewedtimes, description) values ('NEGATIVE', '65660684', 'http://dl.dropbox.com/u/65660684/640px-Carnival_Puppets.jpg' , FLOOR(RAND()  * 401) + 100, 'Description NEGATIVE..');


insert into REVIEW  (type , reviewedMediaUrl , referenceUrl , reviewedtimes, description) values ('CONTROVERSIAL', '65660684', 'http://dl.dropbox.com/u/65660684/640px-Carnival_Puppets.jpg' , FLOOR(RAND()  * 401) + 100, 'Description CONTROVERSIAL.');
insert into REVIEW  (type , reviewedMediaUrl , referenceUrl , reviewedtimes, description) values ('CONTROVERSIAL', 'sdf60684', 'http://dl.dropbox.com/u/65660684/640px-Carnival_Puppets.jpg' , FLOOR(RAND()  * 401) + 100, 'Description CONTROVERSIAL..');
insert into REVIEW  (type , reviewedMediaUrl , referenceUrl , reviewedtimes, description) values ('CONTROVERSIAL', '65660684', 'http://dl.dropbox.com/u/65660684/640px-Carnival_Puppets.jpg' , FLOOR(RAND()  * 401) + 100, 'Description CONTROVERSIAL..');

--insert into MEDIAREVIEW (id , videohash ) values ( 0, 'azertyH56');
--insert into MEDIAREVIEW (id , videohash ) values ( 1, 'qwertyH22');
--insert into MEDIAREVIEW (id , videohash ) values ( 2, 'aaaaaaaah');

--insert into MEDIAREVIEW_REVIEW  (MEDIAREVIEW_ID  ,POSITIVEREVIEWLIST_ID ,NEGATIVEREVIEWLIST_ID ,CONTROVERSIALREVIEWLIST_ID ) values ( 0, 'azertyH56');
--insert into MEDIAREVIEW_REVIEW (id , videohash ) values ( 1, 'qwertyH22');
--insert into MEDIAREVIEW_REVIEW (id , videohash ) values ( 2, 'aaaaaaaah');


select * from MEDIAREVIEW;