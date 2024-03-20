public class Rule {
    private char[] kondisi;
    private char akibat;

    public Rule(char[] kondisi, char akibat) {
        this.kondisi = kondisi;
        this.akibat = akibat;
    }

    public char[] getKondisi() {
        return kondisi;
    }

    public char getAkibat() {
        return akibat;
    }
}
