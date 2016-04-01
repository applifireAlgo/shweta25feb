package com.app.server.service.aaaboundedcontext.authentication;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.aaaboundedcontext.authentication.LoginRepository;
import com.app.shared.aaaboundedcontext.authentication.Login;
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
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
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
import com.app.shared.aaaboundedcontext.authentication.User;
import com.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.app.shared.aaaboundedcontext.authentication.PassRecovery;
import com.app.shared.aaaboundedcontext.authentication.Question;
import com.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import com.app.shared.aaaboundedcontext.authentication.UserData;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase extends EntityTestCriteria {

    @Autowired
    private LoginRepository<Login> loginRepository;

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

    private Login createLogin(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setFirstName("aV1CD2S16lhTSy3v7vmTAikhZ9wykeXRBdhB0ZfGLDoAgtWzKD");
        corecontacts.setEmailId("fg1ep7NbJfUsNTk8PoIIjOwoi0t0pwztBTXlumdkvpj9K0hWTy");
        Gender gender = new Gender();
        gender.setGender("LFeFiEMSGcuD0lGem9gYRX203uEqje2l0Oyeb9fsFMxdGn3qes");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setGmtLabel("wF1e14yLOHxZuxxlTVJv3pxgjFv3cMGFALEWtZygBntwm5EKT1");
        timezone.setUtcdifference(3);
        timezone.setTimeZoneLabel("YPJoqWTsvZEpBU6B8Rp9HQDMP3DrwDqY5Ax2G0VXhk9jIM0bU1");
        timezone.setCities("UjJahcES8KHRC0SWhE8RDeq2AYWB2XLMQGNHOQadaW8jILEfRi");
        timezone.setCountry("NAhNEXoCYWhAJiYrVZrRrQ8TY0BQlqwO2aOcZfKGq9temOsStC");
        Title title = new Title();
        title.setTitles("128NTEooqxYv1X1b4NB36sQRJ4cNj7V7OuY0gYD6NAf8Zf9BC1");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Language language = new Language();
        language.setAlpha4parentid(2);
        language.setAlpha4("S6Df");
        language.setAlpha2("cp");
        language.setAlpha3("n1t");
        language.setLanguage("jp22ZcQbvWz0Dmrv5l9o4vwpAkzsnWUG7Ubs8RvkFyKLVPrUNz");
        language.setLanguageIcon("A3QntVra1lV0txl1zv6RFWsO6CDEzCgNwyxCwgN8tDGbwp7OW8");
        language.setLanguageDescription("gDhKBv2lZ9XB9PXqGIoJ3ISmJYs926eJuhnd3DMIoTXyIvcmky");
        language.setLanguageType("hXW9owwPMYxCGsC3LNmHG7g8TTURljnx");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        corecontacts.setFirstName("1ScPFSrDU8Az7IIFT6lf1xXe8XOfmOSziSmW7aEwQWcMUAIQh1");
        corecontacts.setEmailId("q5GGdrwuLDG18hPZqRjtl19K2gVH6uuzRddzJCY3jldFbIcSZ1");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setLastName("EJWlsbZfrDnNQs0G55e8EFeTn4KxwrQFBmrXwXKSo142v8DmlE");
        corecontacts.setPhoneNumber("9WSDmJiy2eRqkdhO35Qg");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459499551901l));
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setNativeFirstName("65Ml1Mf4TOb38PX58xyHdzsmsD4cutFvgILSdyAgt37JQi0NxS");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(40);
        corecontacts.setNativeTitle("7pg0SDTsRfYCRk421DocX2FUbB4Wmc51AgCtdQnjGPTBmSQYhq");
        corecontacts.setMiddleName("Qa7eEG79e123zazEfcCvADrIf01GihpvPpnJyYfGaCMRu0NKV6");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459499551995l));
        corecontacts.setNativeMiddleName("OksKaVVU7P9DjFJ3txdqlLFKpC2ToHUPMlWwVTotqTdPFhLy8R");
        corecontacts.setNativeLastName("zvbfMd0ctmeczrhrHgjtS2ptQ7r70MWxh5g2Zcxy7IcqbAbCNO");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("bi7CubmhLA6XGq7usNtg2sH8RfyKo92djeOP2gYkt19njGEdMz");
        communicationgroup.setCommGroupDescription("DoIL2QzKdhfbLfs8w8g9Pgt64Eclo0wCnJTeqiKu3tYxWgm3OA");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("V4zPzfekxPtZBivv1JXWG40YZMKwvUyNWPximHl5Wb6WxQU2NY");
        communicationtype.setCommTypeName("436hmVjcotw6yUwOtbwOvNvr8K2qfpDyVAeAs48U6mFG1I0Zta");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeDescription("2VDb04nFgvY1M3i8O8fLnYc5BE1flPGiehYTGmfDZiyXL7e1zD");
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
        address.setAddress1("HVZQGvMvzWqkqlvkfPKtvThB74VkQrBEWfZj7scQeKxME1xHwi");
        address.setZipcode("RS17Q5");
        address.setAddress2("XOGcS4XyNXb9D65gqHji16QwTz8lP9kniTMPu7z7vqTNOUxOae");
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("v8cfK1wF8a1B0HPuuL4Ip0XWIAS6xOqGxRjr0mBywmXmPzNVBJ");
        addresstype.setAddressType("DWmGaG8x3LSVQ8IsYCq9N9LnTQTYPuJyJ6YtBR2KXdYyDji71l");
        addresstype.setAddressTypeDesc("yaxi7SpT4Dk7HTVxGNzFIhUBzqXFuLFKTAiix92CuZPq42BcsW");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        Country country = new Country();
        country.setCountryCode1("LKw");
        country.setCurrencyCode("W5Y");
        country.setCurrencyName("jiRjTxWecAxZnCSKRZ1hdj6gJX6WfvXuf3uUfgxjpfomtQMiop");
        country.setCapital("uu6NhsTNl37ZiWYqBoeW6R8maBVhi3wZ");
        country.setCountryName("LEEsiLCvHPAvZdcdFutdlzIneFF2jnmsft5qaGaOrfzzYqYXCA");
        country.setIsoNumeric(856);
        country.setCountryCode2("WLm");
        country.setCountryFlag("I8I71b1BXnWxTtIohXuzrDNF0fXtWgH9ukj7FuaTwX7lbHqoox");
        country.setCurrencySymbol("qjFSniBlBS1nG2M3UrtsbUfSzX4UwIJS");
        country.setCapitalLatitude(8);
        country.setCapitalLongitude(7);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateCapitalLatitude(4);
        state.setStateFlag("ku5I1CiEyy3pVD30pHChq4bi3kO2epHGfA1TwVqdkC3RTGsBgQ");
        state.setStateName("oq4T8IcDsNRuGhO18WWUUhMTESLNC0YXaP0JrJPlG4NNhUv2co");
        state.setStateCapitalLongitude(2);
        state.setStateDescription("Zf5WTR1kegYaZvJ2sWtM29atcAVhkLtfWivfj31ZrNZuHFSQoo");
        state.setStateCode(1);
        state.setStateCapitalLatitude(10);
        state.setStateFlag("Fy0KtQ1XBrb3jDutt1oWycDNzcJrcaM9MV87FU8V2FuTJD0nmk");
        state.setStateName("EXFF4UhZkWhROfpvS6CKcwpheUrb6anyb6IJ2VgSfySIxmIsVh");
        state.setStateCapitalLongitude(11);
        state.setStateDescription("kaRdecshmvrphWx9XWCgCP4G9VDTYpE1ve0E6w5TTeUq9RPLI6");
        state.setStateCode(1);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar2("G0vqsXuKrtmTDOjCw6m5VEtLjJkZtpIA");
        state.setStateCodeChar3("5jE6ugBx9OwFDjaBYtARlENa2rKzFGvO");
        state.setStateCapital("XFHKIha6hNSzh0HUOHdcWlTr9We7KbG38mV83bMMoupl60aZ88");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityLongitude(10);
        city.setCityLongitude(7);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCode(2);
        city.setCityCodeChar2("rqxp8B8LdJXOm2BGxZQFtNX5ryCVtchG");
        city.setCityName("ZawBelo0xfKVwX9fXwuUfxNBRJMkpMdDVdRy3BTK39CjJ41tmp");
        city.setCityDescription("NUoVLaGFv4AwmZhCoZPpClchYZZ9eO1shLcaIHrQJ4D6HqETfC");
        city.setCityLatitude(11);
        city.setCityFlag("FmH9T37yHH9OFyRWmKFQeQ91XOgQsazWFqQ8pJHEDZLhX6NAmD");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setAddress1("4sbrkBYuqgI4fK6aWT383EH1kKiMEMAUlL4fiURojF7eXF15HX");
        address.setZipcode("xtrtvh");
        address.setAddress2("pspKJ1jsqKi9x52wMUKjohV6ixrf3Cl1T3XOQQqsujgdMd6VgP");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("hJWKVYayb5YXLDrJqq5xqofX2FoUlhmgTOxvqeO9CrejFWBYJN");
        address.setAddressLabel("wCkY8po6ViL");
        address.setAddress3("Vg9Tn9dH02aSCyXIZnU7TyeMbMv0IKnYBooVyQyDhGPLhlIqtu");
        address.setLongitude("vkAogcTOkh4IMzEfsHVjlfA8qNyBZGZVbmADhVNlPjwAtNzNSx");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        User user = new User();
        user.setChangePasswordNextLogin(1);
        user.setGenTempOneTimePassword(1);
        user.setIsDeleted(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1459499552314l));
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelName("O1QVvqSz37VKHu1RpqC9x0jAfzDjFeoXdPTyy8BFe6aYrCnrVR");
        useraccesslevel.setLevelIcon("nivNTJXFJ1fbpgizLkXCA01ZUP5y62hMV0JiJczAguYJvcgBKh");
        useraccesslevel.setLevelDescription("RdEMBaWt210ALc66sHXNZb29hN3jbrA5Odj73yft9FAdiIXTLA");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelHelp("nIPT1tfBHCAFax5MS01YpS1PJgMhXwXhWEFQLdAhNlkuxslPvV");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainName("4HkRrkI8R6uId9LS56l0SgYEQjyb2ZfqY388iluzkwTtlBiyzX");
        useraccessdomain.setDomainIcon("QUunOvnx6teBLYdMYgZVDgwqTIVq3aTtGp9gANnk98z7ZL5gm7");
        useraccessdomain.setDomainHelp("7DXOTUNONWul3CCtXdAUJFYGDUHVE9uZq3akEr09oCS6iZvMcu");
        useraccessdomain.setDomainDescription("IPeM9IfIYmkyngYtQIGOz4q8CHbrhU5Ue9OAGK7fxFHUvI2AKa");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        user.setChangePasswordNextLogin(1);
        user.setGenTempOneTimePassword(1);
        user.setIsDeleted(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1459499552332l));
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setSessionTimeout(525);
        user.setUserAccessCode(54647);
        user.setIsLocked(1);
        user.setPasswordExpiryDate(new java.sql.Timestamp(1459499552361l));
        user.setMultiFactorAuthEnabled(1);
        user.setPasswordAlgo("HJKpRUpPMLYpiMQhjiUxSlmOLfNV1Pmoj6lpwTmQG9sFZeplxr");
        user.setAllowMultipleLogin(1);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        passrecovery.setAnswer("tTxYFq0NiaVCWOC5F4wctOibP16Yli5zuJpNi3XEBkLwtNXSwO");
        Question question = new Question();
        question.setQuestionIcon("J6htvyVOxSDA3Etk4rp4IM07FpWqn2c0u1lXD1VmkwNcsBaH3x");
        question.setQuestion("04VBfipLKQjN3wQc2Z2tBVrGH8Lvup9oIJ2foZRPGsqQOkqhmR");
        question.setQuestionDetails("teqfYIAY6x");
        question.setLevelid(5);
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setAnswer("TC6tKKBonMbHL1mXcrLB5IPqgA2oJWyxZOnypAESDAsXTbFz8T");
        passrecovery.setUser(user);
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459499552527l));
        userdata.setPassword("jYv4ooEfnhqskFkoXK7rhiqHferv2ihFW0IMAnY3JGBcKs5g73");
        userdata.setLast5Passwords("BUnxanUSuK7vkor39KdVc2dQMGwEwNINs6ybn8iLNrbB7FSMpg");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459499552546l));
        userdata.setPassword("qXGrKktqV4UNrlFwo1vX50bHNfup4rW57wnm5wCCVlmrxE2mpH");
        userdata.setLast5Passwords("0TYtiRme7MNeaDRXwQjvlUBZYsnUIw5qqMjTQ6AlwX8z4w23BW");
        userdata.setUser(user);
        userdata.setOneTimePasswordExpiry(9);
        userdata.setOneTimePassword("PEm2bdUYi7RszhnTfZsOjwyXLevFedtj");
        user.setUserData(userdata);
        Login login = new Login();
        login.setFailedLoginAttempts(10);
        login.setServerAuthText("zNcEdbDGr6MxV0k9");
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setIsAuthenticated(true);
        login.setServerAuthImage("PQ1tSaiR0rhteMQGeORrSdghHqtibE67");
        user.setUserId(null);
        login.setUser(user);
        login.setLoginId("4sDHTKHCrsFbtrAzM69hBYBeFMSKNDc9xapfahCXpxHhi1ixKZ");
        login.setEntityValidator(entityValidator);
        return login;
    }

    @Test
    public void test1Save() {
        try {
            Login login = createLogin(true);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(7);
            login.setServerAuthText("lnS3O3mhMt3qMrP2");
            login.setVersionId(1);
            login.setServerAuthImage("W5AFUhk0aY0fdQs0wLRzcFl2M0ZLz2x9");
            login.setLoginId("KpsWHDlZGjVKbqicivlYb1Pi6UNiPAN70ZaRHAi0ni0GM969sT");
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
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

    private void validateLogin(EntityTestCriteria contraints, Login login) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            login.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            login.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            login.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            loginRepository.save(login);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "loginId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "KVzJZgaw6mAoy4PY0DyyIt2rXN6EBbxwLSVfUA9xJzjNM23gowjIH2pp6X5YEphSod8KHVsRIj1t2Kq7xrG7EcgoZwCQibm1KB0PXVNfLdv5MIkh9S1EXPmg97DtUEvDtbU95rMcQklsdNgrls2Llrso3u9Lk1Tpivnbsk9IywzKVOV9sXaPA7ySnClGz88Ch9vJcsDru"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "TceQc1dQlNslLkUZEjB390pU8CEuSnAH5"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "0jNiCc5pefXUJ890c"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 13));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "isAuthenticated", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Login login = createLogin(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = login.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(login, null);
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 2:
                        login.setLoginId(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 3:
                        login.setServerAuthImage(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 4:
                        login.setServerAuthText(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 5:
                        login.setFailedLoginAttempts(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 6:
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
