package za.co.sfh.features.repository.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "country_bank_list")
public class CountryBankListEntity {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id", nullable = false)
     private Long id;

     @Column(name = "institution_id", nullable = false)
     private Long institutionId;

     @Column(name = "country_alpha3", nullable = false)
     private String countryAlpha3;

     @Column(name = "institution_currency")
     private String institutionCurrency;

     @Column(name = "help_text")
     private String helpText;

     @Temporal(TemporalType.TIMESTAMP)
     @Column(name = "time_created", nullable = false)
     private Date timeCreated;

     @Temporal(TemporalType.TIMESTAMP)
     @Column(name = "time_updated", nullable = true)
     private Date timeUpdated;

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public Long getInstitutionId() {
          return institutionId;
     }

     public void setInstitutionId(Long institutionId) {
          this.institutionId = institutionId;
     }

     public String getCountryAlpha3() {
          return countryAlpha3;
     }

     public void setCountryAlpha3(String countryAlpha3) {
          this.countryAlpha3 = countryAlpha3;
     }

     public String getInstitutionCurrency() {
          return institutionCurrency;
     }

     public void setInstitutionCurrency(String institutionCurrency) {
          this.institutionCurrency = institutionCurrency;
     }

     public String getHelpText() {
          return helpText;
     }

     public void setHelpText(String helpText) {
          this.helpText = helpText;
     }

     public Date getTimeCreated() {
          return timeCreated;
     }

     public void setTimeCreated(Date timeCreated) {
          this.timeCreated = timeCreated;
     }

     public Date getTimeUpdated() {
          return timeUpdated;
     }

     public void setTimeUpdated(Date timeUpdated) {
          this.timeUpdated = timeUpdated;
     }

     @Override
     public int hashCode() {
          final int prime = 31;
          int result = 1;
          result = prime * result + ((countryAlpha3 == null) ? 0 : countryAlpha3.hashCode());
          result = prime * result + ((helpText == null) ? 0 : helpText.hashCode());
          result = prime * result + ((id == null) ? 0 : id.hashCode());
          result = prime * result + ((institutionId == null) ? 0 : institutionId.hashCode());
          result = prime * result + ((institutionCurrency == null) ? 0 : institutionCurrency.hashCode());
          result = prime * result + ((timeCreated == null) ? 0 : timeCreated.hashCode());
          result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
          return result;
     }

     @Override
     public boolean equals(Object obj) {
          if (this == obj)
               return true;
          if (obj == null)
               return false;
          if (getClass() != obj.getClass())
               return false;
          CountryBankListEntity other = (CountryBankListEntity) obj;
          if (countryAlpha3 == null) {
               if (other.countryAlpha3 != null)
                    return false;
          } else if (!countryAlpha3.equals(other.countryAlpha3))
               return false;
          if (helpText == null) {
               if (other.helpText != null)
                    return false;
          } else if (!helpText.equals(other.helpText))
               return false;
          if (id == null) {
               if (other.id != null)
                    return false;
          } else if (!id.equals(other.id))
               return false;
          if (institutionId == null) {
               if (other.institutionId != null)
                    return false;
          } else if (!institutionId.equals(other.institutionId))
               return false;
          if (institutionCurrency == null) {
               if (other.institutionCurrency != null)
                    return false;
          } else if (!institutionCurrency.equals(other.institutionCurrency))
               return false;
          if (timeCreated == null) {
               if (other.timeCreated != null)
                    return false;
          } else if (!timeCreated.equals(other.timeCreated))
               return false;
          if (timeUpdated == null) {
               if (other.timeUpdated != null)
                    return false;
          } else if (!timeUpdated.equals(other.timeUpdated))
               return false;
          return true;
     }
}
