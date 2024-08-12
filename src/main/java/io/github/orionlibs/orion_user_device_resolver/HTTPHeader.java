package io.github.orionlibs.orion_user_device_resolver;

enum HTTPHeader
{
    WAPProfile("x-wap-profile"),
    Profile("Profile"),
    UserAgent("User-Agent"),
    Accept("Accept");
    private String name;


    private HTTPHeader(String name)
    {
        setName(name);
    }


    String get()
    {
        return getName();
    }


    String getName()
    {
        return this.name;
    }


    void setName(String name)
    {
        this.name = name;
    }
}