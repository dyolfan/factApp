package com.colors.student.factsapp.databases;

import com.colors.student.factsapp.databases.Fact;

import java.sql.SQLException;

/**
 * Created by kirils on 14.02.18.
 */

public class FactController{
    public FactList factList = new FactList();
    int rating = 0;

    //Animal facts
    Fact fact1 = new Fact(1, "TRAINED PIGEONS CAN TELL THE DIFFERENCE BETWEEN THE PAINTINGS OF PABLO PICASSO AND CLAUDE MONET.", rating);
    Fact fact2 = new Fact(2, "STUDIES HAVE SHOWN THAT WILD CHIMPS IN GUINEA DRINK FERMENTED PALM SAP, WHICH CONTAINS ABOUT 3 PERCENT ALCOHOL BY VOLUME.", rating);
    Fact fact3 = new Fact(3, "CAPUCHIN MONKEYS PEE ON THEIR HANDS TO WASH THEIR FEET.", rating);
    Fact fact4 = new Fact(4, "TIGERS HAVE STRIPED SKIN AS WELL. EACH PATTERN IS AS UNIQUE AS A FINGERPRINT.", rating);
    Fact fact5 = new Fact(5, "SEA OTTERS HOLD HANDS WHILE THEY'RE SLEEPING SO THEY DON'T DRIFT APART.", rating);
    Fact fact6 = new Fact(6, "CATS DON'T MEOW AS A WAY TO COMMUNICATE WITH EACH OTHER. THEY USE IT FOR GETTING ATTENTION FROM HUMANS.", rating);
    Fact fact7 = new Fact(7, "FLAMINGOS ARE NATURALLY WHITE—THEIR DIET OF BRINE SHRIMP AND ALGAE TURNS THEM PINK.", rating);
    Fact fact8 = new Fact(8, "ALBERTA, CANADA IS THE LARGEST RAT-FREE POPULATED AREA IN THE WORLD.", rating);
    Fact fact9 = new Fact(9, "IN THE UK, THE BRITISH MONARCH LEGALLY OWNS ALL UNMARKED MUTE SWANS IN OPEN WATER.", rating);
    Fact fact10 = new Fact(10, "ANTEATERS DON’T HAVE TEETH.", rating);
    Fact fact11 = new Fact(11, "MALE RING-TAILED LEMURS WILL \"STINK FIGHT\" BY WAFTING SCENT AT EACH OTHER.", rating);
    Fact fact12= new Fact(12, "IN 1924, A LABRADOR RETRIEVER WAS SENTENCED TO LIFE WITHOUT PAROLE AT EASTERN STATE PENITENTIARY FOR KILLING THE GOVERNOR'S CAT.", rating);
    Fact fact13 = new Fact(13, "NINE-BANDED ARMADILLOS ALWAYS GIVE BIRTH TO IDENTICAL QUADRUPLETS.", rating);
    Fact fact14 = new Fact(14, "CATS CAN'T TASTE SUGAR. THEY DON'T HAVE SWEET TASTE BUDS.", rating);
    Fact fact15= new Fact(15, "DUCKS LIKE TO SURF. THEY HAVE BEEN OBSERVED RIDING TIDES AND SWIMMING BACK TO RIDE THEM AGAIN.", rating);
    Fact fact16= new Fact(16, "BIRDS ARE IMMUNE TO THE HEAT OF CHILI PEPPERS.", rating);
    Fact fact17= new Fact(17, "CARIBBEAN SPERM WHALES HAVE THEIR OWN REGIONAL ACCENT.", rating);
    Fact fact18= new Fact(18, "WOMBAT POOP IS CUBE-SHAPED.", rating);
    Fact fact19= new Fact(19, "LIONS INHABITED MANY AREAS OF EUROPE UNTIL THEY WERE HUNTED TO EXTINCTION IN THE REGION AROUND 100 BCE.", rating);
    Fact fact20= new Fact(20, "THE OTTOMAN EMPIRE'S SULTAN IBRAHIM I HAD 280 OF HIS CONCUBINES DROWNED IN THE OCEAN AFTER ONE OF THEM SLEPT WITH ANOTHER MAN.", rating);

