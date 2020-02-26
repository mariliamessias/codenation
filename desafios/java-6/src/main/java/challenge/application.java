package challenge;

public class application {

    public static void main(String[] args) {

        Criptografia criptografia = new CriptografiaCesariana();

        System.out.println(criptografia.criptografar("a ligeira raposa marrom saltou sobre o cachorro cansado"));
        System.out.println(criptografia.descriptografar("dsuhqghu mdyd jhud iholflgdgh"));

    }
}
