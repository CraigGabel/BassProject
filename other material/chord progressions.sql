create table chordProgressions
(
    id          number      not null,
    name        varchar(32) not null unique,
    interval1   number,
    interval2   number,
    interval3   number,
    interval4   number,
    interval5   number,
    interval6   number,
    interval7   number,
    interval8   number,
    interval9   number,
    interval10  number,
    interval11  number,
    interval12  number,
    chord1      varchar(32),
    chord2      varchar(32),
    chord3      varchar(32),
    chord4      varchar(32),
    chord5      varchar(32),
    chord6      varchar(32),
    chord7      varchar(32),
    chord8      varchar(32),
    chord9      varchar(32),
    chord10     varchar(32),
    chord11     varchar(32),
    chord12     varchar(32),
    constraint PK_CHORDPROGRESSIONS primary key (id)
);

insert into chordProgressions values(0, 'Major',
2, 2, 1, 2, 2, 2, 1, null, null, null, null, null,
'Major', 'Minor', 'Minor', 'Major', 'Major', 'Minor', 'Diminished', null, null, null, null, null
);

insert into chordProgressions values(1, 'Minor',
2, 1, 2, 2, 1, 2, 2, null, null, null, null, null,
'Minor', 'Diminished', 'Major', 'Minor', 'Minor', 'Major', 'Major', null, null, null, null, null
);

create table jamProgressions
(
    id                  number      not null,
    name                varchar(32) not null,
    chordProgression    varchar(32) not null,
    chord1index         number,
    chord2index         number,
    chord3index         number,
    chord4index         number,
    chord5index         number,
    chord6index         number,
    chord7index         number,
    chord8index         number,
    chord9index         number,
    chord10index        number,
    chord11index        number,
    chord12index        number,
    constraint PK_JAMPROGRESSIONS primary key (id),
    constraint FK_JAMPROG_CHORDPROG foreign key (chordprogression) references chordprogressions (name)
);

insert into jamProgressions values(0, '12-Bar Blues', 'Major', 1, 4, 5, null, null, null, null, null, null, null, null, null);
insert into jamProgressions values(1, 'Pop Punk', 'Major', 1, 5, 6, 4, null, null, null, null, null, null, null, null);
insert into jamProgressions values(2, 'I-ii-V', 'Major', 1, 2, 5, null, null, null, null, null, null, null, null, null);
insert into jamProgressions values(3, 'I-IV-vii°', 'Major', 1, 4, 7, null, null, null, null, null, null, null, null, null);
