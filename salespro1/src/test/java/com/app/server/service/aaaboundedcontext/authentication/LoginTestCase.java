package com.app.server.service.aaaboundedcontext.authentication;
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
import com.app.shared.aaaboundedcontext.authentication.User;
import com.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.app.shared.aaaboundedcontext.authentication.PassRecovery;
import com.app.shared.aaaboundedcontext.authentication.Question;
import com.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import com.app.shared.aaaboundedcontext.authentication.UserData;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setNativeFirstName("18k9P5Zswaa7g2Z1seJVvF98etwkOPEvxDhpzJOH4Ifp06bnUv");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1457954738226l));
            corecontacts.setMiddleName("qnY1NMgzNnx4FtoBbm4kAKlZ50gY3VFHQnu4NVgOgmzVoco5wA");
            corecontacts.setLastName("mfeV8ad2ctmytjjjXSqppxalcCqXFkRpfyBYvUjVeOJ67hgZ1A");
            corecontacts.setNativeLastName("KWDph9wvPzyciKQmMbHz1bo5kUqmbnBd0TpZRhAKYmN1XTLF4s");
            corecontacts.setNativeTitle("zFv0mIYo0TUeRtzz63Sz2FEeuwuy4ItUXnY0rdPjqN5mDnAwiA");
            corecontacts.setAge(16);
            Title title = new Title();
            title.setTitles("nULX63EzlbDmb1MkyzvzvrMb9FP1KltnJ69lZR9FN4V7EF0r6d");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            Language language = new Language();
            language.setAlpha4("xZRX");
            language.setAlpha3("Fy7");
            language.setLanguageDescription("GgANBSPxqqTNqKJZHteNoQhVoNoELDXrEvxxysf5FvoZU4bzZa");
            language.setLanguage("Mf5942uN5penrlt79EL63pwHnjl0m87b0yYdxAIis8CEqUc59F");
            language.setAlpha2("wl");
            language.setLanguageType("5uWq9OJJeO0hI4KIrao0ejlAgRubwgbb");
            language.setAlpha4parentid(2);
            language.setLanguageIcon("I6APHfMCZciIJqPTArHmjSdPNdKUetAjGgNlXumrTjmOZMh303");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Gender gender = new Gender();
            gender.setGender("7D4zkU0UePOnjUB2QQsFSUWPoh3pWUgaRRqZlbx9KslITVB6Zv");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("B7QdDQJYM7BOL0yvphafRC7yMWcTwsT9LZuLPL0lMMnINUlbsB");
            timezone.setUtcdifference(6);
            timezone.setGmtLabel("02CcTg6SvBqm2406Z3yxqHTuT9ozjG1EWHbGhq3atVq8IwvQy9");
            timezone.setTimeZoneLabel("0D2PorqRROjTp6E9FZZZiSxd6xNypfET6Pc8myac0VzvCdFg08");
            timezone.setCountry("3Hxo7ApGPHX3PiOWieu1Nr29pQBCNOjcqmdfe8AEV0YwT1H4aC");
            corecontacts.setNativeFirstName("QnE4YIB6TngP8wmJ0SYyKEJ3inqs2t6AGHWp4Zjgjg9KuwPbYw");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1457954738244l));
            corecontacts.setMiddleName("hfPVroA8sg1NJIGebEB4DGolVrCcCqPOymAWdxLnbPQKGf6dof");
            corecontacts.setLastName("bhUNs3mcjAfQcV7UQu2rZQan80VLmwYlM4qR7q7vlmnM27Qcba");
            corecontacts.setNativeLastName("JXE6Ju8OT8ruXJ8c87JcSGzC6OlY6QqovKqq80JZF9NRghhKV5");
            corecontacts.setNativeTitle("AKTV4duSk2iBHhud8QEVRVRCpDwEmeRO025GXrlpV5VIPSi788");
            corecontacts.setAge(29);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setFirstName("ecPCTJutTEnPAgyftj34d0uKJ26tWY4S9GxhfzIYUgwK4pLa9z");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1457954738283l));
            corecontacts.setEmailId("az4o6fov0gn96lQADh2bcmDod0JyyjtISQR32djjrTj2Us1rK6");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setPhoneNumber("XwT4krzUjXhGjTYomOGD");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeMiddleName("2T4PxvJCFesgLC2CcCNYlRzU7g87W2vAZCqcIq6Rnqz0Sj3jvl");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            State state = new State();
            Country country = new Country();
            country.setCurrencySymbol("XmdwCtG1493DsLt4ulIjxlpW51dEHLm5");
            country.setCapitalLongitude(11);
            country.setCountryCode2("ivA");
            country.setCurrencyName("5K3hpWON8CWMCTYJeQEIvFGm436wk4ay14YWkAdzLJGZLVpKLZ");
            country.setCapitalLatitude(3);
            country.setCountryName("U7K7TUQ5XpFrZlX8A259aU8rC2SVTb2kD6XvZL1n12nsToqCEu");
            country.setCountryFlag("d2vbUGbr108RPhjmHoCbh7kbjfQHEOIIGeMY7ld8txzvH2lBNy");
            country.setCapital("FxwjQgHjU64YiUVW8RJbpYtvKdZtri5M");
            country.setCurrencyCode("oCe");
            country.setCountryCode1("hq5");
            country.setIsoNumeric(8);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateDescription("6e5MyzTtr575QILCTPN1oEsK8esgkVCYNVptbktm3MhMzg7SMS");
            state.setStateCodeChar3("lRYCx1VjSNepfFi6LjlrTTxkfAHWRC1d");
            state.setStateCapital("SyKEVhfiaEcfZpsgdfcrp3Ww7Ew1PoGP0yhIt7OIf3zvlis5Na");
            state.setStateCapitalLatitude(6);
            state.setStateCapitalLongitude(4);
            state.setStateName("RBWZR9k5o7kqeXbFfV1E3XaKRdm7Ccl3w5DzeSV7hLoSyGL5OB");
            state.setStateCodeChar2("cqpHPnvjoxHSDVL8WNeHsefaaFYK72wQ");
            state.setStateCode(1);
            state.setStateFlag("He6TgEjwqiGcrqSSCqoBvJ3c9xjey6pjWCjsMTGkhRjTYYoVEt");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            City city = new City();
            city.setCityFlag("aR3gYQtIhV7myG46a4wbGKTHaSNnt1LCtAq1CKHJXvXstwTOnj");
            city.setCityName("s1vcx7XL8VFodQHZSFLWi0kXTXJOns1yhrdQI8haYSCoHcxmsk");
            city.setCityLatitude(7);
            city.setCityCodeChar2("zRp5HU7FK6VDYlGLbp8JPxkUgWdEv888");
            city.setCityFlag("9vZhE0eyAfEecaNHE2CV8wuDTutfCVKZ28DfJheMnoyMex4FYG");
            city.setCityName("JVsxwyJfvrbNbLejBxkWFdFFIyC64xKOPSpLipJ8cVIt86ofdq");
            city.setCityLatitude(3);
            city.setCityCodeChar2("51YtNoR5iTXNzENXYrJVaByVbcwggMOU");
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityDescription("sFvWNG1G91pPtEu3l9t0GqP0zOI5YDHRi2UdkUhvhUONhMSiYn");
            city.setCityLongitude(10);
            city.setCityCode(3);
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            AddressType addresstype = new AddressType();
            addresstype.setAddressTypeIcon("OKnaIv8dlXFXL2ZeEWbSrgv6xR9zmLxA1uQQGhotCKkyNM7Afk");
            addresstype.setAddressTypeDesc("tTekF4dcR33oIuKuF6qgX1UvTDtab3Bfz4PPrLTOeT7OfBRbFT");
            addresstype.setAddressType("BybGbruGx1sVPghXQ33TpWPMTRKjbUrKXXeAnmLxOgKwhD6pxx");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("EoVLvMzn02o64OUZl6MylQg5tksBpX9Sd28zVkpONguMGqPye5");
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress1("cQ5CYqm62Ym9jTMlQNiLj4FagDj4n0rbuiP5FlNlZA4IqwvtEE");
            address.setAddressLabel("GM5XPESCndb");
            address.setLongitude("Ow0EIuFuesXt5YTpoV6wGWhFcJ3zmTgv3OFQ5PTyiaEhJMfnmD");
            address.setZipcode("xsTQCB");
            address.setAddress2("i7GbcAnpvuH0z10eF2JgC8x5mOJnVOwROkAxtXCIShrTSG4SuK");
            address.setAddress3("hsiOcs2cfCivzWCXFeyEdFrHiHpqFKMMRyNtpQB07JxvYzGggI");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            CommunicationType communicationtype = new CommunicationType();
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupName("GJYDh7pk95Z53Pse4CSKujEvF3voAIPPm41LA8zihxIP155pdi");
            communicationgroup.setCommGroupDescription("HLkPEQYvaL4CuxtTA7w1XJkxcM1wl5stsGHYbkqJBLcWOiqvcY");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("TKCPfBloiABjccQIHJ6uexZw1nbRXzvpnXDuefNGyBgGM8Fbn4");
            communicationtype.setCommTypeName("PyybmcP0HanoKpskgvwk6acVOWencIeVwsKkDpxBvvMGdnjQxy");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommData("3");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            User user = new User();
            user.setPasswordAlgo("PIJfEwrmyGT6KIoUkEajMhmKTfyl2GdBBK7rb1fWJGnD3LidB1");
            user.setLastPasswordChangeDate(new java.sql.Timestamp(1457954738742l));
            user.setGenTempOneTimePassword(1);
            user.setIsLocked(1);
            user.setMultiFactorAuthEnabled(1);
            user.setAllowMultipleLogin(1);
            user.setUserAccessCode(49867);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainHelp("cGR9R5xmGMvzlonH7jtfjdgE9s1RROBvO5iMco7vctiRgkoB9E");
            useraccessdomain.setDomainDescription("zSZxJ6Wc0qgZeDACfWmXmGPyU4Lwv0EAksm0jrOgfv0b8knt0Z");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            useraccessdomain.setDomainName("oyvo1v7Pe73qvC3D9TDRuHAv8oJHntBzTA5khLusM1lH7e0X8M");
            useraccessdomain.setDomainIcon("cFq9TmrK805VPssmKxJEILRd0TyP5maKq5uoxWsY9oqxR8KmzW");
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelIcon("l79aiqZoEV0oaeqE2ny9h1u7uXhtvxKSZixJImqpAOgZxQJMqR");
            useraccesslevel.setLevelName("GphVO2kq1vUbuo11QGgm30olfikyeS5s9sb3yKYwtF4E6kS8of");
            useraccesslevel.setLevelDescription("dErjqaNXDd7SSWwwGeHorTBxG8ypCjqnPohjuARTxofJ5kp8Pw");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            useraccesslevel.setLevelHelp("STmmWwfBIjbvMyHcEHQgDeVBNOn841xAXsKys0EhUpXxchuYdg");
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setPasswordAlgo("MDJo6cyhBgoo2wRfkzDR0RbBgrrBVyMCAner3PhwKarRfLMXhA");
            user.setLastPasswordChangeDate(new java.sql.Timestamp(1457954738768l));
            user.setGenTempOneTimePassword(1);
            user.setIsLocked(1);
            user.setMultiFactorAuthEnabled(1);
            user.setAllowMultipleLogin(1);
            user.setUserAccessCode(59338);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setSessionTimeout(629);
            user.setPasswordExpiryDate(new java.sql.Timestamp(1457954738808l));
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setIsDeleted(1);
            user.setChangePasswordNextLogin(1);
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            Question question = new Question();
            question.setQuestion("kkdJ0RbIjeipeI4Ux572z5yDEQ3AF4oyEEUoX4ISjnTRRwyEYt");
            question.setQuestionDetails("e");
            question.setQuestionIcon("0RoqgauxmLlfwBMe7JaXVQQNlbORtNBveH96EgUfBSKNUt5vWW");
            question.setLevelid(1);
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setUser(user);
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
            passrecovery.setAnswer("xxuVbKRH4PoMRCm4IeQqjDQPfMQaYqiHMMJM0bQQkiUr0w2t1M");
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setUser(user);
            userdata.setLast5Passwords("AiC1UtycPVnvQ16MrTWDowbxMAyrcC1pNGYtjDLbDqoEAzGEU6");
            userdata.setOneTimePasswordExpiry(3);
            userdata.setPassword("V3ymEBXmzBAgWzUWcp8ywMSec5gIlbFDrHunbDjR6fmwjWCFRQ");
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1457954739092l));
            userdata.setOneTimePassword("I6BKTlp1N0paNB518g0Zzvk3ElZ3MTOx");
            user.setUserData(userdata);
            Login login = new Login();
            login.setFailedLoginAttempts(10);
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setLoginId("aVPqiGt0bxQB0EgSHUs4daqsJtrdtNptw1uOkMkzaHqG3sU46f");
            user.setUserId(null);
            login.setUser(user);
            login.setServerAuthText("z0Bchu79ekbWRy6h");
            login.setServerAuthImage("0ibA1UTBAg6ZLmospt1Y7QFezV5JR8uW");
            login.setIsAuthenticated(true);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
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

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(1);
            login.setLoginId("mQE1w6bKgRPs6gzYAEldILyo1kYMk73VmUz0cSFEZh4ruf6uUS");
            login.setVersionId(1);
            login.setServerAuthText("zQUAUqTmd03c8lax");
            login.setServerAuthImage("byaanpPP6fwCT9kl7HIqtPvakjH1wM40");
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
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
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
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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
