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
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class UserAccessDomainTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

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

    private UserAccessDomain createUserAccessDomain(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainName("y4PW5RcMJD7dF7pM81O6H98t0to4eP0WgaI7Y9AXMvJMjfJBIg");
        useraccessdomain.setDomainIcon("7IJR8nj1sCnes6dM8vSsHLKI2raGlAwSZOm1bt8YmBzFzOINy1");
        useraccessdomain.setDomainHelp("PDRWtSuASzA1gsV1mgnnc6K1mLrd8X5gNBmqHL5Hg6GbfyfbeA");
        useraccessdomain.setDomainDescription("gRlTrjtekGR5AdaWy47x9lk8r3j2DIwgmuIrueLsC9N8Te1Erg");
        useraccessdomain.setEntityValidator(entityValidator);
        return useraccessdomain;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessDomain useraccessdomain = createUserAccessDomain(true);
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccessdomain.isValid();
            useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            UserAccessDomain useraccessdomain = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
            useraccessdomain.setUserAccessDomain(95207);
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainName("x2rnV2dxyejHmPEskiowqcjgnwzhQUcQEe5kebClFvb1dSnvCg");
            useraccessdomain.setDomainIcon("co5XtinUHXJm7DmLoALyd8szUpeA3bWDOKPIvPZzaJVAWYwb1l");
            useraccessdomain.setDomainHelp("NWCbVr8RQi8uSDzJ6ZBlg5ZENlvN1Wi8Zkh4DFC5FxswYWWdHd");
            useraccessdomain.setDomainDescription("vFcg520jaQQXEwWPoda6NCWcjspI0lXh32z16Je960BA7mmsFL");
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccessdomainRepository.update(useraccessdomain);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessDomain(EntityTestCriteria contraints, UserAccessDomain useraccessdomain) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccessdomainRepository.save(useraccessdomain);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessDomain", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 134498));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "2sQlIwmu5AUah03IlRzuI63P86TEyirC9YyUPTfqEM2ao807MgNypfXRYHA43OM4YWZXq7WO3jh64FmPTWWDhBOzBEC9lAOuEs4k0xr78d2CrkDfB3jtVBKI7BqodBjuq0utpVeQDfaaswZeWKelO2OiltIjEpBqQSuC2PynVD6nSIsYCjgojtifjzzYeFgUgptqCS93e6comvjXBZxCyTUQvz6mYvX8I7hylYVSgpFuF7ka9UfouB6FPv8EDcc4N"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "RRD6cI6Oyqd36esh5xrnsWhZXWIPTDZ2ecJY7OMsBMTa1w5lE1N2N66yNCRr9oLCSpoIgUBSMKEBLDVbjkYo9OYf5TIuRnkNpH4GAWZcPXCmX5CwkuF52FQyjYRrk1VrReIzqqMp9CRllfhmNYtf3LLpRccu3A6igBbUHmRepR6k6ftIAzueGcbgxMKKpuhGStop4aeApjXeGHISZ1ZukF6vWGIGLHaUpnV5I6VrwB9eoTskWt5tVlZfjB8C2JXeR"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "JItd20cUOwj4kVq4mmyO2ZcgLbLdL2gRqyCF3QBH1EeAFtkaUHph13mMQXQ6pXJlfvpiPxPHHKV9v2n0uyuEtDKS7piv4H6isUB2QHH0Wfb2CwIsda2PzLkRb8zqW0cdq4OzAwXTbzVyQqhlXAa4JcV7qTcZo39lozp6R4a7412EqcWheMd8lExxw77uuumC2rgd4CEMWWnMpk6DZtAfUNYil8LOKNBvgcISTNXC8uyRnLHkxAL1sSu8NEY3lNLrB"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        UserAccessDomain useraccessdomainUnique = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessDomain useraccessdomain = createUserAccessDomain(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccessdomain.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 2:
                        useraccessdomain.setUserAccessDomain(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 4:
                        useraccessdomain.setDomainName(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 6:
                        useraccessdomain.setDomainDescription(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 7:
                        useraccessdomain.setDomainHelp(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 8:
                        useraccessdomain.setDomainIcon(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 9:
                        useraccessdomain.setUserAccessDomain(useraccessdomainUnique.getUserAccessDomain());
                        validateUserAccessDomain(contraints, useraccessdomain);
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
