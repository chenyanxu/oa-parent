package com.kalix.oa.usecase.interview.extjs.internal;

import com.kalix.framework.core.api.osgi.KalixBundleActivator;
import com.kalix.framework.core.util.SystemUtil;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;

/**
 * Created by zangyanming on 2016/06/21.
 */
public class InitActivator extends KalixBundleActivator {
    private ServiceReference reference;
    private HttpService httpService;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        SystemUtil.startBundlePrintln(bundleContext);

        reference = bundleContext.getServiceReference(HttpService.class.getName());
        httpService = (HttpService) bundleContext.getService(reference);

        if(deploy){
            httpService.registerResources(contextPath + "/app/usecase/interview", "/min/interview", null);
            httpService.registerResources(contextPath + "/app/usecase/lecture", "/min/lecture", null);
        }
        else{
            httpService.registerResources(contextPath + "/app/usecase/interview", "/interview", null);
            httpService.registerResources(contextPath + "/app/usecase/lecture", "/lecture", null);
        }
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        SystemUtil.stopBundlePrintln(bundleContext);

        if(httpService!=null){
            httpService.unregister(contextPath +"/app/usecase/interview");
            httpService.unregister(contextPath +"/app/usecase/lecture");
        }
        if (reference != null)
            bundleContext.ungetService(reference);
    }
}
