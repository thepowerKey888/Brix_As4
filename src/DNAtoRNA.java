import java.util.HashMap;
import java.util.Stack;

public class DNAtoRNA {

    public static char[] toRNA(String dna){

        HashMap<Character, Character> conversion = new HashMap<>();
        conversion.put('C', 'C');
        conversion.put('G', 'G');
        conversion.put('A', 'A');
        conversion.put('T', 'U');

        Stack<Character> stack = new Stack<>();
        char[] dnaArray = dna.toCharArray();
        int size = dnaArray.length;
        int counter = 0;

        for(char sequence : dnaArray){
            if(sequence == 'C' || sequence == 'G' || sequence == 'A'){
                stack.push(sequence);
                counter++;
            }
            if(sequence == 'T'){
                char con = conversion.get('T');
                stack.push(con);
                counter++;
            }

        }

        int stack_size = stack.size();
        char[] rna_seq = new char[stack_size];

        if(counter != size){
            System.out.println("Must be a DNA sequence!");
            return rna_seq;
        }
        else{
            //copying the elements of a stack to a char array
            for(int i = 0; i < rna_seq.length; i++){
                rna_seq[i] = stack.pop();
            }

            reverseCharArray(rna_seq);

        }

        return rna_seq;

    }

    private static void reverseCharArray(char[] a){
        int left = 0;
        int right = a.length-1;

        while(left < right){
            char temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
    }

    public static String convert(char[] rna){

        //convert char array to a string
        String string = new String(rna);

        //HashMap to determine corresponding amino acids
        HashMap<String, String> amino = new HashMap<>();
        amino.put("GUU", "V");
        amino.put("GUC", "V");
        amino.put("GUA", "V");
        amino.put("GUG", "V");

        amino.put("GCU", "A");
        amino.put("GCC", "A");
        amino.put("GCA", "A");
        amino.put("GCG", "A");

        amino.put("GAU", "D");
        amino.put("GAC", "D");
        amino.put("GAA", "E");
        amino.put("GAG", "E");

        amino.put("GGU", "G");
        amino.put("GGC", "G");
        amino.put("GGA", "G");
        amino.put("GGG", "G");

        amino.put("UUU", "F");
        amino.put("UUC", "F");
        amino.put("UUA", "L");
        amino.put("UUG", "L");

        amino.put("UCU", "S");
        amino.put("UCC", "S");
        amino.put("UCA", "S");
        amino.put("UCG", "S");

        amino.put("UAU", "Y");
        amino.put("UAC", "Y");
        amino.put("UAA", ".");
        amino.put("UAG", ".");

        amino.put("UGU", "C");
        amino.put("UGC", "C");
        amino.put("UGA", ".");
        amino.put("UGG", "W");

        amino.put("CUU", "L");
        amino.put("CUC", "L");
        amino.put("CUA", "L");
        amino.put("CUG", "L");

        amino.put("CCU", "P");
        amino.put("CCC", "P");
        amino.put("CCA", "P");
        amino.put("CCG", "P");

        amino.put("CAU", "H");
        amino.put("CAC", "H");
        amino.put("CAA", "Q");
        amino.put("CAG", "Q");

        amino.put("CGU", "R");
        amino.put("CGC", "R");
        amino.put("CGA", "R");
        amino.put("CGG", "R");

        amino.put("AUU", "I");
        amino.put("AUC", "I");
        amino.put("AUA", "I");
        amino.put("AUG", "M");

        amino.put("ACU", "T");
        amino.put("ACC", "T");
        amino.put("ACA", "T");
        amino.put("ACG", "T");

        amino.put("AAU", "N");
        amino.put("AAC", "N");
        amino.put("AAA", "K");
        amino.put("AAG", "K");

        amino.put("AGU", "S");
        amino.put("AGC", "S");
        amino.put("AGA", "R");
        amino.put("AGG", "R");


        //turning sequences of strings into full strgins
        StringBuilder aminos = new StringBuilder();
        for(int i =0; i < string.length() -2; i+= 3){
            String cod = string.substring(i, i+3);
            String aminoAcid = amino.getOrDefault(cod, "."); //ARE U SUPPPOSED TO USE A PERIOD???
            aminos.append(aminoAcid);
        }
        return aminos.toString();
    }

    public static void main(String[] args){

        String dna = "AGCTGGGAAACGTAGGCCTA";
        System.out.println(convert(toRNA(dna)));

        String dna2 = "TTTTTTTTTTGGCGCG";
        System.out.println(convert(toRNA(dna2)));

        String dna3 = "CTTTGGGACTAGTAACCCATTTCGGCT";
        System.out.println(convert(toRNA(dna3)));

        String dna4 = "Hello";
        System.out.println(convert(toRNA(dna4)));

    }

}
