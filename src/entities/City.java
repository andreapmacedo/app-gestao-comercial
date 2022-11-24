
package entities;

/**
 *
 * @author Andre
 */
public class City {

    private Integer idCidade;
    private String nomeCidade;
    private Integer idEstado;
    private String nomeEstado;

    public City(Integer idCidade, String nomeCidade, Integer idEstado) {
        this.idCidade = idCidade;
        this.nomeCidade = nomeCidade;
        this.idEstado = idEstado;

    }

    public City(Integer idCidade, String nomeCidade, Integer idEstado, String nomeEstado) {
        this.idCidade = idCidade;
        this.nomeCidade = nomeCidade;
        this.idEstado = idEstado;
        this.nomeEstado = nomeEstado;
    }

    public City(Integer idCidade, String nomeCidade, String nomeEstado) {
        this.idCidade = idCidade;
        this.nomeCidade = nomeCidade;
        this.nomeEstado = nomeEstado;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public City(Integer idCidade, Integer idEstado) {
        this.idCidade = idCidade;
        this.idEstado = idEstado;
    }

    public City() {
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final City other = (City) obj;
        if (this.idCidade != other.idCidade && (this.idCidade == null || !this.idCidade.equals(other.idCidade))) {
            return false;
        }
        if (this.idEstado != other.idEstado && (this.idEstado == null || !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.idCidade != null ? this.idCidade.hashCode() : 0);
        hash = 59 * hash + (this.idEstado != null ? this.idEstado.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return "Cidades{" + "nomeCidade=" + nomeCidade + ", nomeEstado=" + nomeEstado + '}';
    }
    
    

}
