create table licks
(
    id                number not null,
    lickVersion       number not null,
    name              varchar(64) not null,
    --measure 0
    measure0noteCount number not null,
    measure0note0     varchar(3),
    measure0note1     varchar(3),
    measure0note2     varchar(3),
    measure0note3     varchar(3),
    measure0note4     varchar(3),
    measure0note5     varchar(3),
    measure0note6     varchar(3),
    measure0note7     varchar(3),
    --measure 1
    measure1noteCount number not null,
    measure1note0     varchar(3),
    measure1note1     varchar(3),
    measure1note2     varchar(3),
    measure1note3     varchar(3),
    measure1note4     varchar(3),
    measure1note5     varchar(3),
    measure1note6     varchar(3),
    measure1note7     varchar(3),
    --measure 2
    measure2noteCount number not null,
    measure2note0     varchar(3),
    measure2note1     varchar(3),
    measure2note2     varchar(3),
    measure2note3     varchar(3),
    measure2note4     varchar(3),
    measure2note5     varchar(3),
    measure2note6     varchar(3),
    measure2note7     varchar(3),
    --measure 3
    measure3noteCount number not null,
    measure3note0     varchar(3),
    measure3note1     varchar(3),
    measure3note2     varchar(3),
    measure3note3     varchar(3),
    measure3note4     varchar(3),
    measure3note5     varchar(3),
    measure3note6     varchar(3),
    measure3note7     varchar(3),
    --measure 4
    measure4noteCount number not null,
    measure4note0     varchar(3),
    measure4note1     varchar(3),
    measure4note2     varchar(3),
    measure4note3     varchar(3),
    measure4note4     varchar(3),
    measure4note5     varchar(3),
    measure4note6     varchar(3),
    measure4note7     varchar(3),
    --measure 5
    measure5noteCount number not null,
    measure5note0     varchar(3),
    measure5note1     varchar(3),
    measure5note2     varchar(3),
    measure5note3     varchar(3),
    measure5note4     varchar(3),
    measure5note5     varchar(3),
    measure5note6     varchar(3),
    measure5note7     varchar(3),
    --measure 6
    measure6noteCount number not null,
    measure6note0     varchar(3),
    measure6note1     varchar(3),
    measure6note2     varchar(3),
    measure6note3     varchar(3),
    measure6note4     varchar(3),
    measure6note5     varchar(3),
    measure6note6     varchar(3),
    measure6note7     varchar(3),
    --measure 7
    measure7noteCount number not null,
    measure7note0     varchar(3),
    measure7note1     varchar(3),
    measure7note2     varchar(3),
    measure7note3     varchar(3),
    measure7note4     varchar(3),
    measure7note5     varchar(3),
    measure7note6     varchar(3),
    measure7note7     varchar(3),
    constraint PK_LICKS primary key (id)
);

delete from licks where id = 0;

//--G|-----------------|-----------------|-----------------|-----------------|
//--D|-----------------|-----------------|-----------------|-----------------|
//--A|-----------------|-----------------|-----------------|-----------------|
//--E|-----------------|-----------------|-----------------|-----------------|

