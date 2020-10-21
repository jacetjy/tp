package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_KEYWORD;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.SearchCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.flashcard.Description;
import seedu.address.model.flashcard.Flashcard;
import seedu.address.model.flashcard.Title;

import java.util.stream.Stream;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class SearchCommandParser implements Parser<SearchCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public SearchCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_KEYWORD);

        if (!arePrefixesPresent(argMultimap, PREFIX_KEYWORD)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, SearchCommand.MESSAGE_USAGE));
        }

        String keyword = argMultimap.getValue(PREFIX_KEYWORD).get();

        return new SearchCommand(keyword);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
