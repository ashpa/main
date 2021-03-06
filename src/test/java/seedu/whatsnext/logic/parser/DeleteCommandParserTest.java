package seedu.whatsnext.logic.parser;

import static org.junit.Assert.assertEquals;
import static seedu.whatsnext.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.whatsnext.testutil.TypicalTasks.INDEX_FIRST_TASK;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import seedu.whatsnext.logic.commands.DeleteCommand;
import seedu.whatsnext.logic.parser.exceptions.ParseException;

/**
 * Contains integration tests (interaction with the Model) and unit tests for DeleteCommand parser.
 */

/**
 * As we are only doing white-box testing, our test cases do not cover path variations
 * outside of the DeleteCommand code. For example, inputs "1" and "1 abc" take the
 * same path through the DeleteCommand, and therefore we test only one of them.
 * The path variation for those two cases occur inside the ParserUtil, and
 * therefore should be covered by the ParserUtilTest.
 */
public class DeleteCommandParserTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private DeleteCommandParser parser = new DeleteCommandParser();

    @Test
    public void parse_validArgs_returnsDeleteCommand() throws Exception {
        DeleteCommand command = parser.parse("1");
        assertEquals(INDEX_FIRST_TASK, command.targetIndex);
    }

    @Test
    public void parse_invalidArgs_throwsParseException() throws Exception {
        thrown.expect(ParseException.class);
        thrown.expectMessage(String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE));

        parser.parse("a");
    }
}
