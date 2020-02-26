package challenge;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public  String criptografar(String texto) {
        if (texto.trim().isEmpty())   throw new IllegalArgumentException("esse method nao esta implementado aainda");

        char[]charArray = texto.toLowerCase().toCharArray();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder stringConvert = new StringBuilder();

        for (char obj : charArray) {
            int found = alphabet.indexOf(obj);

            if(found != - 1){
                int valueFounded = found + 3;
                if(valueFounded >  26) stringConvert.append(alphabet.charAt(valueFounded - 26));
                else stringConvert.append(alphabet.charAt(found + 3));
            } else stringConvert.append(obj);
        }
        return stringConvert.toString();

    }

    @Override
    public String descriptografar(String texto) {

        if (texto.trim().isEmpty())   throw new IllegalArgumentException("esse method nao esta implementado aainda");

        char[]charArray = texto.toLowerCase().toCharArray();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder stringConvert = new StringBuilder();
        for (char obj : charArray) {
            int found = alphabet.indexOf(obj);

            if(found != - 1){
                int valueFounded = found - 3;
                if(valueFounded < 0) stringConvert.append(alphabet.charAt(valueFounded + 26));
                else stringConvert.append(alphabet.charAt(found - 3));
            } else stringConvert.append(obj);
        }
        return stringConvert.toString();
    }


}
