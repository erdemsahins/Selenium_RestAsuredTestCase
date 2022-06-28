package TrelloRestAsured;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;

public class TrelloTest extends BaseTest {

    @Test
    public void trelloTest() {

        createBoard("Board Create Test");
        getBoardId();
        getBoardLists();
        createCard("Card Oluştur","Api kullanarak board a yeni bir kart oluşturulur.");
        createCard("Card-2 Oluştur","Api kullanarak board a yeni bir kart oluşturulur.");
        randomGetCards();
        updateCard("update","desc");
        deleteCard();
        randomGetCards();
        deleteCard();
        deleteBoard();




    }
}
