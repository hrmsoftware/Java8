package se.hrmsoftware.exercises1.no8;

/**
 * When a statement block is executed in a data source and it fails the executor creates an instance of this class
 * and adds it as a result to be returned.
 */
public class ErrorMessage {

    private final String message;
    private final String sqlBlock;

    public ErrorMessage(String message, String sqlBlock) {
        this.message = message;
        this.sqlBlock = sqlBlock;
    }

    public String getMessage() {
        return message;
    }

    public String getSqlBlock() {
        return sqlBlock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ErrorMessage that = (ErrorMessage) o;

        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        return !(sqlBlock != null ? !sqlBlock.equals(that.sqlBlock) : that.sqlBlock != null);

    }

    @Override
    public int hashCode() {
        int result = message != null ? message.hashCode() : 0;
        result = 31 * result + (sqlBlock != null ? sqlBlock.hashCode() : 0);
        return result;
    }
}
