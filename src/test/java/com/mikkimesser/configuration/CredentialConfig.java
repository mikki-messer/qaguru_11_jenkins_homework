package com.mikkimesser.configuration;

import org.aeonbits.owner.Config;
@Config.Sources("configuration/credentials.properties")
public interface CredentialConfig extends Config {
    String login();
    String password();
}
