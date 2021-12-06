package ru.airconcept.dao;

public class DaoException extends RuntimeException {
    /**
     * Исключение дао слоя
     *
     * @param message текст описывающий условия при которых была ошибка
     * @param cause   причина (исключение)
     */
    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
