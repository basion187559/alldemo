package cn.basion.context;

import cn.basion.beans.factory.ListableBeanFactory;

/**
 * Central interface to provide configuration for an application.
 * This is read-only while the application is running, but may be
 * reloaded if the implementation supports this.4
 * 应用上下文
 */

public interface ApplicationContext extends ListableBeanFactory {
}