    // History facts
    Fact fact21= new Fact(1, "THE OTTOMAN EMPIRE'S SULTAN IBRAHIM I HAD 280 OF HIS CONCUBINES DROWNED IN THE OCEAN AFTER ONE OF THEM SLEPT WITH ANOTHER MAN.", rating);
    Fact fact22= new Fact(2, "IN MEDIEVAL TIMES PEOPLE WERE PUT TO DEATH FOR BEING WITCHES. ONE ANTHROPOLOGIST CONJECTURES AS MANY AS 600,000 \"WITCHES\" LOST THEIR LIVES.", rating);
    Fact fact23= new Fact(3, "MEXICAN GENERAL SANTA ANNA HAD AN ELABORATE STATE FUNERAL FOR HIS AMPUTATED LEG.", rating);
    Fact fact24= new Fact(4, "TENS OF THOUSANDS OF BABY GIRLS WERE ABANDONED EACH YEAR IN CHINA BECAUSE OF THE COUNTRY'S ONE-CHILD POLICY.", rating);
    Fact fact25= new Fact(5, "ROMAN EMPEROR GAIUS MADE HIS BELOVED HORSE A SENATOR.", rating);
    Fact fact26= new Fact(6, "ICE AGE BRITONS USED SKULLS OF THE DEAD AS CUPS.", rating);
    Fact fact27= new Fact(7, "IN CHERNOBYL THE RADIATION WAS SO INTENSIVE THAT THE EYES OF A FIREFIGHTER TURNED FROM BROWN TO BLUE.", rating);
    Fact fact28= new Fact(8, "THE MAYANS ALSO MADE SACRIFICES. THE MOST COMMON INVOLVED PULLING A STILL-BEATING HEART OUT OF A VICTIM'S CHEST.", rating);
    Fact fact29= new Fact(9, "N ANCIENT EGYPT, SERVANTS WERE SMEARED WITH HONEY IN ORDER TO ATTRACT FLIES AWAY FROM THE PHARAOH.", rating);
    Fact fact30= new Fact(10, "UPON DYING, SOME PHARAOHS WERE SEALED INTO THEIR TOMBS ALONGSIDE THEIR LIVING SERVANTS, PETS, AND CONCUBINES.", rating);
    Fact fact31= new Fact(11, "BEFORE THE MID-19TH CENTURY DENTURES WERE COMMONLY MADE WITH TEETH PULLED FROM THE MOUTHS OF DEAD SOLDIERS.", rating);
    Fact fact32= new Fact(12, "THE ANGLO-ZANZIBAR WAR OF 1896 IS THE SHORTEST WAR ON RECORD LASTING AN EXHAUSTING 38 MINUTES.", rating);
    Fact fact33= new Fact(13, "IN 1788 THE AUSTRIAN ARMY ATTACKED ITSELF AND LOST 10,000 MEN.", rating);
    Fact fact34= new Fact(14, "THE ROMANS USED HUMAN URINE AS MOUTHWASH.", rating);
    Fact fact35= new Fact(15, "APPROXIMATELY 750,000 MEN DIED IN THE CIVIL WAR, WHICH WAS MORE THAN 2.5% OF AMERICA'S POPULATION AT THE TIME.", rating);
    Fact fact36= new Fact(16, "THE INTRODUCTION OF EUROPEANS TO THE NEW WORLD SAW THE NATIVE AMERICAN POPULATION DROP FROM AN ESTIMATED 12 MILLION IN 1500 TO BARELY 237,000 IN 1900.", rating);
    Fact fact37= new Fact(17, "IN THE 19TH CENTURY A POPULAR MEDICINE FOR KIDS, \"MRS. WINSLOW'S SOOTHING SYRUP,\" INCLUDED MORPHINE.", rating);
    Fact fact38= new Fact(18, "IN 1917, MARGARET SANGER WAS JAILED FOR ONE MONTH FOR ESTABLISHING THE FIRST BIRTH CONTROL CLINIC.", rating);
    Fact fact39= new Fact(19, "IN THE 15TH CENTURY ROMANIAN RULER VLAD THE IMPALER IMPALED 20,000 OTTOMAN TURKS ON LONG, SHARP POLES ON THE BANKS OF THE DANUBE.", rating);
    Fact fact40= new Fact(20, "IN EARLY ROME A FATHER COULD LEGALLY KILL ANYONE IN HIS FAMILY.", rating);