insert into licks values
(
    0,--id
    0,--lick version
    '!Empty', --name
    ----measure 0
    8,   --measure0noteCount
    '',--measure0note0
    '',  --measure0note1
    '',  --measure0note2
    '',--measure0note3
    '',--measure0note4
    '',  --measure0note5
    '',  --measure0note6
    '',--measure0note7
    ----measure 1
    8,--measure1noteCount
    '',--measure1note0
    '',--measure1note1
    '',--measure1note2
    '',--measure1note3
    '',--measure1note4
    '',--measure1note5
    '',--measure1note6
    '',--measure1note7
    ----measure 2
    8,--measure2noteCount
    '',--measure2note0
    '',--measure2note1
    '',--measure2note2
    '',--measure2note3
    '',--measure2note4
    '',--measure2note5
    '',--measure2note6
    '',--measure2note7
    ----measure 3
    8,--measure3noteCount
    '',--measure3note0
    '',--measure3note1
    '',--measure3note2
    '',--measure3note3
    '',--measure3note4
    '',--measure3note5
    '',--measure3note6
    '',--measure3note7
    ----measure 4
    0,--measure4noteCount
    '',--measure4note0
    '',--measure4note1
    '',--measure4note2
    '',--measure4note3
    '',--measure4note4
    '',--measure4note5
    '',--measure4note6
    '',--measure4note7
    ----measure 5
    0,--measure5noteCount
    '',--measure5note0
    '',--measure5note1
    '',--measure5note2
    '',--measure5note3
    '',--measure5note4
    '',--measure5note5
    '',--measure5note6
    '',--measure5note7
    ----measure 6
    0,--measure6noteCount
    '',--measure6note0
    '',--measure6note1
    '',--measure6note2
    '',--measure6note3
    '',--measure6note4
    '',--measure6note5
    '',--measure6note6
    '',--measure6note7
    ----measure 7
    0,--measure7noteCount
    '',--measure7note0
    '',--measure7note1
    '',--measure7note2
    '',--measure7note3
    '',--measure7note4
    '',--measure7note5
    '',--measure7note6
    ''--measure7note7
);

//--G|-----------------|-----------------|-----------------|-----------------|
//--D|-----------------|-2-----2---------|-----------------|-2-----2-5-4-2-0-|
//--A|-3-----3-5-----5-|---------5-----5-|-3-----3-5-----5-|-----------------|
//--E|-----------------|-----------------|-----------------|-----------------|

insert into licks values
(
    1,--id
    0,--lick version
    'Gin Blossoms - Found Out About You', --name
    ----measure 0
    4,   --measure0noteCount
    'A3',--measure0note0
    '',  --measure0note1
    '',  --measure0note2
    'A3',--measure0note3
    'A5',--measure0note4
    '',  --measure0note5
    '',  --measure0note6
    'A5',--measure0note7
    ----measure 1
    4,--measure1noteCount
    'D2',--measure1note0
    '',--measure1note1
    '',--measure1note2
    'D2',--measure1note3
    'A5',--measure1note4
    '',--measure1note5
    '',--measure1note6
    'A5',--measure1note7
    ----measure 2
    4,--measure2noteCount
    'A3',--measure2note0
    '',--measure2note1
    '',--measure2note2
    'A3',--measure2note3
    'A5',--measure2note4
    '',--measure2note5
    '',--measure2note6
    'A5',--measure2note7
    ----measure 3
    4,--measure3noteCount
    'D2',--measure3note0
    '',--measure3note1
    '',--measure3note2
    'D2',--measure3note3
    'D5',--measure3note4
    'D4',--measure3note5
    'D2',--measure3note6
    'D0',--measure3note7
    ----measure 4
    0,--measure4noteCount
    '',--measure4note0
    '',--measure4note1
    '',--measure4note2
    '',--measure4note3
    '',--measure4note4
    '',--measure4note5
    '',--measure4note6
    '',--measure4note7
    ----measure 5
    0,--measure5noteCount
    '',--measure5note0
    '',--measure5note1
    '',--measure5note2
    '',--measure5note3
    '',--measure5note4
    '',--measure5note5
    '',--measure5note6
    '',--measure5note7
    ----measure 6
    0,--measure6noteCount
    '',--measure6note0
    '',--measure6note1
    '',--measure6note2
    '',--measure6note3
    '',--measure6note4
    '',--measure6note5
    '',--measure6note6
    '',--measure6note7
    ----measure 7
    0,--measure7noteCount
    '',--measure7note0
    '',--measure7note1
    '',--measure7note2
    '',--measure7note3
    '',--measure7note4
    '',--measure7note5
    '',--measure7note6
    ''--measure7note7
);

//G---------------------------------------------------
//D---------------------------------------------------
//A----------666-444---------444-666---------888-666--
//E--444-444---------444-444---------444-444----------

