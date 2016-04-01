package com.app.server.service.organizationboundedcontext.contacts;
import com.app.server.service.EntityTestCriteria;
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
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.organizationboundedcontext.contacts.Gender;
import com.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.app.shared.organizationboundedcontext.location.Timezone;
import com.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.app.shared.organizationboundedcontext.contacts.Title;
import com.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import com.app.shared.organizationboundedcontext.location.Language;
import com.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationData;
import com.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationType;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import com.app.shared.organizationboundedcontext.location.Address;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase extends EntityTestCriteria {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

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
        entityContraint = addingListOfFieldForNegativeTesting();
    }

    private CoreContacts createCoreContacts(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Gender gender = new Gender();
        gender.setGender("QlpuKUBzwNkinuIU0HKMaZKHJTr3sCUP2bO79Vx9tUqqwVPZ7n");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setGmtLabel("a6bnQT5iAqs2Raf1qFb6Vimk5OHB9WR2BLLXC91UEy88gZ7wKy");
        timezone.setUtcdifference(9);
        timezone.setTimeZoneLabel("mfGylW2sxAeRO3WGwULDRdJLqjS1PMyWjuANmBxnjk73rAnQiB");
        timezone.setCities("BRcr0SU67EDuuy7vPmdkLKUhaL9gCb4HKIfZZfTLtjUnboATps");
        timezone.setCountry("XGV3AeF9PKoDEEOMCkB3dQGF3zg6EOQyvx019wCO9DEolfPOGr");
        Title title = new Title();
        title.setTitles("P3k1KwcKGgp8qfWHTRHuyqGhpkW3aDVTYGxJl4Php81zqSmyGQ");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Language language = new Language();
        language.setAlpha4parentid(3);
        language.setAlpha4("8TSQ");
        language.setAlpha2("Yz");
        language.setAlpha3("OCl");
        language.setLanguage("fP6KC82c6wYiZFC0D1ocUqoA44HkSg7HdX8R44sQU0qCxC8oDy");
        language.setLanguageIcon("lT3NyG13AJqAld7qpkvMY509FMiGSIfj9eLm311kzkPJyNgukE");
        language.setLanguageDescription("rqYmNGFBKmsYUjBGkW3zuRU42thc2sEP8fDlWi99c0ycHm44kR");
        language.setLanguageType("o3PxSeHE1HtlFQlPZGqRWXVPTeshf7LR");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setFirstName("9Qt8glLM8WC998zSNEkZSmA1STy2PPWAexByHLswYlSgFZS47l");
        corecontacts.setEmailId("PPA1m09VLaTgSQGeoCQDW9hnajHcWsEn6166r4QqG3xVIPHcNj");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setLastName("BqpFTImm1DbmHN7UBSiBqhxSOfwyXRVfusuEcOMzApVV9WgfSn");
        corecontacts.setPhoneNumber("yHBgL5W1BakUfZWJRN4V");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459499544800l));
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setNativeFirstName("O9ewIC5hSKGka1FIdPaH73xd7I5vIaMyFXjrvlS4d6IsqMmsLM");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(14);
        corecontacts.setNativeTitle("2pTUsrcYtoqKmnKZmoPxk6vHXPUfFagz1y1vZ2x326CVK58xDX");
        corecontacts.setMiddleName("ctCnGMiCegMSfMSi6PkIiJnCBO1rsL5uiAtOWxXxBSfysywwYo");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459499544925l));
        corecontacts.setNativeMiddleName("veVCJKdeeoV2tgqqUhb6BGkC7QQJWwui5lgJtCOXU4UrZ1zsrf");
        corecontacts.setNativeLastName("K8UrCJqJ2tESvwzTgkf3JWBpVos7Bz3Vz4FcsdW36r4ISLfXxZ");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("vIJIyqT5tgznhE6rpmclQ93sacc14FnRXtqTIWwFq4uG1Tx6lW");
        communicationgroup.setCommGroupDescription("Vvuhh6ZOk9BQf8l20eqviGsRNnwhXk5IcimOgvKkGj24b2M1tB");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("d3Bq49RB9XsJTrHZow5gSSZYyW2cU76NrNaoXc02Cnx11ORIF1");
        communicationtype.setCommTypeName("G1VCeZSHav5YwAYOxVh65zMJ1M6TgmYUTKn6zaaENqWrBj5bGN");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeDescription("iC7YaYfkQpmHAH2ouBwmDiPsB0PrbQ3a80vUQKuhZwnlHS3Y6b");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("");
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddress1("Gv0gBvBydg5aEpQ744reEXem3Ye36KkDpr13dBmBvNTPYB1TDm");
        address.setZipcode("2QkJJB");
        address.setAddress2("fSqwxQP5gRx2MAMJEkOa336fzq7vG1s5Nt2YP5AeWyLWq4s6v7");
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("p6mpZqWEaUzVSnr7UxS2HitlxWVA5aqTI580PSVdLP9mPFbtrg");
        addresstype.setAddressType("Rs2rzZdNdEy5v76Maqw4kOENwgG4jq4vih8wtPxcvU3LTYlSxL");
        addresstype.setAddressTypeDesc("pNV8XREzEcrYr4eTUIUa5ruoSKRzWqVrTuN8WglR5JAuWkRHIe");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        Country country = new Country();
        country.setCountryCode1("Sjo");
        country.setCurrencyCode("pWA");
        country.setCurrencyName("fXYHTiUUBK2h6KxUQgpBML3TBIOdrWUjX8o5RS9xJA1F8jNZYb");
        country.setCapital("7wXVsqU6znOw0ZCjUqrHjg4Uxe6RLlmT");
        country.setCountryName("JL7bwkTbTNCWIDZclImxNi2QNx1jD4vF7I3EZUpAlGv3h3XvRE");
        country.setIsoNumeric(70);
        country.setCountryCode2("pkK");
        country.setCountryFlag("UpI0n8Ii5XHzc0gZuuBUWoFX9nMZmyiNI3hu33eqLLGwWkDpuG");
        country.setCurrencySymbol("IkgzyKISQCbYBt3eEtyZRRuIwQyMYhGA");
        country.setCapitalLatitude(4);
        country.setCapitalLongitude(9);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateCapitalLatitude(7);
        state.setStateFlag("Yogfu6O6ghp3NSMPCelHQYnjsT2CBjX3sbN9uwsy4a17Ik3whY");
        state.setStateName("jVehYPprfWbo2HA32v3KfBieeEwWAqDyYz3IdSPt2zp4xcr7CN");
        state.setStateCapitalLongitude(5);
        state.setStateDescription("BG5GWmXgT01471QJJg2NQoKjS7g4C0ROslNo4yJMzZCwe9CfC7");
        state.setStateCode(2);
        state.setStateCapitalLatitude(2);
        state.setStateFlag("hjD7ZLrwEadir3RF4Ps7He6X73L7OQ5hErpICMjBgpQupq6QwW");
        state.setStateName("PpM89UumIgHM1I3m8U5lt4u52FG4zp5oe7xQIXoqLiZFu6ISxu");
        state.setStateCapitalLongitude(8);
        state.setStateDescription("X5ciOEcqeui89SVKFz18eUp6hJGO9gwe46n70SiDNKRv8dkchz");
        state.setStateCode(1);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar2("l5AbF19D6pODSdhbwTFcnRg5aFzOdfAm");
        state.setStateCodeChar3("zgzSh1ehS1vIGkveIFHvqt0FQipO2Iv2");
        state.setStateCapital("1H3P9LbaogQwOLxX1XFL7rKxZOO5n1JDf75PQKnnS2dCXn4mv7");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityLongitude(4);
        city.setCityLongitude(4);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCode(2);
        city.setCityCodeChar2("nem24ixBR1nUYPaFt7vqzjeWHDd9pSjr");
        city.setCityName("YZkvfnaul4i030I3a4HmUHQ8CNMNXfsuqAKkzEZxCBdydRtfWS");
        city.setCityDescription("ajTVg2HHFOfKYwV48g9A9w9AlGdqarTqmfXocVgi9bQ8VdpqvO");
        city.setCityLatitude(5);
        city.setCityFlag("TLyG0YeRppuLDUKhx4UNgM7PPy4qgURwUDDH9qBG2zfwQk5w5r");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setAddress1("xnF23NcNtjKfzoSWQfSuZQvrHW7ueEipAvOPPD74ZFE6JAL2C3");
        address.setZipcode("GHSGQq");
        address.setAddress2("gne24RSHK1G2VaBhGG5bVN7K25VCvxhdpLVyQp2eAyHvxAwFln");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey());
        address.setLatitude("qk5slE17pzenO1PG4B4jslemVK62fUHjmQnFvHcDgSRsIOZg3F");
        address.setAddressLabel("laYX0vN9Dlw");
        address.setAddress3("Oan1EOgm5pzO0Hqfw5gnFG6mrVDfwpvqpKHt2p0PkofY3aGllq");
        address.setLongitude("aWneBgsW6stYRPBVCwIpGflwHIDYvwcZ2lAA06dGKKJOhPVZDj");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        corecontacts.setEntityValidator(entityValidator);
        return corecontacts;
    }

    @Test
    public void test1Save() {
        try {
            CoreContacts corecontacts = createCoreContacts(true);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
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
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setFirstName("jd3cixMupDaU6zuSuZ0R6GOFu0LfcbXDLQtIWsqdBEd1XTwdvq");
            corecontacts.setEmailId("PCBtO0wCJIprv2E6TqaHEJB31KlYdcM7k9jXKbmBMqB3rkPfo0");
            corecontacts.setLastName("POvwpDztntb9ziVDLbsDjXcpIUul97TLCKxTkgDr7E2XQhywIP");
            corecontacts.setPhoneNumber("oLIPoXmRyChjRMnag7dJ");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1459499545314l));
            corecontacts.setNativeFirstName("WXNcw7oSYlJsghE9HAIFpgZoEdpD7CzQCXvxFgFgehW06jSIwA");
            corecontacts.setAge(104);
            corecontacts.setNativeTitle("9JklqSlhyU0QWkj9HWhulTOuo8d5r5ryQCDPMszyTCdau8Emcj");
            corecontacts.setMiddleName("r66s0s14tURunqqbjDkCxZ1USuJWQLSFhrwTg66DQlopJLvDjY");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1459499545395l));
            corecontacts.setVersionId(1);
            corecontacts.setNativeMiddleName("Q8AxSOHX4Mxb7B924LbnA1r2vi4U5dqKSQOa5WSvMWdm2IdQhG");
            corecontacts.setNativeLastName("mjdhbBsdTv17l1Fd2Q1vWIqyo2mpF21CjF7iCbYSTrxIkDPhjQ");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
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
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCoreContacts(EntityTestCriteria contraints, CoreContacts corecontacts) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            corecontactsRepository.save(corecontacts);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "firstName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "hypxO6l451w1urccepr2fF1P9ssxudWndCjbscxXYLc0cv28G9kkxbDJDGpGu5KJWJcggzmpIGrSvsrxI5YwzfYxuA5Iu75PBMWkoiuiO3vtuqBWnqrDbRhWhr4DubwNEcsSN9t2Ar0eYxbWkzaTXK6TV2kGkICEQ6K6RnuFAr0HojHpVlCuFLaSYiiMr0adgX4b2OEZEoiOMpsol2PBzQbPJ1EhPgnkwqGrndJJFL8Q8uuPzP96OI7lR3Q7ykjuN"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "PYaoW79hEIUACmvKqJ0zZmNuNaaF6zFykGneENc4uXUbQpHwCo0CROB50avgRjF2mFi7b7NF1w4m9XHnh4vbaSk5XP9xBD9zcVmJV0iNUD1QJv6n0EcQLOTyDr4N5PQb0coNat25P7J7p9opKYo9ijaHuC24xTr0KswfgAOyNsknfDNZ6hcp6oDPs8HKC6qL93cVvioMxOBS9zKJozh0xglDshYTkuTQ80aLVAIeGIPvLD8wCdYgkMPhiR00ZeVR6"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "7dfyt1bl6Ywtq9dn8zqlIJl7bVIPTBBrCuE8QERTp859SQeoKfg7HgpLRMQawILCVFjnijjtijLB4uw4rD1aWJ6vb7qa6auK2UFtQu5g0y6XZX2oCKpu6M63sAtpTf0ezzANK8s36k8rAoL8zxIVgV9CZ6ARwQaMjZMbpqZhuNv5672OADrkdF8YW9zqQPpZYB9eK9wd7dmVNqJLHtj97d6NsAWbpTFj8jisvrFT3TZZ0n76SelhB7CGBhr5cfJ7u"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "i4MvC6kgA8RqcS0nB4Y6qQaLgAEHn4Mt0KsW13SC8KCHnnBMufD87hU3KWH5INxRF"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "sbNPUmkNT0Y3TyOGlypEsFzWcSGEi1hscIa2nAsV4ujx4ET9ktkXvDM6goaMjsrJI7Hqa9pDFJBXTGZZ4ytr1sNKozYrjywtbMdXv0iiuL49PuBPkpxz3v4hgmg3Yee8ZNeB92YKVvNRL6Ujmm1rm1xxm5T8S6cOuS8uaQOxGaNXpJKoJ5nWUl3vlcljNIdGHHmXArgAQ28VW7KxRyisKTq1XfQ97BRDak9Hi2LakTVYF204wVrFGuSjQkY6MXSnR"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "unVLUzN2jlz0qlnlLdhHunw3f4jyR4EZ0OYROUjo47i2xxS2X96qA92FuiyUIldyaxbV12SIiYXcSroJxi81aO0hlXYxJwYmvEDygIrGHiy01kR6gpsAvjBlui0ciR5CFhifmSTLuGlLeysXU4HPGQxmGygORyLQVHhJuw2ByvCMMhMVomS0GVMll9dvL1fmrYDgS6O1pImB7CYr0elVekUQAS7F5hnSgBYe5uq72Ev7acf75tSCJlYhryaUSOBpK"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "We8Z7Afds29dvg7fSW3i7Dahmx4XmCFNEhjsl6UtdMnX2pLirwesWNPeHLOtz9IZeVM9CbByRVQEVIDwzkNaQyVr2Fr1LahUqeWOAWDHxe51dCgPLKHMFc8D8zllnFairVjjV3DeQ8nlMkAtktTVD4BKrphd8GPbwYGL7eY74HBt3Wxq12HtyXgLoC9g0ANnycMRKcnkGFbORAGsC9g3L1LhSbsiSuEMa0bGVARnTzxVWELJ8XcjWxtw7fHKZoqQz"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 184));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "0lXGOx2cdU3U1LNuBkotVOmUs5MVe0ZyBx3pOhVIgdBKGShLXnoMzMTBWzvRUyvnZ1BlH1Oibj445e7svQoTYpFOA39BdSTXQRxHtl99ceF8AOudovi5YNfEKPDcU8btOD9debuDMh9YQjQ7pzxcqtg01GGlZbsZ1ZW2bd9j1pyYJeAfWpmqsIYk29fh44POXhGwYJhCYelQ1cuk83sXaIaCJ5p6sA8i1hpc10iFqXyEKcn9loURFlw4FJndKrUWM"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "DgEwQLHLbKlEBCqitl1AJ"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                CoreContacts corecontacts = createCoreContacts(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = corecontacts.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 2:
                        corecontacts.setFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 3:
                        corecontacts.setMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 5:
                        corecontacts.setLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 6:
                        corecontacts.setNativeTitle(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 7:
                        corecontacts.setNativeFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 8:
                        corecontacts.setNativeMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 9:
                        corecontacts.setNativeLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 10:
                        corecontacts.setAge(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 11:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 12:
                        corecontacts.setEmailId(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 13:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 14:
                        corecontacts.setPhoneNumber(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                }
            } catch (SpartanIncorrectDataException e) {
                e.printStackTrace();
            } catch (SpartanConstraintViolationException e) {
                e.printStackTrace();
            } catch (SpartanPersistenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
