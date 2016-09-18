/**
 * Created by thanksgiving on 9/8/16.
 */
public class EnumTest {
    public enum ItemType {
        COMPANY_WIDE("Company"),
        DEPARTMENTAL("Departmental"),
        PROJECT_SPECIFIC("Project");

        private String itemCode;
        private ItemType(String dbCode) {
            this.itemCode = dbCode;
        }

        public String getItemCode() {
            return itemCode;
        }
    }

    public static void main(String[] args) {
//        ItemType type3 = new ItemType("Project");
        ItemType type2 = ItemType.valueOf("PROJECT_SPECIFIC");
        ItemType type4 = ItemType.values()[0];
        ItemType type1 = ItemType.DEPARTMENTAL;
    }
}