insert into licks values
(
    2,--id
    0,--lick version
    'Offspring, The - Spare me the Details', --name
    ----measure 0
    6,   --measure0noteCount
    '',--measure0note0
    'E4',  --measure0note1
    'E4',  --measure0note2
    'E4',--measure0note3
    '',--measure0note4
    'E4',  --measure0note5
    'E4',  --measure0note6
    'E4',--measure0note7
    ----measure 1
    6,--measure1noteCount
    '',--measure1note0
    'A6',--measure1note1
    'A6',--measure1note2
    'A6',--measure1note3
    '',--measure1note4
    'A4',--measure1note5
    'A4',--measure1note6
    'A4',--measure1note7
    ----measure 2
    6,--measure2noteCount
    '',--measure2note0
    'E4',--measure2note1
    'E4',--measure2note2
    'E4',--measure2note3
    '',--measure2note4
    'E4',--measure2note5
    'E4',--measure2note6
    'E4',--measure2note7
    ----measure 3
    6,--measure3noteCount
    '',--measure3note0
    'A4',--measure3note1
    'A4',--measure3note2
    'A4',--measure3note3
    '',--measure3note4
    'A6',--measure3note5
    'A6',--measure3note6
    'A6',--measure3note7
    ----measure 4
    6,--measure4noteCount
    '',--measure4note0
    'E4',--measure4note1
    'E4',--measure4note2
    'E4',--measure4note3
    '',--measure4note4
    'E4',--measure4note5
    'E4',--measure4note6
    'E4',--measure4note7
    ----measure 5
    6,--measure5noteCount
    '',--measure5note0
    'A8',--measure5note1
    'A8',--measure5note2
    'A8',--measure5note3
    '',--measure5note4
    'A6',--measure5note5
    'A6',--measure5note6
    'A6',--measure5note7
    ----measure 6
    0,--measure6noteCount
    '',--measure6note0
    '',--measure6note1
    '',--measure6note2
    '',--measure6note3
    '',--measure6note4
    '',--measure6note5
    '',--measure6note6
    '',--measure6note7
    ----measure 7
    0,--measure7noteCount
    '',--measure7note0
    '',--measure7note1
    '',--measure7note2
    '',--measure7note3
    '',--measure7note4
    '',--measure7note5
    '',--measure7note6
    ''--measure7note7
);

--rush - limelight
//--G|-----4-----2-----|---------------4-|-----------------|-----------------|
//--D|---4-----2-------|-------------4---|-----------------|-----------------|
//--A|-2-----0---------|---0-2-4-0-2-----|-----------------|-----------------|
//--E|-------------0-2-|-4---------------|-----------------|-----------------|

insert into licks values
(
    3,--id
    0,--lick version
    'Rush - Limelight', --name
    ----measure 0
    8,   --measure0noteCount
    'A2',--measure0note0
    'D4',  --measure0note1
    'G4',  --measure0note2
    'A0',--measure0note3
    'D2',--measure0note4
    'G2',  --measure0note5
    'E0',  --measure0note6
    'E2',--measure0note7
    ----measure 1
    8,--measure1noteCount
    'E4',--measure1note0
    'A0',--measure1note1
    'A2',--measure1note2
    'A4',--measure1note3
    'A0',--measure1note4
    'A2',--measure1note5
    'D4',--measure1note6
    'G4',--measure1note7
    ----measure 2
    0,--measure2noteCount
    '',--measure2note0
    '',--measure2note1
    '',--measure2note2
    '',--measure2note3
    '',--measure2note4
    '',--measure2note5
    '',--measure2note6
    '',--measure2note7
    ----measure 3
    0,--measure3noteCount
    '',--measure3note0
    '',--measure3note1
    '',--measure3note2
    '',--measure3note3
    '',--measure3note4
    '',--measure3note5
    '',--measure3note6
    '',--measure3note7
    ----measure 4
    0,--measure4noteCount
    '',--measure4note0
    '',--measure4note1
    '',--measure4note2
    '',--measure4note3
    '',--measure4note4
    '',--measure4note5
    '',--measure4note6
    '',--measure4note7
    ----measure 5
    0,--measure5noteCount
    '',--measure5note0
    '',--measure5note1
    '',--measure5note2
    '',--measure5note3
    '',--measure5note4
    '',--measure5note5
    '',--measure5note6
    '',--measure5note7
    ----measure 6
    0,--measure6noteCount
    '',--measure6note0
    '',--measure6note1
    '',--measure6note2
    '',--measure6note3
    '',--measure6note4
    '',--measure6note5
    '',--measure6note6
    '',--measure6note7
    ----measure 7
    0,--measure7noteCount
    '',--measure7note0
    '',--measure7note1
    '',--measure7note2
    '',--measure7note3
    '',--measure7note4
    '',--measure7note5
    '',--measure7note6
    ''--measure7note7
);