    // IT facts
    Fact fact41= new Fact(1, "A RARE FUNCTIONING APPLE 1 COMPUTER – THE COMPANY’S FIRST PRODUCT – HAS BEEN SOLD AT AN AUCTION FOR $374,500 (£240,929).", rating);
    Fact fact42= new Fact(2, "THE FIRST COMPUTER WAS ALMOST 2.5 METRES  HIGH AND WEIGHED NEARLY 30,000KG.", rating);
    Fact fact43= new Fact(3, "APPLE’S FIRST COMPUTER, THE APPLE 1 (1976), DID NOT INCLUDE A KEYBOARD, MONITOR, OR CASE AND WAS BASICALLY AN ASSEMBLED CIRCUIT BOARD.", rating);
    Fact fact44= new Fact(4, "WHILE IT TOOK THE RADIO 38 YEARS, AND THE TELEVISION A SHORT 13 YEARS, IT TOOK THE WORLD WIDE WEB ONLY 4 YEARS TO REACH 50 MILLION USERS.", rating);
    Fact fact45= new Fact(5, "EMAIL IS QUITE OLDER THAN THE WORLD WIDE WEB.", rating);
    Fact fact46= new Fact(6, "BILL GATES’ OWN HOUSE WAS DESIGNED ON, GUESS WHAT, ON A MAC PC.", rating);
    Fact fact47= new Fact(7, "DVORAK KEYBOARD WAS PROVEN TO BE AT LEAST 20 TIMES FASTER THAN THE “QWERTY” KEYBOARD.", rating);
    Fact fact48= new Fact(8, "THE VERY FIRST BANNER AD WAS USED IN THE SEEMINGLY CLOSE, YET INSANELY FAR 1994.", rating);
    Fact fact49= new Fact(9, "IS ONE GIGABYTE A LOT? WELL, THE FIRS 1 GB HARD DRIVE WAS ANNOUNCED IN 1980, WITH A PRICE TAG OF $40.000 AND HAD AN IMPRESSIVE WEIGHT OF 550 POUNDS.", rating);
    Fact fact50= new Fact(10, "ORIGINAL NAME OF THE WINDOWS OS WAS “INTERFACE MANAGER”.", rating);
    Fact fact51= new Fact(11, "INTEL PRIMARILY WERE DESIGNING 4004, THEIR FIRST MICROPROCESSOR FOR A CALCULATOR WITH NO IDEA WHATSOEVER WHERE THIS BREAKTHROUGH WILL LEAD.", rating);
    Fact fact52= new Fact(12, "COMPUTERS WERE CALLED AS NOTHING ELSE, BUT “ELECTRONIC BRAINS” IN 1950S.", rating);
    Fact fact53= new Fact(13, "NINETY-ONE PERCENT OF ALL ADULTS HAVE THEIR MOBILE PHONE WITHIN ARM’S REACH EVERY HOUR OF EVERY DAY.", rating);
    Fact fact54= new Fact(14, "TWO HUNDRED AND TWENTY MILLION TONS OF OLD COMPUTERS AND OTHER TECHNOLOGY DEVICES ARE TRASHED IN THE UNITED STATES EACH YEAR.", rating);
    Fact fact55= new Fact(15, "THE FIRST MOUSE WAS INVENTED BY DOUGLAS ENGELBART IN 1963; IT CONSISTED OF A HARD WOODEN SHELL AND TWO CLUNKY METAL WHEELS.", rating);
    Fact fact56= new Fact(16, "THE FIRST CELL PHONE SOLD IN THE UNITED STATES – THE MOTOROLA DYNATAC 8000X – WAS DESIGNED BY RUDY KROLOPP IN APRIL OF 1984.", rating);
    Fact fact57= new Fact(17, "THE WORD ROBOT COMES FROM CZECH WORD “ROBOTA”. THIS TRANSLATES TO INTO LABOR, WORK.", rating);
    Fact fact58= new Fact(18, "THE FIRST ALARM CLOCK COULD ONLY RING AT 4AM.", rating);
    Fact fact59= new Fact(19, "AS OF SEPT 2014, THERE ARE MORE THAN A BILLION WEBSITES ON THE INTERNET.", rating);
    Fact fact60= new Fact(20, "30,000+ WEBSITES ARE HACKED EVERY DAY.", rating);
    Fact fact61= new Fact(21, "THE FIRST EVER VCR, WHICH WAS MADE IN 1956, WAS THE SIZE OF A PIANO.", rating);
    Fact fact62= new Fact(22, "THE CREATORS OF PNG FILE FORMAT WANTED IT TO BE PRONOUNCED AS ‘PING’", rating);
    Fact fact63= new Fact(23, "THE SKYPE IS BANNED FROM THE PUBLIC IN CHINA", rating);
    Fact fact64= new Fact(24, "THE APPLE II HAD A HARD DRIVE OF ONLY 5 MEGABYTES WHEN IT WAS LAUNCHED.", rating);
    Fact fact65= new Fact(25, "DOUG ENGELBART CREATED THE FIRST MOUSE FROM WOOD IN 1964.", rating);
    Fact fact66= new Fact(26, "THE APPLE LISA WAS THE FIRST COMMERCIAL COMPUTER WITH GRAPHICAL USER INTERFACE AND A MOUSE.", rating);
    Fact fact67= new Fact(27, "1024 GIGABYTES IS EQUAL TO 1 TERABYTE.", rating);
    Fact fact68= new Fact(28, "1 PETABYTE CAN HOLD 13.3 YEARS OF HD-TV VIDEO.", rating);
    Fact fact69= new Fact(29, "THE AVERAGE AGE OF GAMERS IS THE US IS 35 YEARS.", rating);
    Fact fact70= new Fact(30, "THE DREAMCAST WAS THE FIRST CONSOLE WHICH ALLOWED REAL-TIME ONLINE PLAY FEATURE.", rating);
    Fact fact71= new Fact(31, "NINTENDO WAS STARTED IN 1889 AS A PLAYING CARD COMPANY.", rating);
    Fact fact72= new Fact(32, "THE VERY FIRST DOMAIN NAME REGISTERED WAS WWW.SYMBOLICS.COM, ON THE 15TH, MARCH, 1985.", rating);

