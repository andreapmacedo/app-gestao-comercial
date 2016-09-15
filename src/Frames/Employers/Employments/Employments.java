package Frames.Employers.Employments;


import java.util.Date;


public class Employments {
   
    private Integer IdEmployment;
    private Integer idEmployer;
    private Date startDateEmployment;//= new java.sql.Date(new java.util.Date().getTime());
    private Date stopedDateEmployment;
    private Integer activedEmployment;

    public Employments() {
    }

    public Employments(Integer IdEmployment, Integer idEmployer, Date startDateEmployment, Date stopedDateEmployment, Integer activedEmployment) {
        this.IdEmployment = IdEmployment;
        this.idEmployer = idEmployer;
        this.startDateEmployment = startDateEmployment;
        this.stopedDateEmployment = stopedDateEmployment;
        this.activedEmployment = activedEmployment;
    }

    public Integer getIdEmployment() {
        return IdEmployment;
    }

    public void setIdEmployment(Integer IdEmployment) {
        this.IdEmployment = IdEmployment;
    }

    public Integer getIdEmployer() {
        return idEmployer;
    }

    public void setIdEmployer(Integer idEmployer) {
        this.idEmployer = idEmployer;
    }

    public Date getStartDateEmployment() {
        return startDateEmployment;
    }

    public void setStartDateEmployment(Date startDateEmployment) {
        this.startDateEmployment = startDateEmployment;
    }

    public Date getStopedDateEmployment() {
        return stopedDateEmployment;
    }

    public void setStopedDateEmployment(Date stopedDateEmployment) {
        this.stopedDateEmployment = stopedDateEmployment;
    }

    public Integer getActivedEmployment() {
        return activedEmployment;
    }

    public void setActivedEmployment(Integer activedEmployment) {
        this.activedEmployment = activedEmployment;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (this.IdEmployment != null ? this.IdEmployment.hashCode() : 0);
        hash = 47 * hash + (this.idEmployer != null ? this.idEmployer.hashCode() : 0);
        hash = 47 * hash + (this.startDateEmployment != null ? this.startDateEmployment.hashCode() : 0);
        hash = 47 * hash + (this.stopedDateEmployment != null ? this.stopedDateEmployment.hashCode() : 0);
        hash = 47 * hash + (this.activedEmployment != null ? this.activedEmployment.hashCode() : 0);
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
        final Employments other = (Employments) obj;
        if (this.IdEmployment != other.IdEmployment && (this.IdEmployment == null || !this.IdEmployment.equals(other.IdEmployment))) {
            return false;
        }
        if (this.idEmployer != other.idEmployer && (this.idEmployer == null || !this.idEmployer.equals(other.idEmployer))) {
            return false;
        }
        if (this.startDateEmployment != other.startDateEmployment && (this.startDateEmployment == null || !this.startDateEmployment.equals(other.startDateEmployment))) {
            return false;
        }
        if (this.stopedDateEmployment != other.stopedDateEmployment && (this.stopedDateEmployment == null || !this.stopedDateEmployment.equals(other.stopedDateEmployment))) {
            return false;
        }
        if (this.activedEmployment != other.activedEmployment && (this.activedEmployment == null || !this.activedEmployment.equals(other.activedEmployment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Employments{" + "IdEmployment=" + IdEmployment + ", idEmployer=" + idEmployer + ", startDateEmployment=" + startDateEmployment + ", stopedDateEmployment=" + stopedDateEmployment + ", activedEmployment=" + activedEmployment + '}';
    }
    

    
    
}
