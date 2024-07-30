create database fanambadiana;
.\c fanambadiana;
create table PersoAnnexe(
    IdPerso int,
    Nom varchar(30),
    Mdp varchar(20),
    Sexe varchar(30),
    Pays varchar(30),
    Salaire int,
    Fivavahana int,
    Fiavanana int,
    Diplome int,
    Physics int,
    Note int,
    primary key (IdPerso)
);

create table CriterePersonAnnexe (
    IdCritere int,
    Idperson int,
    Sexe varchar(10),
    Salaire int,
    Fivavahana int,
    Fiavanana int,
    Diplome int,
    Physics int,
    Note int,
    primary key (IdCritere),
    foreign key(IdPerson) references PersoAnnexe(idPerso)
);

create table demande (
    idDemande int,
    idDemandeur int,
    idInvite int,
    dateInvitation date
);

create table Raikitra (
    IdRaikitra int,
    IdConnecte int,
    IdDemandeur int,
    DateEvenemnent date,
    primary key (IdRaikitra),
    foreign key (IdConnecte) references PersoAnnexe(IdPerso),
    foreign key (IdDemandeur) references PersoAnnexe(IdPerso)
);

create table PersoIndisponnible (
    IdIndispo int,
    IdPerso int,
    primary key (IdIndispo),
    foreign key(IdPerso) references PersoAnnexe(IdPerso)
);

create table Note (
    IdNote int,
    IdCritere int,
    NoteValue int,
    primary key(IdNote),
    foreign key (IdCritere) references CriterePersonAnnexe(IdCritere)
);

create sequence persAnn 
    minvalue 1
    maxvalue 9999
    start with 1
    increment by 1;

create sequence CritAnnex 
    minvalue 1
    maxvalue 9999
    start with 1
    increment by 1;

create sequence seqDem 
    minvalue 1
    maxvalue 9999
    start with 1
    increment by 1;

create sequence raiki 
    minvalue 1
    maxvalue 9999
    start with 1
    increment by 1;

create sequence persindispo 
    minvalue 1
    maxvalue 9999
    start with 1
    increment by 1;

create sequence seqNote
    minvalue 1
    maxvalue 9999
    start with 1
    increment by 1;

create function getSeqPersAnn return number is seq number(4);
begin
select persAnn.nextval into seq from dual;
return (seq);
end;
/


create function getSeqCritAnn return number is sequ number(4);
begin
select CritAnnex.nextval into sequ from dual;
return (sequ);
end;
/

create function getSeqDem return number is sequences number(4);
begin
select seqDem.nextval into sequences from dual;
return (sequences);
end;
/

create function getSeqRaiki return number is seque number(4);
begin
select raiki.nextval into seque from dual;
return (seque);
end;
/


create function getSeqPersIndispo return number is sequen number(4);
begin
select persindispo.nextval into sequen from dual;
return (sequen);
end;
/

create function getSeqNote return number is sequenc number(4);
begin
select seqNote.nextval into sequenc from dual;
return (sequenc);
end;
/
