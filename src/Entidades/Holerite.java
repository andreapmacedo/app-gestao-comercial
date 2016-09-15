package Entidades;

import java.math.BigDecimal;

public class Holerite {

    private Integer idPk;
    private Integer idFk_Employer;
    private Integer idFk_Description;
    private BigDecimal quantity;
    private BigDecimal salary;
    private BigDecimal deduction;
    private String empIdentify;
    private String holDescription;
    private String holReference;
    private String holIncidence;

    public Holerite() {
    }

    public String getHolIncidence() {
        return holIncidence;
    }

    public void setHolIncidence(String holIncidence) {
        this.holIncidence = holIncidence;
    }

    public Integer getIdPk() {
        return idPk;
    }

    public void setIdPk(Integer idPk) {
        this.idPk = idPk;
    }

    public Integer getIdFk_Employer() {
        return idFk_Employer;
    }

    public void setIdFk_Employer(Integer idFk_Employer) {
        this.idFk_Employer = idFk_Employer;
    }

    public Integer getIdFk_Description() {
        return idFk_Description;
    }

    public void setIdFk_Description(Integer idFk_Description) {
        this.idFk_Description = idFk_Description;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getDeduction() {
        return deduction;
    }

    public void setDeduction(BigDecimal deduction) {
        this.deduction = deduction;
    }

    public String getEmpIdentify() {
        return empIdentify;
    }

    public void setEmpIdentify(String empIdentify) {
        this.empIdentify = empIdentify;
    }

    public String getHolDescription() {
        return holDescription;
    }

    public void setHolDescription(String holDescription) {
        this.holDescription = holDescription;
    }

    public String getHolReference() {
        return holReference;
    }

    public void setHolReference(String holReference) {
        this.holReference = holReference;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (this.idPk != null ? this.idPk.hashCode() : 0);
        hash = 59 * hash + (this.idFk_Employer != null ? this.idFk_Employer.hashCode() : 0);
        hash = 59 * hash + (this.idFk_Description != null ? this.idFk_Description.hashCode() : 0);
        hash = 59 * hash + (this.quantity != null ? this.quantity.hashCode() : 0);
        hash = 59 * hash + (this.salary != null ? this.salary.hashCode() : 0);
        hash = 59 * hash + (this.deduction != null ? this.deduction.hashCode() : 0);
        hash = 59 * hash + (this.empIdentify != null ? this.empIdentify.hashCode() : 0);
        hash = 59 * hash + (this.holDescription != null ? this.holDescription.hashCode() : 0);
        hash = 59 * hash + (this.holReference != null ? this.holReference.hashCode() : 0);
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
        final Holerite other = (Holerite) obj;
        if (this.idPk != other.idPk && (this.idPk == null || !this.idPk.equals(other.idPk))) {
            return false;
        }
        if (this.idFk_Employer != other.idFk_Employer && (this.idFk_Employer == null || !this.idFk_Employer.equals(other.idFk_Employer))) {
            return false;
        }
        if (this.idFk_Description != other.idFk_Description && (this.idFk_Description == null || !this.idFk_Description.equals(other.idFk_Description))) {
            return false;
        }
        if (this.quantity != other.quantity && (this.quantity == null || !this.quantity.equals(other.quantity))) {
            return false;
        }
        if (this.salary != other.salary && (this.salary == null || !this.salary.equals(other.salary))) {
            return false;
        }
        if (this.deduction != other.deduction && (this.deduction == null || !this.deduction.equals(other.deduction))) {
            return false;
        }
        if ((this.empIdentify == null) ? (other.empIdentify != null) : !this.empIdentify.equals(other.empIdentify)) {
            return false;
        }
        if ((this.holDescription == null) ? (other.holDescription != null) : !this.holDescription.equals(other.holDescription)) {
            return false;
        }
        if ((this.holReference == null) ? (other.holReference != null) : !this.holReference.equals(other.holReference)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Holerite{" + "idPk=" + idPk + ", idFk_Employer=" + idFk_Employer + ", idFk_Description=" + idFk_Description + ", quantity=" + quantity + ", salary=" + salary + ", deduction=" + deduction + ", empIdentify=" + empIdentify + ", holDescription=" + holDescription + ", holReference=" + holReference + ", holIncidence=" + holIncidence + '}';
    }

}
