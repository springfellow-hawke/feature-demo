package za.co.sfh.features.repository.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "country_institution_config")
public class CountryInstitutionConfigEntity {

     @Id
     @Column(name = "country_alpha3", nullable = false)
     private String countryAlpha3;

     @Column(name = "currency", nullable = false)
     private String currency;

     @Column(name = "currency_help")
     private String currencyHelp;

     @Column(name = "wallet_transfer_time")
     private String walletTransferTime;

     @Column(name = "bank_transfer_time")
     private String bankTransferTime;

     @Column(name = "cash_transfer_time")
     private String cashTransferTime;

     @Enumerated(EnumType.STRING)
     @Column(name = "required_on_cash_collection")
     private RequiredOnCashCollectionType requiredOnCashCollection;

     @Temporal(TemporalType.TIMESTAMP)
     @Column(name = "time_created", nullable = false)
     private Date timeCreated;

     @Temporal(TemporalType.TIMESTAMP)
     @Column(name = "time_updated", nullable = true)
     private Date timeUpdated;

     @OneToMany(targetEntity = CountryWalletListEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY,
             orphanRemoval = true)
     @JoinColumn(name = "country_alpha3", referencedColumnName = "country_alpha3")
     private List<CountryWalletListEntity> walletList = new ArrayList<>();

     @OneToMany(targetEntity = CountryBankListEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY,
             orphanRemoval = true)
     @JoinColumn(name = "country_alpha3", referencedColumnName = "country_alpha3")
     private List<CountryBankListEntity> bankList = new ArrayList<>();

     public String getCountryAlpha3() {
          return countryAlpha3;
     }

     public void setCountryAlpha3(String countryAlpha3) {
          this.countryAlpha3 = countryAlpha3;
     }

     public String getCurrency() {
          return currency;
     }

     public void setCurrency(String currency) {
          this.currency = currency;
     }

     public String getCurrencyHelp() {
          return currencyHelp;
     }

     public void setCurrencyHelp(String currencyHelp) {
          this.currencyHelp = currencyHelp;
     }

     public String getWalletTransferTime() {
          return walletTransferTime;
     }

     public void setWalletTransferTime(String walletTransferTime) {
          this.walletTransferTime = walletTransferTime;
     }

     public String getBankTransferTime() {
          return bankTransferTime;
     }

     public void setBankTransferTime(String bankTransferTime) {
          this.bankTransferTime = bankTransferTime;
     }

     public String getCashTransferTime() {
          return cashTransferTime;
     }

     public void setCashTransferTime(String cashTransferTime) {
          this.cashTransferTime = cashTransferTime;
     }

     public RequiredOnCashCollectionType getRequiredOnCashCollection() {
          return requiredOnCashCollection;
     }

     public void setRequiredOnCashCollection(RequiredOnCashCollectionType requiredOnCashCollection) {
          this.requiredOnCashCollection = requiredOnCashCollection;
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

     public List<CountryWalletListEntity> getWalletList() {
          return walletList;
     }

     public void setWalletList(List<CountryWalletListEntity> walletList) {
          this.walletList = walletList;
     }

     public List<CountryBankListEntity> getBankList() {
          return bankList;
     }

     public void setBankList(List<CountryBankListEntity> bankList) {
          this.bankList = bankList;
     }

     public void removeCountryBankListEntity(CountryBankListEntity countryBankListEntity){
          countryBankListEntity.setInstitutionCurrency(null);
          this.bankList.remove(countryBankListEntity);
     }

     public void removeCountryWalletListEntity(CountryWalletListEntity countryWalletListEntity){
          countryWalletListEntity.setInstitutionCurrency(null);
          this.walletList.remove(countryWalletListEntity);
     }

     public enum RequiredOnCashCollectionType {

          IDENTITY_DOCUMENT("IDENTITY_DOCUMENT"), PICK_UP_TOKEN("PICK_UP_TOKEN");

          final String requiredOnCashCollectionType;

          RequiredOnCashCollectionType(String requiredOnCashCollectionType) {
               this.requiredOnCashCollectionType =
                       requiredOnCashCollectionType == null ? name() : requiredOnCashCollectionType;
          }

          public String toString() {
               return requiredOnCashCollectionType;
          }
     }

     @Override
     public int hashCode() {
          final int prime = 31;
          int result = 1;
          result = prime * result + ((bankList == null) ? 0 : bankList.hashCode());
          result = prime * result + ((bankTransferTime == null) ? 0 : bankTransferTime.hashCode());
          result = prime * result + ((cashTransferTime == null) ? 0 : cashTransferTime.hashCode());
          result = prime * result + ((countryAlpha3 == null) ? 0 : countryAlpha3.hashCode());
          result = prime * result + ((currency == null) ? 0 : currency.hashCode());
          result = prime * result + ((currencyHelp == null) ? 0 : currencyHelp.hashCode());
          result = prime * result + ((requiredOnCashCollection == null) ? 0 : requiredOnCashCollection.hashCode());
          result = prime * result + ((timeCreated == null) ? 0 : timeCreated.hashCode());
          result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
          result = prime * result + ((walletList == null) ? 0 : walletList.hashCode());
          result = prime * result + ((walletTransferTime == null) ? 0 : walletTransferTime.hashCode());
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
          CountryInstitutionConfigEntity other = (CountryInstitutionConfigEntity) obj;
          if (bankList == null) {
               if (other.bankList != null)
                    return false;
          } else if (!bankList.equals(other.bankList))
               return false;
          if (bankTransferTime == null) {
               if (other.bankTransferTime != null)
                    return false;
          } else if (!bankTransferTime.equals(other.bankTransferTime))
               return false;
          if (cashTransferTime == null) {
               if (other.cashTransferTime != null)
                    return false;
          } else if (!cashTransferTime.equals(other.cashTransferTime))
               return false;
          if (countryAlpha3 == null) {
               if (other.countryAlpha3 != null)
                    return false;
          } else if (!countryAlpha3.equals(other.countryAlpha3))
               return false;
          if (currency == null) {
               if (other.currency != null)
                    return false;
          } else if (!currency.equals(other.currency))
               return false;
          if (currencyHelp == null) {
               if (other.currencyHelp != null)
                    return false;
          } else if (!currencyHelp.equals(other.currencyHelp))
               return false;
          if (requiredOnCashCollection != other.requiredOnCashCollection)
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
          if (walletList == null) {
               if (other.walletList != null)
                    return false;
          } else if (!walletList.equals(other.walletList))
               return false;
          if (walletTransferTime == null) {
               if (other.walletTransferTime != null)
                    return false;
          } else if (!walletTransferTime.equals(other.walletTransferTime))
               return false;
          return true;
     }
}
