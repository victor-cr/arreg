create table PERSON (
    ID uuid not null primary key,
    LAST_NAME varchar(50) not null,
    FIRST_NAME varchar(50) not null,
    MIDDLE_NAME varchar(50) not null,
    BIRTH_DATE DATE not null,
    BIRTH_PLACE varchar(200) not null,
    ITN varchar(10) not null,
    BLOOD_GROUP varchar(2) not null,
    BLOOD_RHD varchar(8) not null
);
alter table PERSON add constraint UNQ_PERSON_ITN unique(ITN);

create table MILITARY_IDENTITY_CARD (
    ID uuid not null primary key,
    SERIAL_NUMBER varchar(50) not null ,
    PERSON_ID uuid not null,
    ISSUED_BY varchar(200) not null,
    ISSUED_AT date not null,
    EDUCATION varchar(200) not null,
    CIVIL_OCCUPATION varchar(200) not null,
    MARITAL_STATUS varchar(10) not null
);
alter table MILITARY_IDENTITY_CARD add constraint FK_MIC_PERSON foreign key (PERSON_ID) references PERSON(ID) on delete cascade;

create table TRANSFER (
    ID uuid not null primary key,
    DIRECTION varchar(3) not null,
    REASON varchar(200) not null,
    STARTED_AT date not null,
    PERSON_ID uuid not null,
    constraint FK_TRANSFER_PERSON foreign key (PERSON_ID) references PERSON(ID) on delete cascade
);

create table MEDICAL_TRANSFER (
    TRANSFER_ID uuid not null primary key,
    CLINIC varchar(100) not null,
    DIAGNOSIS varchar(100) not null,
    constraint FK_MEDICAL_TRANSFER foreign key (TRANSFER_ID) references TRANSFER(ID) on delete cascade
);

create table ASSESSMENT_TRANSFER (
    TRANSFER_ID uuid not null primary key,
    LOCATION varchar(100) not null,
    constraint FK_ASSESSMENT_TRANSFER foreign key (TRANSFER_ID) references TRANSFER(ID) on delete cascade
);

create table REGULAR_TRANSFER (
    TRANSFER_ID uuid not null primary key,
    constraint FK_REGULAR_TRANSFER foreign key (TRANSFER_ID) references TRANSFER(ID) on delete cascade
);

create table VACATION_TRANSFER (
    TRANSFER_ID uuid not null primary key,
    PLANNED_DAYS int not null,
    constraint FK_VACATION_TRANSFER foreign key (TRANSFER_ID) references TRANSFER(ID) on delete cascade
);