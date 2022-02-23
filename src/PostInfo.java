public class PostInfo {

    private int postalCode;
    private String townName;


    public PostInfo(int postalCode, String townName) {
        this.postalCode = postalCode;
        this.townName = townName;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getTownName() {
        return townName;
    }

    @Override
    public String toString() {

        String postalCode = String.valueOf(this.postalCode);

        return  String.format("%-4s - %-20s", postalCode, townName);
    }
}
