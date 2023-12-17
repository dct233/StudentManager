package com.nocl.studentmanager.view.main.utils;

import com.nocl.studentmanager.Main;
import com.nocl.studentmanager.view.main.StudentMain;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

import javax.swing.*;
import java.io.Serializable;

@Plugin(name = "SwingAppender", category = "Core", elementType = "appender", printObject = true)
public class SwingAppender extends AbstractAppender {
    private final JTextArea log;
    protected SwingAppender(String name, Filter filter, Layout<? extends Serializable> layout, boolean ignoreExceptions, Property[] properties, JTextArea log) {
        super(name, filter, layout, ignoreExceptions, properties);
        this.log = log;
    }

    @Override
    public void append(LogEvent event) {
        log.append(new String (getLayout().toByteArray(event)));
    }

    @PluginFactory
    public static SwingAppender createAppender(
            @PluginAttribute("name") String name,
            @PluginAttribute("ignoreExceptions") boolean ignoreExceptions,
            @PluginElement("Layout") Layout<? extends Serializable> layout,
            @PluginElement("Filters") Filter filter
    ) {
        if (name == null) {
            LOGGER.error("No name provided for CustomAppender");
            return null;
        }
        if (layout == null) {
            layout = PatternLayout.createDefaultLayout();
        }
        JTextArea log = Main.studentMain.logger.getLog();

        return new SwingAppender(name, filter, layout, ignoreExceptions, null, log);
    }
}
