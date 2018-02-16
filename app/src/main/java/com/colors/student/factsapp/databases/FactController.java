package com.colors.student.factsapp.databases;

import com.colors.student.factsapp.databases.Fact;

import java.sql.SQLException;

/**
 * Created by kirils on 14.02.18.
 */

public class FactController{
    public FactList factList = new FactList();
    int rating = 0;
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

    }
}

