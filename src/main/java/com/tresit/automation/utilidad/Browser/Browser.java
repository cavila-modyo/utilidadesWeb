package com.tresit.automation.utilidad.Browser;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariOptions;

import java.util.Map;

public enum Browser {
    CHROME {
        @Override
        public MutableCapabilities getDefaultCapabilities() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--ignore-certificate-errors");
            return options;
        }
    },
    FIREFOX {
        @Override
        public MutableCapabilities getDefaultCapabilities() {
            //FirefoxOptions firefoxOptions = new FirefoxOptions();
            //firefoxOptions.setCapability("enableVNC", true);
            return new FirefoxOptions();
        }
    },
    OPERA {
        @Override
        public MutableCapabilities getDefaultCapabilities() {
            OperaOptions operaOptions = new OperaOptions();
            operaOptions.setCapability("browserName", "operablink");
            operaOptions.setBinary("/usr/bin/opera");
            return operaOptions;
        }
    },
    SAFARI {
        @Override
        public MutableCapabilities getDefaultCapabilities() {
            return new SafariOptions();
        }
    },
    EDGE {
        @Override
        public MutableCapabilities getDefaultCapabilities() {
            return new EdgeOptions();
        }
    },
    IE {
        @Override
        public MutableCapabilities getDefaultCapabilities() {
            return new InternetExplorerOptions();
        }
    };

    public abstract MutableCapabilities getDefaultCapabilities();

    public MutableCapabilities withCapabilities(Map<String, Object> capabilities) {
        MutableCapabilities defaultCapabilities = this.getDefaultCapabilities();

        if (capabilities == null) {
            return defaultCapabilities;
        }

        capabilities.forEach(defaultCapabilities::setCapability);

        return defaultCapabilities;
    }
}
