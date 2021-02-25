import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookTests {
    @Test
    public void test0() {
        Book recordBook = new Book("Nikita Panin", 19214, 2);
        recordBook.insertSubj("введение в алгебру и анализ", 1, 4);
        recordBook.insertSubj("введение в дискретную математику и математическую логику", 1, 4);
        recordBook.insertSubj("декларативное программирование", 1, 4);
        recordBook.insertSubj("императивное программирование", 1, 4);
        recordBook.insertSubj("иностранный язык", 1, 1);
        recordBook.insertSubj("основы культуры речи", 1, 5);
        recordBook.insertSubj("история", 1, 5);
        recordBook.insertSubj("физическая культура и спорт (элективная дисциплина)", 1, 1);
        recordBook.insertSubj("физическая культура и спорт", 1, 1);
        recordBook.insertSubj("цифровые платформы", 1, 1);

        recordBook.insertSubj("введение в алгебру и анализ", 2, 3);
        recordBook.insertSubj("введение в дискретную математику и математическую логику", 2, 4);
        recordBook.insertSubj("декларативное программирование", 2, 5);
        recordBook.insertSubj("императивное программирование", 2, 4);
        recordBook.insertSubj("иностранный язык", 2, 4);
        recordBook.insertSubj("физическая культура и спорт (элективная дисциплина)", 2, 1);
        recordBook.insertSubj("физическая культура и спорт", 2, 1);
        recordBook.insertSubj("цифровые платформы", 2, 5);

        assertFalse(recordBook.isRed());
        assertFalse(recordBook.isHighPensia());
        recordBook.insertQualifWorkMark(4);
        assertFalse(recordBook.isRed());
    }
}
