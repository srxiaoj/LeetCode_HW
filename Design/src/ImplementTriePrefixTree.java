import java.util.HashMap;

/**
 * Created by thanksgiving on 1/4/16.
 */
public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        // Your Trie object will be instantiated and called as such:
        Trie trie = new Trie();
//        trie.insert("cat");
//        trie.insert("abby");
//        trie.insert("bob");
//        trie.insert("dish");
//        trie.insert("elon");
//        trie.insert("fish");
////        System.out.println(trie.root.left.val);
////        System.out.println(trie.search("bobb"));
//        System.out.println(trie.startsWith("de"));
        /*
        System.out.println(trie.search("adenotomic"));
        trie.insert("malconstruction");
        System.out.println(trie.search("dithyrambus"));
        trie.insert("hydrocarbostyril");trie.insert("oratorize");
        System.out.println(trie.startsWith("unparadox"));
        System.out.println(trie.search("behemoth"));System.out.println(trie.startsWith("knapsack"));
        trie.insert("emmarble");trie.insert("pinolin");System.out.println(trie.startsWith("rooty"));
        trie.insert("gematrical");System.out.println(trie.startsWith("deglutitiou"));
        System.out.println(trie.startsWith("consummativeness"));
        trie.insert("lager");trie.insert("polyvinylidene");
        trie.insert("formalith");trie.insert("retack");trie.insert("roding");trie.insert("lees");trie.insert("aplectrum");
        trie.insert("diesinker");System.out.println(trie.search("pigfish"));trie.insert("uninsurability");
        System.out.println(trie.search("curve"));System.out.println(trie.search("bacterium"));
        System.out.println(trie.search("sobrevest"));System.out.println(trie.search("bigamously"));
        System.out.println(trie.startsWith("ecclesiasticall"));
        System.out.println(trie.search("piceworth"));
        System.out.println(trie.search("reinfestation"));
        System.out.println(trie.search("bibliolater"));
        trie.insert("turnwrest");trie.insert("prestress");
        System.out.println(trie.search("disavowable"));
        trie.insert("calamistral");trie.insert("zygomorphous");
        trie.insert("lease");System.out.println(trie.search("ponerid"));
        System.out.println(trie.startsWith("nec"));
        System.out.println(trie.startsWith("t"));trie.insert("executrix");
        trie.insert("octahydrated");System.out.println(trie.startsWith("misology"));
        System.out.println(trie.search("everbearing"));
        trie.insert("myriadth");trie.insert("preferable");System.out.println(trie.startsWith("wind"));
        System.out.println(trie.startsWith("d"));System.out.println(trie.search("pityrogramma"));
        System.out.println(trie.startsWith("piassavak"));System.out.println(trie.startsWith("tig"));
        System.out.println(trie.startsWith("outfig"));System.out.println(trie.search("wawa"));
        System.out.println(trie.startsWith("manicate"));trie.insert("ichthyosauridae");
        System.out.println(trie.startsWith("le"));System.out.println(trie.startsWith("upb"));
        System.out.println(trie.search("dicaeidae"));System.out.println(trie.search("nondeciduous"));
        trie.insert("maltolte");System.out.println(trie.search("telegnosis"));
        System.out.println(trie.search("lithontriptic"));trie.insert("hypermetamorphism");
        System.out.println(trie.search("unanimated"));System.out.println(trie.startsWith("pro"));
        System.out.println(trie.search("silversmithing"));trie.insert("outlandishlike");
        trie.insert("polychromatophilia");System.out.println(trie.startsWith("ionicc"));
        System.out.println(trie.search("hoop"));System.out.println(trie.search("revestry"));
        System.out.println(trie.startsWith("vauquel"));System.out.println(trie.search("wifeism"));
        System.out.println(trie.search("pukras"));trie.insert("understain");
        System.out.println(trie.startsWith("alcoholicallys"));System.out.println(trie.startsWith("hedonic"));
        System.out.println(trie.search("gunneraceae"));trie.insert("gameful");
        trie.insert("rebeautify");trie.insert("whereup");System.out.println(trie.search("reprovide"));
        System.out.println(trie.search("pyromania"));trie.insert("dionymal");
        System.out.println(trie.search("outlove"));System.out.println(trie.search("airwayman"));
        trie.insert("upstaff");System.out.println(trie.search("quinquennially"));
        System.out.println(trie.search("semiliquidity"));System.out.println(trie.search("otomi"));
        System.out.println(trie.startsWith("toot"));System.out.println(trie.search("unbalked"));
        System.out.println(trie.startsWith("ana"));System.out.println(trie.startsWith("staphyleaceous"));
        System.out.println(trie.search("scaphite"));System.out.println(trie.startsWith("reg"));
        System.out.println(trie.search("epithesis"));System.out.println(trie.search("androspore"));
        System.out.println(trie.search("antinomic"));System.out.println(trie.startsWith("mer"));
        System.out.println(trie.startsWith("fea"));System.out.println(trie.search("nacry"));
        System.out.println(trie.search("thyreocervical"));System.out.println(trie.search("ferntickle"));
        System.out.println(trie.startsWith("l"));System.out.println(trie.startsWith("ba"));
        System.out.println(trie.startsWith("eyes"));System.out.println(trie.startsWith("conch"));
        System.out.println(trie.startsWith("irresist"));trie.insert("hugely");System.out.println(trie.startsWith("ahnfelt"));
        System.out.println(trie.search("unrancored"));trie.insert("carposporangial");trie.insert("islot");
        System.out.println(trie.search("searchful"));System.out.println(trie.search("parle"));
        System.out.println(trie.startsWith("swinging"));System.out.println(trie.startsWith("s"));
        System.out.println(trie.search("hemocyturia"));System.out.println(trie.startsWith("assis"));
        System.out.println(trie.search("plangent"));System.out.println(trie.search("meller"));
        System.out.println(trie.startsWith("engr"));System.out.println(trie.startsWith("unh"));
        trie.insert("noninherited");trie.insert("mantispidae");System.out.println(trie.search("staggerwort"));
        trie.insert("osteophyma");System.out.println(trie.search("jasminum"));
        System.out.println(trie.search("superstructure"));System.out.println(trie.search("metabatic"));
        System.out.println(trie.search("deacidify"));System.out.println(trie.startsWith("ubiquit"));
        System.out.println(trie.search("limetta"));System.out.println(trie.search("hamated"));
        trie.insert("polyesthesia");System.out.println(trie.startsWith("entific"));
        System.out.println(trie.search("correspondently"));System.out.println(trie.startsWith("g"));
        System.out.println(trie.search("epistemic"));System.out.println(trie.startsWith("reamer"));
        trie.insert("tautomery");trie.insert("plethodontid");System.out.println(trie.startsWith("asterale"));
        trie.insert("enclitically");System.out.println(trie.startsWith("tagaloe"));
        System.out.println(trie.startsWith("synergetic"));System.out.println(trie.startsWith("snea"));
        trie.insert("taikhana");trie.insert("hemilingual");trie.insert("peltigerine");
        trie.insert("magnetometrically");System.out.println(trie.startsWith("m"));
        trie.insert("wantingly");trie.insert("jurat");System.out.println(trie.search("bacchian"));
        System.out.println(trie.search("superattraction"));trie.insert("styful");
        System.out.println(trie.search("epithumetic"));System.out.println(trie.search("terebinth"));
        trie.insert("peroratory");System.out.println(trie.startsWith("m"));
        trie.insert("pleurothotonus");System.out.println(trie.startsWith("azo"));
        trie.insert("reconstruct");System.out.println(trie.startsWith("overzealous"));
        trie.insert("sprangle");System.out.println(trie.search("nonresolvability"));
        trie.insert("whorlflower");System.out.println(trie.startsWith("thixl"));
        trie.insert("jova");trie.insert("emmett");trie.insert("semisecrecy");
        System.out.println(trie.startsWith("consuetudinary"));trie.insert("watap");trie.insert("pulp");
        System.out.println(trie.startsWith("c"));System.out.println(trie.search("xeromorphous"));
        System.out.println(trie.startsWith("leath"));System.out.println(trie.startsWith("symples"));
        trie.insert("rampant");trie.insert("queeve");trie.insert("shaatnez");trie.insert("centumvirate");
        System.out.println(trie.search("communicably"));trie.insert("unextensible");
        System.out.println(trie.search("unthorough"));System.out.println(trie.search("milliamp"));
        trie.insert("recontribution");System.out.println(trie.startsWith("pseudony"));
        System.out.println(trie.startsWith("tidological"));System.out.println(trie.search("idiograph"));
        System.out.println(trie.startsWith("precounse"));System.out.println(trie.startsWith("tel"));
        trie.insert("exocyclic");System.out.println(trie.search("ytterbia"));trie.insert("bryales");
        trie.insert("coferment");System.out.println(trie.search("inexpediently"));
        System.out.println(trie.search("syllable"));
        System.out.println(trie.search("ovenpeel"));
        */

        trie.insert("apps");trie.insert("apple");trie.insert("beer");trie.insert("add");trie.insert("jam");trie.insert("rental");
