package io.github.orionlibs.orion_user_device_resolver;

import jakarta.servlet.http.HttpServletRequest;

class UserDeviceResolver
{
    static UserDeviceType resolveDeviceType(HttpServletRequest request)
    {
        String userAgent = request.getHeader(HTTPHeader.UserAgent.get());
        if(userAgent != null)
        {
            userAgent = userAgent.toLowerCase();
            if(UserDeviceResolverHelper.isTabletDevice(userAgent))
            {
                return UserDeviceType.TABLET;
            }
            else if(UserDeviceResolverHelper.isMobileDevice(userAgent, request))
            {
                return UserDeviceType.MOBILE;
            }
        }
        return UserDeviceType.DESKTOP;
    }
}
