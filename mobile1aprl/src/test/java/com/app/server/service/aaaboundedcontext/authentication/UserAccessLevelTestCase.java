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
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
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
public class UserAccessLevelTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

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

    private UserAccessLevel createUserAccessLevel(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelName("rkIalJcwAtOwEYzjOPbNMjG5d1o8BoMPY37uceaEDpD2wW3xBc");
        useraccesslevel.setLevelIcon("vcWMnn8NnpDvhPcfn4vgP7zaY9eadvFyBZQzlAwb40OoSHQsay");
        useraccesslevel.setLevelDescription("PrNoM0AykR8wC7QjyteVhOLLlH9zXG9EJnoKISPCxsERMRqjIa");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelHelp("672gsfELd8VLNL03tvoYoP8IC6gQ7JNTyE7TVtYTBD2IxokEg7");
        useraccesslevel.setEntityValidator(entityValidator);
        return useraccesslevel;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessLevel useraccesslevel = createUserAccessLevel(true);
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccesslevel.isValid();
            useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            UserAccessLevel useraccesslevel = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
            useraccesslevel.setLevelName("9E6u8WBok6Fa6g0yaLqqqVKCslKFq1TGtuMsJxSPD9fTvUu6AQ");
            useraccesslevel.setLevelIcon("CwjoNb7tQkHtotcAJVM4dxTAoax58V9qhtQWg44Og2NMPTCOkW");
            useraccesslevel.setLevelDescription("wCrxQNgF6wQtuh8ELfeQVmlo32xodxMf7ZyAuvxtxHfg9YagMa");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setUserAccessLevel(41334);
            useraccesslevel.setLevelHelp("fCjio1IOk8uHJWukp8r4OlLTjVEISh6MHYkcID296enZcDuRHR");
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccesslevelRepository.update(useraccesslevel);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessLevel(EntityTestCriteria contraints, UserAccessLevel useraccesslevel) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccesslevelRepository.save(useraccesslevel);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessLevel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 187847));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "KLHhPPU0BrrZW6mmQ3K4EO3rKVqeePeuGcXc2gwdmuPhZhoFmkUbPL3BcP4b02X1nmvhOpVTOahi84UmwFPrVzecfQl9WhDbrkVYRVAbrJYOFGWXi7cGvz1Uh29Bn4ayyucvYXDbEQfgViWKSrKDAs4K32X0hIWkEilNG3Xf31lRNN0WjPCfaMrrkVsIkdhSk0PjyFXgMemDLQwHFNIdSoWrn3X3yMv68SL55cmGY93uXA7DQZ92fyDc6bBnSA7rX"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "U26dSwL1IRJ8zXvZjaDHltvwwsr7YREfWmMZxuu5dDZecyMGKqZrc2XC0Ru2tBHIdUFkkmMII4ahtsIlJibwMwa47lXFU72pcP3IjBv7bqHVLPjKKgNl6P8jfV4pIENNReEeXghy4YnG4wIem7ZUadrEmqfna2hxxUGFJFjz1jc6JVXKAW7a9acSbZG3BKO07NFhwlmXMOadjeM8UwMkhlULT2z6xJm1XwPXllAkVGqVtXAmp8f09Ad5mgY1deFnO"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "rAWbxFA5BXpLC1hgpnnQWWbtt2QWOxlJSF0b3CNkdjtnqfD3BNm3U8ORkxrbLwUSycvx31AqKBVY0FjA576M7glRlVmebkHlzfGhQNBK5wfLh60sruck8r9nNe2JfPK6piao0BPj7DS1zRQAiP4VIBaSGJ7qiNaGlVecHZyYrELRMCdHuhzPSE9nvKI6ggRUIIRd0xQYJaHO5p7YIkKS4QWph7izpoRL8bePH3jrbupghAGZlfSCYcxfWN2C9Pak1"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        UserAccessLevel useraccesslevelUnique = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessLevel useraccesslevel = createUserAccessLevel(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccesslevel.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 2:
                        useraccesslevel.setUserAccessLevel(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 4:
                        useraccesslevel.setLevelName(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 6:
                        useraccesslevel.setLevelDescription(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 7:
                        useraccesslevel.setLevelHelp(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 8:
                        useraccesslevel.setLevelIcon(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 9:
                        useraccesslevel.setUserAccessLevel(useraccesslevelUnique.getUserAccessLevel());
                        validateUserAccessLevel(contraints, useraccesslevel);
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
