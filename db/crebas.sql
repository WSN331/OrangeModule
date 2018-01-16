/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/1/16 ÐÇÆÚ¶þ 16:05:15                       */
/*==============================================================*/


drop table if exists D_AIR_QUALITY;

drop table if exists D_FORMALDEHYDE;

drop table if exists D_FRAME;

drop table if exists D_U_DISK;

drop table if exists D_WATER_QUALITY;

drop table if exists T_CONFIG;

drop table if exists T_DEVICE;

drop table if exists T_SHOPPING_CAR;

drop table if exists T_TRADE;

drop table if exists T_TRADE_ORDER;

drop table if exists T_TRADE_ORDER_SINGLE;

drop table if exists T_USER;

drop table if exists T_USER_LOGIN;

/*==============================================================*/
/* Table: D_AIR_QUALITY                                         */
/*==============================================================*/
create table D_AIR_QUALITY
(
   C_ID                 int not null auto_increment,
   C_PM25               float,
   C_CREATE_TIME        datetime,
   C_USER_ID            int,
   C_DEVICE_ID          int,
   primary key (C_ID)
);

/*==============================================================*/
/* Table: D_FORMALDEHYDE                                        */
/*==============================================================*/
create table D_FORMALDEHYDE
(
   C_ID                 int not null auto_increment,
   C_FORMALDEHYDE       float,
   C_INDOOR_TEMPERATURE float,
   C_OUTDOOR_TEMPERATURE float,
   C_CREATE_TIME        datetime,
   C_USER_ID            int,
   C_DEVICE_ID          int,
   primary key (C_ID)
);

/*==============================================================*/
/* Table: D_FRAME                                               */
/*==============================================================*/
create table D_FRAME
(
   C_ID                 int not null auto_increment,
   C_ELECTRIC_QUANTITY  float,
   C_VOLTAGE            float,
   C_CREATE_TIME        datetime,
   C_USER_ID            int,
   C_DEVICE_ID          int,
   primary key (C_ID)
);

/*==============================================================*/
/* Table: D_U_DISK                                              */
/*==============================================================*/
create table D_U_DISK
(
   C_ID                 int not null auto_increment,
   C_SPACE              float,
   C_USED_SPACE         float,
   C_CREATE_TIME        datetime,
   C_USER_ID            int,
   C_DEVICE_ID          int,
   primary key (C_ID)
);

/*==============================================================*/
/* Table: D_WATER_QUALITY                                       */
/*==============================================================*/
create table D_WATER_QUALITY
(
   C_ID                 int not null auto_increment,
   C_TDS                float,
   C_CREATE_TIME        datetime,
   C_USER_ID            int,
   C_DEVICE_ID          int,
   primary key (C_ID)
);

/*==============================================================*/
/* Table: T_CONFIG                                              */
/*==============================================================*/
create table T_CONFIG
(
   C_ID                 int not null auto_increment,
   C_NAME               varchar(50),
   C_KEY                varchar(50),
   C_VALUE              varchar(50),
   primary key (C_ID)
);

/*==============================================================*/
/* Table: T_DEVICE                                              */
/*==============================================================*/
create table T_DEVICE
(
   C_ID                 int not null auto_increment,
   C_CODE               varchar(50),
   C_NAME               varchar(50),
   primary key (C_ID)
);

/*==============================================================*/
/* Table: T_SHOPPING_CAR                                        */
/*==============================================================*/
create table T_SHOPPING_CAR
(
   C_ID                 int not null auto_increment,
   C_TRADE_ID           int,
   C_USER_ID            int,
   C_PRICE              float,
   C_COUNT              int,
   C_SUM_PRICE          float,
   C_CREATE_TIME        datetime,
   primary key (C_ID)
);

/*==============================================================*/
/* Table: T_TRADE                                               */
/*==============================================================*/
create table T_TRADE
(
   C_ID                 int not null auto_increment,
   C_CODE               varchar(50),
   C_DEVICE_ID          int,
   C_NAME               varchar(50),
   C_INTRODUCE          text,
   C_PRICE              float,
   primary key (C_ID)
);

/*==============================================================*/
/* Table: T_TRADE_ORDER                                         */
/*==============================================================*/
create table T_TRADE_ORDER
(
   C_ID                 int not null auto_increment,
   C_CODE               varchar(50),
   C_USER_ID            int,
   C_ADDRESS            varchar(50),
   C_CREATE_TIME        datetime,
   C_RECEIVE            int,
   C_PRICE              float,
   primary key (C_ID)
);

/*==============================================================*/
/* Table: T_TRADE_ORDER_SINGLE                                  */
/*==============================================================*/
create table T_TRADE_ORDER_SINGLE
(
   C_ID                 int not null auto_increment,
   C_TRADE_ORDER_ID     varchar(50),
   C_TRADE_ID           int,
   C_USER_ID            int,
   C_PRICE              float,
   C_COUNT              int,
   C_SUM_PRICE          float,
   primary key (C_ID)
);

/*==============================================================*/
/* Table: T_USER                                                */
/*==============================================================*/
create table T_USER
(
   C_ID                 int not null auto_increment,
   C_ACCOUNT            varchar(11),
   C_NICKNAME           varchar(50),
   C_NAME               varchar(50),
   C_CREATE_TIME        datetime,
   C_ICON               varchar(50),
   primary key (C_ID)
);

/*==============================================================*/
/* Table: T_USER_LOGIN                                          */
/*==============================================================*/
create table T_USER_LOGIN
(
   C_ID                 int not null auto_increment,
   C_USER_ID            int,
   C_CREATE_TIME        datetime,
   C_ACCESS_TOKEN       varchar(128),
   primary key (C_ID)
);