//        System.out.println(trie.search("apps"));
//        System.out.println(trie.search("app"));
//        System.out.println(trie.search("ad"));
//        System.out.println(trie.search("applepie"));
//        System.out.println(trie.search("rest"));
//        System.out.println(trie.search("jan"));
//        System.out.println(trie.search("rent"));
//        System.out.println(trie.search("beer"));
//        System.out.println(trie.search("jam"));
        System.out.println(trie.startsWith("pps"));
        System.out.println(trie.startsWith("app"));
        System.out.println(trie.startsWith("ad"));
        System.out.println(trie.startsWith("applepie"));
        System.out.println(trie.startsWith("rest"));
        System.out.println(trie.startsWith("jan"));
        System.out.println(trie.startsWith("rent"));
        System.out.println(trie.startsWith("beer"));
        System.out.println(trie.startsWith("jam"));

    }

}

class TrieNode {
    public HashMap<Character, TrieNode> children = null;
    public boolean isLeaf = false;
    public char val;
    public TrieNode(char val) {
        this.val = val;
    }


    // Initialize your data structure here.
    public TrieNode() {

    }
}

class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode cur  = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (cur.children == null)
                cur.children = new HashMap<Character, TrieNode>();
            if (!cur.children.containsKey(ch))
                cur.children.put(ch, new TrieNode(ch));
            cur = cur.children.get(ch);
        }
        cur.isLeaf = true;
    }
    public boolean search(String word) {
        TrieNode cur  = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (cur.children == null || !cur.children.containsKey(ch))
                return false;
            cur = cur.children.get(ch);
        }
        return cur.isLeaf;
    }
    public boolean startsWith(String prefix) {
        TrieNode cur  = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (cur.children == null || !cur.children.containsKey(ch))
                return false;
            cur = cur.children.get(ch);
        }
        return true;
    }
}