--offspring - want you bad (timing)
//--G|-----------------|-----------------|-----------------|-----------------|
//--D|-----------------|-----------------|-----------------|-----------------|
//--A|-7---7-7---------|-----------------|-7-7-7-7---------|-----------------|
//--E|---------7---7-7-|-5---5---9---7---|---------7---7-7-|-5---5---9---7---|

insert into licks values
(
    4,--id
    0,--lick version
    'Offspring, The - Want You Bad', --name
    ----measure 0
    6,   --measure0noteCount
    'A7',--measure0note0
    '',  --measure0note1
    'A7',  --measure0note2
    'A7',--measure0note3
    'E7',--measure0note4
    '',  --measure0note5
    'E7',  --measure0note6
    'E7',--measure0note7
    ----measure 1
    4,--measure1noteCount
    'E5',--measure1note0
    '',--measure1note1
    'E5',--measure1note2
    '',--measure1note3
    'E9',--measure1note4
    '',--measure1note5
    'E7',--measure1note6
    '',--measure1note7
    ----measure 2
    7,--measure2noteCount
    'A7',--measure2note0
    'A7',--measure2note1
    'A7',--measure2note2
    'A7',--measure2note3
    'E7',--measure2note4
    '',--measure2note5
    'E7',--measure2note6
    'E7',--measure2note7
    ----measure 3
    4,--measure3noteCount
    'E5',--measure3note0
    '',--measure3note1
    'E5',--measure3note2
    '',--measure3note3
    'E9',--measure3note4
    '',--measure3note5
    'E7',--measure3note6
    '',--measure3note7
    ----measure 4
    0,--measure4noteCount
    '',--measure4note0
    '',--measure4note1
    '',--measure4note2
    '',--measure4note3
    '',--measure4note4
    '',--measure4note5
    '',--measure4note6
    '',--measure4note7
    ----measure 5
    0,--measure5noteCount
    '',--measure5note0
    '',--measure5note1
    '',--measure5note2
    '',--measure5note3
    '',--measure5note4
    '',--measure5note5
    '',--measure5note6
    '',--measure5note7
    ----measure 6
    0,--measure6noteCount
    '',--measure6note0
    '',--measure6note1
    '',--measure6note2
    '',--measure6note3
    '',--measure6note4
    '',--measure6note5
    '',--measure6note6
    '',--measure6note7
    ----measure 7
    0,--measure7noteCount
    '',--measure7note0
    '',--measure7note1
    '',--measure7note2
    '',--measure7note3
    '',--measure7note4
    '',--measure7note5
    '',--measure7note6
    ''--measure7note7
);

--fort minor - kenji
//--G|-----------------|-----------------|-----------------|-----------------|
//--D|-----------------|-----------------|-----------------|-----------------|
//--A|-----------------|-----------------|-6-6-6-6-4-4-4-4-|-9-9-8-8---------|
//--E|-6---6-6-7-6-4---|-6-6-6-6-7-6-4---|-----------------|-----------------|

