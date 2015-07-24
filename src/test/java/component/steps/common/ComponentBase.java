package component.steps.common;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class ComponentBase {

    @Autowired
    protected MockDispatcherServlet servlet;

    @Autowired
    protected TestDataContext testDataContext;

    /**
     * Override this method to pull references from the MockDispatcherServlet.
     * This is needed because the Spring ApplicationContext that the Servlet
     * creates is separate from the ApplicationConext that Cucumber-Spring
     * creates when it runs cucumber-jvm tests. If there is a way to set the
     * Servlet ApplicationContext as the parent of the cucumber
     * ApplicationContext, it would be possible to wire these beans directly
     * into step classes.
     */
    @PostConstruct
    public void initDependencyReferences() {
    }

    

}
