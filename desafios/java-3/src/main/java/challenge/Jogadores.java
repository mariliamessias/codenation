package challenge;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Jogadores {

    private List<Jogador> listaJogadores = new ArrayList<>();
    private final String VIRGULA = ",";
    private List<String> titulos;


    private void add (Jogador jogador){
        this.listaJogadores.add(jogador);
    }

    public void popularJogadores() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/data.csv")));
        boolean firstLine = true;
        String linha = null;
        while ((linha = reader.readLine()) != null) {
            String[] jogador = linha.split(VIRGULA);
            if(!firstLine){

                try{

                    double eur_wage = jogador[getIndex("eur_wage")].isEmpty() ? 0.0 : Double.parseDouble( jogador[getIndex("eur_wage")] );
                    double eur_release_clause = jogador[getIndex("eur_release_clause")].isEmpty() ? 0.0 :  Double.parseDouble( jogador[getIndex("eur_release_clause")]);

                    Jogador jogador1 = new Jogador( Integer.parseInt(jogador[getIndex("ID")]),
                            jogador[getIndex("full_name")],
                            jogador[getIndex("club")],
                            Integer.parseInt(jogador[getIndex("age")]),
                            jogador[getIndex("birth_date")],
                            jogador[getIndex("nationality")],
                            eur_wage,
                            eur_release_clause
                    );


                    this.add(jogador1);
                }catch (NullPointerException ex){
                    ex.getMessage();
                }
            }
            else {
                titulos = Arrays.asList(jogador);
                firstLine = false;
                continue;
            }
        }
        reader.close();
    }

    private int getIndex(String coluna) {
        try {
            return titulos.indexOf(coluna);
        } catch (NullPointerException e) {
            throw new NullPointerException("A coluna não foi encontrada.");
        }
    }

    public List<String> getJogadores(){
       return listaJogadores.stream()
                .map(jogador -> jogador.getFullName())
                .limit(20)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public int countNationalities(){
       return listaJogadores.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Jogador::getNationality))
               .size();
    }

    public int countClubs(){
        return listaJogadores.stream()
                .filter(Objects::nonNull)
                .filter(a -> !a.getNomeClub().isEmpty())
                .collect(Collectors.groupingBy(Jogador::getNomeClub))
                .size();
    }

    public List<String> getJogadoresClausulas(){
        return listaJogadores.stream()
                .sorted(Comparator.comparingDouble(Jogador::getEurReleaseClause).reversed())
                .map(jogador -> jogador.getFullName())
                .limit(10)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Map<Integer, Integer> getJogadoresByAge(){
        return listaJogadores.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Jogador::getAge, Collectors.reducing(0, j -> 1, Integer::sum)));
    }

    public List<String> getJogadoresOldest(){
        return listaJogadores.stream()
                .sorted(
                        Comparator
                        .comparingLong(this::getAgeInDays).
                        thenComparing(Jogador::getEurWage)
                        .reversed())
                .map(Jogador::getFullName)
                .limit(10)
                .collect(Collectors.toList());
    }

    private Long getAgeInDays(Jogador jogador) {
        return ChronoUnit.DAYS.between(LocalDate.parse(jogador.getBirthDate()), LocalDate.now());
    }
}