insert into licks values
(
    5,--id
    0,--lick version
    'Fort Minor - Kenji', --name
    ----measure 0
    6,   --measure0noteCount
    'E6',--measure0note0
    '',  --measure0note1
    'E6',  --measure0note2
    'E6',--measure0note3
    'E7',--measure0note4
    'E6',  --measure0note5
    'E4',  --measure0note6
    '',--measure0note7
    ----measure 1
    7,--measure1noteCount
    'E6',--measure1note0
    'E6',--measure1note1
    'E6',--measure1note2
    'E6',--measure1note3
    'E7',--measure1note4
    'E6',--measure1note5
    'E4',--measure1note6
    '',--measure1note7
    ----measure 2
    8,--measure2noteCount
    'A6',--measure2note0
    'A6',--measure2note1
    'A6',--measure2note2
    'A6',--measure2note3
    'A4',--measure2note4
    'A4',--measure2note5
    'A4',--measure2note6
    'A4',--measure2note7
    ----measure 3
    4,--measure3noteCount
    'A9',--measure3note0
    'A9',--measure3note1
    'A8',--measure3note2
    'A8',--measure3note3
    '',--measure3note4
    '',--measure3note5
    '',--measure3note6
    '',--measure3note7
    ----measure 4
    0,--measure4noteCount
    '',--measure4note0
    '',--measure4note1
    '',--measure4note2
    '',--measure4note3
    '',--measure4note4
    '',--measure4note5
    '',--measure4note6
    '',--measure4note7
    ----measure 5
    0,--measure5noteCount
    '',--measure5note0
    '',--measure5note1
    '',--measure5note2
    '',--measure5note3
    '',--measure5note4
    '',--measure5note5
    '',--measure5note6
    '',--measure5note7
    ----measure 6
    0,--measure6noteCount
    '',--measure6note0
    '',--measure6note1
    '',--measure6note2
    '',--measure6note3
    '',--measure6note4
    '',--measure6note5
    '',--measure6note6
    '',--measure6note7
    ----measure 7
    0,--measure7noteCount
    '',--measure7note0
    '',--measure7note1
    '',--measure7note2
    '',--measure7note3
    '',--measure7note4
    '',--measure7note5
    '',--measure7note6
    ''--measure7note7
);

--offspring - vultures
//--G|-----------------|-----------------|-----------------|-----------------|
//--D|-----------------|-----------------|-0-0-0-0-3-3-3-3-|-2-2-2-----------|
//--A|-0-0-0-0-3-3-3-3-|-2-2-2-----------|-----------------|-------3-3-3-3-3-|
//--E|-----------------|-------0-0-0-0-0-|-----------------|-----------------|

//--G|-----------------|-1-1-1-1-1-1-1-1-|-----------------|-----------------|
//--D|-2-2-2-2-2-2-2-2-|-----------------|-----------------|-----------------|
//--A|-----------------|-----------------|-----------------|-----------------|
//--E|-----------------|-----------------|-----------------|-----------------|

insert into licks values
(
    6,--id
    0,--lick version
    'Offspring, The - Vultures', --name
    ----measure 0
    8,   --measure0noteCount
    'A0',--measure0note0
    'A0',  --measure0note1
    'A0',  --measure0note2
    'A0',--measure0note3
    'A3',--measure0note4
    'A3',  --measure0note5
    'A3',  --measure0note6
    'A3',--measure0note7
    ----measure 1
    8,--measure1noteCount
    'A2',--measure1note0
    'A2',--measure1note1
    'A2',--measure1note2
    'E0',--measure1note3
    'E0',--measure1note4
    'E0',--measure1note5
    'E0',--measure1note6
    'E0',--measure1note7
    ----measure 2
    8,--measure2noteCount
    'D0',--measure2note0
    'D0',--measure2note1
    'D0',--measure2note2
    'D0',--measure2note3
    'D3',--measure2note4
    'D3',--measure2note5
    'D3',--measure2note6
    'D3',--measure2note7
    ----measure 3
    8,--measure3noteCount
    'D2',--measure3note0
    'D2',--measure3note1
    'D2',--measure3note2
    'A3',--measure3note3
    'A3',--measure3note4
    'A3',--measure3note5
    'A3',--measure3note6
    'A3',--measure3note7
    ----measure 4
    8,--measure4noteCount
    'D2',--measure4note0
    'D2',--measure4note1
    'D2',--measure4note2
    'D2',--measure4note3
    'D2',--measure4note4
    'D2',--measure4note5
    'D2',--measure4note6
    'D2',--measure4note7
    ----measure 5
    8,--measure5noteCount
    'G1',--measure5note0
    'G1',--measure5note1
    'G1',--measure5note2
    'G1',--measure5note3
    'G1',--measure5note4
    'G1',--measure5note5
    'G1',--measure5note6
    'G1',--measure5note7
    ----measure 6
    0,--measure6noteCount
    '',--measure6note0
    '',--measure6note1
    '',--measure6note2
    '',--measure6note3
    '',--measure6note4
    '',--measure6note5
    '',--measure6note6
    '',--measure6note7
    ----measure 7
    0,--measure7noteCount
    '',--measure7note0
    '',--measure7note1
    '',--measure7note2
    '',--measure7note3
    '',--measure7note4
    '',--measure7note5
    '',--measure7note6
    ''--measure7note7
);