    //Politics facts
    Fact fact73= new Fact(1, "JOHN F. KENNEDY ORDERED OVER 1,000 CUBAN CIGARS FOR PERSONAL USE JUST HOURS BEFORE HE MADE THEM ILLEGAL.", rating);
    Fact fact74= new Fact(2, "ABRAHAM LINCOLN WAS A LICENSED BARTENDER.", rating);
    Fact fact75= new Fact(3, "GEORGE WASHINGTON GREW MARIJUANA IN HIS GARDEN.", rating);
    Fact fact76= new Fact(4, "INDIA IS THE WORLD’S LARGEST DEMOCRACY WITH MORE THAN 700 MILLION REGISTERED VOTERS.", rating);
    Fact fact77= new Fact(5, "THE SYSTEM OF DEMOCRACY WAS INTRODUCED 2 500 YEARS AGO IN ATHENS, GREECE.", rating);
    Fact fact78= new Fact(6, "THE YOUNGEST ACTIVE SYSTEM OF GOVERNANCE IS COMMUNISM, WHICH WAS INTRODUCED IN 1848 BY FRIEDRICH ENGELS AND KARL MARX.", rating);
    Fact fact79= new Fact(7, "THE OLDEST EXISTING GOVERNING BODY OPERATES IN ALTHING IN ICELAND. IT WAS ESTABLISHED IN 930 AD.", rating);
    Fact fact80= new Fact(8, "THE UNITED NATIONS ORGANIZATION (UN) WAS FOUNDED IN 1945.", rating);
    Fact fact81= new Fact(9, "THE EUROPEAN UNION WAS FOUNDED IN 1957 AS THE EUROPEAN ECONOMIC COMMUNITY. IT THEN BECAME THE EC (EUROPEAN COMMUNITY) AND IN 1993 THE EU (EUROPEAN UNION).", rating);
    Fact fact82= new Fact(10, "ALTHOUGH THE UNITED STATES OF AMERICA WAS ESTABLISHED IN 1776 THE FIRST AMERICAN PRESIDENT EVER TO VISITED EUROPE WHILE IN OFFICE WAS WOODROW WILSON IN 1918.", rating);
    Fact fact83= new Fact(11, "ONLY RICHARD NIXON SERVED TWO TERMS AS VICE PRESIDENT AND ALSO WAS ELECTED TO TWO TERMS AS PRESIDENT.", rating);
    Fact fact84= new Fact(12, "NATO STANDS FOR NORTH ATLANTIC TREATY ORGANIZATION.", rating);
    Fact fact85= new Fact(13, "THE NATO TREATY WAS SIGNED ON APRIL 4, 1949. NATO HAS ITS HEADQUARTERS IN BRUSSELS, BELGIUM.", rating);
    Fact fact86= new Fact(14, "FOUNDING MEMBER STATES OF EU 1957 WAS BELGIUM, GERMANY, FRANCE, ITALY, LUXEMBOURG, NETHERLANDS.", rating);
    Fact fact87= new Fact(15, "ENGLISH AND FRENCH ARE THE OFFICIAL LANGUAGES OF NATO.", rating);
    Fact fact88= new Fact(16, "THE FIRST PRESIDENT OF LATVIA WAS JANIS CHAKSTE.", rating);
    Fact fact89= new Fact(17, "THE FIRST WOMEN PRESIDENT OF LATVIA WAS VAIRA VIKE-FREIBERGA.", rating);
    Fact fact90= new Fact(18, "IN THE SAEIMA(PARLIAMENT OF LATVIA) THERE AR 100 DEPUTIES.", rating);
    Fact fact91= new Fact(19, "THE INDEPENDENCY OF LATVIA WAS DECLARED ON 18 NOVEMBER 1918.", rating);
    Fact fact92= new Fact(20, "LATVIA JOINED THE EUROPIAN UNION ON 1 MAY 2004.", rating);

