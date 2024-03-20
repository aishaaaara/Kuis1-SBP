public class MainKuis{
    static boolean[] facts = new boolean[26];

    public static void main(String[] args) {
        //menentukan array rules 
        Rule[] rules = {
                new Rule(new char[]{'A', 'B'}, 'C'),
                new Rule(new char[]{'C'}, 'D'),
                new Rule(new char[]{'A', 'E'}, 'F'),
                new Rule(new char[]{'A'}, 'G'),
                new Rule(new char[]{'F', 'G'}, 'D'),
                new Rule(new char[]{'G', 'E'}, 'H'),
                new Rule(new char[]{'C', 'H'}, 'I'),
                new Rule(new char[]{'I', 'A'}, 'J'),
                new Rule(new char[]{'G'}, 'J'),
                new Rule(new char[]{'J'}, 'K')
        };
        
        //FAKTA AWAL
        facts['A' - 'A'] = true;
        facts['E' - 'A'] = true;

        boolean updated;
        do {
            updated = false;
            for (Rule rule : rules) {
                char kesimpulan = rule.getAkibat();
                boolean ruleTerpenuhi = true;
                for (char condition : rule.getKondisi()) {
                    if (!facts[condition - 'A']) {
                        ruleTerpenuhi = false;
                        break;
                    }
                }
                if (ruleTerpenuhi && !facts[kesimpulan - 'A']) {
                    facts[kesimpulan - 'A'] = true;
                    updated = true;
                }
            }
        } while (updated);

        System.out.println(" ------------- Kuis 1 SBP (cr: Aisha Rahmadia & Naura Haidar) ------------- ");
        //cetak fakta awal
        System.out.print("Fakta Baru : ");
        for (char c = 'A'; c <= 'Z'; c++) {
            if (c == 'A' || c == 'E') {
                if (facts[c - 'A']) {
                    System.out.print(c + " ");
                }
            }
        }
        System.out.println();

        //cetak fakta baru
        System.out.print("Fakta baru: ");
        boolean adaFaktaBaru = false;
        for (char c = 'A'; c <= 'K'; c++) {
            if (facts[c - 'A']) {
                adaFaktaBaru = true;
                System.out.print(c + " ");
            }
        }
        if (!adaFaktaBaru) {
            System.out.print("Tidak ada fakta baru");
        }
        System.out.println();

        // Pengecekan kondisi K 
        if (facts['K' - 'A']) {
            System.out.println("Hasilnya : K bernilai benar.");
        } else {
            System.out.println("Hasilnya : K bernilai salah.");
        }
    }
}
