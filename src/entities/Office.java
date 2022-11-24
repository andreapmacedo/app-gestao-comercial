/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Andre
 */
public class Office implements java.io.Serializable {

    public Office() {
    }

    private Integer idFuncao;
    private String nomeFuncao;
    private Integer idSetor;

    public Integer getIdSetor() {
        return idSetor;
    }


    public void setIdSetor(Integer idSetor) {
        this.idSetor = idSetor;
    }

    public Office(Integer idFuncao) {
        this.idFuncao = idFuncao;
    }


    public Integer getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(Integer idFuncao) {
        this.idFuncao = idFuncao;
    }

    public String getNomeFuncao() {
        return nomeFuncao;
    }

    public void setNomeFuncao(String nomeFuncao) {
        this.nomeFuncao = nomeFuncao;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Office other = (Office) obj;
        if (this.idFuncao != other.idFuncao && (this.idFuncao == null || !this.idFuncao.equals(other.idFuncao))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.idFuncao != null ? this.idFuncao.hashCode() : 0);
        return hash;
    }
    
     @Override
    public String toString() {
        return getNomeFuncao();
    }
    
}
