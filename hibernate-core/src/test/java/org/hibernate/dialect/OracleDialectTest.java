package org.hibernate.dialect;

import org.hibernate.testing.RequiresDialect;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import java.sql.Types;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.*;

@RequiresDialect( OracleDialect.class )
class OracleDialectTest {
    @Mock
    DatabaseVersion databaseVersion;

    OracleDialect oracleDialect;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        oracleDialect = new OracleDialect(databaseVersion);
    }

    @Test
    @DisplayName("should_return_BIT_for_dbversion_same21")
    void testGetPreferredSqlTypeCodeForBoolean_SameVersion() {
        when(databaseVersion.isSame(anyInt())).thenReturn(true);
        when(databaseVersion.isBefore(anyInt())).thenReturn(false);

        int result = oracleDialect.getPreferredSqlTypeCodeForBoolean();
        assertEquals(Types.BIT, result);
    }

    @Test
    @DisplayName("should_return_BIT_for_dbversion_same21")
    void testGetPreferredSqlTypeCodeForBoolean_BeforeVersion() {
        when(databaseVersion.isSame(anyInt())).thenReturn(false);
        when(databaseVersion.isBefore(anyInt())).thenReturn(true);

        int result = oracleDialect.getPreferredSqlTypeCodeForBoolean();
        assertEquals(Types.BIT, result);
    }

    @Test
    @DisplayName("should_return_BOOLEAN_for_dbversion_23c")
    void testGetPreferredSqlTypeCodeForBoolean_AfterVersion() {
        when(databaseVersion.isSame(anyInt())).thenReturn(false);
        when(databaseVersion.isBefore(anyInt())).thenReturn(false);

        int result = oracleDialect.getPreferredSqlTypeCodeForBoolean();
        assertEquals(Types.BOOLEAN, result);
    }
}