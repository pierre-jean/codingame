package fr.baraud.codingame.easy.chucknorris;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ChuckNorrisMessage {
    private static final char ZERO = '0';
    private static final String ONE_SEQ = "0";
    private static final String ZERO_SEQ = "00";
    private final String asciiMessage;

    public ChuckNorrisMessage(String asciiMessage) {
        this.asciiMessage = asciiMessage;
    }

    String toChuckNorrisMessage(){
        BinaryMessage binaryMessage = BinaryMessage.fromAscii(asciiMessage);
        List<String> binarySequences = binaryMessage.getSequencesOfZeroAndOnes();
        List<String> chuckNorrisSequences = encodeToChuckNorrisSequences(binarySequences);
        return String.join(" ", chuckNorrisSequences);
    }

    private List<String> encodeToChuckNorrisSequences(List<String> binarySequences) {
        List<String> chuckNorrisSequences = new ArrayList<>();
        for (String binarySeq : binarySequences){
            chuckNorrisSequences.add(encodeToChuckNorrisSequence(binarySeq));
        }
        return chuckNorrisSequences;
    }

    static String encodeToChuckNorrisSequence(String binarySeq) {
        StringBuffer sequence = new StringBuffer();
        if (binarySeq.charAt(0) == ZERO) {
            sequence.append(ZERO_SEQ);
        } else {
            sequence.append(ONE_SEQ);
        }
        sequence.append(" ");
        for (int i = 0; i < binarySeq.length(); i++){
            sequence.append(ZERO);
        }
        return sequence.toString();
    }

    @Override
    public String toString() {
        return toChuckNorrisMessage();
    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String asciiMessage = in.nextLine();
        ChuckNorrisMessage chuckNorrisMessage =  new ChuckNorrisMessage(asciiMessage);
        System.out.println(chuckNorrisMessage.toString());
    }
}
