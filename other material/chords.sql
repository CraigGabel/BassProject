create table chords
(
    id              number      not null,
    name            varchar(32) not null,
    symbol          varchar(16) not null,
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
    majorSeventh    number      not null, --M7
    constraint PK_CHORDS primary key (id)
);

Major (M) (ma) (maj):            r, M3, P5
Minor (m) (min) (-):             r, m3, P5
Augmented (+) (aug):             r, M3, m6
Flat Five (b5):                  r, M3, A4
Diminished (°) (dim):            r, m3, A4
Suspended (sus4) (sus.):         r, P4, P5
Sus 2:                           r, M2, P5
Major sixth (sixth) (6) (M6):    r, M3, P5, M6
Minor sixth (m6):                r, m3, P5, M6
Seventh (dominant seventh) (7):  r, M3, P5, m7
Major seventh (M7) (∆7):         r, M3, P5, M7
Minor seventh (m7) (-7):         r, m3, P5, m7
Augmented seventh (+7) (7+5):    r, M3, m6, m7
Diminished seventh (dim 7) (°7): r, m3, A4, M6
Seventh flat five (7b5):         r, M3, A4, m7
Minor seven flat five (m7b5):    r, m3, A4, m7
Ninth (dominant ninth)(9):       r, M3, P5, m7, M2
Major ninth (M9):                r, M3, P5, M7, M2
Minor ninth (m9):                r, m3, P5, m7, M2
Add nine (add9):                 r, M3, P5, M2
Eleventh (11):                   r, M3, P5, M7, M2, P4
Thirteenth (13):                 r, M3, P5, M7, M2, P4, M6

insert into chords values(0, 'Major', 'maj',                     1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0);
insert into chords values(1, 'Minor', 'min',                     1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0);
insert into chords values(2, 'Augmented', 'aug',                 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0);
insert into chords values(3, 'Flat Five', 'b5',                  1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0);
insert into chords values(4, 'Diminished', 'dim',                1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0);
insert into chords values(5, 'Suspended', 'sus4',                1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0);
insert into chords values(6, 'Suspended Second', 'sus2',         1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0);
insert into chords values(7, 'Major Sixth', 'M6',                1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0);
insert into chords values(8, 'Minor Sixth', 'm6',                1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0);
insert into chords values(9, 'Seventh', '7',                     1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0);
insert into chords values(10, 'Major Seventh', '∆7',             1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1);
insert into chords values(11, 'Minor Seventh', '-7',             1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0);
insert into chords values(12, 'Augmented Seventh', '7+5',        1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0);
insert into chords values(13, 'Diminished Seventh', '°7',        1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0);
insert into chords values(14, 'Seventh Flat Five', '7b5',        1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0);
insert into chords values(15, 'Minor Seventh Flat Five', 'm7b5', 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0);
insert into chords values(16, 'Ninth', '9',                      1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0);
insert into chords values(17, 'Major Ninth', 'M9',               1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1);
insert into chords values(18, 'Minor Ninth', 'm9',               1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0);
insert into chords values(19, 'Add Nine', 'add9',                1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0);
insert into chords values(20, 'Eleventh', '11',                  1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1);
insert into chords values(21, 'Thirteenth', '13',                1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1);

create table chords
(
    id              number      not null,
    name            varchar(32) not null,
    symbol          varchar(16) not null,
    interval1       number,
    interval2       number,
    interval3       number,
    interval4       number,
    interval5       number,
    interval6       number,
    constraint PK_CHORDS primary key (id)
);

