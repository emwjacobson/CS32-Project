/*
 * Emerson Jacobson & Alice Li
 * CS23, Section #0169
 * Assignment: Team Project
 * Summary: 
 */
package cs32.project.Classes;

public interface AllCourses {

    final String[] deptList = {"ACR", "ACRP", "AJ", "ANAT", "ANTH", "APHY",
        "ARCH", "ART", "ASTR", "ASTU", "ATEC", "BIOL", "BUS", "CADD", "CDEV",
        "CH", "CHEM", "CHIN", "CIS", "COMS", "COSM", "CSCI", "CTEC", "DANC",
        "ET", "ECHT", "ECLA", "ECON", "EDEV", "EDUC", "ENGL", "ENGR", "ESL",
        "ESTU", "FAID", "FASH", "FILM", "FREN", "FTEC", "GEOG", "GEOL", "GERM",
        "HDEV", "HIST", "HORT", "HUMA", "ITAL", "JAPA", "JOUR", "LAW", "LIBR",
        "MATH", "MEDT", "MICR", "MTEC", "MTT", "MUSI", "NFOO", "NURS", "OCEA",
        "PARA", "PE", "PHIL", "PHOT", "PHYO", "PHYS", "POLI", "PSCI", "PSYC",
        "RC", "RE", "RECR", "RTEC", "SLAN", "SOCI", "SPAN", "SUPV", "THEA",
        "WELD", "WSTU"};

