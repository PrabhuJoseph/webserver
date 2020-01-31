package com.sample.web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class VersionInfo {

    protected String version;

    public VersionInfo() {
    } // JAXB needs this

    public VersionInfo(String version) {
        this.version = version;
    }

    public String getVersion() {
        return this.version;
    }

    public void serVersion(String version) {
        this.version = version;
    }
}