--green day - x-kid
//--G|-----------------|-----------------|-----------------|-----------------|
//--D|-----------------|-----------------|-----------------|-----------------|
//--A|-7---7-7-4---4-7-|-2---2-2-0---0-0-|---------2---2-2-|-4---4-4-0---0-0-|
//--E|-----------------|-----------------|-0---0-0---------|-----------------|

E, C#, B, A

n: A, B, C#, E
i: 0, 2, 2, 3

n: B, C#, E, A
i: 0, 2, 3, 5

n: C#, E, A, B
i: 0, 3, 5, 2

n: E, A, B, C#
i: 0, 5, 2, 2

insert into licks values
(
    7,--id
    0,--lick version
    'Green Day - X-Kid', --name
    ----measure 0
    6,   --measure0noteCount
    'A7',--measure0note0
    '',  --measure0note1
    'A7',  --measure0note2
    'A7',--measure0note3
    'A4',--measure0note4
    '',  --measure0note5
    'A4',  --measure0note6
    'A7',--measure0note7
    ----measure 1
    6,--measure1noteCount
    'A2',--measure1note0
    '',--measure1note1
    'A2',--measure1note2
    'A2',--measure1note3
    'A0',--measure1note4
    '',--measure1note5
    'A0',--measure1note6
    'A0',--measure1note7
    ----measure 2
    6,--measure2noteCount
    'E0',--measure2note0
    '',--measure2note1
    'E0',--measure2note2
    'E0',--measure2note3
    'A2',--measure2note4
    '',--measure2note5
    'A2',--measure2note6
    'A2',--measure2note7
    ----measure 3
    6,--measure3noteCount
    'A4',--measure3note0
    '',--measure3note1
    'A4',--measure3note2
    'A4',--measure3note3
    'A0',--measure3note4
    '',--measure3note5
    'A0',--measure3note6
    'A0',--measure3note7
    ----measure 4
    0,--measure4noteCount
    '',--measure4note0
    '',--measure4note1
    '',--measure4note2
    '',--measure4note3
    '',--measure4note4
    '',--measure4note5
    '',--measure4note6
    '',--measure4note7
    ----measure 5
    0,--measure5noteCount
    '',--measure5note0
    '',--measure5note1
    '',--measure5note2
    '',--measure5note3
    '',--measure5note4
    '',--measure5note5
    '',--measure5note6
    '',--measure5note7
    ----measure 6
    0,--measure6noteCount
    '',--measure6note0
    '',--measure6note1
    '',--measure6note2
    '',--measure6note3
    '',--measure6note4
    '',--measure6note5
    '',--measure6note6
    '',--measure6note7
    ----measure 7
    0,--measure7noteCount
    '',--measure7note0
    '',--measure7note1
    '',--measure7note2
    '',--measure7note3
    '',--measure7note4
    '',--measure7note5
    '',--measure7note6
    ''--measure7note7
);

