package com.app.server.service.organizationboundedcontext.location;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.Address;
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
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            State state = new State();
            Country country = new Country();
            country.setCurrencySymbol("Ti2M4rJxFijLQp4WM2HXx1C7CoQd6MxE");
            country.setCapitalLongitude(1);
            country.setCountryCode2("5ai");
            country.setCurrencyName("MLuuMLTft9BRhT3jRvAXE3VGC3GVHmUsiO6sp7YB4lBn6MaDDd");
            country.setCapitalLatitude(5);
            country.setCountryName("f0kwQWGbSW7H4JWTkk0EhjdKBZkGWZtg5duubir5bvbpuDl1O4");
            country.setCountryFlag("CGxH2RXU6K4bU4jIDllbYUhWQIRaX5m0Wf6fnW3sIjBZiuhuLZ");
            country.setCapital("5rEPOdxeEzUBxQNrCW3DNN5EqoL00LK6");
            country.setCurrencyCode("tIv");
            country.setCountryCode1("HHP");
            country.setIsoNumeric(10);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateDescription("Do1w0meRv64dgzTPXVmcb86fXOz3i41voSnfBJEE0ABS1jOfbb");
            state.setStateCodeChar3("GVO7jPRdAeMPirxPuj7l18nxLjinGTaI");
            state.setStateCapital("QaIjt6fmE5LFY0eq0e6jj7L2g4v0CDFUFNgPGQdl7UXeEPmG6a");
            state.setStateCapitalLatitude(3);
            state.setStateCapitalLongitude(3);
            state.setStateName("QEYUVpZzevZWzVSlOnosUCeF8RJHR8U4SfYDqqqvPLJrTdwEbz");
            state.setStateCodeChar2("iPb0OASoLVAElcwwB90ipLAncNY59URg");
            state.setStateCode(2);
            state.setStateFlag("d6FK9dnhRzPxciNOY1vDr3UQRRQrpFI47rG6HRFUiZszrEP0xN");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            City city = new City();
            city.setCityFlag("xs2T3LAW1pt1jhoOD971DcH1saKLpBVW5ZOc21rrLcwNv9IZua");
            city.setCityName("GodbpyMGo21GgAW5Sxaj2ySvbK7dZreec2I73Q5ruhpfeSi7I7");
            city.setCityLatitude(10);
            city.setCityCodeChar2("4tutmaShIpJkqDffhpxT71jPfHliwaqH");
            city.setCityFlag("Ye6WTkrZBq6BaymkMjIZugwbUSL2pL3gmxYNH5Q0czpgmbGQzs");
            city.setCityName("Sy3rtAHcdaLkPo18QfyXTUgMKdDglWeLQhmyUpKYqy2P92uA9Y");
            city.setCityLatitude(10);
            city.setCityCodeChar2("HGmT60JF2AErfwF44O2tQBBtg5tD1rbj");
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityDescription("EeH6CLBYzXSBgseXm7gxbAgfCanUUYDxzEwmmwR4qlfvgcCIsr");
            city.setCityLongitude(3);
            city.setCityCode(3);
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            AddressType addresstype = new AddressType();
            addresstype.setAddressTypeIcon("GXxaA8FR9gggHU7fxvzeyb6TlKEGUxGLKKyt1KXQTqKpAmSnfv");
            addresstype.setAddressTypeDesc("43fPXJ2hyRrEUwyJokufA5Ng5hoOGc3aX8C22TIjCcQfjVJcP4");
            addresstype.setAddressType("Ztf0TnXk2M3O7XtWz2REqIdnE5NNFQ55DVCLBwiK7WjhMbxoLS");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            Address address = new Address();
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("kqTmrwRfCVwDRaQJUV8nZ70o88CVZcJF6b1hUgxvsrub0GblAj");
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey());
            address.setAddress1("Uu75ElzSzvjLMSPn5boJfxQGEUWIbRyYsXVWSrsEgEBdCaKZe5");
            address.setAddressLabel("MWrmtMqBMU3");
            address.setLongitude("dGiP9zzDzrETjegA1RTlRSei7wEUvces0G0Ipm6bEH6rpmYWYb");
            address.setZipcode("r4xIDh");
            address.setAddress2("c1FDW7yB5SwOBUBBzWuv3vslAlOHrd6j4eXSopdulzXpj4roKR");
            address.setAddress3("aFupOE9u6EHXGysCcAdImqLs1LikyS4lqNrMFR8VFjaXXKQsjO");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setVersionId(1);
            address.setLatitude("JAB0ccU4gCZOEpEEj888UaZQuQGozt5CbXDyinKDXE30mnA7wx");
            address.setAddress1("AAXoOJQCprOKS38vX8c3dwcKUmzFzSm9e80ZA9UAEfMUzvYsM7");
            address.setAddressLabel("13OEtpJ8OYv");
            address.setLongitude("J0icuM0ewyfYInBQQt8z6Bwd0I9qWmRAOaYBhirooxBCl7m91j");
            address.setZipcode("dLJaXG");
            address.setAddress2("BMFH88zkK5LcG4L8ErKGxKqy0oifUVHxyhUj0abdyfNIbJysh8");
            address.setAddress3("djclQmgxVzSCmm4tYPoGtWyGTQUuRYXufY3EebJqTwSJ8mLTq7");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
