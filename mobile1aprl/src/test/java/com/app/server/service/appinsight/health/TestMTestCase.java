package com.app.server.service.appinsight.health;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appinsight.health.TestMRepository;
import com.app.shared.appinsight.health.TestM;
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
public class TestMTestCase extends EntityTestCriteria {

    @Autowired
    private TestMRepository<TestM> testmRepository;

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

    private TestM createTestM(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        TestM testm = new TestM();
        testm.setTestNM("1PV7RN1wskZvq9uiipkZnb2jYBTfPyvac3cWcbhkvuHjudmI81");
        testm.setTestNo(2147483647);
        testm.setEntityValidator(entityValidator);
        return testm;
    }

    @Test
    public void test1Save() {
        try {
            TestM testm = createTestM(true);
            testm.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            testm.isValid();
            testmRepository.save(testm);
            map.put("TestMPrimaryKey", testm._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestMPrimaryKey"));
            TestM testm = testmRepository.findById((java.lang.String) map.get("TestMPrimaryKey"));
            testm.setVersionId(1);
            testm.setTestNM("gLEm5YY284evPftFXlO9tAJBUM6oux2pGl8mviKuvCH09FicYe");
            testm.setTestNo(2147483647);
            testm.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            testmRepository.update(testm);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestMPrimaryKey"));
            testmRepository.findById((java.lang.String) map.get("TestMPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestMPrimaryKey"));
            testmRepository.delete((java.lang.String) map.get("TestMPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateTestM(EntityTestCriteria contraints, TestM testm) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            testm.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            testm.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            testm.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            testmRepository.save(testm);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "testNM", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "testNM", "Hhw9TyzysyVa0B8Sp3SJDgglWvdIDnhYtnNCMyVgbkhSgYAwnY5oqB6TvjK0w4Ntd5BozKa7yUMnvNTj8EVMOWXZWuf9FKG7RJ4Rov7FHbNPvPzdh5PLuNJt2x3HJTOFvEzzPFBOIZUSUDmVDcEZga8Pr0BU1Q1ISyrLtNaT51AudAwMIggT6YuqXWpLm1RwIWN7BHbaWRitpt3sSDKAbwkThIOn6TOvBe6KWcTVUAwafJAtj2rUn70ePGrPsSl3r"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "testNo", null));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                TestM testm = createTestM(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = testm.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(testm, null);
                        validateTestM(contraints, testm);
                        failureCount++;
                        break;
                    case 2:
                        testm.setTestNM(contraints.getNegativeValue().toString());
                        validateTestM(contraints, testm);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(testm, null);
                        validateTestM(contraints, testm);
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
