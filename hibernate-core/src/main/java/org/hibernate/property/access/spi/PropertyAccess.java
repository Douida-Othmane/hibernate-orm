/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.property.access.spi;

import org.hibernate.metamodel.spi.ManagedTypeRepresentationStrategy;

/**
 * Defines how a given persistent attribute is accessed by exposing
 * a {@link Getter} and a {@link Setter} for the attribute.
 * <p>
 * Instances are obtained from a {@link PropertyAccessStrategy}.
 *
 * @see ManagedTypeRepresentationStrategy
 *
 * @author Steve Ebersole
 * @author Gavin King
 */
public interface PropertyAccess {
	/**
	 * Access to the {@link PropertyAccessStrategy} that created this instance.
	 *
	 * @return The {@code PropertyAccessStrategy}
	 */
	PropertyAccessStrategy getPropertyAccessStrategy();

	/**
	 * Obtain the delegate for getting values of the persistent attribute.
	 *
	 * @return The property getter
	 */
	Getter getGetter();

	/**
	 * Obtain the delegate for setting values of the persistent attribute.
	 *
	 * @return The property setter
	 */
	Setter getSetter();
}