--seether - fine again (timinh)
//--G|-----------------|-----------------|-----------------|-----------------|
//--D|-----------------|-----------------|-----------------|-----------------|
//--A|---------0-0-0---|-----------------|-------------0-0-|-0---------------|
//--E|-2---2-2---------|-----------------|-0-----0---0-----|-----------------|

--blink 182 - whats my age again?
//--G|-----------------|-----------------|-----------------|-----------------|
//--D|-----------------|-----------------|---4-------------|-----------------|
//--A|-2-2-2-2---------|-4-4-4-4-6-6-6-6-|-4-------4-4-----|-6-6-----2-2-2-2-|
//--E|---------2-2-2-2-|-----------------|-----------------|-----------------|

--tommy tutone - 867-5309 (timing)
//--G|-----------------|-----------------|-----------------|-----------------|
//--D|-----------------|-----------------|-----------------|-----------------|
//--A|-------5-5-------|-----2-2---------|-------5-5-------|-----2-2-4-0-----|
//--E|-2-------------5-|-5-------------2-|-2-------------5-|-5-------------2-|

--kansas - carry on wayward son (timing)
//--G|-----------------|-----------------|-----------------|-----------------|--
//--D|-----------------|-----------------|-----------------|---------5-------|--
//--A|-0-0-------------|-0-0-------------|-3-5-5-3-3-1-1-3-|-5-5-3-3---5-----|--
//--E|-----3-3-1-1-3-3-|-----3-3-1-1-3-5-|-----------------|-------------3-3-|-1


--=========================================================

//--G|-----------------|-----------------|-----------------|-----------------|
//--D|-----------------|-----------------|-----------------|-----------------|
//--A|-----------------|-----------------|-----------------|-----------------|
//--E|-----------------|-----------------|-----------------|-----------------|

insert into licks values
(
    0,--id
    0,--lick version
    'test lick', --name
    ----measure 0
    4,   --measure0noteCount
    '',--measure0note0
    '',  --measure0note1
    '',  --measure0note2
    '',--measure0note3
    '',--measure0note4
    '',  --measure0note5
    '',  --measure0note6
    '',--measure0note7
    ----measure 1
    4,--measure1noteCount
    '',--measure1note0
    '',--measure1note1
    '',--measure1note2
    '',--measure1note3
    '',--measure1note4
    '',--measure1note5
    '',--measure1note6
    '',--measure1note7
    ----measure 2
    4,--measure2noteCount
    '',--measure2note0
    '',--measure2note1
    '',--measure2note2
    '',--measure2note3
    '',--measure2note4
    '',--measure2note5
    '',--measure2note6
    '',--measure2note7
    ----measure 3
    4,--measure3noteCount
    '',--measure3note0
    '',--measure3note1
    '',--measure3note2
    '',--measure3note3
    '',--measure3note4
    '',--measure3note5
    '',--measure3note6
    '',--measure3note7
    ----measure 4
    0,--measure4noteCount
    '',--measure4note0
    '',--measure4note1
    '',--measure4note2
    '',--measure4note3
    '',--measure4note4
    '',--measure4note5
    '',--measure4note6
    '',--measure4note7
    ----measure 5
    0,--measure5noteCount
    '',--measure5note0
    '',--measure5note1
    '',--measure5note2
    '',--measure5note3
    '',--measure5note4
    '',--measure5note5
    '',--measure5note6
    '',--measure5note7
    ----measure 6
    0,--measure6noteCount
    '',--measure6note0
    '',--measure6note1
    '',--measure6note2
    '',--measure6note3
    '',--measure6note4
    '',--measure6note5
    '',--measure6note6
    '',--measure6note7
    ----measure 7
    0,--measure7noteCount
    '',--measure7note0
    '',--measure7note1
    '',--measure7note2
    '',--measure7note3
    '',--measure7note4
    '',--measure7note5
    '',--measure7note6
    ''--measure7note7
);
