/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.sql.results.spi;

import org.hibernate.metamodel.mapping.EmbeddableMappingType;
import org.hibernate.metamodel.mapping.EmbeddableValuedModelPart;
import org.hibernate.metamodel.mapping.ManagedMappingType;
import org.hibernate.query.NavigablePath;

/**
 * @author Steve Ebersole
 */
public interface CompositeResultMappingNode extends ResultSetMappingNode, FetchParent {
	@Override
	default NavigablePath getNavigablePath() {
		return null;
	}

	@Override
	EmbeddableValuedModelPart getReferencedMappingContainer();

	@Override
	EmbeddableMappingType getReferencedMappingType();
}
