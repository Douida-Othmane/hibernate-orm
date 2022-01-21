/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.engine.transaction.jta.platform.spi;

import java.util.Map;

import org.hibernate.service.Service;
import org.hibernate.service.spi.ServiceRegistryImplementor;

/**
 * A {@link Service} defining a strategy for obtaining a {@link JtaPlatform}
 * in configurations where the application did not explicitly specify one.
 * <p>
 * An implementation may be selected by specifying the configuration property
 * {@value org.hibernate.cfg.AvailableSettings#JTA_PLATFORM_RESOLVER}.
 *
 * @see JtaPlatform
 * @see JtaPlatformProvider
 *
 * @author Steve Ebersole
 */
public interface JtaPlatformResolver extends Service {
	public JtaPlatform resolveJtaPlatform(Map configurationValues, ServiceRegistryImplementor registry);
}
