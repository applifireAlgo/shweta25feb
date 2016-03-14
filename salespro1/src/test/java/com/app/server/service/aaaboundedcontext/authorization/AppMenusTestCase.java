package com.app.server.service.aaaboundedcontext.authorization;
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
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AppMenusTestCase {

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

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
            AppMenus appmenus = new AppMenus();
            appmenus.setAppId("PT1y6uIrsWmV5JEIki2T7xD8cTdk4mjELA5qOA0hdtejVCdywU");
            appmenus.setMenuTreeId("YXaYspJ5PjBbhBdfpxQE5aVj6zM1T0LbFvnJLalYh2XVIxgy8M");
            appmenus.setMenuCommands("TiVDqiFz6abgGChi0EnlFpsuAmbUnqBB79BKhjzvdvm0w3UMTH");
            appmenus.setAutoSave(true);
            appmenus.setMenuAccessRights(4);
            appmenus.setMenuIcon("NH07yF78ZsGSbYKaNLaoaUkw0Mk9LpaA9haFXtQ17eCWNnvVTD");
            appmenus.setUiType("HQo");
            appmenus.setMenuAction("KVNsKuIRUYqgjSQIOfnYDoYxtOztdgZXcSKXDxDovTSpUzvzhH");
            appmenus.setAppType(2);
            appmenus.setRefObjectId("WtZmdIBsXkJlcERoJ8jq7bZB6VriMT1MUazdGk7D73pcXrzRoW");
            appmenus.setMenuDisplay(true);
            appmenus.setMenuLabel("9zvauHzZy6eLiOjM12mBTtQ9aVNMSnHash7uq1bljRdzSF2Ce7");
            appmenus.setMenuHead(true);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appmenus.setEntityValidator(entityValidator);
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
            appmenus.setAppId("tqXQwVBIV3CnhncfrPiS0i73cd0CjUNZcVqkvanN448VgNYi9Q");
            appmenus.setMenuTreeId("sIIhr9FM0BTSyrT6fM1XCM1AhlrmLo3oP977zaFig8UZdTD9Oy");
            appmenus.setMenuCommands("MSuHORxeHWF9wHoKUBQH4VlchNBoW8FXcgWQFB4wSioftdbDVQ");
            appmenus.setMenuAccessRights(7);
            appmenus.setMenuIcon("UrlBcHgHZPDt9B1gRVvsLRzevX3tu2HcpayIHzBgLnvE9o77zm");
            appmenus.setUiType("oKK");
            appmenus.setMenuAction("zjBJt9pBLFOpbOeePe5Qch0NjU2YaUvLp0GE3ybTo36ceuVoJD");
            appmenus.setAppType(2);
            appmenus.setRefObjectId("ewFKp3SUjGLEqbLE00SAhHi8ceybKUtekS9hBzJVVfFMjH7t8a");
            appmenus.setVersionId(1);
            appmenus.setMenuLabel("HcFlm6UdgKvYu3brCX0sYP7BdLwDSD5bvXDVdRXFGrkWQCJ5ld");
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
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
