package org.apache.maven.archetypes.maven_archetype_webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoggerDemoController {
    private static final Logger logger = LoggerFactory.getLogger(LoggerDemoController.class);

    @GetMapping("/log-demo")
    @ResponseBody
    public String demonstrateLogging() {
        logger.info("LoggerDemoController: INFO level log message");
        logger.debug("LoggerDemoController: DEBUG level log message");
        logger.warn("LoggerDemoController: WARN level log message");
        logger.error("LoggerDemoController: ERROR level log message");

        return "Logging demonstration completed. Check the console for log output.";
    }
}
