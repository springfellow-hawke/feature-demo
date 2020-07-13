package za.co.sfh.features.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.sfh.features.services.ConfigService;

@RestController
@RequestMapping("/api")
public class ConfigController {

     private ConfigService configService;

     public ConfigController(ConfigService configService) {
          this.configService = configService;
     }

     @GetMapping("/delete/config/{country-alpha3}")
     public void testDelete(@PathVariable("country-alpha3") String countryAlpha3) {
          configService.testDeleteConfig(countryAlpha3);
     }
}
