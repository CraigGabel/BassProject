create table scales
(
    id              number      not null,
    name            varchar(32) not null,
    root            number      not null, --r
    minorSecond     number      not null, --m2
    majorSecond     number      not null, --M2
    minorThird      number      not null, --m3
    majorThird      number      not null, --M3
    perfectFourth   number      not null, --P4
    augmentedFourth number      not null, --A4
    perfectFifth    number      not null, --P5
    minorSixth      number      not null, --m6
    majorSixth      number      not null, --M6
    minorSeventh    number      not null, --m7
    majorSeventh    number      not null,  --M7
    constraint PK_SCALES primary key (id)
);

UPDATE table_name
SET column1 = value1, column2 = value2, ...
WHERE condition;

update scales set name = '!Chromatic' where id = 0;

--insert into scales values(......,       r,m2,M2,m3,M3,P4,A4,P5,m6,M6,m7,M7)
insert into scales values(0, 'Chromatic', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
--insert into scales values(......,   r,m2,M2,m3,M3,P4,A4,P5,m6,M6,m7,M7)
insert into scales values(1, 'Major', 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1);
--insert into scales values(.....,              r,m2,M2,m3,M3,P4,A4,P5,m6,M6,m7,M7)
insert into scales values(2, 'Minor - Natural', 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0);
--insert into scales values(.....,              r,m2,M2,m3,M3,P4,A4,P5,m6,M6,m7,M7)
insert into scales values(3, 'Pentatonic - Major', 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0);
--insert into scales values(.....,              r,m2,M2,m3,M3,P4,A4,P5,m6,M6,m7,M7)
insert into scales values(4, 'Pentatonic - Minor', 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0);
--insert into scales values(......,    r,m2,M2,m3,M3,P4,A4,P5,m6,M6,m7,M7)
insert into scales values(5, 'Dorian', 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0);
--insert into scales values(.....     ,    r,m2,M2,m3,M3,P4,A4,P5,m6,M6,m7,M7)
insert into scales values(6, 'Mixolydian', 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0);
--insert into scales values(.....,    r,m2,M2,m3,M3,P4,A4,P5,m6,M6,m7,M7)
insert into scales values(7, 'Blues', 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0);


create table scales_v2
(
    id              number      not null,
    name            varchar(32) not null,
    mode1name       varchar(32),
    mode2name       varchar(32),
    mode3name       varchar(32),
    mode4name       varchar(32),
    mode5name       varchar(32),
    mode6name       varchar(32),
    mode7name       varchar(32),
    mode8name       varchar(32),
    mode9name       varchar(32),
    mode10name      varchar(32),
    mode11name      varchar(32),
    mode12name      varchar(32),
    root            number      not null, --r
    minorSecond     number      not null, --m2
    majorSecond     number      not null, --M2
    minorThird      number      not null, --m3
    majorThird      number      not null, --M3
    perfectFourth   number      not null, --P4
    augmentedFourth number      not null, --A4
    perfectFifth    number      not null, --P5
    minorSixth      number      not null, --m6
    majorSixth      number      not null, --M6
    minorSeventh    number      not null, --m7
    majorSeventh    number      not null,  --M7
    constraint PK_SCALESV2 primary key (id)
);

insert into scales_v2 values(0, '!Chromatic',
'Chromatic', null, null, null, null, null, null, null, null, null, null, null,
1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

insert into scales_v2 values(1, 'Major',
'Ionian', 'Dorian', 'Phrygian', 'Lydian', 'Mixolydian', 'Aeolian (Natural Minor)', 'Locrian', null, null, null, null, null,
1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1);

insert into scales_v2 values(2, 'Melodic Minor',
'Melodic Minor', 'Dorian b2', 'Lydian Augmented', 'Lydian Dominant', 'Mixolydian b6', 'Aeolian b5', 'Altered Scale', null, null, null, null, null,
1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1);

insert into scales_v2 values(3, 'Harmonic Minor',
'Harmonic Minor', 'Locrian #6', 'Ionian #5', 'Dorian #4', 'Phrygian Dominant', 'Lydian #2', 'Superlocrian', null, null, null, null, null,
1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1);

insert into scales_v2 values(4, 'Blues (Hexatonic)',
'Major', null, null, null, null, 'Minor', null, null, null, null, null, null,
1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0);

insert into scales_v2 values(5, 'Pentatonic',
'Major', null, null, null, 'Minor', null, null, null, null, null, null, null,
1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0);


create table scales_v3
(
    id              number      not null,
    name            varchar(32) not null,
    mode1name       varchar(32),
    mode2name       varchar(32),
    mode3name       varchar(32),
    mode4name       varchar(32),
    mode5name       varchar(32),
    mode6name       varchar(32),
    mode7name       varchar(32),
    mode8name       varchar(32),
    mode9name       varchar(32),
    mode10name      varchar(32),
    mode11name      varchar(32),
    mode12name      varchar(32),
    interval1       number,
    interval2       number,
    interval3       number,
    interval4       number,
    interval5       number,
    interval6       number,
    interval7       number,
    interval8       number,
    interval9       number,
    interval10      number,
    interval11      number,
    interval12      number,
    constraint PK_SCALESV3 primary key (id)
);

insert into scales_v3 values(0, '!Chromatic',
'Chromatic', null, null, null, null, null, null, null, null, null, null, null,
1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

insert into scales_v3 values(1, 'Major',
'Ionian', 'Dorian', 'Phrygian', 'Lydian', 'Mixolydian', 'Aeolian (Natural Minor)', 'Locrian', null, null, null, null, null,
2, 2, 1, 2, 2, 2, 1, null, null, null, null, null);

insert into scales_v3 values(2, 'Melodic Minor',
'Melodic Minor', 'Dorian b2', 'Lydian Augmented', 'Lydian Dominant', 'Mixolydian b6', 'Aeolian b5', 'Altered Scale', null, null, null, null, null,
2, 1, 2, 2, 2, 2, 1, null, null, null, null, null);

insert into scales_v3 values(3, 'Harmonic Minor',
'Harmonic Minor', 'Locrian #6', 'Ionian #5', 'Dorian #4', 'Phrygian Dominant', 'Lydian #2', 'Superlocrian', null, null, null, null, null,
2, 1, 2, 2, 1, 3, 1, null, null, null, null, null);

insert into scales_v3 values(4, 'Blues (Hexatonic)',
'Major', null, null, null, null, 'Minor', null, null, null, null, null, null,
2, 1, 1, 3, 2, 3, null, null, null, null, null, null);

insert into scales_v3 values(5, 'Pentatonic',
'Major', null, null, null, 'Minor', null, null, null, null, null, null, null,
2, 2, 3, 2, 3, null, null, null, null, null, null, null);
