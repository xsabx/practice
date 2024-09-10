DROP TABLE IF EXISTS institutions;
DROP TABLE IF EXISTS classifiers_translations;
DROP TABLE IF EXISTS classifiers;
DROP SEQUENCE IF EXISTS institutions_id_seq;
DROP SEQUENCE IF EXISTS classifiers_id_seq;
DROP SEQUENCE IF EXISTS classifiers_translations_id_seq;


CREATE SEQUENCE institutions_id_seq;
CREATE TABLE institutions (
    id int4 NOT NULL DEFAULT nextval('institutions_id_seq'),
    name varchar(250) NOT NULL,
    reg_num varchar(11) NOT NULL,
    reg_date timestamp NOT NULL,
    type_id int4 NOT NULL,
    status varchar(15) NOT NULL,
    CONSTRAINT institutions_id PRIMARY KEY (id)
);

CREATE SEQUENCE classifiers_id_seq;
CREATE TABLE classifiers (
    id int4 NOT NULL DEFAULT nextval('classifiers_id_seq'),
    code varchar(16) NOT NULL,
    CONSTRAINT classifiers_id PRIMARY KEY (id)
);

ALTER TABLE institutions ADD CONSTRAINT fk_institutions_foundation_type_id
    FOREIGN KEY (type_id) REFERENCES classifiers(id);

CREATE SEQUENCE classifiers_translations_id_seq;
CREATE TABLE classifiers_translations (
    id int4 NOT NULL DEFAULT nextval('classifiers_translations_id_seq'),
    classifier_id int4 NOT NULL,
    text text NOT NULL,
    language varchar(2) NOT NULL,
    CONSTRAINT classifiers_translations_id PRIMARY KEY (id)
);

ALTER TABLE classifiers_translations ADD CONSTRAINT fk_classifiers_translations_classifier_id
    FOREIGN KEY (classifier_id) REFERENCES classifiers(id);

INSERT INTO classifiers(code) VALUES ('FP');
INSERT INTO classifiers(code) VALUES ('M');
INSERT INTO classifiers(code) VALUES ('S');
INSERT INTO classifiers(code) VALUES ('P');
INSERT INTO classifiers(code) VALUES ('PO');
INSERT INTO classifiers(code) VALUES ('RO');
INSERT INTO classifiers(code) VALUES ('AB');
INSERT INTO classifiers(code) VALUES ('VI');
INSERT INTO classifiers(code) VALUES ('US');
INSERT INTO classifiers(code) VALUES ('PI');
INSERT INTO classifiers(code) VALUES ('U');
INSERT INTO classifiers(code) VALUES ('PP');
INSERT INTO classifiers(code) VALUES ('FG');
INSERT INTO classifiers(code) VALUES ('V');
INSERT INTO classifiers(code) VALUES ('PR');
INSERT INTO classifiers(code) VALUES ('PL');
INSERT INTO classifiers(code) VALUES ('FL');

INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='FP'),'Fiziska persona','LV');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='M'),'Ministrija','LV');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='S'),'Biedrība (Sab.org.)','LV');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='P'),'Pašvaldība','LV');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='PO'),'Politiska organizācija','LV');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='RO'),'Reliģiska organizācija','LV');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='AB'),'Arodbiedrība','LV');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='VI'),'Valsts iestāde','LV');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='US'),'Uzņēmējsabiedrība','LV');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='PI'),'Pašvaldības iestāde','LV');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='U'),'Universitāte (akadēmija)','LV');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='PP'),'Publiskajā piedāvājumā','LV');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='FG'),'Personu grupa','LV');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='V'),'Valsts','LV');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='PR'),'Pārstāvniecība','LV');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='PL'),'Plānošanas reģions','LV');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='FP'),'Natural person','EN');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='M'),'Ministry','EN');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='S'),'Association (Public Organisation)','EN');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='P'),'Local Government','EN');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='PO'),'Political Organisation','EN');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='RO'),'Religious Organisation','EN');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='AB'),'Trade Union','EN');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='VI'),'State Institution','EN');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='US'),'Business Company','EN');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='PI'),'Local Government Institution','EN');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='U'),'University (Academy)','EN');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='PP'),'In public offering','EN');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='FG'),'Group of Persons','EN');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='V'),'State','EN');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='PR'),'Representative Office','EN');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='PL'),'Planning Region','EN');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='FL'),'Foreign branch','EN');
INSERT INTO classifiers_translations(classifier_id,text,language) VALUES ((select id from classifiers where code='FL'),'Ārvalsts filiāle','LV');

INSERT INTO institutions(name,reg_num,reg_date,type_id,status) VALUES ('Zvērināts notārs Jānis Testētājs','40000000001','2009-10-05T14:48:00.000Z',1, 'ACTIVE');
INSERT INTO institutions(name,reg_num,reg_date,type_id,status) VALUES ('Finanšu ministrija','40000000002','2011-09-07T11:47:00.000Z',2, 'ACTIVE');
INSERT INTO institutions(name,reg_num,reg_date,type_id,status) VALUES ('Lielvārdes novada pašvaldība','40000000003','2001-01-22T17:48:00.000Z',10, 'ACTIVE');
INSERT INTO institutions(name,reg_num,reg_date,type_id,status) VALUES ('Pansionāts "Balvi"','40000000004','2017-11-06T14:11:00.000Z',8, 'ACTIVE');
INSERT INTO institutions(name,reg_num,reg_date,type_id,status) VALUES ('Rēzeknes Tehnoloģiju akadēmija','40000000005','1999-12-08 09:05:16.037',11, 'ACTIVE');
INSERT INTO institutions(name,reg_num,reg_date,type_id,status) VALUES ('Neaktīva filiāle','40000000006','2011-09-23T09:01:00.000Z',17, 'INACTIVE');
