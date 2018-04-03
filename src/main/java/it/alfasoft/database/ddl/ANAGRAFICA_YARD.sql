--------------------------------------------------------
--  File creato - martedì-aprile-03-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ANAGRAFICA_YARD
--------------------------------------------------------

  CREATE TABLE "DARIO_DB"."ANAGRAFICA_YARD" 
   (	"ID" NUMBER, 
	"CODICE_PIAZZALE" VARCHAR2(5 BYTE), 
	"DESCRIZIONE_PIAZZALE" VARCHAR2(50 BYTE), 
	"DATA_INSERIMENTO" DATE, 
	"DATA_AGGIORNAMENTO" DATE, 
	"DATA_DELETE" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table ANAGRAFICA_YARD
--------------------------------------------------------

  ALTER TABLE "DARIO_DB"."ANAGRAFICA_YARD" MODIFY ("CODICE_PIAZZALE" NOT NULL ENABLE);
  ALTER TABLE "DARIO_DB"."ANAGRAFICA_YARD" MODIFY ("ID" NOT NULL ENABLE);
