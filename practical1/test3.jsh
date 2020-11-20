/open Instructor.java
/open Lesson.java
/open Lecture.java
/open Tutorial.java
Lecture hchia_L = new Lecture("CS2030", 1, "LT19", new Instructor("hchia"), 10)
hchia_L.clashWith(hchia_L)
hchia_L.clashWith(new Lecture("CS2030", 1, "LT19", new Instructor("hchia"), 10))
hchia_L.clashWith(new Lecture("CS2030", 1, "LT19", new Instructor("tsim"), 11))
hchia_L.clashWith(new Lecture("CS2030", 1, "LT19", new Instructor("hchia"), 12))
hchia_L.clashWith(new Lecture("CS2040", 1, "LT19", new Instructor("tanst"), 10))
Tutorial tsim_T = new Tutorial("CS2030", 1, "SR7", new Instructor("tsim"), 10)
tsim_T.clashWith(tsim_T)
tsim_T.clashWith(hchia_L)
hchia_L.clashWith(tsim_T)
tsim_T.clashWith(new Tutorial("CS2030", 2, "SR8", new Instructor("ehan"), 10))
tsim_T.clashWith(new Tutorial("CS2030", 2, "SR7", new Instructor("ehan"), 10))
tsim_T.clashWith(new Tutorial("CS2030", 2, "SR8", new Instructor("tsim"), 10))
tsim_T.clashWith(new Tutorial("CS2040", 2, "SR8", new Instructor("tsim"), 10))
/exit
