package com.app.server.service.organizationboundedcontext.contacts;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.organizationboundedcontext.contacts.Title;
import com.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import com.app.shared.organizationboundedcontext.location.Language;
import com.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.app.shared.organizationboundedcontext.contacts.Gender;
import com.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.app.shared.organizationboundedcontext.location.Timezone;
import com.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.app.shared.organizationboundedcontext.location.Address;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationData;
import com.app.shared.organizationboundedcontext.contacts.CommunicationType;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            Title title = new Title();
            title.setTitles("3Bjklyx32dRh32Op3KtoAcFjpbgl6DC7JAajaB6nWKtvP436iy");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            Language language = new Language();
            language.setAlpha4("fI9m");
            language.setAlpha3("ZBo");
            language.setLanguageDescription("IxPJk89J2h5FlvndwQ1ZskIL7aO9VPaNJlhdhckNV94i51OhzE");
            language.setLanguage("uwfiwZJTtvFmrdJlSkMdQRoqz6HU9JWPRFZA6fbYGedJGKmPlr");
            language.setAlpha2("Ox");
            language.setLanguageType("9YZvBCJ99DSFdIBmH9HrocByHA7vclRA");
            language.setAlpha4parentid(2);
            language.setLanguageIcon("vbz04wAVaLMWhk7TIIZVEjwtZGqDcTzLLEqgbOJ28v117LzRbG");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Gender gender = new Gender();
            gender.setGender("i2FnqbeLbWg6SYnSgXDR2QkIMeHdC5mIJNQPrEDtK1Jy2RC6Vt");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("TPcTeWthLJTjEEjSZZpoMymeVPOJ5zkal82hx2wi2630kE2Qln");
            timezone.setUtcdifference(4);
            timezone.setGmtLabel("FZisHBCctWAlTzvu1CI8oMlquKxvWMxnTB6lXbRePtCoz7ciDB");
            timezone.setTimeZoneLabel("S6STF0SyVgx4v1wmCfCEbwch2zwTWbEkJy1rz2d76i9qhdJn3m");
            timezone.setCountry("aYTEzsanVOwH8CsX1G67q7uxNgAnkrheap5sHVF0YWTIyfb2Eg");
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setNativeFirstName("gIGcZVbRb5xclp5as3zLN4ESqAkPibVDTIkwHe8g2Gd8WHdAi3");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1457954732296l));
            corecontacts.setMiddleName("OjKKfxMWu5RHSNeZZ9b38dy3sPNWvQBpk2zpIMMLplPDPHhUBp");
            corecontacts.setLastName("FIqnbGfun0PjRf2GioLukTcxLuDqtgEMx204avRgcxI1tJQhBn");
            corecontacts.setNativeLastName("3AuhLcF83ryFuAexrLavv5gGV0MbD2MZA8P0vOHPbAYJnf9BNX");
            corecontacts.setNativeTitle("OJE6Kn6HdZK5lz1EqikLAZyeJL4s67F7aKrTqLuXehcYUFbU3c");
            corecontacts.setAge(53);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setFirstName("5U28Ib6Ex6VOBK9538zwmRzUK29akY1r05sLctRZrnfbA3K8TU");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1457954732331l));
            corecontacts.setEmailId("iwhAwedcJdRsUw71v25NfAajK0RjP1c1JcXT306jTowKi4VbmQ");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setPhoneNumber("kzc0L7IDgViUM6Y8qTf7");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeMiddleName("IZL2B8IUPzdcf69096LLyik57N0RXy3tP37OU8keiUVU3QJg4I");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            State state = new State();
            Country country = new Country();
            country.setCurrencySymbol("pcREoXsqA17FsHkJGcZcup7vqhYUwHuh");
            country.setCapitalLongitude(10);
            country.setCountryCode2("RzC");
            country.setCurrencyName("2i0lYcv9MtTme1brexaH94xOxEIhw7HRVYvt8jnnrHdtoleRH6");
            country.setCapitalLatitude(11);
            country.setCountryName("HSiHG5xXGuZl7J89Pp6cb4rWT69DuXcixD7mXQo8HLL4DZA9qA");
            country.setCountryFlag("wq1NYfH2IGZov1C65gLOto3p4HTMwZRniNiO5G1llWJMjb1Jut");
            country.setCapital("sghrhsuYemsHWM6QY7sh26liMBRm6UZQ");
            country.setCurrencyCode("Wql");
            country.setCountryCode1("pWM");
            country.setIsoNumeric(8);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateDescription("MoQGyL1vruQj49j4XpYGMEF5xNqUcpUISz6vBXvp5SfhVAcdp9");
            state.setStateCodeChar3("7Y7rXnC3vnt57KMAnZN48MLL7MgDIo62");
            state.setStateCapital("AyXTNqtku5bZsgazJX1mz8Tn4zZNJufR4V7nLHCsdo5p5oriBa");
            state.setStateCapitalLatitude(1);
            state.setStateCapitalLongitude(9);
            state.setStateName("YoS42JTQD2H2iSTbbfpuISeOaN1DoqrHSaZloMHsuKB8BKN9S1");
            state.setStateCodeChar2("iRV8kkSx05pFec5w76dnuWZwAqcabBEI");
            state.setStateCode(2);
            state.setStateFlag("qHaTqZTESM6pv1uvDnRJxIjY89dgYA4t0EztG6cgmHqvOcyrzH");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            City city = new City();
            city.setCityFlag("PnBJXT6k1z5IwnyJqhFUhwNgRih93IkGaHpuSAwfrHwluqftOa");
            city.setCityName("RG8tPCnWP7YRDyK1N33CEwpfodNJGaTi5VE3b9vhLt328VFUQ6");
            city.setCityLatitude(6);
            city.setCityCodeChar2("k6jXgQrKYVGMfHGlaeaWVtcF0EkAjJsV");
            city.setCityFlag("M5pyLL7PEGnwrKWMg9OLpjtlq31mHCwWxHZC4YHwFWuLBHUqG9");
            city.setCityName("5pm2zRVVml2I7vTWrTDGXZ1NiED2GdWnIL1wnrjD72sqC2fKgM");
            city.setCityLatitude(1);
            city.setCityCodeChar2("ROoe96Hm5MbKZEjEk84vRJemgwY2Z0Yd");
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityDescription("NqqDBQCEzsnFKYPLMN7JgpkELJIVShJXDn0bNqxHpMZsXtqakp");
            city.setCityLongitude(1);
            city.setCityCode(2);
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            AddressType addresstype = new AddressType();
            addresstype.setAddressTypeIcon("NUmYvNjmV5FMPfDkcEhE7xvdmFojK2gZHOl0AUeIdcMzCNSQB6");
            addresstype.setAddressTypeDesc("nP4HnsfMAcVqVMOXO5Emdvq49WUmPRCx34rYRLKjg8dF35F3F7");
            addresstype.setAddressType("phTCjQc5x7ZpWrvTKKSVbZQvwwAoW3SzDSCaS4m937STst9wR8");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("fu3LJSzlgn9dnWOMAuW7JnLQUu7yMYbOkpmiI2aCH02cI6IRhi");
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress1("Mx3OKQWl2PahUwEEGBjqSceD8LNXDj4jIAl6qDTb7cdzUnsVAc");
            address.setAddressLabel("JEY2EA7XQ3p");
            address.setLongitude("glAdTcmDUZZP481oQT6jNoiaonHFxoXXWyOnivbMoHsdJhrAW7");
            address.setZipcode("NTdPVA");
            address.setAddress2("KGCWMkBOlLiX1QRt8xBA7bEfCu8bTxTNKbGxZTusKYpjf93GDm");
            address.setAddress3("IqZXXlOOgIwb986bGk9kWZd1N5RXZC1kCTekczAwWUZ6AhjEy2");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            CommunicationType communicationtype = new CommunicationType();
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupName("KfpMeFdVWjdQlC46R1Gb6tMx4dvhPf5yDdhSE6Cfv8iWocDEnV");
            communicationgroup.setCommGroupDescription("61GHg28HQskijoXasXLX330gWwK3YaqZC2PjKMXpCsBRV4YHm5");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("ncnm2k4Uga7kmaJ5gHDUMMrsCcFXJ0ykmWmpdD5lXP7oQbkEfQ");
            communicationtype.setCommTypeName("iUaRUcogzUD4kpt5xI02GuuEATJ7lt0eDGfdchtSun81MvkU7x");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommData("c");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey());
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setNativeFirstName("jOlr1y4OVcdxmE9Up7fdEQNTbCQbAHq9qdqu4vNGnJm0IpwSyU");
            corecontacts.setVersionId(1);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1457954732796l));
            corecontacts.setMiddleName("Eu0CDt9qY91Gt1qk3MhbJ1siZCotDqUQFoVGpJ81yEpEGYNH5J");
            corecontacts.setLastName("4tAc4mcPS1QI8fz4uIR5hLyE6u04lkRRM9xwadpd8pqRUf6XDl");
            corecontacts.setNativeLastName("cWnqMukJi8mnbWaq7Pe5Vv8dS27JalsDN79cm2bEefqOEqeFW2");
            corecontacts.setNativeTitle("p6vaMevz9wuLfboWY9sgjUeuYykHZykJFL7hmc9ZHIuoZlaIIO");
            corecontacts.setAge(88);
            corecontacts.setFirstName("e36mWTSXB5W0gNgwHIuY6HuMolofInt50tg0EJyr4flpF9fI4k");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1457954732885l));
            corecontacts.setEmailId("8Z9N5g3q79AU0VBwctul9WpsTDfZQ2oQBLhqddE5y8WSDNaUfM");
            corecontacts.setPhoneNumber("z816zHQtjtx3X2RdYhTF");
            corecontacts.setNativeMiddleName("3i0cVSfUK03TjuzA21SsdBlkkAXs7Jot2gZqg38IC0HQdJtUCe");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
