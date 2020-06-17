#pragma once
#include <string>
#include "Textmarker.h"
#include "ErrorLevel.h"

namespace RAC_OPENSCENARIO
{
    /**
     * A message that consists of the message itself and some meta information like the error level and a textmarker
     * that enables the user to trace the message back to a file location.
     *
     */
    class FileContentMessage
    {
    private:
        Textmarker _textmarker;
        std::string _message;
        ErrorLevel _errorLevel;

    public:
        /**
         * Constructor;
         * @param message the message text
         * @param errorLevel the error level of the message
         * @param textmarker the text marker that enables the user to trace the message back to a file location.
         */
        FileContentMessage(const std::string message, const ErrorLevel errorLevel, Textmarker& textmarker) :
            _textmarker(textmarker), _message(message), _errorLevel(errorLevel) {}

        /**
         * The text marker that enables the user to trace the message back to a file location
         * @return the text marker
         */
        Textmarker GetTextmarker() const
        {
            return _textmarker;
        }

        /**
         * The text of a message
         * @return the message text
         */
        std::string GetMessage() const
        {
            return _message;
        }

        /**
         * The error level of the message.
         * @return the error level
         */
        ErrorLevel GetErrorLevel() const
        {
            return _errorLevel;
        }

        bool operator==(const FileContentMessage& rhs) const
        {
            //TODO: check if the dyncamic cast is necessary or if this will already be ensured
            return strcmp(rhs.ToString().c_str(), this->ToString().c_str());
        }

        int HashCode() const { return std::hash<std::string>{}(this->ToString()); }

        std::string ToString() const
        {
            return  "Message: '" + _message + "'" +
                " ErrorLevel: " + ErrorLevelString::ToString(_errorLevel) +
                " Textmarker: '" + _textmarker.ToString() + "'";
        }

        int CompareTo(const FileContentMessage& rhs) const
        {
            //TODO: not exactly the java equivalent 
            return strcmp(rhs.ToString().c_str(), this->ToString().c_str());
        };
    };
}
