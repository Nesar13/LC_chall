public class Lc108_StringBuilding {

    public String defangIPaddr(String address) {
        //using final does improve performance for local variables, but readability
        //will be an issue
        final StringBuilder defanged = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.') {
                defanged.append("[.]");
            } else {
                defanged.append(c);
            }
        }
        return defanged.toString();
    }

    public String defangIPaddr2(String address) {
        //replaces each instances  of the char
        return address.replace(".", "[.]");
    }
    public static void main(String[] args) {

    }

}
