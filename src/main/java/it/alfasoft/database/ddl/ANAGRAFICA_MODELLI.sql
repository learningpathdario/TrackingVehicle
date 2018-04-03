--------------------------------------------------------
--  File creato - martedì-aprile-03-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ANAGRAFICA_MODELLI
--------------------------------------------------------

  CREATE TABLE "DARIO_DB"."ANAGRAFICA_MODELLI" 
   (	"ID" NUMBER, 
	"CODICE_MODELLO" VARCHAR2(20 BYTE), 
	"DESCRIZIONE_MODELLO" VARCHAR2(50 BYTE), 
	"DATA_INSERIMENTO" DATE, 
	"DATA_AGGIORNAMENTO" DATE, 
	"DATA_DELETE" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table ANAGRAFICA_MODELLI
--------------------------------------------------------

  ALTER TABLE "DARIO_DB"."ANAGRAFICA_MODELLI" MODIFY ("CODICE_MODELLO" NOT NULL ENABLE);
  ALTER TABLE "DARIO_DB"."ANAGRAFICA_MODELLI" MODIFY ("ID" NOT NULL ENABLE);