    //Soprts facts
    Fact fact93= new Fact(1, "BULLS AND WHITE SOX OWNER JERRY REINSDORF CONTINUED TO PAY MICHAEL JORDAN HIS $4 MILLION BASKETBALL SALARY WHILE HE WAS EXPERIMENTING WITH BASEBALL.", rating);
    Fact fact94= new Fact(2, "IF MICHAEL PHELPS WERE A COUNTRY, HE’D RANK NO. 35 ON THE ALL-TIME OLYMPIC GOLD MEDAL LIST, AHEAD OF 97 NATIONS.", rating);
    Fact fact95= new Fact(3, "“FEDERER” CAN BE TYPED ENTIRELY WITH THE LEFT HAND.", rating);
    Fact fact96= new Fact(4, "IF MICHAEL PHELPS WERE A COUNTRY, HE’D RANK NO. 35 ON THE ALL-TIME OLYMPIC GOLD MEDAL LIST, AHEAD OF 97 NATIONS.", rating);
    Fact fact97= new Fact(5, "THE AVERAGE GOLF BALL HAS 336 DIMPLES.", rating);
    Fact fact98= new Fact(6, "JIMMY CHITWOOD, THE HERO OF THE FILM HOOSIERS, ONLY HAS FOUR LINES IN THE ENTIRE MOVIE.", rating);
    Fact fact99= new Fact(7, "LIECHTENSTEIN HAS COMPETED IN THE MOST SUMMER OLYMPICS (16) WITHOUT WINNING ANY MEDAL.", rating);
    Fact fact100= new Fact(1, "YOGI BERRA WON 13 WORLD SERIES IN 18 SEASONS WITH THE YANKS.", rating);
    Fact fact101= new Fact(1, "THE FIRST BASKETBALL “HOOPS” WERE ACTUALLY JUST PEACH BASKETS AND THE FIRST BACKBOARDS WERE MADE OF WIRE.", rating);
    Fact fact102= new Fact(1, "THE MOST PARTICIPATED SPORT ON EARTH IS FISHING.", rating);
    Fact fact103= new Fact(1, "A FOOTBALL IS MADE UP OF 32 LEATHER PIECES, HELD TOGETHER BY 642 STITCHES.", rating);
    Fact fact104= new Fact(1, "GOLF THE ONLY SPORT TO HAVE EVER BEEN PLAYED ON THE MOON – ALAN SHEPARD HIT A GOLF BALL ON 6 FEBRUARY 1971.", rating);
    Fact fact105= new Fact(1, "BILL KLEM SERVED THE MOST SEASONS AS MLB UMPIRE, OFFICIATING FOR 37 YEARS, STARTING IN 1905.", rating);
    Fact fact106= new Fact(1, "WILLIAM GEORGE MORGAN OF HOLYOKE, MASSACHUSETTS INVENTED VOLLEYBALL IN 1895.", rating);
    Fact fact107= new Fact(1, "A BADMINTON SHUTTLECOCK’S SPEED EASILY EXCEEDS 180 KM/H (112 MPH) AND CAN GO UP TO 350 KM/H (186 MPH).", rating);
    Fact fact108= new Fact(1, "ROMANIAN FERENC SZISZ WON THE FIRST FORMULA ONE GRAND PRIX, IN A RENAULT, HELD AT LE MANS, FRANCE IN 1906. THE RACE WAS 1,260 KM LONG.", rating);
    Fact fact109= new Fact(1, "MICHAEL JORDAN MAKES MORE MONEY FROM NIKE ANNUALLY THAN ALL OF THE NIKE FACTORY WORKERS IN MALAYSIA COMBINED.", rating);
    Fact fact110= new Fact(1, "THE SILHOUETTE ON THE NBA LOGO IS HALL OF FAME LAKER JERRY WEST.", rating);
    Fact fact111= new Fact(1, "THE SILHOUETTE ON THE NBA LOGO IS HALL OF FAME LAKER JERRY WEST.", rating);
    Fact fact112= new Fact(1, "IN JULY OF 1934, BABE RUTH PAID A FAN $20 FOR THE RETURN OF THE BASEBALL HE HIT FOR HIS 700TH CAREER HOME RUN.", rating);





