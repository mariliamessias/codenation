package challenge;

public class Jogador {
    private Integer id;
    private String fullName;
    private String nomeClub;
    private Integer age;
    private String birthDate;
    private String nationality;
    private Double eurWage;
    private Double eurReleaseClause;

    public Jogador(Integer id, String fullName, String nomeClub, Integer age, String birthDate, String nationality, Double eurWage, Double eurReleaseClause) {
        this.id = id;
        this.fullName = fullName;
        this.nomeClub = nomeClub;
        this.age = age;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.eurWage = eurWage;
        this.eurReleaseClause = eurReleaseClause;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNomeClub() {
        return nomeClub;
    }

    public void setNomeClub(String nomeClub) {
        this.nomeClub = nomeClub;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Double getEurWage() {
        return eurWage;
    }

    public void setEurWage(Double eurWage) {
        this.eurWage = eurWage;
    }

    public Double getEurReleaseClause() {
        return eurReleaseClause;
    }

    public void setEurReleaseClause(Double eurReleaseClause) {
        this.eurReleaseClause = eurReleaseClause;
    }
}