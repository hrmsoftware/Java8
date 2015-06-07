package se.hrmsoftware.exercises1.no8;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

/**
 * In this exercise we will try to make hard use of all the mad functional style programming
 * skillz we built up so far.
 *
 * Your task (or your teams task) is to implement a sql script executor. This executor
 * will execute the statements found in a regular sql script file for sql server on
 * a given Statement instance. It is only for sake of argument and for academic purposes that we build the solution
 * around the fact that we input the statement onto which we want to execute stuff on. A real world example would
 * perhaps involve getting a connection to a dataase etc.
 *
 * The format of the sql script file is that it is sectioned with "GO"  blocks. That information is
 * crucial for a successful implementation. =).
 *
 * If for some reason (you might not have written the sql file your self) the statement fails that is given in the file
 * we must keep track of that and create an {@link ErrorMessage} for the block that failed. We should however not stop
 * execution of the different blocks just because one has misbehaved.
 *
 *
 * IOExceptions is allowed when the file to be read from misbehaves, e.g. is not present or is corrupt etc. But the main
 * execution should not throw such exceptions if a statement fails.
 *
 * IMPORTANT! ONLY use Statement.execute(String sql), the test creator was lazy!
 */
public class SqlScriptExecutor {


    public static List<ErrorMessage> execute(Path sqlStatements, Statement statement) throws IOException {

        //Todo implement the executor!
        //A word of advise, think about the problem and break it down into smaller pieces, then use those smaller
        //pieces to compose your grand solution!

        //You must use the stream API in Java8 to solve this puzzle.


        return Collections.emptyList();
    }

}
