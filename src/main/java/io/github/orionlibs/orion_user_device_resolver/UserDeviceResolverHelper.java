package io.github.orionlibs.orion_user_device_resolver;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Enumeration;

class UserDeviceResolverHelper
{
    static boolean isTabletDevice(String userAgent)
    {
        if((userAgent.contains("android") || userAgent.contains("silk")) && (!(userAgent.contains("mobile"))))
        {
            return true;
        }
        return UserAgents.tabletUserAgentKeywords.stream().anyMatch(keyword -> userAgent.contains(keyword));
    }


    static boolean isMobileDevice(String userAgent, HttpServletRequest request)
    {
        if((request.getHeader(HTTPHeader.WAPProfile.get()) != null) || (request.getHeader(HTTPHeader.Profile.get()) != null))
        {
            return true;
        }
        if(userAgent.length() >= 4)
        {
            String prefix = userAgent.substring(0, 4).toLowerCase();
            if(UserAgents.mobileUserAgentPrefixes.contains(prefix))
            {
                return true;
            }
        }
        String accept = request.getHeader(HTTPHeader.Accept.get());
        if(accept.contains("wap"))
        {
            return true;
        }
        if(UserAgents.mobileUserAgentKeywords.stream().anyMatch(keyword -> userAgent.contains(keyword)))
        {
            return true;
        }
        Enumeration<String> headers = request.getHeaderNames();
        while(headers.hasMoreElements())
        {
            if(((String)(headers.nextElement())).contains("OperaMini"))
            {
                return true;
            }
        }
        return false;
    }
}
