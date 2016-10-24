package com.kalix.oa.system.meetingroom.extjs.internal;

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
        super.start(bundleContext);

        reference = bundleContext.getServiceReference(HttpService.class.getName());
        httpService = (HttpService) bundleContext.getService(reference);

        if(deploy){
            httpService.registerResources(contextPath + "/app/system/meetingroom", "/min/meetingroom", null);
        }
        else {
            httpService.registerResources(contextPath + "/app/system/meetingroom", "/meetingroom", null);
        }
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        super.stop(bundleContext);

        if(httpService!=null){
            httpService.unregister(contextPath +"/app/system/meetingroom");
        }
        if (reference != null)
            bundleContext.ungetService(reference);
    }
}
