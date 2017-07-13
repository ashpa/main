package seedu.whatsnext.testutil;

import java.util.Arrays;
import java.util.Optional;

import seedu.whatsnext.commons.exceptions.IllegalValueException;
import seedu.whatsnext.logic.commands.EditCommand.EditTaskDescriptor;
import seedu.whatsnext.logic.parser.ParserUtil;
import seedu.whatsnext.model.task.BasicTaskFeatures;

/**
 * A utility class to help with building EditTaskDescriptor objects.
 */
public class EditTaskDescriptorBuilder {

    private EditTaskDescriptor descriptor;

    public EditTaskDescriptorBuilder() {
        descriptor = new EditTaskDescriptor();
    }

    public EditTaskDescriptorBuilder(EditTaskDescriptor descriptor) {
        this.descriptor = new EditTaskDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPersonDescriptor} with fields containing {@code person}'s details
     */
    public EditTaskDescriptorBuilder(BasicTaskFeatures task) throws IllegalValueException {
        descriptor = new EditTaskDescriptor();
        descriptor.setName(task.getName());
        descriptor.setIsCompleted(task.getIsCompleted());
        descriptor.setStartDateTime(task.getStartDateTime());
        descriptor.setEndDateTime(task.getEndDateTime());
        descriptor.setTags(task.getTags());
    }

    public EditTaskDescriptorBuilder withName(String name) throws IllegalValueException {
        ParserUtil.parseName(Optional.of(name)).ifPresent(descriptor::setName);
        return this;
    }

    public EditTaskDescriptorBuilder withPhone(String phone) throws IllegalValueException {
        ParserUtil.parsePhone(Optional.of(phone)).ifPresent(descriptor::setPhone);
        return this;
    }

    public EditTaskDescriptorBuilder withEmail(String email) throws IllegalValueException {
        ParserUtil.parseEmail(Optional.of(email)).ifPresent(descriptor::setEmail);
        return this;
    }

    public EditTaskDescriptorBuilder withAddress(String address) throws IllegalValueException {
        ParserUtil.parseAddress(Optional.of(address)).ifPresent(descriptor::setAddress);
        return this;
    }

    public EditTaskDescriptorBuilder withTags(String... tags) throws IllegalValueException {
        descriptor.setTags(ParserUtil.parseTags(Arrays.asList(tags)));
        return this;
    }

    public EditTaskDescriptor build() {
        return descriptor;
    }
}
