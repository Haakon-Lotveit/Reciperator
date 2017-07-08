create table recipe (
       id UUID,
       title varchar(64),
       difficulty varchar(64),	
       coocktime varchar(64),
       portionInfo varchar(64),
       instructions UUID,
       ingredients UUID,
       foreign key (instructions),
       foreign key (ingredients),
       primary key (id))
