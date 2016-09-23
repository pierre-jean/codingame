package fr.baraud.codingame.easy.chucknorris;

import java.util.ArrayList;
import java.util.List;

class BinaryMessage {

    private final String binaryMessage;

    private BinaryMessage(String binaryMessage){
        this.binaryMessage = binaryMessage;
    }

    static BinaryMessage fromAscii(String ascii){
        return new BinaryMessage(encodeToBinary(ascii));
    }

    static BinaryMessage fromBinary(String binary){
        return new BinaryMessage(binary);
    }


    static String encodeToBinary(String asciiMessage){
        StringBuffer binaryMessage = new StringBuffer();
        for (byte characterAsByte : asciiMessage.getBytes()){
            binaryMessage.append(String.format("%7s",Integer.toBinaryString(characterAsByte)).replace(' ', '0'));
        }
        return binaryMessage.toString();
    }

    List<String> getSequencesOfZeroAndOnes() {
        List<String> sequences = new ArrayList<>();
        String remainingMessage = binaryMessage;
        while (remainingMessage.length() > 0){
            String seq = extractFirstSeq(remainingMessage);
            sequences.add(seq);
            remainingMessage = remainingMessage.substring(seq.length());
        }
        return sequences;
    }

    static String extractFirstSeq(String message) {
        StringBuffer sequenceBuffer = new StringBuffer();
        int sequenceLength = 0;
        char sequenceChar = message.charAt(sequenceLength);
        while(sequenceLength < message.length() && message.charAt(sequenceLength) == sequenceChar){
            sequenceBuffer.append(sequenceChar);
            sequenceLength++;
        }
        return sequenceBuffer.toString();
    }
}
