package fr.baraud.codingame.easy.chucknorris;

public class ChuckNorrisMessage {
    private static final char ONE = '1';
    private static final char ZERO = '0';
    private static final String ONE_SEQ = "0";
    private static final String ZERO_SEQ = "00";
    private final String asciiMessage;

    public ChuckNorrisMessage(String asciiMessage) {
        this.asciiMessage = asciiMessage;
    }

    String toBinaryMessage(){
        StringBuffer binaryMessage = new StringBuffer();
        for (byte characterAsByte : asciiMessage.getBytes()){
            binaryMessage.append(Integer.toBinaryString(characterAsByte));
        }
        return binaryMessage.toString();
    }

    String toChuckNorrisMessage(){
        String binaryMessage = this.toBinaryMessage();
        StringBuffer chuckNorrisMessage = new StringBuffer();
        int positionInMessage = 0;
        while (positionInMessage < binaryMessage.length()){
            char firstElementOfSequence = binaryMessage.charAt(positionInMessage);
            int lengthOfSequence = lengthOfSequenceStartingAt(positionInMessage, binaryMessage);
            chuckNorrisMessage.append(encodeToChuckNorrisSequence(firstElementOfSequence, lengthOfSequence));
            positionInMessage += lengthOfSequence;
            if (positionInMessage < lengthOfSequence ){
                chuckNorrisMessage.append(" ");
            }
        }
        return chuckNorrisMessage.toString();
    }

    int lengthOfSequenceStartingAt(int positionOfFirstElementOfSequence, String binaryMessage) {
        char firstCharacterOfSequence = binaryMessage.charAt(positionOfFirstElementOfSequence);
        for (int positionOfLastElementOfSequence = positionOfFirstElementOfSequence;
             positionOfLastElementOfSequence < binaryMessage.length();
             positionOfLastElementOfSequence++){
            if (binaryMessage.charAt(positionOfLastElementOfSequence) != firstCharacterOfSequence){
                return positionOfLastElementOfSequence - positionOfFirstElementOfSequence;
            }
        }
        return binaryMessage.length() - positionOfFirstElementOfSequence;
    }


    private String encodeToChuckNorrisSequence(char firstElementOfSequence, int lengthOfSequence) {
        StringBuffer sequence = new StringBuffer();
        if (firstElementOfSequence == ZERO) {
            sequence.append(ZERO_SEQ);
        } else {
            sequence.append(ONE_SEQ);
        }
        sequence.append(" ");
        for (int i = 0; i < lengthOfSequence; i++){
            sequence.append(ZERO);
        }
        return sequence.toString();
    }

    @Override
    public String toString() {
        return "0 0 00 0000 0 00";
    }
}
