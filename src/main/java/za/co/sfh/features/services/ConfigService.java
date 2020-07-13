package za.co.sfh.features.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.sfh.features.repository.entities.CountryBankListEntity;
import za.co.sfh.features.repository.entities.CountryInstitutionConfigEntity;
import za.co.sfh.features.repository.CountryInstitutionConfigRepository;
import za.co.sfh.features.repository.CountryWalletListRepository;
import za.co.sfh.features.repository.entities.CountryWalletListEntity;

import java.util.Optional;

@Service
@Slf4j
public class ConfigService {

     private CountryInstitutionConfigRepository countryInstitutionConfigRepository;
     private CountryWalletListRepository countryWalletListRepository;

     public ConfigService(CountryInstitutionConfigRepository countryInstitutionConfigRepository, CountryWalletListRepository countryWalletListRepository) {
          this.countryInstitutionConfigRepository = countryInstitutionConfigRepository;
          this.countryWalletListRepository = countryWalletListRepository;
     }

     @Transactional
     public void testDeleteConfig(String id) {
          Optional<CountryInstitutionConfigEntity> byId = countryInstitutionConfigRepository.findById(id);


          if (byId.isPresent()) {

               CountryInstitutionConfigEntity countryInstitutionConfigEntity = byId.get();
               CountryWalletListEntity countryWalletListEntity = countryInstitutionConfigEntity.getWalletList().get(0);

               countryInstitutionConfigEntity.removeCountryWalletListEntity(countryWalletListEntity);

               log.info("Rectrieved object : {}", byId);
               countryInstitutionConfigRepository.delete(countryInstitutionConfigEntity);
          }
     }

     public void testDeleteWallet(Long id) {

     }
}
