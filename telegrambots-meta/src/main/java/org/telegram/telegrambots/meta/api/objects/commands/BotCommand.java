package org.telegram.telegrambots.meta.api.objects.commands;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import org.telegram.telegrambots.meta.api.interfaces.BotApiObject;
import org.telegram.telegrambots.meta.api.interfaces.Validable;
import org.telegram.telegrambots.meta.exceptions.TelegramApiValidationException;

/**
 * This object represents a bot command.
 * @author Ruben Bermudez
 * @version 4.7
 */
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@SuperBuilder
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BotCommand implements BotApiObject, Validable {
    private static final String COMMAND_FIELD = "command";
    private static final String DESCRIPTION_FIELD = "description";

    /**
     * Text of the command. Can contain only lowercase English letters, digits and underscores. 1-32 characters.
     */
    @JsonProperty(COMMAND_FIELD)
    @NonNull
    private String command;
    /**
     * Description of the command, 3-256 characters.
     */
    @JsonProperty(DESCRIPTION_FIELD)
    @NonNull
    private String description;

    @Override
    public void validate() throws TelegramApiValidationException {
        if (command.isEmpty()) {
            throw new TelegramApiValidationException("Command parameter can't be empty", this);
        }
        if (description.isEmpty()) {
            throw new TelegramApiValidationException("Description parameter can't be empty", this);
        }
    }
}
