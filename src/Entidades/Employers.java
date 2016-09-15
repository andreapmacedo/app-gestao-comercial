package Entidades;

import java.sql.Date;







public class Employers {

    private Integer IdEmployer;
    private String identificacaoEmployer;
    private Date dataRegistroEmployer; //= new java.sql.Date(new java.util.Date().getTime());
    private Integer status;


 
    
    public Employers() {
    }

    public Employers(Integer idEmployer, String nomeEmployer, Date dataCadastro, Integer status) {
        this.IdEmployer = idEmployer;
        this.identificacaoEmployer = nomeEmployer;
        this.dataRegistroEmployer = dataCadastro;
        this.status = status;
        
    }
    
    public Integer getIdEmployer() {
        return IdEmployer;
    }

    public void setIdEmployer(Integer idEmployer) {
        this.IdEmployer = idEmployer;
    }

    public String getIdentificacaoEmployer() {
        return identificacaoEmployer;
    }

    public void setIdentificacaoEmployer(String identificacaoEmployer) {
        this.identificacaoEmployer = identificacaoEmployer;
    }

    public Employers(Integer idEmployer) {
        this.IdEmployer = idEmployer;
    }

    public Date getDataRegistroEmployer() {
        
        return dataRegistroEmployer;
        
    }

    public void setDataRegistroEmployer(Date dataRegistro) {
        this.dataRegistroEmployer = dataRegistro;
        
    }
    
        public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.IdEmployer != null ? this.IdEmployer.hashCode() : 0);
        hash = 97 * hash + (this.status != null ? this.status.hashCode() : 0);
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
        final Employers other = (Employers) obj;
        if (this.IdEmployer != other.IdEmployer && (this.IdEmployer == null || !this.IdEmployer.equals(other.IdEmployer))) {
            return false;
        }
        if (this.status != other.status && (this.status == null || !this.status.equals(other.status))) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return getIdentificacaoEmployer();
    }

}
