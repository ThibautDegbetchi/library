//package training.test.demo.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import training.test.demo.entities.Preference;
//import training.test.demo.repositories.PreferenceRepository;
//
//@Service
//public class PreferenceServiceImpl implements PreferenceService{
//    @Autowired
//    private PreferenceRepository preferenceRepository;
//
//    public void savePreference(String key, String value) {
//        Preference preference = new Preference();
//        preference.setKey(key);
//        preference.setValue(value);
//        preferenceRepository.save(preference);
//    }
//
//    public String getPreference(String key) {
//        return preferenceRepository.findById(key)
//                .map(Preference::getValue)
//                .orElse(null);
//    }
//}