    public void setList() {
        factList.addFact("Animals", fact1);
        factList.addFact("Animals", fact2);
        factList.addFact("Animals", fact3);
        factList.addFact("Animals", fact4);
        factList.addFact("Animals", fact5);
        factList.addFact("Animals", fact6);
        factList.addFact("Animals", fact7);
        factList.addFact("Animals", fact8);
        factList.addFact("Animals", fact9);
        factList.addFact("Animals", fact10);
        factList.addFact("Animals", fact11);
        factList.addFact("Animals", fact12);
        factList.addFact("Animals", fact13);
        factList.addFact("Animals", fact14);
        factList.addFact("Animals", fact15);
        factList.addFact("Animals", fact16);
        factList.addFact("Animals", fact17);
        factList.addFact("Animals", fact18);
        factList.addFact("Animals", fact19);
        factList.addFact("Animals", fact20);

        factList.addFact("History", fact21);
        factList.addFact("History", fact22);
        factList.addFact("History", fact23);
        factList.addFact("History", fact24);
        factList.addFact("History", fact25);
        factList.addFact("History", fact26);
        factList.addFact("History", fact27);
        factList.addFact("History", fact28);
        factList.addFact("History", fact29);
        factList.addFact("History", fact30);
        factList.addFact("History", fact31);
        factList.addFact("History", fact32);
        factList.addFact("History", fact33);
        factList.addFact("History", fact34);
        factList.addFact("History", fact35);
        factList.addFact("History", fact36);
        factList.addFact("History", fact37);
        factList.addFact("History", fact38);
        factList.addFact("History", fact39);
        factList.addFact("History", fact40);

        factList.addFact("IT", fact41);
        factList.addFact("IT", fact42);
        factList.addFact("IT", fact43);
        factList.addFact("IT", fact44);
        factList.addFact("IT", fact45);
        factList.addFact("IT", fact46);
        factList.addFact("IT", fact47);
        factList.addFact("IT", fact48);
        factList.addFact("IT", fact49);
        factList.addFact("IT", fact50);
        factList.addFact("IT", fact51);
        factList.addFact("IT", fact52);
        factList.addFact("IT", fact53);
        factList.addFact("IT", fact54);
        factList.addFact("IT", fact55);
        factList.addFact("IT", fact56);
        factList.addFact("IT", fact57);
        factList.addFact("IT", fact58);
        factList.addFact("IT", fact59);
        factList.addFact("IT", fact60);
        factList.addFact("IT", fact61);
        factList.addFact("IT", fact62);
        factList.addFact("IT", fact63);
        factList.addFact("IT", fact64);
        factList.addFact("IT", fact65);
        factList.addFact("IT", fact66);
        factList.addFact("IT", fact67);
        factList.addFact("IT", fact68);
        factList.addFact("IT", fact69);
        factList.addFact("IT", fact70);
        factList.addFact("IT", fact71);
        factList.addFact("IT", fact72);

        factList.addFact("Politics", fact73);
        factList.addFact("Politics", fact74);
        factList.addFact("Politics", fact75);
        factList.addFact("Politics", fact76);
        factList.addFact("Politics", fact77);
        factList.addFact("Politics", fact78);
        factList.addFact("Politics", fact79);
        factList.addFact("Politics", fact80);
        factList.addFact("Politics", fact81);
        factList.addFact("Politics", fact82);
        factList.addFact("Politics", fact83);
        factList.addFact("Politics", fact84);
        factList.addFact("Politics", fact85);
        factList.addFact("Politics", fact86);
        factList.addFact("Politics", fact87);
        factList.addFact("Politics", fact88);
        factList.addFact("Politics", fact89);
        factList.addFact("Politics", fact90);
        factList.addFact("Politics", fact91);
        factList.addFact("Politics", fact92);

        factList.addFact("Sports", fact94);
        factList.addFact("Sports", fact95);
        factList.addFact("Sports", fact96);
        factList.addFact("Sports", fact97);
        factList.addFact("Sports", fact98);
        factList.addFact("Sports", fact99);
        factList.addFact("Sports", fact100);
        factList.addFact("Sports", fact101);
        factList.addFact("Sports", fact102);
        factList.addFact("Sports", fact103);
        factList.addFact("Sports", fact104);
        factList.addFact("Sports", fact105);
        factList.addFact("Sports", fact106);
        factList.addFact("Sports", fact107);
        factList.addFact("Sports", fact108);
        factList.addFact("Sports", fact109);
        factList.addFact("Sports", fact110);
        factList.addFact("Sports", fact111);
        factList.addFact("Sports", fact112);

    }
}

