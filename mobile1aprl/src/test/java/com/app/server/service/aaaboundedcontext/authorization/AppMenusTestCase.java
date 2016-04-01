package com.app.server.service.aaaboundedcontext.authorization;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
import com.app.shared.aaaboundedcontext.authorization.AppMenus;
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
public class AppMenusTestCase extends EntityTestCriteria {

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

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

    private AppMenus createAppMenus(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        AppMenus appmenus = new AppMenus();
        appmenus.setMenuTreeId("iquJWBgLyk1ELLY6G2RKCvg500wsQLjtKZBwH808vmqJ41rhx1");
        appmenus.setMenuAccessRights(3);
        appmenus.setAppType(2);
        appmenus.setMenuHead(true);
        appmenus.setAppId("pGNe7UOb0J9sO3ISE9tSMKJuTqMVpPdpi1Dl7mNyiiVvIOD97f");
        appmenus.setMenuLabel("bAuJ1arLT4q35sdH8HGy5bcWWqJhIR1SwWQXF3DYd1W5cIb2Zc");
        appmenus.setMenuAction("fDcx3SlAZIUMoFtLKLDfYvNXhbjsc3JSrtHZRCrrGzXhm36jjh");
        appmenus.setAutoSave(true);
        appmenus.setMenuIcon("QBxjq9TeDG7NZhCWULxJ0Cx4PcgyEDRC0r0xBGUzRz9elXLw7s");
        appmenus.setUiType("D3F");
        appmenus.setRefObjectId("BCjccYuA1sYNXMw5fHkKhnbzZK5K1rOdzIovdGw2qIvENv4Ste");
        appmenus.setMenuDisplay(true);
        appmenus.setMenuCommands("DVH6zGpF32YOm0hqcmclHUoXqjpxptdHDonQsKBryhrmL1AJvf");
        appmenus.setEntityValidator(entityValidator);
        return appmenus;
    }

