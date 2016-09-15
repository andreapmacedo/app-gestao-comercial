
package Entidades;

public class EmployersPhone {

    private Integer IdPk;
    private Integer IdFK_Employer;
    private String numero;
    private String tipo;
    private String operadora;
    private String IdentificacaoColaborador;



    public EmployersPhone(Integer IdPk, Integer IdFK_Employer, String numero, String tipo, String operadora,String identificacaoColaborador) {
        this.IdPk = IdPk;
        this.IdFK_Employer = IdFK_Employer;
        this.numero = numero;
        this.tipo = tipo;
        this.operadora = operadora;
        this.IdentificacaoColaborador = identificacaoColaborador;
    }

    public EmployersPhone() {

    }

    public Integer getIdPk() {
        return IdPk;
    }

    public void setIdPk(Integer IdPk) {
        this.IdPk = IdPk;
    }

    public Integer getIdFK_Employer() {
        return IdFK_Employer;
    }

    public void setIdFK_Employer(Integer IdFK_Employer) {
        this.IdFK_Employer = IdFK_Employer;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }
    
    public String getNomeColaborador() {
        return IdentificacaoColaborador;
    }

    public void setNomeColaborador(String nomeColaborador) {
        this.IdentificacaoColaborador = nomeColaborador;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (this.IdPk != null ? this.IdPk.hashCode() : 0);
        hash = 89 * hash + (this.IdFK_Employer != null ? this.IdFK_Employer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmployersPhone other = (EmployersPhone) obj;
        if (this.IdPk != other.IdPk && (this.IdPk == null || !this.IdPk.equals(other.IdPk))) {
            return false;
        }
        if (this.IdFK_Employer != other.IdFK_Employer && (this.IdFK_Employer == null || !this.IdFK_Employer.equals(other.IdFK_Employer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EmployersPhone{" + "numero=" + numero + ", tipo=" + tipo + ", operadora=" + operadora + ", nomeColaborador=" + IdentificacaoColaborador + '}';
    }

 

    
}