    final String[] ACR = {"21", "23", "25", "27", "5", "6", "61"};
    final String[] ACRP = {"1A", "1C", "3A", "3B", "4A", "5D", "95"};
    final String[] AJ = {"10", "100", "103", "107", "109", "111", "115", "12",
        "126", "130", "131", "132", "133", "134", "135", "142", "150", "170",
        "190", "49"};
    final String[] ANAT = {"30", "32"};
    final String[] ANTH = {"1", "11", "2", "3", "4", "5", "6"};
    final String[] APHY = {"34A", "34B"};
    final String[] ARCH = {"100", "104", "107", "119", "121", "150A", "158",
        "170", "171"};
    final String[] ART = {"101", "102A", "102B", "102C", "110", "130", "131",
        "132", "133", "141", "144", "146", "147", "150", "152", "161", "173",
        "187", "205A", " 207", "208H", "217", "218", "218B", "219", "220",
        "222", "223A", "223B", "233", "247A", "262", "263", "274", "275",
        "288"};
    final String[] ASTR = {"12", "20", "25", "25H"};
    final String[] ASTU = {"7"};
    final String[] ATEC = {"1", "14", "16", "21", "22A", "22B", "25", "34",
        "35", "41", "51"};
    final String[] BIOL = {"10", "101", "101H", "102", "102H", "10H", "11",
        "12", "15"};
    final String[] BUS = {"11", "14", "17", "1A", "1B", "20", "21", "22", "24",
        "25", "27", "28", "29", "2A", "3", "5A", "60", "60B"};
    final String[] CADD = {"28", "31", "32", "33", "37", "45", "5", "7"};
    final String[] CDEV = {"103", "104", "106", "107", "108", "110", "112",
        "114", "115", "116", "125", "130", "131", "150", "165", "169"};
    final String[] CH = {"1"};
    final String[] CHEM = {"1A", "1B", "20", "21A", "21B", "4", "7A", "7B"};
    final String[] CHIN = {"1", "2", "24"};
    final String[] CIS = {"119", "13", "132", "133", "140", "141", "150", "19",
        "2", "26", "28", "29", "40"};
    final String[] COMS = {"100", "120", "130", "140", "250", "260", "265",
        "270", "275", "292ABCD"};
    final String[] COSM = {"1", "10"};
    final String[] CSCI = {"1", "12", "14", "16", "2", "23", "3", "30", "7"};
    final String[] CTEC = {"100", "110", "132", "150", "172", "200", "201",
        "202", "203", "213"};
    final String[] DANC = {"101", "103", "110", "120A", "120B", "130A", "130B",
        "161", "165", "168", "170", "171A", "171B", "183AB", "220A", "220B",
        "221", "230A", "230B", "250", "261", "265", "268", "271B", "287AB",
        "289AB", "571A"};
    final String[] ET = {"101"};
    final String[] ECHT = {"10", "11", "110", "120", "130", "140", "22"};
    final String[] ECLA = {"LEVEL 1", "LEVEL 2", "LEVEL 3"};
    final String[] ECON = {"1", "2", "5"};
    final String[] EDEV = {"11", "140", "29", "32", "33", "35", "36", "37",
        "38", "41"};
    final String[] EDUC = {"101", "201"};
    final String[] ENGL = {"1", "100", "12", "15A", "1A", "1AH", "1AS", "1B",
        "1BH", "1C", "1CH", "20", "24A", "25A", "30", "40A", "42", "78"};
    final String[] ENGR = {"1", "9"};
    final String[] ESL = {"02D", "08", "41A", "41B", "41C", "42A", "42C", "51A",
        "51B", "51C", "52A", "52B", "52C", "53A", "53B", "53C"};
    final String[] ESTU = {"1", "3", "5"};
    final String[] FAID = {"1"};
    final String[] FASH = {"1", "10", "11", "15", "18", "26A", "27", "29", "31",
        "35", "4", "41", "95"};
    final String[] FILM = {"100", "105", "110", "122", "153", "154", "234",
        "236"};
    final String[] FREN = {"1", "2", "4"};
    final String[] FTEC = {"1", "10", "120", "130", "131", "132", "133", "134",
        "135", "136", "137", "138", "139", "144", "15", "19", "20", "3", "4",
        "5", "6", "9"};
    final String[] GEOG = {"1", "2", "5", "5H", "6", "9"};
    final String[] GEOL = {"1", "2", "3", "36", "4", "7"};
    final String[] GERM = {"1"};
    final String[] HDEV = {"101", "105", "110", "115"};
    final String[] HIST = {"101", "102", "105", "108", "110", "111", "112",
        "114", "122", "128", "129", "140", "141", "152", "154"};
    final String[] HORT = {"53", "54"};
    final String[] HUMA = {"1"};
    final String[] ITAL = {"1", "2"};
    final String[] JAPA = {"1", "2", "21", "22", "3", "4"};
    final String[] JOUR = {"1", "11ABCD", "12", "6", "7AB", "8", "9ABCD"};
    final String[] LAW = {"11", "12", "13", "14", "17", "19", "4", "5", "95"};
    final String[] LIBR = {"1", "10"};
    final String[] MATH = {"110", "115", "12", "120", "130", "140", "150",
        "150H", "165", "170", "180", "190", "191", "210", "220", "23", "270",
        "37", "40", "60", "67", "73", "80"};
    final String[] MEDT = {"1"};
    final String[] MICR = {"33"};
    final String[] MTEC = {"70"};
    final String[] MTT = {"101", "105", "10A", "10J", "2"};
    final String[] MUSI = {"101", "102A", "103A", "103B", "105", "111", "112H",
        "113", "116", "117", "120", "131A", "131B", "143", "144", "146", "147A",
        "147B", "152ABCD", "181A", "181B", "190A", "190B", "190C", "190D",
        "203", "215A", "220", "222ABCD", "231A", "231B", "232", "253ABCD",
        "257ABCD", "258ABCD", "260ABCD", "261ABCD", "262ABCD", "264ABCD",
        "265ABCD", "266ABCD", "267ABCD", "268ABCD", "284", "290", "555", "560",
        "561", "562", "564", "565", "567", "570"};
    final String[] NFOO = {"11"};
    final String[] NURS = {"101", "143", "144", "149", "153", "154", "155",
        "220", "222", "224", "226", "250", "251", "253", "254", "255"};
    final String[] OCEA = {"10", "10H"};
    final String[] PARA = {"1"};
    final String[] PE = {"201", "204", "208", "220", "221", "224", "240A",
        "240B", "240C", "245", "247", "249", "250", "251", "266", "275", "277",
        "280", "290", "400", "401", "402", "404", "407"};
    final String[] PHIL = {"101", "103", "105", "106", "107", "111", "112",
        "115"};
    final String[] PHOT = {"101", "102", "106", "150", "202", "203", "206AB",
        "223A", "223B", "254"};
    final String[] PHYO = {"31"};
    final String[] PHYS = {"11", "12", "1A", "1B", "1C", "1D", "2A", "2B",
        "3A"};
    final String[] POLI = {"1", "10", "1H", "2", "3", "5", "7"};
    final String[] PSCI = {"25"};
    final String[] PSYC = {"10", "12", "15", "16", "19", "2", "3", "5", "5H",
        "7", "8", "9A", "9B"};
    final String[] RC = {"170", "182", "174", "178", "288", "289", "296", "297",
        "298"};
    final String[] RE = {"11", "12A", "13", "19", "41"};
    final String[] RECR = {"207", "217"};
    final String[] RTEC = {"106", "111", "123", "217", "233", "244", "328",
        "A"};
    final String[] SLAN = {"101", "111", "112", "113", "114", "115", "130",
        "131", "210", "211", "220", "221", "230"};
    final String[] SOCI = {"101", "102", "104", "107", "109", "109A", "112",
        "118"};
    final String[] SPAN = {"1", "2", "21", "22", "3", "4", "52A"};
    final String[] SUPV = {"27"};
    final String[] THEA = {"103", "104", "113", "114", "185", "189", "214A",
        "216"};
    final String[] WELD = {"10A", "10B", "10C", "15", "1A", "29", "40B", "40C",
        "45"};
    final String[] WSTU = {"1"};

    final Object[] allCourses = {ACR, ACRP, AJ, ANAT, ANTH, APHY,
        ARCH, ART, ASTR, ASTU, ATEC, BIOL, BUS, CADD, CDEV,
        CH, CHEM, CHIN, CIS, COMS, COSM, CSCI, CTEC, DANC,
        ET, ECHT, ECLA, ECON, EDEV, EDUC, ENGL, ENGR, ESL,
        ESTU, FAID, FASH, FILM, FREN, FTEC, GEOG, GEOL, GERM,
        HDEV, HIST, HORT, HUMA, ITAL, JAPA, JOUR, LAW, LIBR,
        MATH, MEDT, MICR, MTEC, MTT, MUSI, NFOO, NURS, OCEA,
        PARA, PE, PHIL, PHOT, PHYO, PHYS, POLI, PSCI, PSYC,
        RC, RE, RECR, RTEC, SLAN, SOCI, SPAN, SUPV, THEA,
        WELD, WSTU};

}