    @Test
    public void test1Save() {
        try {
            AppMenus appmenus = createAppMenus(true);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appmenus.isValid();
            appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            AppMenus appmenus = appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
            appmenus.setVersionId(1);
            appmenus.setMenuTreeId("8shXo612902ixNGXvGeNUwztqRfX52vZHrFr79fxtUWQWVrXlJ");
            appmenus.setMenuAccessRights(8);
            appmenus.setAppType(1);
            appmenus.setAppId("sD1BuD367CHjNgxeeWKKl5T6w6yNUIHIDStvLdjagX79nAKiU2");
            appmenus.setMenuLabel("ots2FI2wg4Dv9k94StDh51CLCIt6UhzDuOpwu5ykCuhoHfbx58");
            appmenus.setMenuAction("oqtjXNBungNcI9LnvWDCBktqRfVQgyT6GYmFlJnEnE9goiuL8q");
            appmenus.setMenuIcon("IRK4CmNkBwqufOYr1dK29MftQ9jiWGow8TZzI5phzcfuXGvOQV");
            appmenus.setUiType("QXy");
            appmenus.setRefObjectId("nhlGOeJdy9RJoGKx4wrLNurnauz6M8iTI82uuInefRJi4m2RjE");
            appmenus.setMenuCommands("VSEkBm0YqbqzsqJZM9slEPD6Crkgh3aZ1UXzmTRR1945KSWN8r");
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appmenusRepository.update(appmenus);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAppMenus(EntityTestCriteria contraints, AppMenus appmenus) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            appmenusRepository.save(appmenus);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "menuTreeId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "dR6rB6t5354sYmHkB22RhvlnweQz8JMVVRiIVgm27ZAF02BwbrP5F0y7nQpotKCTVsrhHAHUX4fVu9zD6ucXSeYWYDKVDCxtdi7bj0dNE98C1tmTTjm93M0AhDpb6Z3cvRT1nBodVjqgNjETGm5cTgmdRlVZgkIc74VvBe0ybmyShvE6Gv4Rwfqzcnj4747812q1o9yIFiWJ35IQe45FNH9oIUszlr8sSoLWw86JpbrmSow9HJdIsi7XbxoFfndeA"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "0VjX1Ipgzm7lxrXYaP53tMWJqOLlDX0w8SXPTY0ey1bg2Dsqa8y7o9sv4fKtn2KtJLRULOPBRlPd9WO15tncgunRh1tkru668Ft1932Nb4o95irkyOfvTzVKZxbaEaUyoShsXK4eydsysrSu8fmdxCtTC6PyxOvTFHCVELtUUXfUl0AfLtOM5ajNeOPEEIVmdDHMu2MgvtmJLg1u3PYg4tayPuSp9Hrepp5vhLVbXyGn7TG37wLMmRG9InWg7B5k3"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "hitHGt7IsIqUNcFK9swXh4aWXi5ekJH09XMActUzvpc3CX6w4SCe9KFSjqrvSqTTEhyqadnsSBm7gQs8AjKFu2c4sr501MnwKjpl4JUYMaEhaxyHK50Nac0WyyrDOica91xzipU48dU0j8sB8zk5xqzfyKdtaTx17x5GqhCONlyomrZIMFhcvqqzlS0t3DLuDovc0dGBDTKk7sJjZfPvEI3pdZeJfiufSo5TXDHgvn3OWH19Ba2FPYwaj6hXWWnbZ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "bNoRzx3SQ5GXaksSQgRTE6yEYXs8vP1UpXrc7a2AuWdDBuRiM3QwlLKVSuuQvBTiE"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "dSRKqkgoY4JSmL75AbimyqoRQMNYEGqzeQAzdjfoM7QDViBkd41Lx3LiLcKXa42S4GJ4kctZKOSmGsedkCHTY5MSqkiB0n9tDwfw9cCm58JXKeqILbBSDA4kZDqMZOC9v8uzFdV4wtzu5nxOGjTuJ6NEeBrt24busHMJvYMoIaQ1q7LvfnI8ScPRpHjJeWJl9TC0EnppCHBbpreL5MmYB6p1CKfSiI7WiyaZ5D5Eqe1egZXgC8RHD0DHO2Gr3Ycgh"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "HU8Y"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "5rwfUTRN90uET5lRU1hh7EwldUL2FRQGnnOp5B7gpXKNAsm99P4x3vh14LMloll8JI0a0JiklxqXvV8IW4PmR9XCapsUAq3RM2jAbXlbx5YHAH1eqhDk8Fa2PhAe45AAZoJ2IOPQpjH9CA1BvRzYQ1l8bTlBmYvf8RvGd1msZsBtACYPj0o0h5iSbTwXLXCdcZB2cFQVtFLLEHLsJnFefEZ6ygMP7iYH8pa2C4Te4jfDEp0TajLoBu8GEPOokFF4k"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 15));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 3));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "saKEgBhSJaPxZg8F0peqzCQv7LWrXbHCdq1vl3zU526j77KiYX7mTLPi7EMWheUrP6EQ6KspbAsguTazWxhdbk3yDmeS9Ls2SPvnjOSN0jzBoXPlIG0SoPpvJxI0J0sZEuRMQsU67m637niJsuQq1UWgwMJgrCTh2sHUcJ2zv68664ndK5DBC7JkxRxW70MzXMldfH0bvA58Br9Zi45jc91LljxAcaj9QBMbXvvmDjmMKyBmghtMmQED3Suj5OBHE"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 18, "autoSave", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 19, "autoSave", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                AppMenus appmenus = createAppMenus(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = appmenus.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 2:
                        appmenus.setMenuTreeId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 3:
                        appmenus.setMenuIcon(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 4:
                        appmenus.setMenuAction(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 5:
                        appmenus.setMenuCommands(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 6:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 7:
                        break;
                    case 8:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 9:
                        break;
                    case 10:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 11:
                        appmenus.setMenuLabel(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 12:
                        appmenus.setUiType(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 13:
                        appmenus.setRefObjectId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 14:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 15:
                        appmenus.setMenuAccessRights(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 16:
                        appmenus.setAppType(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 17:
                        appmenus.setAppId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 18:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 19:
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
