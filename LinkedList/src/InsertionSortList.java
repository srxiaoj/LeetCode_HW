/**
 * Created by thanksgiving on 12/29/15.
 */
public class InsertionSortList {
    public static void main(String[] args) {
        InsertionSortList obj = new InsertionSortList();
        int[] array = {4, 5, 2, 1, 3, 8, 9, -120, 25, 7};
//        int[] array = {0,0,0,0,0};
//        int[] array = {3911,1546,3370,1944,3306,1150,-1343,3573,-1393,675,2107,-1094,2272,425,-1599,-1140,503,-1730,-1728,3420,365,608,-72,2528,3907,1932,-411,-1460,3241,-278,1624,3653,-1795,3241,-1755,3896,3385,1404,1063,3973,-970,2976,3639,1723,-582,2490,-893,2223,969,2599,945,-1950,1242,-588,935,-1075,1451,-498,3801,-1652,1907,2368,-45,2191,3105,1499,-1983,3836,1600,439,2963,655,1354,724,2420,2325,-1458,1777,2376,1114,341,-1565,1204,-46,-1927,-255,1908,-1935,-37,-1039,-342,2918,572,-706,1665,2978,-1670,1645,-1082,1116,2330,3754,912,2625,3802,-1759,208,3869,-1668,3153,641,-1996,2360,-687,-788,-1652,3452,1856,232,3510,3469,589,210,2962,69,-617,-1886,-296,-1945,3306,3329,-31,-131,1267,-1857,2644,-404,1546,-1505,2424,-1723,3777,-1941,7,2887,2730,2221,1337,3738,-1846,2002,858,75,3190,-1316,2733,1438,269,1539,1014,-323,2306,912,3986,38,3526,-1553,1306,-775,2913,-1312,3133,364,-1664,-1802,1474,-584,-1541,-82,2548,-1999,-1945,1424,353,2934,-49,2553,-1548,-163,2842,-1270,-408,1675,1374,543,-1904,3338,-284,985,-1069,3633,1918,1615,510,3849,3613,1275,3133,2691,1173,3796,-1757,-1775,658,1257,3688,1160,3696,1397,1653,1822,-251,1557,-1493,-714,192,2038,77,-172,-1935,569,2107,-1580,102,-1990,-1619,2252,2780,2913,-1762,-1132,3126,2003,3077,2152,781,150,-1330,893,-1325,1175,1697,2043,1331,827,3510,-534,1598,2347,680,-1649,1194,-1192,-1836,1618,2920,688,-1234,-138,3214,1492,1706,-739,-1647,-1785,-283,-1930,-444,1860,1467,-1839,3854,-297,-1988,3193,1204,3905,-624,716,-1777,1077,2154,-1360,2612,3714,-969,-1328,-1905,1010,-435,48,2953,351,1596,947,440,-212,3912,3670,1270,2997,-803,3491,1020,1911,529,1394,-1864,-112,-721,1865,3441,-1362,-1953,-82,-1878,2897,3871,653,3559,-395,2480,2948,1090,609,3193,-1298,3386,3296,3869,1228,1258,3392,746,-1846,2827,-1804,345,2740,1432,-1388,3104,3721,2682,372,1065,2279,70,282,-1541,-1624,-538,-333,3901,750,-525,2913,-795,3447,-1160,2182,215,-1395,-763,1460,-1910,772,-829,1827,1665,1469,4,3608,-1689,1235,-774,3157,-1671,2497,2168,-1476,1486,2690,1117,1829,-1314,677,1838,1008,-182,-1211,848,-293,-329,-1901,-785,587,2602,-1043,3280,2406,1913,1067,-1531,-36,285,1073,958,719,3667,2001,622,-1885,2856,-539,249,2441,2237,2201,-667,-1344,1663,1227,3933,1150,28,1066,3736,1275,326,254,3247,-1695,3562,-174,30,25,3723,-1232,3565,-1434,3404,-861,-1057,1794,1410,-650,231,3798,-100,869,1690,812,750,-858,1054,1137,3174,3114,3844,-819,2987,-871,922,3089,-1794,-1481,2628,2150,-629,-1112,2289,-455,3977,2411,3511,3424,329,1242,3787,3728,2589,2292,3393,1941,-1265,2338,1981,97,-1935,2556,-1997,2508,-106,802,-729,-265,648,1042,-1241,-1151,-1987,2746,3485,1542,461,-1588,3789,184,-1656,-1731,-651,2857,1665,2745,357,1154,-1058,276,543,-1946,1944,3270,2632,2131,-849,3849,-42,830,-1281,2624,3736,3628,3138,3970,1596,3072,940,1176,3151,-1874,-1798,-770,-981,2660,-737,3552,432,2344,289,-669,-1737,-979,-615,-1214,3365,2806,1497,2556,-1888,-1751,1349,-44,3553,-150,1080,3113,3015,2999,-1398,445,2604,2763,3403,965,-1985,311,-521,-1392,-735,1909,3068,-91,-122,-691,1482,3881,2010,3490,1253,-42,-1338,-1242,-1824,-287,-919,3925,1257,1643,-829,-289,3059,2891,3290,-1803,-598,1066,-726,3647,2845,3326,2471,1388,3683,3140,-339,-69,3099,2194,3639,736,-266,2513,-456,3945,2231,-560,2230,361,-1211,3735,1475,1536,66,-1542,-1525,350,3638,2046,2272,-863,770,1915,-891,3105,2687,3875,2915,2277,3049,2342,-500,2573,-518,1287,1253,2778,3250,1379,2829,3824,3554,-441,2765,1547,1789,777,-1354,534,950,1914,-768,3187,2551,1928,1308,2314,-1308,2345,785,12,3196,-443,-1576,2903,144,-614,2242,1378,638,2556,3914,1420,610,-1294,3357,1701,-988,831,2983,1911,1041,3836,-421,-834,1301,1143,1865,831,-1926,-210,-889,-355,853,-695,-280,693,309,3434,1028,-175,2877,-1060,1660,3116,1745,3862,3629,-680,3387,1356,1037,-1523,338,876,-1167,1665,2334,-1763,1199,2377,2549,-1962,-415,-590,-1819,-91,2639,3093,3100,3967,275,-1689,1188,1068,3734,411,204,904,3769,-1998,2147,-1347,-887,1369,3660,3088,1625,1759,-813,1439,2129,-137,3103,-921,1039,556,3865,3956,1969,-666,1558,-234,744,-198,-1349,43,2913,3979,651,2799,577,95,-1378,2486,2640,397,-631,2410,3879,3018,-60,3438,-455,-769,-1097,1810,113,-1627,-801,-1964,603,2764,210,1857,-1657,3693,2302,-1800,-48,2547,-1529,2444,3652,294,-754,275,2257,-1814,-1838,2187,1169,-215,-319,3051,-1024,698,-272,3079,3536,3887,106,1034,-1803,1253,1826,840,317,-127,-584,1611,644,881,1672,1002,-326,507,-900,2997,1632,-1856,834,2786,2822,457,-1593,1671,1272,2969,3095,286,971,3395,2002,-1996,3048,1152,3238,-1723,466,3855,2209,-52,274,-1037,2496,-892,-895,516,1300,3704,-1663,3451,1240,1908,456,3790,3663,835,-1728,-1830,763,3915,1899,-1042,771,3269,2538,-1779,704,264,1414,2849,1069,-1906,3453,320,1763,62,1618,-1883,3020,-157,-1428,68,-378,-665,551,670,440,2745,718,2587,1541,3271,243,1773,-187,-1575,3469,-583,50,2491,606,580,2152,1249,2189,-679,81,3974,2402,2674,865,3212,2359,1001,2145,2768,397,-1349,-232,-616,3205,3944,1376,865,3245,-686,2943,356,1416,-798,-1009,875,3667,3320,-1666,-897,2198,286,-1498,1325,2749,125,3831,-704,-589,553,1415,-490,3348,-1183,-426,1512,1340,-5,220,-91,2422,3409,-561,220,2818,1316,3445,-455,2298,2804,494,-114,-247,-1456,2578,3331,2981,2739,684,-874,357,2074,480,-1987,1704,1929,-1049,-240,65,-1739,3251,1874,-449,2532,1467,2838,946,-108,-683,2116,3094,1924,3184,1004,-909,3053,1857,591,3687,-1770,2042,2948,-1576,1285,2391,1315,-1187,272,3666,-1439,-836,880,2849,3981,2567,1723,2975,2422,-1970,3943,3820,432,3882,201,3616,-863,-509,1347,-949,3154,-678,-1776,-1146,671,2411,928,-403,793,1559,1354,-1630,-1424,2801,990,3225,1625,3272,1828,763,2420,-569,3928,380,3995,-1955,-1542,1320,-478,1445,-1365,2979,2545,-1561,1824,2672,-1921,3979,-252,3306,2814,309,2406,2612,-324,890,-67,-1354,1424,-1133,2332,2186,879,2598,-798,671,1599,1952,2186,3401,-293,2414,-1123,1951,-1740,923,17,1926,3538,3952,3162,-858,3736,3869,3623,3414,-412,-1139,2754,3934,2155,1489,-1587,1013,1807,1958,613,336,2629,-974,100,3071,2517,1092,3738,3209,2628,2357,1719,3663,-9,738,-1145,3202,-1413,3917,-279,-754,-1526,1807,3516,3737,1471,-1268,-610,-532,1542,3589,-1008,218,3413,-785,-148,201,2364,-90,-1464,3153,1070,1197,-1032,826,3098,885,-999,1728,1773,47,611,1740,-310,3878,3657,-1167,2349,-170,1431,2930,2432,1015,839,-1967,1591,1317,2672,2296,3250,927,455,3620,-353,-1652,3367,-875,-1588,166,-1420,112,1142,-869,2083,321,2119,-1437,3143,-221,1317,-246,3511,3577,984,1220,-1248,1697,3373,2586,3710,-894,2672,2476,1226,1899,-1818,-1964,-770,-1468,255,647,3515,788,-1699,2711,1773,2190,-1685,122,3047,-685,522,-143,-630,1482,-688,-1390,-522,-1739,2517,-1003,543,3054,-1814,2622,160,-853,-398,1897,2142,-207,-347,843,3058,293,3929,3348,-161,-1672,1168,-1577,235,2710,2326,3853,2103,-699,2879,3404,-1366,3840,-1054,2498,-758,3803,834,-626,1895,-728,-427,2399,-526,159,3014,571,-1698,1337,-1453,-12,-1516,1510,1275,1586,-576,3354,-427,2964,1023,-784,443,-461,-953,3208,3061,-1858,-16,78,248,982,2075,-537,2934,-798,1843,-1366,-459,3230,-1161,-1066,1778,-844,1004,-641,2806,731,2417,-733,-1993,-962,-1022,469,2047,3138,-1776,1819,3345,-211,-1081,-1059,-345,2033,3252,2071,3292,-843,-990,2893,3593,-263,2910,2967,2510,-834,-922,-1340,-107,3639,2,-942,-432,2465,1390,1917,348,970,3663,-763,-563,-363,1226,2583,1334,305,-610,1500,3322,3477,415,-1752,201,3646,2117,-84,305,2691,3986,1158,921,2092,-1167,2872,-1151,1420,3374,1564,249,703,2471,1181,-866,1949,-87,-1988,2319,-644,3078,3226,-678,1855,-1083,1939,-1374,-914,-85,-104,3029,1481,1160,1892,3136,3968,1953,-1434,2989,3507,-1921,2466,3969,695,2813,947,2506,-1445,-1138,197,3147,3315,-676,-184,1555,-167,1686,3142,116,2560,117,1747,1270,-1694,1892,-723,-1579,-24,-1665,-1924,-1604,2247,-541,-1985,3082,-754,2424,2380,2205,299,954,55,2643,1852,-813,3059,3133,-1707,-1880,535,-13,1760,2996,102,1224,-694,3917,3116,456,3738,1799,3546,3026,-1172,-466,-1873,462,3418,2866,2996,522,3461,2908,-521,2309,1474,3306,3705,-1138,924,-1235,-1428,3377,3442,3325,-1336,3275,3834,3731,1178,1291,923,2571,2777,2577,3409,-1765,2228,2444,3058,2415,849,3994,919,-927,3376,-612,898,3909,-1527,719,2476,2484,2112,1242,-947,3696,-895,1449,-1402,338,781,2975,-836,510,3439,-223,2706,-970,3805,-1208,-1064,3497,1985,2030,1025,1104,-414,219,-1482,-14,364,-1044,-1191,3486,2800,3965,2060,-96,484,3269,3112,1023,30,1322,-1116,-511,1624,399,2365,1901,-1275,538,-1003,3816,-1867,-409,3494,3740,1570,1529,2890,3111,714,531,-1158,-1781,3512,1053,107,2284,1673,642,-905,1013,-531,3016,1268,101,731,-264,2770,112,-892,623,1109,-1499,1504,512,533,3443,2536,3767,-1709,-1376,2852,2248,2255,-992,-1305,3333,-669,206,-42,-400,1011,-50,3697,668,-1165,3464,2123,1513,-249,746,631,3530,2843,1339,-1134,-1776,1139,2557,3639,2888,3112,466,-1999,-658,1653,1685,824,3730,1600,1174,2875,-1356,3429,1325,-497,2895,1309,855,-1510,-935,1065,2395,-837,384,-730,1354,-1233,-776,3557,3625,417,1460,2742,-929,-31,3631,2931,3605,-361,2256,2244,1263,-1545,1433,607,-1107,-574,-162,1806,1937,1053,-504,3279,283,534,-1909,766,797,-1323,2812,-1506,-1545,-1857,-618,829,3075,1223,236,3718,1372,558,-336,1638,1011,2041,1526,2727,733,-465,3112,3902,-1850,1612,-1444,747,2456,2798,2238,-1872,1350,140,-1201,2502,-1757,2651,3836,1514,18,2636,558,2536,1228,3502,2003,-1227,1504,-1442,338,1407,265,3809,-1885,-454,256,451,-1228,200,1081,1855,3157,3388,3540,-1428,-75,-1694,1416,2672,2853,208,1989,1831,157,-944,1424,1231,-1640,324,3859,3907,2971,1670,3958,197,354,-144,3,661,2431,-1848,3571,3172,3184,-795,1053,1383,-1228,2645,926,-191,3263,-1306,1420,2066,23,3645,1220,3435,-1012,-40,1246,-769,1904,1329,1137,-1944,-1213,202,2700,1024,-1031,3917,-739,1213,3661,1392,-1351,989,-794,-285,2288,-243,-339,2110,2422,-1770,512,3522,565,1697,2356,1614,2658,2694,1274,1883,681,3477,3123,-72,3713,-362,1557,3059,1221,-1804,2110,3565,-1970,1433,-1459,2968,3433,-1394,2845,3649,0,3676,-1338,-294,-246,1339,2544,1752,3637,1955,2913,3397,-1090,-1553,297,2641,2422,499,329,-841,1721,2561,-1650,2942,1498,353,-1351,3864,293,-1847,421,61,1028,3859,-1332,898,3534,923,-1058,-534,-1498,-1084,-1270,2306,3375,3642,-1730,-1250,2781,2564};
        ListNode head = ListNode.create(array);
        ListNode res = obj.insertionSortList(head);
        ListNode.printListNode(res);
    }

    /**
     * 每次insert一个node, 下一次又从dummy从头开始判断下一个插入点进行插入
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        // create a dummy head and insert new element and keep this list sorted
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            insert(dummy, cur);
            cur = next;
        }
        return dummy.next;
    }

    private void insert(ListNode dummyHead, ListNode target) {
        // left to right scan to insert the target node
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.val < target.val) {
            cur = cur.next;
        }
        target.next = cur.next;
        cur.next = target;
    }
}
