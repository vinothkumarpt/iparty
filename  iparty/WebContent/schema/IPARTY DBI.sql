INSERT INTO PARTY_ADMIN VALUES(ADMIN_ID_SEQ.NEXTVAL, 'INVITER','WELCOME','inviter@gmail.com',sysdate);

SELECT * FROM PARTY_ADMIN;


INSERT INTO PARTY_MASTER VALUES(PARTY_SEQ.NEXTVAL, 'TEST PARTY',26, '#1000','STREET ONE','NEW YORK','USA','10001','Yours Mr and Mrs Inviter',
null,sysdate,sysdate+1,'We are inviting you to this special occasion',001,sysdate,sysdate, 'please choose the same restaurant');

SELECT * FROM PARTY_MASTER;

INSERT INTO PARTY_USER values(21,26,USER_ID_SEQ.NEXTVAL,'Y','INVITER','inviter@gmail.com',1,SYSDATE,SYSDATE);
INSERT INTO PARTY_USER values(21,26,USER_ID_SEQ.NEXTVAL,'N','INVITEE','invitee1@gmail.com',1,SYSDATE,SYSDATE);

SELECT * FROM PARTY_USER;

insert into PARTY_ITEMS values(21,21,1,'Mc Donald','burger',1,sysdate);
insert into PARTY_ITEMS values(21,21,1,'Domino','pizza',1,sysdate);
insert into PARTY_ITEMS values(21,22,2,'Soft Drink','pepsi',500,sysdate);

SELECT * FROM PARTY_ITEMS;
--delete from PARTY_ITEMS;

insert into CATEGORY_MASTER values(287, 1,'Food','Item name','Restaurant',1);
insert into CATEGORY_MASTER values(287, 2,'Drink','Type','Brand Name',2);
SELECT * FROM CATEGORY_MASTER;

insert into unit_master values(1,'Number');
insert into unit_master values(2,'Ml');
insert into unit_master values(3,'L');
insert into unit_master values(4,'Mg');
insert into unit_master values(5,'Kg');
insert into unit_master values(6,'Pound');
insert into unit_master values(7,'LB');
insert into unit_master values(8,'Ounze');

SELECT * FROM UNIT_MASTER;


INSERT INTO USER_STATUS_MASTER values(
001, 'ACCEPTED');
INSERT INTO USER_STATUS_MASTER values(002, 'DECLINED');
SELECT * FROM USER_STATUS_MASTER;

INSERT INTO PARTY_STATUS_MASTER values(001, 'ACTIVE');
INSERT INTO PARTY_STATUS_MASTER values(002, 'INACTIVE');
INSERT INTO PARTY_STATUS_MASTER values(003, 'CANCELLED');

SELECT * FROM PARTY_STATUS_MASTER;

commit;



