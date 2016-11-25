package com.kalix.oa.workflow.evectionapply.extjs.internal;

import com.kalix.framework.core.api.osgi.KalixBundleActivator;
import com.kalix.framework.core.util.SystemUtil;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;

public class InitActivator extends KalixBundleActivator {
    private ServiceReference reference;
    private HttpService httpService;


    @Override
    public void start(BundleContext bundleContext) throws Exception {
        super.start(bundleContext);

        reference = bundleContext.getServiceReference(HttpService.class.getName());
        httpService = (HttpService) bundleContext.getService(reference);

        if(deploy){
            httpService.registerResources(contextPath + "/app/workflow/evectionApply", "/min/evectionApply", null);
            httpService.registerResources(contextPath + "/app/workflow/loan", "/min/loan", null);
        }
        else{
            httpService.registerResources(contextPath + "/app/workflow/evectionApply", "/evectionApply", null);
            httpService.registerResources(contextPath + "/app/workflow/loan", "/loan", null);
        }
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        super.stop(bundleContext);

        if (reference != null)
            bundleContext.ungetService(reference);
        if (httpService != null) {
            httpService.unregister(contextPath + "/workflow/evectionApply");
            httpService.unregister(contextPath + "/workflow/loan");
        }
    }
}
