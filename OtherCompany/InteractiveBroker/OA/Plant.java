/**
 * Created by thanksgiving on 9/8/16.
 */
public class Plant {
    String name;
    public Plant(){};

    public static void main(String[] args) {
//        List<Tree> trees = new ArrayList<>();
       /* List<Plant> plants = new ArrayList<>();
        plants.add(new Plant());
        List<? extends Plant> trees = plants;
        Plant plant = trees.get(0);*/

       /* List<Tree> trees = new ArrayList<Tree>();
        trees.add(new Tree());
        List<? extends Plant> plants = trees;
        Tree tree = plants.get(0);*/
    }
}

class Tree extends Plant {
    String name;
}

