package se.hrmsoftware.exercises1.no8;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * These are extremely simple tests for the SqlScriptExecutor, time was short by the time of writing.
 *
 * Thus it is also within the scope of the implementation to add some more test cases.
 */
@RunWith(MockitoJUnitRunner.class)
public class SqlScriptExecutorTest {

    String block1 = "IF NOT EXISTS (SELECT * FROM SysObjects WHERE Name='IntegratedCircuits')\n" +
            "BEGIN\n" +
            "  PRINT 'A new table is borne'\n" +
            "  CREATE TABLE dbo.IntegratedCircuits (\n" +
            "  id int IDENTITY Primary Key,\n" +
            "  name varchar(12) not NULL ,\n" +
            "  description VARCHAR (255)\n" +
            "  )\n" +
            "END\n";


    @Mock
    private Statement stmt;

    @Test
    public void testExecute_Success() throws Exception {

        Path test1 = Paths.get(getClass().getResource("/se/hrmsoftware/execises1/no8/sql_1.sql").toURI());
        when(stmt.execute(anyString())).thenReturn(true);//every invocation will succeed, we'll verify the mock later.

        List<ErrorMessage> msg = SqlScriptExecutor.execute(test1, stmt);

        assertEquals("Well no errors should be detected", 0, msg.size());

        verify(stmt, times(1)).execute(block1);
    }

    @Test
    public void testExecute_1() throws Exception {

        Path test1 = Paths.get(getClass().getResource("/se/hrmsoftware/execises1/no8/sql_1.sql").toURI());

        String errorMsg = "It simply does not compute";
        when(stmt.execute(anyString())).thenThrow(new SQLException(errorMsg));

        List<ErrorMessage> msg = SqlScriptExecutor.execute(test1, stmt);

        ErrorMessage msg1 = new ErrorMessage(errorMsg, block1);

        assertEquals("Well there was not exactly one error message", 1, msg.size());

        assertEquals(msg1, msg.get(0));

    }

    @Test
    public void testExecute_2() throws Exception {

        Path test1 = Paths.get(getClass().getResource("/se/hrmsoftware/execises1/no8/sql_2.sql").toURI());

        when(stmt.execute(anyString())).thenReturn(true);

        List<ErrorMessage> msg = SqlScriptExecutor.execute(test1, stmt);

        assertEquals("Well there shouldn't be any error messages", 0, msg.size());

        verify(stmt,times(5)).execute(anyString());

    }


    //TODO add more tests to verify that you have made a proper implementation.


}