insert into chords values(0, 'Major', 'maj',                     4, 3, null, null, null, null);
insert into chords values(1, 'Minor', 'min',                     3, 4, null, null, null, null);
insert into chords values(2, 'Augmented', 'aug',                 4, 4, null, null, null, null);
insert into chords values(3, 'Flat Five', 'b5',                  4, 2, null, null, null, null);
insert into chords values(4, 'Diminished', 'dim',                3, 3, null, null, null, null);
insert into chords values(5, 'Suspended', 'sus4',                5, 2, null, null, null, null);
insert into chords values(6, 'Suspended Second', 'sus2',         2, 5, null, null, null, null);
insert into chords values(7, 'Major Sixth', 'M6',                4, 3, 2, null, null, null);
insert into chords values(8, 'Minor Sixth', 'm6',                3, 4, 2, null, null, null);
insert into chords values(9, 'Seventh', '7',                     4, 3, 3, null, null, null);
insert into chords values(10, 'Major Seventh', '∆7',             4, 3, 4, null, null, null);
insert into chords values(11, 'Minor Seventh', '-7',             3, 4, 3, null, null, null);
insert into chords values(12, 'Augmented Seventh', '7+5',        4, 4, 2, null, null, null);
insert into chords values(13, 'Diminished Seventh', '°7',        3, 3, 3, null, null, null);
insert into chords values(14, 'Seventh Flat Five', '7b5',        4, 2, 4, null, null, null);
insert into chords values(15, 'Minor Seventh Flat Five', 'm7b5', 3, 3, 4, null, null, null);
insert into chords values(16, 'Ninth', '9',                      4, 3, 3, 4, null, null);
insert into chords values(17, 'Major Ninth', 'M9',               4, 3, 4, 3, null, null);
insert into chords values(18, 'Minor Ninth', 'm9',               3, 4, 3, 4, null, null);
insert into chords values(19, 'Add Nine', 'add9',                4, 3, 7, null, null, null);
insert into chords values(20, 'Eleventh', '11',                  4, 3, 4, 3, 3, null);
insert into chords values(21, 'Thirteenth', '13',                4, 3, 4, 3, 3, 4);

Major (M) (ma) (maj):            r, 4, 3
                                 r, M3, P5
Minor (m) (min) (-):             r, 3, 4
                                 r, m3, P5
Augmented (+) (aug):             r, 4, 4
                                 r, M3, m6
Flat Five (b5):                  r, 4, 2
                                 r, M3, A4
Diminished (°) (dim):            r, 3, 3
                                 r, m3, A4
Suspended (sus4) (sus.):         r, 5, 2
                                 r, P4, P5
Sus 2:                           r, 2, 5
                                 r, M2, P5
Major sixth (sixth) (6) (M6):    r, 4, 3, 2
                                 r, M3, P5, M6
Minor sixth (m6):                r, 3, 4, 2
                                 r, m3, P5, M6
Seventh (dominant seventh) (7):  r, 4, 3, 3
                                 r, M3, P5, m7
Major seventh (M7) (∆7):         r, 4, 3, 4
                                 r, M3, P5, M7
Minor seventh (m7) (-7):         r, 3, 4, 3
                                 r, m3, P5, m7
Augmented seventh (+7) (7+5):    r, 4, 4, 2
                                 r, M3, m6, m7
Diminished seventh (dim 7) (°7): r, 3, 3, 3
                                 r, m3, A4, M6
Seventh flat five (7b5):         r, 4, 2, 4
                                 r, M3, A4, m7
Minor seven flat five (m7b5):    r, 3, 3, 4
                                 r, m3, A4, m7
Ninth (dominant ninth)(9):       r, 4, 3, 3, 4
                                 r, M3, P5, m7, M2
Major ninth (M9):                r, 4, 3, 4, 3
                                 r, M3, P5, M7, M2
Minor ninth (m9):                r, 3, 4, 3, 4
                                 r, m3, P5, m7, M2
Add nine (add9):                 r, 4, 3, 7
                                 r, M3, P5, M2
Eleventh (11):                   r, 4, 3, 4, 3, 3
                                 r, M3, P5, M7, M2, P4
Thirteenth (13):                 r, 4, 3, 4, 3, 3, 4
                                 r, M3, P5, M7, M2, P4, M6

