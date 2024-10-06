package esbet.start.playground.application.utils;


import esbet.start.playground.domain.exceptions.BadAttributeFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class CheckTypeAttribute {

    private void stringIsVoidOrNull(String stringToTest, String infoAttribute) {
        log.debug("Check that the{}is present: {}", infoAttribute, stringToTest);
        if (stringToTest == null || stringToTest.isEmpty()) {
            log.error("{} can't be Null!", infoAttribute);
            throw new BadAttributeFormatException(infoAttribute + " can't be Null or Empty!");
        }
    }

    public void checkStringNullOrEmpty(String stringToTest, String infoAttribute) {
        stringIsVoidOrNull(stringToTest, infoAttribute);
    }

    public void checkIntegerNullOrNegative(Integer idToTest, String infoAttribute) {
        if (idToTest == null || idToTest < 0) {
            log.error("{} can't be Null or Negative!", infoAttribute);
            throw new BadAttributeFormatException(infoAttribute + " can't be Null or Negative!");
        }
        log.debug("Check that the {} is present and not negative: {}", infoAttribute, idToTest);
    }

    public UUID checkUUIDNullOrInvalid(String uuidToTest, String infoAttribute) {
        stringIsVoidOrNull(uuidToTest, infoAttribute);

        UUID id;

        try {
            id = UUID.fromString(uuidToTest);
        } catch (IllegalArgumentException e) {
            log.error("{} is not a valid UUID!", uuidToTest);
            throw new BadAttributeFormatException(uuidToTest + " is not a valid UUID!");
        }

        return id;
    }
}
